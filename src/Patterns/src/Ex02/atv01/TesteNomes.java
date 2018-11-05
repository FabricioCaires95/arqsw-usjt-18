package Ex02.atv01;



public class TesteNomes {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		FactoryNome factNS = new FactoryNomeSobrenome();
		FactoryNome factSN = new FactorySobrenomeNome();
		
		String scott = "McNealy, Scott";
		String james = "James Gosling";
		String patrick = "Naughton, Patrick";
		
		Nome nomeScott = factSN.getNome(scott);
		Nome nomeJames = factNS.getNome(james);
		Nome nomePatrick = factSN.getNome(patrick);
		
		factNS.listarNomes();
		factSN.listarNomes();
		
	}
}
