package prog.grafo.aresta;

import prog.grafo.vertice.Vertice;

public class Aresta implements Comparable<Aresta> {

	private Vertice a;
	private Vertice b;
	private int valor;

	private Aresta(Vertice a, Vertice b, int valor) {
		this.a = a;
		this.b = b;
		this.valor = valor;
	}

	public static Aresta newInstance(Vertice a, Vertice b, int valor) {
		return new Aresta(a, b, valor);
	}

	public int getValor() {
		return valor;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Aresta){
			Aresta other = (Aresta) obj;
			return (this.valor == other.valor) && 
				   ((this.a.equals(other.a) && this.b.equals(other.b) )  ||  (this.a.equals(other.b) && this.b.equals(other.a))) ;
			
		}
		return false;
	}
	@Override
	public String toString() {
		return String.format("%s(%s) %s(%s) %d", a.getRotulo(), a.getPai().getRotulo(), b.getRotulo(),b.getPai().getRotulo(), valor);
	}

	@Override
	public int compareTo(Aresta o) {
		if (this.valor > o.valor) {
			return 1;
		} else if (this.valor < o.valor) {
			return -1;
		}
		return 0;
	}
	
	public Vertice getA() {
		return a;
	}
	
	public Vertice getB() {
		return b;
	}

}
