package br.unb.cic;

public class Curva extends Segmento{
	private double arco;
	private double initRadius;
	private double endRadius;
	private double comprimento;
	
	public enum Lado{
		DIREITA, ESQUERDA;
	};
	
	private Lado lado;
	
	public Curva(String nome, double arco, double initRadius, double endRadius, Lado lado, Tipo t){
		this.setNome(nome);
		this.arco = arco;
		this.initRadius = initRadius;
		this.endRadius = endRadius;
		this.lado = lado;
		
		// @todo Lembrar de ajustar o cálculo do comprimento. 
		this.comprimento = initRadius*arco*3.14159/180;
		if(endRadius != 0.0){
			double size2 = endRadius*arco*3.14159/180;
			comprimento = (this.comprimento + size2)/2;
		}
		this.tipo = t;
		Estatisticas.aumentaComprimentoCurvas(comprimento);
		Estatisticas.aumentaComprimentoTotal(comprimento);
	}

	protected double getArco() {
		return arco;
	}

	protected double getInitRadius() {
		return initRadius;
	}

	protected double getEndRadius() {
		return endRadius;
	}

	protected double getComprimento() {
		return comprimento;
	}

	protected Lado getLado() {
		return lado;
	}
	
	

}
