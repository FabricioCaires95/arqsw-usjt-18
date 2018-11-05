package Ex03.atv01;

public class TesteIncremental {
	
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			Incremental inc = Incremental.getInstanceOff();
			inc.incrementa();
			System.out.println(inc);
		}
	}
	
}
