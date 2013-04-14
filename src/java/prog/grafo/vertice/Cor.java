package prog.grafo.vertice;


public class Cor {
	
	private final String nome;
	
	private Cor(String nome) {
		this.nome = nome;
	}
	
	public static Cor newInstance(String nome) throws Exception{
		
		if(nome == null || "".equals(nome) ){
			throw new Exception("Erro ao instanciar cor");
		}
		return new Cor(nome);
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Cor){
			Cor other = (Cor) obj;
			return this.nome.endsWith(other.nome);
		}
		return false;
	}
	
	public String toString() {
		return this.nome;
	}
	
	public String getNome() {
		return nome;
	}
	

}
