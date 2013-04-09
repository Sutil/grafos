package prog;

import prog.file.ReadingFile;
import prog.grafo.Grafo;


public class Main {
    public static void main(String[] args) throws Exception {
    	args[0] = "bfs";
        for (String s : args) {
        }
        bfs(args[1]);
    }
    
    
    
    public static void bfs(String path) throws Exception{
    	ReadingFile readingFile = new ReadingFile();
    	Grafo grafo = readingFile.montaGrafo(path);
    	Grafo bfs = BFS.bfs(grafo, grafo.getVertices().get(0));
    	System.out.print(bfs.getBfs(bfs.getVertices().get(0)));
    }
}
