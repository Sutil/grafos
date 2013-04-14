package prog.algs.dfs;

import java.util.LinkedList;
import java.util.List;

import prog.grafo.vertice.Vertice;

public class Componente {
	
	private List<Vertice> vertices = new LinkedList<Vertice>();
	
	public List<Vertice> getVertices() {
		return vertices;
	}
	
	public void addVertice(Vertice v){
		if(!vertices.contains(v)){
			vertices.add(v);
		}
	}
	
	private void setVertices(List<Vertice> vertices){
		this.vertices = vertices;
	}
	
	public Componente copy(){
		Componente c = new Componente();
		c.setVertices(this.vertices);
		return c;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < vertices.size(); i++){
			Vertice v = vertices.get(i);
			if(i == 0){
				sb.append(String.format("%s", v.getRotulo()));
			}
			else{
				sb.append(String.format(" %s", v.getRotulo()));
			}
		}
		return sb.toString();
	}

}
