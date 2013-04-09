package prog.grafo.vertice;


public class Cor {
	
	private final String nome;
	
	private final String rgb;

	private Cor(String nome, String rgb) {
		this.nome = nome;
		this.rgb = rgb;
	}
	
	public static Cor newInstance(String nome, String rgb) throws Exception{
		
		if(nome == null || "".equals(nome) || rgb == null || rgb.length() != 6){
			throw new Exception("Erro ao instanciar cor");
		}
		return new Cor(nome, rgb);
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
	
	public String getRgb() {
		return String.format("%s%s", "#", rgb);
	}

}
