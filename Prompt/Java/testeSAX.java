package Java;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/*import br.unb.cic.Segmento.Tipo;*/

public class testeSAX {
	
  public static void main(String[] args){
	Pista pista = new Pista();
  //A testar: D-Speedway, Forza, Brondehach, Alpine 1

  //String nomePista = new String("XML/d-speedway.xml");
  String nomePista = new String("XML/forza.xml");
  //String nomePista = new String("XML/brondehach.xml");
  //String nomePista = new String("XML/alpine-1.xml");

  //Pistas a serem testadas:
  //String nomePista = new String("XML/aalborg.xml");
  //String nomePista = new String("XML/alpine-2.xml");
  //String nomePista = new String("XML/c-speedway.xml");
  //String nomePista = new String("XML/dirt-1.xml");
  //String nomePista = new String("XML/dirt-3.xml");
  //String nomePista = new String("XML/e-speedway.xml");
  //String nomePista = new String("XML/g-speedway.xml");
  //String nomePista = new String("XML/Limalonges-mountain-snow.xml");
  //String nomePista = new String("XML/spring.xml");
  //String nomePista = new String("XML/wheel-2.xml");


	Estatisticas est = new Estatisticas();
	
    try {
      // vamos criar e retornar uma nova instância da implementação SAX
      SAXParserFactory factory = SAXParserFactory.newInstance();

      // vamos criar o parser
      SAXParser parser = factory.newSAXParser();

      // vamos definir a classe tratador (handler) que extende a 
      // classe DefaultHandler
      SaxHandler handler = new SaxHandler();

      // finalmente vamos fazer o parsing do documento XML
      parser.parse(nomePista, handler);
      // Caminho do arquivo que funciona(exemplo): "XML/forza.xml"
    }
    catch(Exception ex){
      ex.printStackTrace(System.out);
    }
    
    Estatisticas.calculaEstatisticas();
    
    Segmento seg = Pista.getSegmento(0);
    Curva c = null;
    Reta r = null;
    
    if(seg.tipo.equals(Segmento.Tipo.RETA))
    	r = (Reta)seg;
    else
    	c = (Curva)seg;
    
    
    System.out.println("\n\n\n Nome da pista: " + nomePista + "\n");
    System.out.println("Comprimento da Pista: " + Estatisticas.getComprimentoTotal() + " m");
    System.out.println("Numero de Retas: " + Estatisticas.getNumeroRetas());
    System.out.println("Comprimento das Retas: " + Estatisticas.getComprimentoRetas() + " m");
    System.out.println("Numero de Curvas: " + Estatisticas.getNumeroCurvas());
    System.out.println("Comprimento das Curvas: " + Estatisticas.getComprimentoCurvas() + " m");
    System.out.println("Metrica 'Comprimento das retas sobre o total': " + Estatisticas.getMetricaRetasSobreTotal());
    System.out.println("Metrica 'Soma de raios vezes angulos ponderada pelos raios': " + Estatisticas.getMetricaSomaPonderadaPorRaios());
    System.out.println("Metrica 'Somatório dos inversos dos raios': " + Estatisticas.getMetricaInvRaios());
    System.out.println("Metrica 'Somatório dos inversos dos raios vezes o número de curvas': " + Estatisticas.getMetricaInvRaiosXCurvas());
    System.out.println("Métrica 'Curvas seguidas': " + Estatisticas.getMetricaCurvasSeguidas());

    System.out.println("Variancia dos comprimentos de retas: " + Estatisticas.getVarRetas());
    System.out.println("Variancia dos comprimentos de curvas: " + Estatisticas.getVarCurvas());
    System.out.println("Variancia dos angulos: " + Estatisticas.getVarAngulos());
    System.out.println("Variancia dos raios: " + Estatisticas.getVarRaios() + " " + Estatisticas.getRaiosTotais());

    
    System.out.println("Deu certo!");
  }
}
