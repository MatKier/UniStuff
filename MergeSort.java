package AlgUDat.Blatt5;

public class MergeSort {
	public static void main(String[] args) {
		int[] daten = { 5, 4, 2, 1, 7, 3 };

		sort(daten);
	}

	/** Array of int sortieren mittels MergeSort */
	public static void sort(int[] daten) {
		mergesort(daten, new int[daten.length], 0, daten.length - 1);
	}

	/** Teilarray of int sortieren mittels MergeSort */
	public static void mergesort(int[] daten, int[] tmp, int start, int ende) {
		if (start >= ende) {
			return;
		} // Max 1 Element: fertig!
			// Divide:
		final int half = (start + ende) / 2;
		// Conquer:
		mergesort(daten, tmp, start, half);
		mergesort(daten, tmp, half + 1, ende);
		// Merge:
		int i = start, j = half + 1, k = start;
		while (i <= half && j <= ende) {
			if (tmp[i] <= tmp[j]) {
				daten[k] = tmp[i];
				i++;
			} else {
				daten[k] = tmp[j];
				j++;
			}
			k++;
		}
		while (i <= half) { // Rechter Teil schon leer!
			daten[k] = tmp[i];
			k++;
			i++;
		}
		while (j <= ende) { // Linker Teil schon leer!
			tmp[k] = daten[j];
			k++;
			i++;
		}
		// aus tmp zurueck kopieren:
		for (int l = start; l < k; l++) {
			daten[l] = tmp[l];
		}
	}
}
