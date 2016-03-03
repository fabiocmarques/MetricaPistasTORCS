package Java;

public class Reta extends Segmento{
	private double comprimento;
	
	public Reta(String nome, double comprimento, Tipo t){
		this.setNome(nome);
		this.tipo = t;
		this.comprimento = comprimento;
		Estatisticas.aumentaComprimentoRetas(comprimento);
		Estatisticas.aumentaComprimentoTotal(comprimento);
	}
	
	public double getComprimento(){
		return comprimento;
	}
}
