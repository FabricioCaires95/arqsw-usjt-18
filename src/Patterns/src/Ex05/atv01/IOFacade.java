package Ex05.atv01;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class IOFacade {
	
	public void gravarArquivoTexto(String nome, String[] conteudo) {
		File outFile = new File(nome);
		try {
			outFile.createNewFile();
			BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));
			for (String linha : conteudo) {
				writer.write(linha);
				writer.newLine();
			}
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void lerArquivoTexto(String nome) {
		try{
			BufferedReader reader = new BufferedReader(new FileReader(nome));
			while (reader.ready()) {
				String linha;
				while ((linha = reader.readLine()) != null) {
					System.out.println(linha);
				}
			}
			reader.close();
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	public void gravarArquivoBinario(String nome, byte[] conteudo) {
		File outFile = new File(nome);
		try {
			FileOutputStream outStream = new FileOutputStream(outFile);
			outStream.write(conteudo);
			outStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void lerArquivoBinario(String nome) {
		File inFile = new File(nome);
		try {
			FileInputStream inStream = new FileInputStream(inFile);
			int tamanho = (int) inFile.length();
			byte[] conteudo = new byte[tamanho];
			inStream.read(conteudo);
			for (int i = 0; i < conteudo.length; i++) {
				System.out.println(conteudo[i]);
			}
			inStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	
			
	}
	
	public void gravarObjeto(String nome, Object objeto) {
		try {
			ObjectOutputStream objectOut = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(nome)));			
			objectOut.writeObject(objeto);
			objectOut.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void lerObjeto(String nome) {
		try {
			ObjectInputStream objectIn = new ObjectInputStream(new BufferedInputStream(new FileInputStream(nome)));
			Object objeto = (Object) objectIn.readObject();
			System.out.println(objeto.toString());
			objectIn.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
