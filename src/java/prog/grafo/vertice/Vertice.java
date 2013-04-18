package prog.grafo.vertice;

import java.util.LinkedList;
import java.util.List;

public class Vertice implements Comparable<Vertice> {
	
	private String rotulo;
	private List<Vertice> adjacentes = new LinkedList<Vertice>();
	private Cor cor;
	private Integer d = Integer.MAX_VALUE;
	private Integer f = Integer.MAX_VALUE;
	private Vertice pai;
	
	private Vertice(String rotulo){
		this.rotulo = rotulo;
	}
	
	private Vertice(String rotulo, Integer f){
		this.rotulo  = rotulo;
		this.f = f;
	}
	
	public static Vertice newInstance(String rotulo) throws Exception{
		if(rotulo == null || "".equals(rotulo)){
			throw new  Exception("rotulo não pode ser nulo ou vazio.");
		}
		return new Vertice(rotulo);
	}
	
	public static Vertice newInstance(String rotulo, Integer f) throws Exception{
		if(rotulo == null || "".equals(rotulo)){
			throw new  Exception("rotulo não pode ser nulo ou vazio.");
		}
		return new Vertice(rotulo, f);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Vertice){
			Vertice other = (Vertice) obj;
			return this.rotulo.equals(other.rotulo);
		}
		return false;
	}
	
	
	@Override
	public String toString() {
		return this.rotulo;
	}
	
	@Override
	public int compareTo(Vertice o) {
		if (this.f > o.f){
			return -1;
		}
		else if(this.f < o.f){
			return 1;
		}
		return 1;
	}
	
	public boolean addAdjacente(Vertice u){
		if(u != null && !adjacentes.contains(u)){
			return adjacentes.add(u);
		}
		return false;
	}
	
	public void addAdjacentes(List<Vertice> vertices){
		if (vertices != null) {
			for (Vertice v :vertices){
				addAdjacente(v);
			}
		}
	}
	
	public String getRotulo() {
		return rotulo;
	}
	
	public List<Vertice> getAdjacentes() {
		return adjacentes;
	}
	
	public Cor getCor() {
		return cor;
	}
	
	public void setCor(Cor cor) {
		this.cor = cor;
	}
	
	public Integer getD() {
		return d;
	}
	
	public void setD(Integer d) {
		this.d = d;
	}
	
	public Vertice getPai() {
		return pai;
	}
	
	public void setPai(Vertice pai) {
		this.pai = pai;
	}
	
	public void setF(Integer f) {
		this.f = f;
	}
	
	public Integer getF() {
		return f;
	}

	

}
