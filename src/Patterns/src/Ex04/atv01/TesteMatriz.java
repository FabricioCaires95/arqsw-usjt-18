package Ex04.atv01;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class TesteMatriz {
	
	public static void main(String[] args) {
		
		int[][] matriz = {
				{
					1, 2, 3
				},
				{
					4, 5, 6
				}
		};
		
		@SuppressWarnings("unchecked")
		HashMap<Integer, Integer> map = new MatrizAdapter(matriz);
		
		StringBuilder sb = new StringBuilder();
	    Iterator<Entry<Integer, Integer>> iter = map.entrySet().iterator();
	    while (iter.hasNext()) {
	        Entry<Integer, Integer> entry = iter.next();
	        sb.append(entry.getKey());
	        sb.append('=').append('"');
	        sb.append(entry.getValue());
	        sb.append('"');
	        if (iter.hasNext()) {
	            sb.append(',').append(' ');
	        }
	    }
	    System.out.println(sb.toString());
		
	}
}
