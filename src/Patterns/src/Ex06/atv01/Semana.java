package Ex06.atv01;


//classe Context
public class Semana {
	private final DiaDaSemana dia;
	
	public Semana(DiaDaSemana dia) {
		this.dia=dia;
	}
	
	public void imprimeDia() {
		System.out.println(dia.dia());
	}
	
}
