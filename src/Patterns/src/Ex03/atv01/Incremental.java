package Ex03.atv01;


public class Incremental {
	private static int count = 0;
	private int numero;

	private static Incremental primeiraInstancia = null;

	static Incremental getInstanceOff() {
		if (primeiraInstancia == null) {
			primeiraInstancia = new Incremental();

		}
		return primeiraInstancia;
	}

	public void incrementa() {
		numero = ++count;
	}

	public String toString() {
		return "Incremental " + numero;
	}
}
