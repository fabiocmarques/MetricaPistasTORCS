package Java;

public class Estatisticas {
	
	protected static int numeroSegmentos;
	protected static int numeroCurvas;
	protected static int numeroRetas;
	protected static double comprimentoTotal;
	protected static double comprimentoRetas;
	protected static double comprimentoCurvas;
	protected static double raiosTotais;
	protected static double raioVezesAnguloTotal;
	protected static double total1SobreRaio;
	protected static double somatorioAngulos;
	
	protected static double metricaCompRetasSobreTotal;
	protected static double metricaMediaPonderadaPorRaios;
	protected static double metricaSomInvRaios;
	protected static double metricaInvRaiosVezesNumCurvas;
	protected static double varCompRetas;
	protected static double varCompCurvas;
	protected static double varAngulos;
	protected static double varRaios;

	protected static int metricaCurvasSeguidas;
	
	public Estatisticas(){
		this.numeroSegmentos = 0;
		this.numeroCurvas = 0;
		this.numeroRetas = 0;
		this.comprimentoTotal = 0.0;
		this.comprimentoRetas = 0.0;
		this.comprimentoCurvas = 0.0;
		this.raiosTotais = 0.0;
		this.raioVezesAnguloTotal = 0.0;
		this.total1SobreRaio = 0.0;
		this.metricaCurvasSeguidas = 0;
		this.somatorioAngulos = 0.0;

		this.varCompRetas = 0.0;
		this.varCompCurvas = 0.0;
		this.varAngulos = 0.0;
		this.varRaios = 0.0;
	}
	
	public static void calculaEstatisticas(){
		metricaCompRetasSobreTotal = comprimentoRetas/comprimentoTotal;
		metricaMediaPonderadaPorRaios = raioVezesAnguloTotal/raiosTotais;
		metricaSomInvRaios = total1SobreRaio;
		metricaInvRaiosVezesNumCurvas = total1SobreRaio*numeroCurvas;
		metricaCurvasSeguidas = calcCurvasSeguidas();
		geraVariancias();
		
	}
	
	protected static int getNumeroSegmentos() {
		return numeroSegmentos;
	}
	protected static void incrementaNumeroSegmentos() {
		Estatisticas.numeroSegmentos = Estatisticas.numeroSegmentos + 1;
	}
	protected static int getNumeroCurvas() {
		return numeroCurvas;
	}
	protected static void incrementaNumeroCurvas() {
		Estatisticas.numeroCurvas = Estatisticas.numeroCurvas + 1;
	}
	protected static int getNumeroRetas() {
		return numeroRetas;
	}
	protected static void incrementaNumeroRetas() {
		Estatisticas.numeroRetas = Estatisticas.numeroRetas + 1;
	}
	protected static double getComprimentoTotal() {
		return comprimentoTotal;
	}
	protected static void aumentaComprimentoTotal(double comprimentoTotal) {
		Estatisticas.comprimentoTotal = Estatisticas.comprimentoTotal + comprimentoTotal;
	}
	protected static double getComprimentoRetas() {
		return comprimentoRetas;
	}
	protected static void aumentaComprimentoRetas(double comprimentoRetas) {
		Estatisticas.comprimentoRetas = Estatisticas.comprimentoRetas + comprimentoRetas;
	}
	protected static double getComprimentoCurvas() {
		return comprimentoCurvas;
	}
	protected static void aumentaComprimentoCurvas(double comprimetoCurvas) {
		Estatisticas.comprimentoCurvas = Estatisticas.comprimentoCurvas + comprimetoCurvas;
	}
	
	protected static void aumentaRaiosTotais(double raio){
		Estatisticas.raiosTotais += raio;
	}
	
	protected static double getRaiosTotais(){
		return Estatisticas.raiosTotais;
	}
	
	protected static void aumentaRaioVezesAngulo(double raioXangulo){
		Estatisticas.raioVezesAnguloTotal += raioXangulo;
	}
	
	protected static double getRaioVezesAngulo(){
		return Estatisticas.raioVezesAnguloTotal;
	}
	
	protected static double getMetricaRetasSobreTotal(){
		return Estatisticas.metricaCompRetasSobreTotal;
	}
	
	protected static double getMetricaSomaPonderadaPorRaios(){
		return Estatisticas.metricaMediaPonderadaPorRaios;
	}

	protected static void aumentaTotal1SobreRaio(double incremento){
		Estatisticas.total1SobreRaio += 1/incremento; 
	}

	protected static double getTotal1SobreRaio(){
		return Estatisticas.total1SobreRaio;
	}

	protected static double getMetricaInvRaios(){
		return Estatisticas.metricaSomInvRaios;
	}

	protected static double getMetricaInvRaiosXCurvas(){
		return Estatisticas.metricaInvRaiosVezesNumCurvas;
	}

	protected static int getMetricaCurvasSeguidas(){
		return Estatisticas.metricaCurvasSeguidas;
	}

	protected static void aumentaAnguloTotal(double incremento){
		Estatisticas.somatorioAngulos += incremento;
	}

	protected static int calcCurvasSeguidas(){
		int i, j = 0;
		Segmento aux;

		for(i = 0; i < Pista.Segmentos.size(); ++i){
			aux = Pista.Segmentos.get(i);

			if(i == Pista.Segmentos.size()-1){
				if(aux.tipo == Segmento.Tipo.CURVA && ((Curva)aux).getLado() == Curva.Lado.DIREITA){
					if( Pista.Segmentos.get(0).tipo == Segmento.Tipo.CURVA && ((Curva)Pista.Segmentos.get(0)).getLado() == Curva.Lado.ESQUERDA){
						++j;
					}
				}
				if(aux.tipo == Segmento.Tipo.CURVA && ((Curva)aux).getLado() == Curva.Lado.ESQUERDA){
					if( Pista.Segmentos.get(0).tipo == Segmento.Tipo.CURVA && ((Curva)Pista.Segmentos.get(0)).getLado() == Curva.Lado.DIREITA)
						++j;
				}

				continue;
			}


			if(aux.tipo == Segmento.Tipo.CURVA && ((Curva)aux).getLado() == Curva.Lado.DIREITA){
				if( Pista.Segmentos.get(i+1).tipo == Segmento.Tipo.CURVA && ((Curva)Pista.Segmentos.get(i+1)).getLado() == Curva.Lado.ESQUERDA){
					++j;
				}					
									
			}
			if(aux.tipo == Segmento.Tipo.CURVA && ((Curva)aux).getLado() == Curva.Lado.ESQUERDA){
				if( Pista.Segmentos.get(i+1).tipo == Segmento.Tipo.CURVA && ((Curva)Pista.Segmentos.get(i+1)).getLado() == Curva.Lado.DIREITA){
					++j;
				}
			}
		}


		return j;
	}

	protected static void geraVariancias(){
		double mediaCompRetas = comprimentoRetas/numeroRetas, mediaCompCurvas = comprimentoCurvas/numeroCurvas, 
				mediaAngulos = somatorioAngulos/numeroCurvas, mediaRaios = raiosTotais/numeroCurvas;
		double aux;
		Segmento aux2;

		System.out.println("Media de comprimento de retas: " + mediaCompRetas);
		System.out.println("Media de comprimento de curvas: " + mediaCompCurvas);
		System.out.println("Media de angulos: " + mediaAngulos);
		System.out.println("Media de raios: " + mediaRaios);

			for(int i = 0; i < Pista.Segmentos.size(); ++i){
				aux2 = Pista.Segmentos.get(i);

				if(aux2.tipo == Segmento.Tipo.CURVA){
					aux = mediaCompCurvas-(((Curva)aux2).getComprimento());
					varCompCurvas += (aux*aux);
					aux = mediaAngulos - (((Curva)aux2).getArco());
					varAngulos += (aux*aux);
					aux = mediaRaios - (((Curva)aux2).getInitRadius());
					varRaios += (aux*aux);
				}
				if(aux2.tipo == Segmento.Tipo.RETA){
					aux = mediaCompRetas-(((Reta)aux2).getComprimento());
					varCompRetas += (aux*aux);
				}
			}

		varAngulos /= numeroCurvas;
		varCompCurvas /= numeroCurvas;
		varCompRetas /= numeroRetas;
		varRaios /= numeroCurvas;

	}

	protected static double getVarRetas(){
		return varCompRetas;
	}

	protected static double getVarCurvas(){
		return varCompCurvas;
	}

	protected static double getVarAngulos(){
		return varAngulos;
	}

	protected static double getVarRaios(){
		return varRaios;
	}
}