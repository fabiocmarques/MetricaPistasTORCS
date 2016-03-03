package Java;

import java.util.ArrayList;

public class Pista {
	protected static AuxSeg aux;
	protected static ArrayList<Segmento> Segmentos;
	
	/**
	 * Definindo em um "enum" os possíveis estados para aquisição de informações do XML (EX significa extrair), caso o "enum" :
	 * 
	 * - EX_SEG: um novo segmento foi encontrado, seja ele uma nova curva ou reta. Nesse ponto um novo segmento é criado e é nomeado;
	 * - EX_COMP_RETA: uma reta está sendo criada e é o ponto de aquisição de seu comprimento;
	 * - EX_ARCO: uma curva está sendo criada e o seu arco deve ser extraído;
	 * - EX_INIT_RADIUS: ainda no processo de criação da curva, é extraído o raio inicial;
	 * - EX_END_RADIUS: o raio final da curva deve ser extraído.
	 * 
	 * @author fabio
	 *
	 */

	
	public Pista(){
		Segmentos = new ArrayList<Segmento>();
	}
	
	protected static Segmento getSegmento(int i){
		return Segmentos.get(i);
	}
		
	
}
