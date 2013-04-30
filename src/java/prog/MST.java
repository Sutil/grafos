package prog;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import prog.grafo.Grafo;
import prog.grafo.aresta.Aresta;
import prog.grafo.vertice.Vertice;

public class MST {
	
	
	
	public static List<Aresta> mst(Grafo g){
		
		List<Aresta> arvore = new LinkedList<Aresta>();
		
		
		for(Vertice v: g.getVertices()){
			 makeSet(v);
			 
		}
		Collections.sort(g.getArestas());
		for(Aresta a : g.getArestas()){
			if(!findSet(a.getA()).equals(findSet(a.getB())) ){
				arvore.add(a);
				union(a.getB(), a.getA());
			}
			
		}
		return arvore;
		
	}
	
	
	public static void makeSet(Vertice v){
		v.setPai(v);
		v.setD(0);
	}
	
	
	public static Vertice findSet(Vertice x){
		if(!x.equals(x.getPai())){
			x.setPai(findSet(x.getPai()));
		}
		return x.getPai();
	}
	
	public static void link(Vertice u, Vertice v){
		if((int)u.getD() > (int)v.getD()){
			v.setPai(u);
		}
		else{
			u.setPai(v);
			if((int) u.getD() == (int)v.getD()){
				v.setD(v.getD()+1);
			}
		}
	}
	
	public static void union(Vertice u, Vertice v){
		link(findSet(u), findSet(v));
	}
	 
	

}
