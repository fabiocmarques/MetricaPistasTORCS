package Java;

public abstract class Segmento{
	public String nome;
	
	public enum Tipo{
		RETA, CURVA;
	};
	
	public Tipo tipo;
	
	protected void setNome(String nome){
		this.nome = nome;
	}

}
