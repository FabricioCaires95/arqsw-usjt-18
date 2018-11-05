package Ex02.atv01;

import java.util.ArrayList;

public class FactoryNomeSobrenome implements FactoryNome {
	
	ArrayList<Nome> nomes;
	
	public FactoryNomeSobrenome() {
		nomes = new ArrayList<Nome>();
	}
	
	public Nome getNome(String string) {
		Nome nome = new NomeSobrenome(string);
		nomes.add(nome);
		return nome;
	}

	@Override
	public void listarNomes() {
		System.out.println("Listando 'Nome Sobrenome':");
		for(Nome nome : nomes) {
			nome.exibir();
		}
		
	}

}
