package prog;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import prog.algs.dfs.Componente;
import prog.grafo.Grafo;
import prog.grafo.vertice.Cor;
import prog.grafo.vertice.Vertice;

/**
 * @Referencie Livro: Algoritmos - Teoria e Prática. 
 * @Autor: Cormen, Thomas H.
 * @Editora: Campus
 * @Página 430
 */
public class DFS {
	
private List<Vertice> lista = new LinkedList<Vertice>();
	
	private final Cor cinza = Cor.newInstance("GRAY");
	private final Cor preto = Cor.newInstance("BLACK");
	private final Cor branco = Cor.newInstance("WAIT");
	private int tempo;
	private Componente componente = new Componente();
	
	private List<Componente> componentes = new LinkedList<Componente>();
	private Grafo grafo;
	
	private DFS() throws Exception{
	}
	
	public static DFS newInstance() throws Exception{
		return new DFS();
	}
	
	
	public List<Vertice> dfs(Grafo g, boolean ordenarLista) throws Exception{
		
		for (Vertice v : g.getVertices()){
			v.setCor(branco);
		}
		tempo = 0;
		
		List<Vertice> vertices = g.getVertices();
		if(ordenarLista){
			Collections.sort(vertices);
		}
		for (Vertice u : vertices){
			if(u.getCor().equals(branco)){
				dfsVisit(u);
				Componente copy = componente.copy();
				componentes.add(copy);
				componente = new Componente();
			}
		}
		grafo = g;
		return lista;
	}

	private void dfsVisit(Vertice u) throws Exception {
		u.setCor(cinza);
		componente.addVertice(u);
		tempo ++;
		u.setD(tempo);
		for (Vertice v : u.getAdjacentes()){
			if(v.getCor().equals(branco)){
				v.setPai(u);
				dfsVisit(v);
			}
		}
		u.setCor(preto);
		u.setF(tempo++);
		lista.add(0, u);
		
		
	}
	
	public List<Componente> getComponentes() {
		return componentes;
	}
	
	public Grafo getGrafo() {
		return grafo;
	}

}
