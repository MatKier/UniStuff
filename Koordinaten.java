/**
 * Koordinaten Klasse, um die umrechnung von kartesischen- in Polarkoordinaten
 * und umgekehrt zu veranschaulichen
 * 
 * @author Kiermeier
 * @version 1.0
 * @since 2014-11-21
 */
public class Koordinaten {

	/**
	 * Initialisiert 4 Arrays für kartesische, bzw. Polarkoordinaten und rechnet
	 * diese in das jeweils gegenteilige um
	 * 
	 * @param args
	 * 
	 */
	public static void main(String[] args) {
		// Aufgabe b
		System.out
				.println("Dezimale Kommazahlen können im Binären nur dann komplett richtig dargestellt werden,"
						+ " wenn sie eine nagative Portenz von zwei sind. Ist das nicht der Fall, so macht sich "
						+ "diese ungenauigkeit bemerkbar (viele Nullen, oder Neunen als Nachkommastelle)");

		// Arrays für die kartesischen Koordinaten (muessen gleich lang sein)
		double[] xKarte = { 3.0, 0.0, 0.0, 0.0 };
		double[] yKarte = { 4.0, 4.0, -4.0, 0.0 };

		// Arrays für die Polarkoordinaten (muessen gleich lang sein)
		double[] alphaPolar = { 0.9272952180016122, 1.5707963267948966,
				4.71238898038469, 0.0 };
		double[] deltaPolar = { 5.0, 4.0, 4.0, 0.0 };

		// Schleife für die Berechnung der Polarkoordinaten aus den kartesischen
		// Koordinaten
		for (int i = 0; i < xKarte.length; i++) {
			System.out
					.println("Die Polarkoordinaten für die kartesischen Koordinaten \n x="
							+ xKarte[i]
							+ " und y="
							+ yKarte[i]
							+ " sind alpha="
							+ berechneAlpha(xKarte[i], yKarte[i])
							+ " und delta="
							+ berechneDelta(xKarte[i], yKarte[i]));
		}

		// Schleife für die Berechnung der kartesischen Koordinaten aus den
		// Polarkoordinaten
		for (int i = 0; i < alphaPolar.length; i++) {
			System.out
					.println("Die kartesischen für die Polarkoordinaten \n alpha="
							+ alphaPolar[i]
							+ " und delta="
							+ deltaPolar[i]
							+ " sind x="
							+ berechneX(alphaPolar[i], deltaPolar[i])
							+ " und y="
							+ berechneY(alphaPolar[i], deltaPolar[i]));
		}
	}

	/**
	 * Berechnet alpha aus den zwei übergebenen kartesischen Koordinaten
	 * 
	 * @param x
	 *            Koordinate x
	 * @param y
	 *            Koordinate y
	 * @return Polarkoordinate alpha
	 */
	private static double berechneAlpha(double x, double y) {
		double alpha = 0.0;
		if (x > 0) {
			if (y >= 0) {
				alpha = Math.atan(y / x);
			} else {
				alpha = Math.atan(y / x + 2 * Math.PI);
			}
		} else if (x < 0) {
			alpha = Math.atan(y / x + Math.PI);
		} else {
			if (y > 0) {
				alpha = Math.PI / 2;
			} else if (y < 0) {
				alpha = 3 * Math.PI / 2;
			} else {
				alpha = 0.0;
			}
		}
		return alpha;
	}

	/**
	 * Berechnet delta aus den zwei übergebenen kartesischen Koordinaten
	 * 
	 * @param x
	 *            Koordinate x
	 * @param y
	 *            Koordinate y
	 * @return Polarkoordinate delta
	 */
	private static double berechneDelta(double x, double y) {
		return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}

	/**
	 * Berechnet x aus den zwei übergebenen Polarkoordinaten
	 * 
	 * @param alpha
	 *            Koordinate alpha
	 * @param delta
	 *            Koordinate delta
	 * @return kartesische Koordinate x
	 */
	private static double berechneX(double alpha, double delta) {
		return delta * Math.cos(alpha);
	}

	/**
	 * Berechnet y aus den zwei übergebenen Polarkoordinaten
	 * 
	 * @param alpha
	 *            Koordinate alpha
	 * @param delta
	 *            Koordinate delta
	 * @return kartesische Koordinate y
	 */
	private static double berechneY(double alpha, double delta) {
		return delta * Math.sin(alpha);
	}
}
