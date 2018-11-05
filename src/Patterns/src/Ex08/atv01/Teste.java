package Ex08.atv01;

import java.util.ArrayList;

public class Teste {

	public static void main(String[] args) {
		
		NoticiaAssina noticiario = new NoticiaAssina(new ArrayList<ConsomeNoticia>());
		
		Consumidor con1 = new Consumidor(noticiario,"Rodrigo");
		Consumidor con2 = new Consumidor(noticiario,"Guilherme");
		Consumidor con3 = new Consumidor(noticiario,"Renanzinho");
		
		con1.assinar();
		con2.assinar();
		Noticia noticia1 = new Noticia();
		noticia1.setTextoNoticia("Dólar aumento 3,2% em um dia");
		noticia1.setDia(24);
		noticia1.setMes(10);
		noticia1.setTopico("Economia");
		noticiario.setNoticia(noticia1);
		
		con1.cancelar();
		
		Noticia noticia2 = new Noticia();
		noticia2.setTextoNoticia("Novo presidente será eleito Domingo");
		noticia2.setDia(25);
		noticia2.setMes(10);
		noticia2.setTopico("Politica");
		
		noticiario.setNoticia(noticia2);
		con3.assinar();
		con1.assinar();
		
		
		Noticia noticia3 = new Noticia();
		noticia3.setTextoNoticia("Venda de discos volta a crescer");
		noticia3.setDia(20);
		noticia3.setMes(9);
		noticia3.setTopico("Cultura");
		
		noticiario.setNoticia(noticia3);
		
		
	}
	
	

}
