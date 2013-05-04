package prog;

import java.util.LinkedList;
import java.util.List;

import prog.grafo.Grafo;
import prog.grafo.vertice.Vertice;

public class TS  {
	
	private List<Vertice> listaDeSaida = new LinkedList<Vertice>();
	
	public List<Vertice> ts(Grafo g) throws Exception{
		DFS dfs = DFS.newInstance();
		listaDeSaida = dfs.dfs(g);
		return listaDeSaida;
	}
	
	public String formatScreen(){
		StringBuilder sb = new StringBuilder();
    	for(int i = 0 ; i < listaDeSaida.size(); i++){
    		Vertice v = listaDeSaida.get(i);
    		if(i < listaDeSaida.size()-1){
    			sb.append(String.format("%s\n", v.getRotulo()));
    		}
    		else{
    			sb.append(String.format("%s", v.getRotulo()));
    		}
    	}
    	return sb.toString();
	}
	

}
