package Ex08.atv02;


import java.util.ArrayList;
import java.util.List;

public class NoticiarioAssina extends Noticiario {
	
	private List<ConsomeNoticia> consumidores = new ArrayList<>();
	
	public void adicionaConsumidor(ConsomeNoticia consumidor) {
		this.consumidores.add(consumidor);
	}
	
	public void removeConsumidor(ConsomeNoticia consumidor) {
		this.consumidores.remove(consumidor);
	}

	@Override
	public void notificaNoticia(String textoNoticia, int dia, int mes, String topico) {
		for (ConsomeNoticia consumidor : this.consumidores) {
			consumidor.notificaNoticia(textoNoticia, dia, mes, topico);
		}
	}
}
