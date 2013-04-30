package prog;

import java.util.LinkedList;
import java.util.List;

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

	private List<Vertice> listaEmOrdemDePeso = new LinkedList<Vertice>();

	private final Cor cinza = Cor.newInstance("GRAY");
	private final Cor preto = Cor.newInstance("BLACK");
	private final Cor branco = Cor.newInstance("WAIT");
	private int tempo;

	private Grafo grafo;

	private DFS() throws Exception {
	}

	public static DFS newInstance() throws Exception {
		return new DFS();
	}

	public List<Vertice> dfs(Grafo g) throws Exception {

		for (Vertice v : g.getVertices()) {
			v.setCor(branco);
		}
		tempo = 0;

		for (Vertice u : g.getVertices()) {
			if (u.getCor().equals(branco)) {
				dfsVisit(u);
			}
		}
		
		grafo = g;
		return listaEmOrdemDePeso;
	}

	private void dfsVisit(Vertice u) throws Exception {
		u.setCor(cinza);
		tempo++;
		u.setD(tempo);
		for (Vertice v : u.getAdjacentes()) {
			if (v.getCor().equals(branco)) {
				v.setPai(u);
				dfsVisit(v);
			}
		}
		u.setCor(preto);
		u.setF(tempo++);
		listaEmOrdemDePeso.add(0, u);

	}

	public Grafo getGrafo() {
		return grafo;
	}

}
