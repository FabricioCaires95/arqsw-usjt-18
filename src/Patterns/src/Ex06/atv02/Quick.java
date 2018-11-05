package Ex06.atv02;


public class Quick implements Sort {

	@Override
	public int[] sort(int v[]) {
		quicksort(v, 0, v.length - 1);
		return v;
	}

	int separa(int v[], int p, int r) {
		int c = v[p];
		int i = p + 1, f = r;
		while (i <= f) {
			if (v[i] <= c)
				i++;
			else if (c < v[f])
				f--;
			else {
				int troca = v[i];
				v[i] = v[f];
				v[f] = troca;
				i++;
				f--;
			}
		}
		v[p] = v[f];
		v[f] = c;
		return f;
	}

	private void quicksort(int v[], int p, int r) {
		int j;
		if (p < r) {
			j = separa(v, p, r);
			quicksort(v, p, j - 1);
			quicksort(v, j + 1, r);
		}
	}

}
