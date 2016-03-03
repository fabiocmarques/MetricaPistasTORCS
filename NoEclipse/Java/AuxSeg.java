package Java;

public class AuxSeg extends Segmento{
	public double comprimento;
	
	public double arco;
	public double radius;
	public Curva.Lado lado;
	
	
	public AuxSeg(Segmento.Tipo tipo){
		this.tipo = tipo;
		if(tipo.equals(Tipo.RETA))
			Estatisticas.incrementaNumeroRetas();
		else
			Estatisticas.incrementaNumeroCurvas();
			
		Estatisticas.incrementaNumeroSegmentos();
		
		this.arco = -1;
		this.radius = -1;
	}
	
	public void setComprimento(double comprimento){
		this.comprimento = comprimento;
	}
	
	public void setArco(double arco){
		this.arco = arco;
	}
	
	public void setInitRadius(double radius){
		this.radius = radius;
	}
	
	public void setLado(String lado){
		if(lado.equals("rgt"))
			this.lado = Curva.Lado.DIREITA;
		else
			this.lado = Curva.Lado.ESQUERDA;
	}


}
