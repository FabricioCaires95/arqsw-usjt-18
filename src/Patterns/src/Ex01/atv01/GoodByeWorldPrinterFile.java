package Ex01.atv01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class GoodByeWorldPrinterFile implements WorldPrinter{
	@Override
	public void print() {
		File file = new File("goodbye.txt");
		PrintWriter writer;
		System.out.println("file");
		try {
			writer = new PrintWriter(file);
			writer.print("GoodBye,World");
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		

	}
}
