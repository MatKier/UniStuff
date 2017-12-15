package AlgUDat.Blatt4;

/** Binaerer Baum fuer Daten vom Typ INHALT */
public class BinaerBaum<INHALT> {
	/** Wurzel des Baumes */
	Knoten<INHALT> wurzel;

	/** Konstruktor fuer den Baum */
	public BinaerBaum(Knoten<INHALT> wurzel) {
		this.wurzel = wurzel;
	};

	/** Anzahl der Knoten zaehlen */
	public int anzahlKnoten() {
		return anzahlKnoten(wurzel);
	}

	/** 
	 * Rekursive Hilfsmez
	 * @param k Wurzelknoten von dem gezählt wird
	 * @return Anzahl der Knoten
	 */
	private int anzahlKnoten(Knoten k) {
		if (k == null) {
			return 0;
		} else {
			return 1 + anzahlKnoten(k.links)
					+ anzahlKnoten(k.rechts);
		}
	}

	/** Hoehe berechnen */
	public int hoehe() {
		return hoehe(wurzel);
	}

	/** Rekursive Hoehe */
	private int hoehe(Knoten k) {
		if (k == null) {
			return 0;
		} else {
			return 1 + Math.max(hoehe(k.links), hoehe(k.rechts));
		}
	}

	/** Klasse, die einen Knoten des Baumes speichert */
	protected static class Knoten<INHALT> {
		/** Gespeichterte Daten */
		protected INHALT daten;

		/** Linker und rechter Sohn */
		protected Knoten<INHALT> links, rechts;

		/** Konstruktor fuer Knoten */
		public Knoten(INHALT daten, Knoten<INHALT> links, Knoten<INHALT> rechts) {
			this.daten = daten;
			this.links = links;
			this.rechts = rechts;
		}
	}

	/** Methode zum Testen der Implementierung - besser: JUnit Test */
	public static void main(String[] args) {
		Knoten<Integer> links = new Knoten<Integer>(1, null,
				new Knoten<Integer>(2, null, null));
		Knoten<Integer> rechts = new Knoten<Integer>(5, new Knoten<Integer>(4,
				null, null), new Knoten<Integer>(6, null, new Knoten<Integer>(
				7, null, null)));
		Knoten<Integer> wurzel = new Knoten<Integer>(3, links, rechts);
		BinaerBaum<Integer> baum = new BinaerBaum<Integer>(wurzel);
		System.out.println("Hat der Baum die Hoehe 4? " + baum.hoehe());
		BinaerBaum<Integer> leer = new BinaerBaum<Integer>(null);
		System.out.println("Hat der leere Baum die Hoehe 0? " + leer.hoehe());
		System.out.println("Hat der Baum 7 Knoten? " + baum.anzahlKnoten());
		System.out.println("Hat der leere Baum 0 Knoten? "
				+ leer.anzahlKnoten());
	}
}
