package Ex01.atv01;

public class GoodByeWorldPrinterFactory implements AbstractWorldPrinterFactory {
	public static final String SCREEN = "screen";
	public static final String FILE = "file";
	@Override
	public WorldPrinter getPrinterInstance(String printerType) {
		switch(printerType) {
		case SCREEN:
			return new GoodbyeWorldPrinterScreen();
		case FILE:
			return new GoodByeWorldPrinterFile();
		}
		return null;
	}

}
