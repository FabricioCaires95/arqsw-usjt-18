package Ex01.atv01;


public class ClientHelloWorld {
	public static void main(String [] args) {
		ClientHelloWorld cliente= new ClientHelloWorld();
		AbstractWorldPrinterFactory [] factory = {new HelloWorldPrinterFactory(), 
				new GoodByeWorldPrinterFactory()};
		
		AbstractWorldPrinterFactory printerFactory = factory[cliente.sorteio()];
		
		String[] tipos = {HelloWorldPrinterFactory.SCREEN,HelloWorldPrinterFactory.FILE};
		WorldPrinter printer = printerFactory.getPrinterInstance(tipos[cliente.sorteio()]);
		printer.print();
	}
	
	public int sorteio() {
		return (int) Math.round(Math.random());
	}
}
