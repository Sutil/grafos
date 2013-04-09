package prog.grafo.vertice;

import java.util.LinkedList;
import java.util.List;

public class Vertice {
	
	private String rotulo;
	private List<Vertice> adjacentes = new LinkedList<Vertice>();
	private Cor cor;
	private Integer distanciadDaOrigem = Integer.MAX_VALUE;
	private Vertice pai;
	
	
	private Vertice(String rotulo){
		this.rotulo = rotulo;
	}
	
	public static Vertice newInstance(String rotulo) throws Exception{
		if(rotulo == null || "".equals(rotulo)){
			throw new  Exception("rotulo não pode ser nulo ou vazio.");
		}
		return new Vertice(rotulo);
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
	
	public Integer getDistanciadDaOrigem() {
		return distanciadDaOrigem;
	}
	
	public void setDistanciadDaOrigem(Integer distanciadDaOrigem) {
		this.distanciadDaOrigem = distanciadDaOrigem;
	}
	
	public Vertice getPai() {
		return pai;
	}
	
	public void setPai(Vertice pai) {
		this.pai = pai;
	}

}
