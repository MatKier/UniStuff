package AlgUDat.Blatt7;

public class SortUtil {
  /** Testet, ob Daten sortiert sind. */
  public static boolean isSorted(int[] daten) {
    int prev = daten[0];
    for (int i = 1; i < daten.length; i++) {
      if (daten[i] < prev) {
        return false;
      }
      prev = daten[i];
    }
    return true;
  }

  /** Vertauscht zwei Elemente */
  public static void vertausche(int[] daten, int x, int y) {
    final int tmp = daten[x];
    daten[x] = daten[y];
    daten[y] = tmp;
  }
}
