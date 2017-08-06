package Projeto;

import java.util.List;
import java.util.ArrayList;

public class JogosTabuleiro extends Item {

	private List<String> pecasPerdidas;
	
	
	public JogosTabuleiro(String nomeItem, double valor) {
		
		super(nomeItem, valor);
		pecasPerdidas = new ArrayList<>();
		
		
	}
	
	public void adicionaPecaPerdida(String nomePeca){
		
		pecasPerdidas.add(nomePeca);
	}
	
	/**EST� FALTANDO O EQUALS]
	 * Tem que comparar as pe�as perdidas e o nome, por�m n�o como o nome ta em item n�o consegui saber como fazer(MATHEUS)
		
		**/


}
