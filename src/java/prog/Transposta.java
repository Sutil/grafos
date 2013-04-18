package prog;

import prog.grafo.Grafo;
import prog.grafo.vertice.Vertice;

public class Transposta {


	public static Grafo transpor(Grafo g) throws Exception{
		Grafo t = Grafo.newInstance(g.copy());
		
		for (Vertice v : g.getVertices()){
			for(Vertice u : v.getAdjacentes()){
				t.getVertices().get(t.getPositionVertice(u)).addAdjacente(t.getVertices().get(t.getPositionVertice(v)));
			}
		}
		return t;
	}
}
