package Ex08.atv02;

public class TesteNoticias {
	
	public static void main(String[] args) {
		
		NoticiarioAssina not = new NoticiarioAssina();
		ConsomeNoticia pub = new Publicador();
		Agregador agrTop = new AgregadorTopico("Programacaoo");
		Agregador agrMes = new AgregadorMes();
		
		not.adicionaConsumidor(pub);
		not.adicionaConsumidor(agrTop);
		not.adicionaConsumidor(agrMes);
		
		agrTop.adicionaConsumidor(pub);
		agrMes.adicionaConsumidor(pub);
		
		not.notificaNoticia("Universitario vai votar em um candidato!", 3, 6, "Politica");
		not.notificaNoticia("Universitario é visto programando em Java!", 6, 6, "Programacao");
		not.notificaNoticia("Ocorrera um Hackaton em breve!", 21, 6, "Programacao");
		not.notificaNoticia("Imperdivel! Jovem aprende a programar em duas linguagens de programacao!", 2, 7, "Programacao");
		not.notificaNoticia("Noticia urgente de programacao!", 4, 7, "Programacao");
		not.notificaNoticia("Noticia nem tao urgente de programacao!", 5, 7, "Programacao");
		not.notificaNoticia("Noticia sobre programacao!", 7, 7, "Programacao");
		not.notificaNoticia("Amontoado de informaçoes!", 13, 7, "Programacao");
		not.notificaNoticia("Nova linguagem de programacao!", 21, 7, "Programacao");
		not.notificaNoticia("App lançado!", 28, 7, "Programacao");
		not.notificaNoticia("Padrao de projeto revolucionario!", 15, 8, "Programacao");
	
	}

}
