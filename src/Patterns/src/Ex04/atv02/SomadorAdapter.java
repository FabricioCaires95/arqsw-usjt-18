package Ex04.atv02;

import java.util.ArrayList;
import java.util.List;

public class SomadorAdapter implements SomadorEsperado{

	@Override
	public int somaVetor(int[] vetor) {
		SomadorExistente somador = new SomadorExistente();
		List<Integer> lista = new ArrayList<Integer>();
		for (int i = 0; i<vetor.length;i++){
			lista.add(vetor[i]);
		} 
		return somador.somaLista(lista);
	}
	
}
