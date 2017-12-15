package AlgUDat.Blatt10;

public class LinearesSondieren {
	/** Speicher */
	private int[] daten;

	/** Reservierter Wert */
	private static final int FREE = Integer.MIN_VALUE;

	/** Exception, falls die Tabelle voll ist */
	public static class FullException extends RuntimeException {
		/** Constructor */
		public FullException() {
			super("Tabelle ist voll.");
		}
	}

	/**
	 * Constructor
	 * 
	 * @param size
	 *            Tabellengroesse
	 */
	public LinearesSondieren(int size) {
		this.daten = new int[size];
		java.util.Arrays.fill(this.daten, FREE);
	}

	/* Aktuellen Inhalt ausgeben (Debug) */
	private void output() {
		for (int i : daten) {
			System.out.print(i == FREE ? "___ " : String.format("%3d ", i));
		}
		System.out.println();
	}

	/* Einfache Hashfunktion. Nicht besonders gut! */
	private int hash(int val) {
		val = val % daten.length;
		// Vorsicht: Java Modulo kann negative Werte liefern!
		return (val < 0) ? (val + daten.length) : val;
	}

	/* Einen Schluessel in die Hashtabelle einfuegen */
	public void insert(int val) {
		if (val == FREE) { // Sonderfall verbieten
			throw new RuntimeException("Der Schluessel " + FREE
					+ " darf in dieser Implementierung nicht verwendet werden!");
		}
		if (contains(val)) {
			return;
		}
		final int h = hash(val);
		if (daten[h] == FREE) {
			daten[h] = val;
		} else {
			boolean insertedVal = false;
			for (int i = h + 1; i < daten.length + h; i++) {
				int x = 0;
				if (i >= daten.length) {
					x = daten.length;
				}
				if (daten[i - x] == FREE) {
					daten[i - x] = val;
					insertedVal = true;
					break;
				}
			}
			if (!insertedVal) {
				throw new FullException();
			}
		}
	}

	/** Schluessel in der Tabelle suchen */
	public boolean contains(int val) {
		final int h = hash(val);
		// Überprüft ob Wert an der eigentlichen HAsh-Adresse vorhanden ist
		if (daten[h] == val) {
			return true;
		}
		// Falls Wert nicht an der eigentlichen Hash-Adresse vorhanden ist wird
		// an den nächstgrößeren Adressen gesucht, befindet er sich auch nicht
		// in der letzten wird von der untersten Adresse bis zur ursprünglichen
		// Adresse-1 gesucht
		else {
			for (int i = h + 1; i < daten.length + h; i++) {
				int x = 0;
				if (i >= daten.length) {
					x = daten.length;
				}
				if (daten[i - x] == val) {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		LinearesSondieren linSon = new LinearesSondieren(10);
		for (int i = 2; i <= 92; i = i + 10) {
			linSon.insert(i);
			linSon.output();
		}

		System.out.println("");

		for (int i = 2; i <= 102; i = i + 10) {
			System.out.println("Tabelle enthält: " + i + " = "
					+ linSon.contains(i));
		}

		System.out.println("");

		System.out.println("Exception nach dieser Zeile");
		linSon.insert(102);
	}
}
