package prog;

import java.util.List;

import prog.algs.dfs.Componente;
import prog.grafo.Grafo;
import prog.grafo.vertice.Vertice;

public class SCC {
	
	public static List<Componente> scc(Grafo g) throws Exception{
		DFS dfs = DFS.newInstance();
		List<Vertice> verticesOrdenados = dfs.dfs(g);
		g.setVertices(verticesOrdenados);
		g = dfs.getGrafo();
		Grafo t = Transposta.transpor(g);
		SccDFS dfsTransposto = SccDFS.newInstance();
		dfsTransposto.dfs(t);
		return dfsTransposto.getComponentes();
		
	}

}
