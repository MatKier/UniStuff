package AlgUDat.Blatt7;

import java.util.Arrays;

import AlgUDat.Blatt6.SortUtil;

public class HeapSort {

	public static void main(String[] args) {
		int[] liste = { 11, 8, 3, 9, 25, 4, 6, 19, 10, 23, 13, 2, 1, 0, 5, 7,
				42, 18, 12, 20, 30, 21, 14, 15, 22, 17, 23, 16, 24, 29 };
		sort(liste);

		System.out
				.println("Richtige Reihenfolge: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15,"
						+ " 16, 17, 18, 19, 20, 21, 22, 23, 23, 24, 25, 29, 30, 42]");
		System.out.println(Arrays.toString(liste));

		System.out.println();
		System.out.println("List sorted = " + SortUtil.isSorted(liste));
	}

	/** Array of int sortieren mittels HeapSort */
	public static void sort(int[] daten) {
		// Heap erzeugen (Bottom-Up)
		for (int i = daten.length / 2 - 1; i >= 0; --i) {
			korrigiere(daten, i, daten.length);
		}
		// Heap auslesen bis er leer ist:
		for (int i = daten.length - 1; i > 0; --i) {
			SortUtil.vertausche(daten, 0, i);
			korrigiere(daten, 0, i);
		}
	}

	/** Heap an der Position i korrigieren */
	public static void korrigiere(int[] daten, int i, int len) {
		while (i <= (len / 2) - 1) {
			int childInd = ((i + 1) * 2) - 1;

			if (childInd + 1 <= len - 1) {
				if (daten[childInd] < daten[childInd + 1]) {
					childInd++;
				}
			}

			if (daten[i] < daten[childInd]) {
				SortUtil.vertausche(daten, i, childInd);
				i = childInd;
			} else
				break;
		}
	}
}
