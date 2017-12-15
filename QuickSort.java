package AlgUDat.Blatt6;

import java.util.Arrays;

public class QuickSort {
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

	/** Array of int sortieren mittels QuickSort */
	public static void sort(int[] daten) {
		quicksort(daten, 0, daten.length - 1);
	}

	/** Teilarray of int sortieren mittels QuickSort */
	public static void quicksort(int[] daten, int start, int ende) {
		if (start >= ende) {
			return;
		} // Max 1 Element: fertig!
			// Divide at Pivot:
		final int pivot = daten[start]; // Pivot
		int links = start + 1, rechts = ende;
		while (true) {
			while ((daten[links] < pivot) && links < ende) {
				links = links + 1;
			}
			while (daten[rechts] > pivot) {
				rechts = rechts - 1;
			}
			if (links < rechts) {
				SortUtil.vertausche(daten, rechts, links);
				links = links + 1;
				rechts = rechts - 1;
			} else {
				break;
			}
		}
		// Pivot an der RICHTIGEN Position einsetzen:
		SortUtil.vertausche(daten, start, rechts);
		// Conquer (kein Merge notwendig, wenn Pivot korrekt):
		quicksort(daten, start, rechts - 1);
		quicksort(daten, rechts + 1, ende);
	}
}
