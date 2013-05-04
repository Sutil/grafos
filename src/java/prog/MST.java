package prog;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import prog.grafo.Grafo;
import prog.grafo.aresta.Aresta;
import prog.grafo.vertice.Vertice;

public class MST {
	
	
	private List<Aresta> arvore = new LinkedList<Aresta>();
	
	public List<Aresta> mst(Grafo g){
		
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
	
	
	protected void makeSet(Vertice v){
		v.setPai(v);
		v.setD(0);
	}
	
	
	protected Vertice findSet(Vertice x){
		if(!x.equals(x.getPai())){
			x.setPai(findSet(x.getPai()));
		}
		return x.getPai();
	}
	
	protected void link(Vertice u, Vertice v){
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
	
	protected void union(Vertice u, Vertice v){
		link(findSet(u), findSet(v));
	}
	
	public String formatScreen(){
		StringBuilder sb = new StringBuilder();
    	for (int i = 0; i < arvore.size(); i++){
    		Aresta w = arvore.get(i);
    		if(i == arvore.size() - 1){
    			sb.append(String.format("%s %s", w.getA(), w.getB()));
    		}
    		else{
    			sb.append(String.format("%s %s\n", w.getA(), w.getB()));
    		}
    	}
    	return sb.toString();
	}

}
