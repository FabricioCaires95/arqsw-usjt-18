package Ex01.atv01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class HelloWorldPrinterFile implements WorldPrinter {

	@Override
	public void print() {
		File file = new File("hello.txt");
		PrintWriter writer;
		try {
			writer = new PrintWriter(file);
			writer.print("Hello,World");
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		

	}

}
