/**
  * Ein Modul, dass Operationen f&uuml;r physikalische
  * Berechnungen zur Verf&uuml;gung stellt.
  */

public class Physik {

     /**
       * Berechnung der Strecke, die ein K&ouml;rper mit einer gegeben Masse,
       * der ein gegebene Zeit lang mit einer auf ihn einwirkenden
       * konstanten Kraft bewegt wird, zur&uuml;cklegt.
       * @param   m die Masse
       * @param   t die Zeit
       * @param   k die Kraft
       * @return  die Strecke, die der K&ouml;rper zur&uuml;cklegt.
       */
     public static double strecke(double m, double t, double k) {
         return ( k * Math.pow(t,2)) / (2 * m);
     }

     /**
       * Berechnung der Arbeit, die ein K&ouml;rper mit einer gegeben Masse,
       * der ein gegebene Zeit lang mit einer auf ihn einwirkenden
       * konstanten Kraft bewegt wird, leistet.
       * @param   m die Masse
       * @param   t die Zeit
       * @param   k die Kraft
       * @return  die Arbeit, die der K&ouml;rper leistet.
       */
     public static double arbeit(double m, double t, double k) {
         return k * strecke(m,t,k);
     }


     // IMPLEMENTIEREN SIE HIER DIE METHODE celsius
     /**
      * Umrechnung von Fahrenheit in Celsius
      * 
      * @param Temperatur in Fahrenheit
      * @return Temperatur in Celsius
      */
     public static double celsius(double fahrenheit) {
    	 double celsius = (fahrenheit - 32) * (5/9);
    	 return celsius;
     }
     
     // IMPLEMENTIEREN SIE HIER DIE METHODE spannarbeit
     /**
      * Berechnet den Wert der Spannarbeit aus der gegebenen 
      * Federkonstante und der Auslenkung der Feder
      * 
      * @param d Federkonstante(in N/m)
      * @param s Weg der Auslenkung(in m)
      * @return Spannarbeit (in J)
      */
     public static double spannarbeit(double d, double s) {
    	 double w = (1/2)*d*Math.pow(s, 2);
    	 return w;
     }

     /**
      * Nur zu Testzwecken.
      */
     public static void main(String[] args) {
         System.out.println("Strecke(1,2,3) = "+strecke(1.0, 2.0, 3.0));
         System.out.println("Arbeit(1,2,3) = "+arbeit(1.0, 2.0, 3.0));

     }

}
