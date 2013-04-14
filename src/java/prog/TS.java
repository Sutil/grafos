package prog;

import java.util.List;

import prog.grafo.Grafo;
import prog.grafo.vertice.Vertice;

public class TS  {
	
	
	public List<Vertice> ts(Grafo g) throws Exception{
		DFS dfs = DFS.newInstance();
		List<Vertice> listaDeSaida = dfs.dfs(g, false);
		return listaDeSaida;
	}

	

}
