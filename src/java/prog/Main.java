package prog;

import java.util.List;

import prog.algs.dfs.Componente;
import prog.file.BuildBfs;
import prog.file.BuildMst;
import prog.grafo.Grafo;
import prog.grafo.aresta.Aresta;
import prog.grafo.vertice.Vertice;


public class Main {
    public static void main(String[] args) throws Exception {
        String alg = args[0];
        String path = args[1];
        switch (alg) {
		case "bfs":
			bfs(path);
			break;
			
		case "mst":
			mst(path);
			break;
		case "ts" :
			ts(path);
			break;
			
		case "scc":
			scc(path);
		default:
			break;
		}
    }
    
    
    
    public static void bfs(String path) throws Exception{
    	BuildBfs builder = new BuildBfs();
    	Grafo grafo = builder.montaGrafo(path);
    	Grafo bfs = BFS.bfs(grafo, grafo.getVertices().get(0));
    	System.out.print(bfs.getBfs(bfs.getVertices().get(0)));
    }
    
    public static void mst(String path) throws Exception{
    	BuildMst builder = new BuildMst();
    	Grafo g = builder.montaGrafo(path);
    	MST mst = new MST();
    	mst.mst(g);
    	System.out.println(mst.formatScreen());
    }
    
    public static void ts(String path) throws Exception{
    	BuildBfs builder = new BuildBfs();
    	Grafo g = builder.montaGrafo(path);
    	TS ts = new TS();
    	ts.ts(g);
    	System.out.println(ts.formatScreen());
    	
    }
    
    public static void scc(String path) throws Exception{
    	BuildBfs b = new BuildBfs();
    	Grafo grafo = b.montaGrafo(path);
    	SCC scc = new SCC();
    	List<Componente> componentes = scc.scc(grafo);
    	System.out.println(scc.formatScreen());
    }
}
