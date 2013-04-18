package prog;

import java.util.List;

import prog.algs.dfs.Componente;
import prog.grafo.Grafo;
import prog.grafo.vertice.Vertice;

public class SCC {
	
	public static List<Componente> scc(Grafo g) throws Exception{
		DFS dfs = DFS.newInstance();
		dfs.dfs(g, false);
		g = dfs.getGrafo();
		Grafo t = Transposta.transpor(g);
		DFS dfsTransposto = DFS.newInstance();
		dfsTransposto.dfs(t, true);
		return dfsTransposto.getComponentes();
		
	}

}
