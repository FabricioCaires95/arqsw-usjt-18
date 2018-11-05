package Ex02.atv03;


public class ConsoleLog extends Log {
	
	@Override
	void efetuar(int[] numeros) {
		for (int i : numeros) {
			System.out.println(i);
		}
	}

}
