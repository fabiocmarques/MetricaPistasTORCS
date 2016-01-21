package br.unb.cic;

import java.security.GeneralSecurityException;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import br.unb.cic.Segmento.Tipo;

public class SaxHandler extends DefaultHandler{
	
  @Override
  public void startElement(String uri, String localName,
     String qName, Attributes attrs) throws SAXException {
	  
	  /**
	   * Operações para retas
	   */
	  if(qName.equals("DOCTYPE") || qName.equals("ENTITY")){
		  return;
	  }

     // Nova reta é encontrada e o processo de criação dela é iniciado 
     if(qName.equals("attstr") && "str".equals(attrs.getValue("val")) ){
    	 Pista.aux = new AuxSeg(Tipo.RETA);
    	 Pista.aux.setNome("Reta " + Estatisticas.numeroRetas);
     }
     
     // Aquisição do comprimento da reta 
     if(qName.equals("attnum") && "lg".equals(attrs.getValue("name")) ){
    	 Pista.aux.setComprimento(Double.parseDouble(attrs.getValue("val")));
    	 if("ft".equals(attrs.getValue("unit")))
    		 Pista.Segmentos.add(new Reta(Pista.aux.nome, Pista.aux.comprimento*0.3048, Tipo.RETA));
    	 else	 
    		 Pista.Segmentos.add(new Reta(Pista.aux.nome, Pista.aux.comprimento, Tipo.RETA));
  	 
     }
     
     
     
     /**
      * Operações para curvas
      */
     
     // Nova curva para a direita é encontrada e o processo de criação dela é iniciado 
     if(qName.equals("attstr") && "rgt".equals(attrs.getValue("val"))){
    	 Pista.aux = new AuxSeg(Tipo.CURVA);
    	 Pista.aux.setNome("Curva " + Estatisticas.numeroCurvas);
    	 Pista.aux.setLado("rgt");
     }
     
     
     // Nova curva para a esquerda é encontrada e o processo de criação dela é iniciado 
     if(qName.equals("attstr") && "lft".equals(attrs.getValue("val")) ){
    	 Pista.aux = new AuxSeg(Tipo.CURVA);
    	 Pista.aux.setNome("Curva " + Estatisticas.numeroCurvas);
    	 Pista.aux.setLado("lft");
     }
     
     
     
     // Aquisição do arco da curva 
     if(qName.equals("attnum") && "arc".equals(attrs.getValue("name"))){
    	 Pista.aux.setArco(Double.parseDouble(attrs.getValue("val")) /* 3.14159 / 180*/);
    	 
    	 if(Pista.aux.radius != -1)
        	 Pista.Segmentos.add(new Curva(Pista.aux.nome, Pista.aux.arco, Pista.aux.radius, Pista.aux.lado, Tipo.CURVA));
  	 
     }
     
     
     // Aquisição do raio inicial da curva 
     if(qName.equals("attnum") && "radius".equals(attrs.getValue("name")) ){
    	 Pista.aux.setInitRadius(Double.parseDouble(attrs.getValue("val")));
    	 if("ft".equals(attrs.getValue("unit")))
    		 Pista.aux.setInitRadius(Pista.aux.radius*0.3048);
    	 Estatisticas.aumentaRaiosTotais(Pista.aux.radius);
    	 Estatisticas.aumentaRaioVezesAngulo(Pista.aux.radius * Pista.aux.arco);
    	 
    	 if(Pista.aux.arco != -1)
        	 Pista.Segmentos.add(new Curva(Pista.aux.nome, Pista.aux.arco, Pista.aux.radius, Pista.aux.lado, Tipo.CURVA));  	 
     }
     
  }
  
}   