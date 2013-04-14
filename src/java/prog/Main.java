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
        
        switch (alg) {
		case "bfs":
			bfs(args[1]);
			break;
			
		case "mst":
			mst(args[1]);
			break;
		case "ts" :
			ts(args[1]);
			break;
			
		case "scc":
			scc(args[1]);
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
    	List<Aresta> mst = MST.mst(g);
    	StringBuilder sb = new StringBuilder();
    	for (int i = 0; i < mst.size(); i++){
    		Aresta w = mst.get(i);
    		if(i == mst.size() - 1){
    			sb.append(String.format("%s %s", w.getA(), w.getB()));
    		}
    		else{
    			sb.append(String.format("%s %s\n", w.getA(), w.getB()));
    		}
    		
    	}
    	System.out.println(sb.toString());
    }
    
    public static void ts(String path) throws Exception{
    	BuildBfs builder = new BuildBfs();
    	Grafo grafo = builder.montaGrafo(path);
    	TS ts = new TS();
    	List<Vertice> listaOrdenada = ts.ts(grafo);
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0 ; i < listaOrdenada.size(); i++){
    		Vertice v = listaOrdenada.get(i);
    		if(i < listaOrdenada.size()-1){
    			sb.append(String.format("%s\n", v.getRotulo()));
    		}
    		else{
    			sb.append(String.format("%s", v.getRotulo()));
    		}
    	}
    	System.out.println(sb.toString());
    	
    }
    
    public static void scc(String path) throws Exception{
    	BuildBfs b = new BuildBfs();
    	Grafo grafo = b.montaGrafo(path);
    	List<Componente> componentes = SCC.scc(grafo);
    	for (Componente c : componentes){
    		System.out.println(c.toString());
    	}
    }
}
