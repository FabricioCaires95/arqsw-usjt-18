package Ex07.atv02;



import java.util.Comparator;

public class PontoFlutuanteComparator implements Comparator<Double> {
	@Override
	public int compare(Double o1, Double o2) {
		// TODO Auto-generated method stub
		String a = o1.toString();
		String b = o2.toString();
		String[] splitA = a.split("\\.");
		String[] splitB = b.split("\\.");
		return splitA[1].compareTo(splitB[1]);
	}
}
