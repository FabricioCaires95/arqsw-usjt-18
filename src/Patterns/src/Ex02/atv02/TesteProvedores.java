package Ex02.atv02;

public class TesteProvedores {
	
	public static void main(String[] args) {
		
		FactoryProvedor provFact = new FactoryProvedor();
		
		// Confidencial
		Provedor provedor = provFact.getProvedor("design patterns");
		provedor.exibir();
		
		// Publico
		provedor = provFact.getProvedor();
		provedor.exibir();
		
	}

}
