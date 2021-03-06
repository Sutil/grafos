# encoding: utf-8

from collections import deque

# Representacao de conjuntos, em geral não é eficiente mas é simples
class Graph:
    def __init__(self, V, E):
        self.V = V
        self.E = E

class UndirectedGraph:
    def __init__(self, V, E):
        self.V = V
        self.E = E

    def _adj(self, u):
        for x, y, w in self.E:
            if u == x:
                yield y, w
            elif u == y:
                yield x, w

    def adj(self, u):
        for v, w in self._adj(u):
            yield v

    def cost(self, u, v):
        for x, w in self._adj(u):
            if v == x:
                return w

    def is_adj(self, u, v):
        return v in self.adj(u)

def parse_tgf(lines, G = Graph):
    def edge(u, v, w = None):
        return u, v, (int(w) if w != None else None)
    sharp = lines.index('#')
    V = lines[:sharp]
    edges = [line.split() for line in lines[sharp + 1:]]
    E = [edge(*e) for e in edges]
    return G(V, E)

def parse_tgf_undirected(lines):
    return parse_tgf(lines, UndirectedGraph)

class ParseError(Exception):
    def __init__(self, message):
        Exception.__init__(self, message)
        self.message = message


# BFS
def bfs_parse(lines):
    d = {}
    for line in lines:
        values = line.split()
        if len(values) != 3:
            raise ParseError(u"formatação: linha não tem 3 valores: " + line)
        u, v, _d = values
        if (u, v) in d:
            raise ParseError(u"formatação: aresta repetida: " + u + " " + v)
        d[(u, v)] = _d
    return d

def bfs_check(test_result, expected, actual):
    if expected != actual:
        e = sorted(" ".join([e[0], e[1], d]) for e, d in expected.items())
        a = sorted(" ".join([e[0], e[1], d]) for e, d in actual.items())
        test_result.add_error(u"saída incorreta", e, a)

def bfs_main(test_result, case, expected, program_result):
    expected = bfs_parse(readlines(expected))
    try:
        actual = bfs_parse(program_result.out.splitlines())
        bfs_check(test_result, expected, actual)
    except ParseError as e:
        test_result.add_error(e.message)


# topological sort
def ts_check(test_result, g, actual):
    if set(g.V) != set(actual):
        test_result.add_error(u"a saída não tem os mesmos vértices do grafo de entrada")
    elif len(set(actual)) != len(actual):
        test_result.add_error(u"a saída contém vértices repetidos")
    else:
        pos = {v : p for p, v in enumerate(actual)}
        for u, v, w in g.E:
            if pos[u] > pos[v]:
                test_result.add_error(u"aresta da direita para esquerda encontrada: %s -> %s" %
                                      (u, v))

def ts_main(test_result, case, expected, program_result):
    g = parse_tgf(readlines(case))
    ts_check(test_result, g, program_result.out.splitlines())


# strongly connected components
def scc_normalize(sccs):
    return sorted(list([tuple(sorted(comp)) for comp in sccs]))

def scc_parse(lines):
    return [line.split() for line in lines]
 
def scc_check(test_result, expected, actual):
    vertices = set()
    for comp in actual:
        for v in comp:
            if v in vertices:
                test_result.add_error(u"vértice repetido: " + v)
            vertices.add(v)
    if not test_result.success(): return

    expected = scc_normalize(expected)
    actual = scc_normalize(actual)
    if expected != actual:
        e = [" ".join(comp) for comp in expected]
        a = [" ".join(comp) for comp in actual]
        test_result.add_error(u"saída incorreta", e, a)

def scc_main(test_result, case, expected, program_result):
    expected = scc_parse(readlines(expected))
    actual = scc_parse(program_result.out.splitlines())
    scc_check(test_result, expected, actual)


# minimum spanning tree
def mst_parse_result(lines):
    tree = [tuple(line.split()) for line in lines]
    for e in tree:
        if len(e) != 2:
            raise ParseError(u"formatação: linha não tem 2 valores: " + " ".join(e))
    return tree

def find_reachable(g, s):
    Q = deque([s])
    reachable = set([s])
    while Q:
        u = Q.popleft()
        for v in g.adj(u):
            if v not in reachable:
                reachable.add(v)
                Q.append(v)
    return reachable

def mst_check(test_result, g, expected, actual):
    # invalid edges
    for u, v in actual:
        if not g.is_adj(u, v):
            test_result.add_error(u"aresta da árvore não está no grafo: " + u + " " + v)
    if not test_result.success(): return

    # invalid tree
    if len(g.V) - 1 != len(actual):
        test_result.add_error(u"não é uma árvore, número de arestas tem que ser |V| - 1",
                             len(g.V) - 1, len(actual))
    else:
        tree = UndirectedGraph(g.V, [(u, v, None) for u, v in actual])
        reachable = find_reachable(tree, actual[0][0])
        V = set(g.V)
        if V != reachable:
            r = " ".join(V - reachable)
            test_result.add_error(u"não é uma árvore, vértice não acessíveis: " + r)
    if not test_result.success(): return

    # wrong weight
    weight = sum(g.cost(u, v) for u, v in actual)
    if weight != expected:
        test_result.add_error(u"peso", expected, weight)

def mst_main(test_result, case, expected, program_result):
    g = parse_tgf_undirected(readlines(case))
    expected = int(readlines(expected)[0])
    actual = None
    try:
        actual = mst_parse_result(program_result.out.splitlines())
    except ParseError as e:
        test_result.add_error(e.message)
        return
    mst_check(test_result, g, expected, actual)


# utilidades
def readlines(infile):
    with open(infile) as f:
        return f.read().splitlines()
