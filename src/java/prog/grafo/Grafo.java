package prog.grafo;

import java.util.LinkedList;
import java.util.List;
import java.util.SortedSet;

import prog.grafo.aresta.Aresta;
import prog.grafo.vertice.Vertice;

public class Grafo {

	List<Vertice> vertices = new LinkedList<Vertice>();
	List<Aresta> arestas = new LinkedList<Aresta>();

	private Grafo(List<Vertice> vertices) {
		this.vertices = vertices;
	}

	public static Grafo newInstance(List<Vertice> vertices) {
		if (vertices == null) {
			return new Grafo(new LinkedList<Vertice>());
		}
		return new Grafo(vertices);
	}

	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	
	public int getPositionVertice(Vertice v){
		int position = -1;
		for (int i = 0 ; i < vertices.size(); i++){
			Vertice u = vertices.get(i);
			if(u.equals(v)){
				position = i;
				break;
			}
		}
		return position;
	}

	public List<Vertice> getVertices() {
		return vertices;
	}
	
	public List<Vertice> copy() throws Exception{
		List<Vertice> vtcs = new LinkedList<Vertice>();
		for (Vertice v: vertices){
			vtcs.add(Vertice.newInstance(v.getRotulo()));
		}
		return vtcs;
	}

	public void addVertice(Vertice v) {
		if (v != null && !vertices.contains(v)) {
			vertices.add(v);
		}
	}

	public void addAdjacente(Vertice u, Vertice v) {
		Vertice vertice = null;
		Vertice incidente = null;
		for (Vertice y : vertices) {
			if (y.equals(u)) {
				vertice = y;
			}
			if (y.equals(v)) {
				incidente = y;
			}
		}
		vertice.addAdjacente(incidente);
	}
	
	public void addAdjacente(Vertice u, Vertice v, int peso){
		Vertice vertice = null;
		Vertice incidente = null;
		for (Vertice y : vertices){
			if (y.equals(u)) {
				vertice = y;
			}
			if (y.equals(v)) {
				incidente = y;
			}
		}
		vertice.addAdjacente(incidente);
		incidente.addAdjacente(vertice);
		
		arestas.add(Aresta.newInstance(vertice, incidente, peso));
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Vertice v : vertices) {
			sb.append(String.format("%s%s", v.getRotulo(), "-> "));
			for (Vertice u : v.getAdjacentes()) {
				sb.append(String.format("%s %s", u.getRotulo(),
						" - "));
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	public String getBfs(Vertice origem) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < vertices.size(); i++) {
			Vertice v = vertices.get(i);
			if (!v.getD().equals(Integer.MAX_VALUE)) {
				sb.append(String.format("%s %s %d", origem.getRotulo(),
						v.getRotulo(), v.getD()));
				if(i < vertices.size()){
					sb.append("\n");
				}
			}
			
		}
        return sb.toString();
	}
	
	public List<Aresta> getArestas() {
		return arestas;
	}

}
