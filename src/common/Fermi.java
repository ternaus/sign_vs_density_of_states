package common;

/**
 * Created by vladimir on 10/15/14.
 */

public class Fermi {
    public static double fermi(final double band, final double temperature) {
        if (temperature > 0) {
            return 1.0 / (Math.exp(band / temperature) + 1);
        } else if (temperature == 0) {
            if (band < 0) {
                return 1;
            } else if (band > 0) {
                return 0;
            } else {
                return 0.5;
            }
        }
        System.out.println("Fermi, we should not be here");
        return -1;
    }
}
