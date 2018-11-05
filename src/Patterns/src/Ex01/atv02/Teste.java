package Ex01.atv02;

public class Teste {

	public static void main(String[] args) {
		AbstractPizzaria fabrica = new Pizzaria();
		
		Pizza pizza = fabrica.getFactory(DiaSemana.SEGUNDA);
		System.out.println(pizza.fazer());
		
		pizza = fabrica.getFactory(DiaSemana.TERCA);
		System.out.println(pizza.fazer());
		
		fabrica = new Calzonaria();
		
		pizza = fabrica.getFactory(DiaSemana.QUARTA);
		System.out.println(pizza.fazer());
		
		pizza = fabrica.getFactory(DiaSemana.QUINTA);
		System.out.println(pizza.fazer());
		
		pizza = fabrica.getFactory(DiaSemana.DOMINGO);

	}

}
