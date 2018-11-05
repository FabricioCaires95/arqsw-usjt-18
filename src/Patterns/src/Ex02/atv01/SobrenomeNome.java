package Ex02.atv01;


public class SobrenomeNome extends Nome {
	
	public SobrenomeNome(String string) {
		String[] partes = string.split(", ");
		super.setNome(partes[1]);
		super.setSobrenome(partes[0]);
		
	}


	@Override
	public void exibir() {
		System.out.println(super.getSobrenome() + ", " + super.getNome());
		
	}
	
	

}
