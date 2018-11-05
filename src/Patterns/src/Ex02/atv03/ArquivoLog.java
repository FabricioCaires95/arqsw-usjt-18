package Ex02.atv03;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class ArquivoLog extends Log {

	@Override
	void efetuar(int[] numeros) {
		PrintWriter writer;
		try {
			writer = new PrintWriter("log.txt", "UTF-8");
			for (int i : numeros) {
				writer.println(i);
			}
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
