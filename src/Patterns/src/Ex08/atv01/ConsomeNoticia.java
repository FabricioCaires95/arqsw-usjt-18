package Ex08.atv01;

public interface ConsomeNoticia {
	public void consomeNoticia(String textoNoticia, int dia, int mes, String topico);
	public void assinar();
	public void cancelar();
	public String getAssinante();
}