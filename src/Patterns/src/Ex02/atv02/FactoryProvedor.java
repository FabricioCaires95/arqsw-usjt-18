package Ex02.atv02;


public class FactoryProvedor {
	
	public Provedor getProvedor(String senha) {
		if (senha.equals("design patterns")) {
			return new ProvedorConfidencial();
		}
		// Se a senha for incorreta, retorna o p�blico
		return new ProvedorPublico();
	}
	
	public Provedor getProvedor() {
		return new ProvedorPublico();
	}

}
