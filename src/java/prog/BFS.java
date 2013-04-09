package prog;

import java.util.LinkedList;
import java.util.Queue;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

import prog.grafo.Grafo;
import prog.grafo.vertice.Cor;
import prog.grafo.vertice.Vertice;

public class BFS {
	
	public static Grafo bfs(Grafo g, Vertice origem) throws Exception{
		Queue<Vertice> fila = new LinkedList<Vertice>();
		Cor branco = Cor.newInstance("Branco", "FFFFFF");
		Cor cinza = Cor.newInstance("Cinza", "888888");
		Cor preto = Cor.newInstance("Preto", "000000");
		
		for (Vertice u : g.getVertices()){
			if(!u.equals(origem)){
				u.setCor(branco);
			}
			else{
				origem = u;
			}
		}
		origem.setCor(cinza);
		origem.setDistanciadDaOrigem(0);
		origem.setPai(null);
		fila.add(origem);
		while(!fila.isEmpty()){
			Vertice u = fila.remove();
			for (Vertice v : u.getAdjacentes()){
				if(v.getCor().equals(branco)){
					v.setCor(cinza);
					v.setDistanciadDaOrigem(u.getDistanciadDaOrigem() + 1);
					v.setPai(u);
					fila.add(v);
				}
			}
			u.setCor(preto);
		}
		return g;
	}

}
