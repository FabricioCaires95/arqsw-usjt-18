package Ex02.atv01;

public class NomeSobrenome extends Nome {
	
	public NomeSobrenome(String string) {
		String[] partes = string.split(" ");
		super.setNome(partes[0]);
		super.setSobrenome(partes[1]);
		
	}

	@Override
	public void exibir() {
		System.out.println(super.getNome() + " " + super.getSobrenome());
		
	}
	
	

}
