package br.unb.cic;

import br.unb.cic.Curva.Lado;

public class AuxSeg extends Segmento{
	public double comprimento;
	
	public double arco;
	public double initRadius;
	public double endRadius;
	public Lado lado;
	
	
	public AuxSeg(Tipo tipo){
		this.tipo = tipo;
		if(tipo.equals(Tipo.RETA))
			Estatisticas.incrementaNumeroRetas();
		else
			Estatisticas.incrementaNumeroCurvas();
			
		Estatisticas.incrementaNumeroSegmentos();
	}
	
	public void setComprimento(double comprimento){
		this.comprimento = comprimento;
	}
	
	public void setArco(double arco){
		this.arco = arco;
	}
	
	public void setInitRadius(double radius){
		this.initRadius = radius;
	}
	
	public void setEndRadius(double radius){
		this.endRadius = radius;
	}
	
	public void setLado(String lado){
		if(lado.equals("rgt"))
			this.lado = Curva.Lado.DIREITA;
		else
			this.lado = Curva.Lado.ESQUERDA;
	}


}
