package Ex04.atv01;
import java.util.HashMap;



@SuppressWarnings("rawtypes")
public class MatrizAdapter extends HashMap {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public MatrizAdapter(int[][] matriz) {
		super();
		for (int i = 0; i < matriz[1].length; i++) {
			put(matriz[0][i], matriz[1][i]);
		}
		
	}

}
