package prog.file;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import prog.grafo.Grafo;
import prog.grafo.vertice.Vertice;


public class BuildBfs {
	
	private Grafo grafo;
	
	public Grafo montaGrafo(String path) throws Exception{

		criaGrafo();
		
		FileInputStream file = new FileInputStream(path);
		Scanner sc = new Scanner(file);
		
		if(sc.hasNext()){
			String linha = sc.nextLine();
			while (!"#".equals(linha)){
				grafo.addVertice(Vertice.newInstance(linha));
				linha = sc.nextLine();
			}
			while(sc.hasNext()){
				linha = sc.nextLine();
				String[] split = linha.split(" ");
				grafo.addAdjacente(Vertice.newInstance(split[0]), Vertice.newInstance(split[1]));
			}
		}
		
		sc.close();
		file.close();
		return grafo;
	}
	
	private void criaGrafo(){
		List<Vertice> vertices = new LinkedList<Vertice>();;
		grafo = Grafo.newInstance(vertices);
	}

}
