package Ex08.atv01;

import java.util.List;

public class NoticiaAssina extends Noticiario {
	private Noticia noticia;
	
	public Noticia getNoticia() {
		return noticia;
	}
	public void setNoticia(Noticia noticia) {
		this.noticia = noticia;
		notificaNoticia(noticia.getTextoNoticia(), noticia.getDia(), noticia.getMes(), noticia.getTopico());
	}

	private final List<ConsomeNoticia> consumidores;
	
	public  NoticiaAssina (List<ConsomeNoticia> consumidores) {
		this.consumidores=consumidores;
	}
	@Override
	public void notificaNoticia(String textoNoticia, int dia, int mes, String topico) {
		for (ConsomeNoticia consumidor: consumidores) {
			System.out.printf("Assinante: %s. \n", consumidor.getAssinante());
			consumidor.consomeNoticia(textoNoticia, dia, mes, topico);
		}
		
	}

	@Override
	public void inscreverConsumidor(ConsomeNoticia consumidor) {
		consumidores.add(consumidor);
		System.out.printf("%s assinou \n", consumidor.getAssinante());
		
	}

	@Override
	public void removerConsumidor(ConsomeNoticia consumidor) {
		int index = consumidores.indexOf(consumidor);
		consumidores.remove(index);
		System.out.printf("%s removeu \n",consumidor.getAssinante());
	}

}
