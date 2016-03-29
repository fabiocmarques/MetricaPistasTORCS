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
	
	protected static double metricaCompRetasSobreTotal;
	protected static double metricaMediaPonderadaPorRaios;
	protected static double metricaSomInvRaios;
	protected static double metricaInvRaiosVezesNumCurvas;
	
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
	}
	
	public static void calculaEstatisticas(){
		metricaCompRetasSobreTotal = comprimentoRetas/comprimentoTotal;
		metricaMediaPonderadaPorRaios = raioVezesAnguloTotal/raiosTotais;
		metricaSomInvRaios = total1SobreRaio;
		metricaInvRaiosVezesNumCurvas = total1SobreRaio*numeroCurvas;
		
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
		Estatisticas.total1SobreRaio += incremento; 
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
}
