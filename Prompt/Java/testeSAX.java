package Java;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/*import br.unb.cic.Segmento.Tipo;*/

public class testeSAX {
	
  public static void main(String[] args){
	Pista pista = new Pista();
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
      parser.parse("XML/alpine-2.xml", handler);
      // Caminho do arquivo que funciona: /home/fabio/Documentos/Eclipse/SAX/XML/forza.xml
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
    
    if(r != null)
    	System.out.println(r.nome + " - Comprimento: " + r.getComprimento());
    
    if(c != null)
    	System.out.println(c.nome + " - Raio: " + c.getInitRadius());
    
    System.out.println("Comprimento da Pista: " + Estatisticas.getComprimentoTotal() + " m");
    System.out.println("Comprimento das Retas: " + Estatisticas.getComprimentoRetas() + " m");
    System.out.println("Metrica 'Comprimento das retas sobre o total': " + Estatisticas.getMetricaRetasSobreTotal());
    System.out.println("Metrica 'Soma de raios vezes angulos ponderada pelos raios': " + Estatisticas.getMetricaSomaPonderadaPorRaios());
    	
    
    System.out.println("Deu certo!");
  }
}
