package Ex04.atv02;

public class Teste {

	public static void main(String[] args) {
		SomadorEsperado somador = new SomadorAdapter();
		Cliente cliente = new Cliente(somador);
		cliente.executar();
	}

}
