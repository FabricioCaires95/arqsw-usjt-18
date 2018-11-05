package Ex09.atv01;

public class TesteMaquinaVendas {
	
	public static void main(String[] args) {
		
		SlotChain chain1cent = new Slot1Cent();
		SlotChain chain5cent = new Slot5Cent();
		SlotChain chain10cent = new Slot10Cent();
		SlotChain chain25cent = new Slot25Cent();
		SlotChain chain50cent = new Slot50Cent();
		SlotChain chain1real = new Slot1Real();
		
		chain1cent.setNextChain(chain5cent);
		chain5cent.setNextChain(chain10cent);
		chain10cent.setNextChain(chain25cent);
		chain25cent.setNextChain(chain50cent);
		chain50cent.setNextChain(chain1real);
		
		Produto refri = new Produto("Refrigerante", 1.00);
		Produto batatinhas = new Produto("Batata", 2.50);
		
		Moeda m1c = new Moeda(0.01);
		Moeda m5c = new Moeda(0.05);
		Moeda m10c = new Moeda(0.10);
		Moeda m25c = new Moeda(0.25);
		Moeda m50c = new Moeda(0.50);
		Moeda m1r = new Moeda(1.00);
		
		chain1cent.calcula(m5c, refri);
		chain1cent.calcula(m10c, refri);
		chain1cent.calcula(m25c, refri);
		chain1cent.calcula(m25c, refri);
		chain1cent.calcula(m1r, refri);
		
		chain1cent.calcula(m1c, batatinhas);
		chain1cent.calcula(m50c, batatinhas);
		chain1cent.calcula(m1r, batatinhas);
		chain1cent.calcula(m50c, batatinhas);
		chain1cent.calcula(m25c, batatinhas);
		chain1cent.calcula(m25c, batatinhas);
	
	}

}
