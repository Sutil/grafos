package prog;

import java.util.List;

import prog.algs.dfs.Componente;
import prog.grafo.Grafo;
import prog.grafo.vertice.Vertice;

public class SCC {
	
	private DFS dfs;
	private SccDFS dfsTransposto; 
	
	public List<Componente> scc(Grafo g) throws Exception{
		dfs = DFS.newInstance();
		List<Vertice> verticesOrdenados = dfs.dfs(g);
		g.setVertices(verticesOrdenados);
		g = dfs.getGrafo();
		Grafo t = Transposta.transpor(g);
		dfsTransposto = SccDFS.newInstance();
		dfsTransposto.dfs(t);
		return dfsTransposto.getComponentes();
		
	}
	
	public String formatScreen(){
		StringBuilder sb = new StringBuilder();
		List<Componente> componentes = dfsTransposto.getComponentes();
		for (int i = 0; i < componentes.size(); i++){
			Componente c = componentes.get(i);
			if(i != componentes.size() - 1){
				sb.append(c.toString()).append("\n");
			}
			else{
				sb.append(c.toString());
			}
    	}
		return sb.toString();
	}

}
