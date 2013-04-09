package prog.grafo;

import java.util.LinkedList;
import java.util.List;

import prog.grafo.vertice.Vertice;

public class Grafo {

	List<Vertice> vertices = new LinkedList<Vertice>();

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

	public List<Vertice> getVertices() {
		return vertices;
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

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Vertice v : vertices) {
			sb.append(String.format("%s%s", v.getRotulo(), "-> "));
			for (Vertice u : v.getAdjacentes()) {
				sb.append(String.format("%s%s %s", u.getRotulo(), u.getCor(),
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
			if (!v.getDistanciadDaOrigem().equals(Integer.MAX_VALUE)) {
				sb.append(String.format("%s %s %d", origem.getRotulo(),
						v.getRotulo(), v.getDistanciadDaOrigem()));
				if(i < vertices.size()){
					sb.append("\n");
				}
			}
			
		}
        return sb.toString();
	}

}
