package common;

/**
 * User: Vladimir Iglovikov
 * Date: 8/15/14
 */
public class Krange {
    public static double[] krange(final int max_k, final double a) {
        double[] result = new double[max_k];
        double k_step = 2 * Math.PI / (a * max_k);
//        double k_min = -Math.PI / a;
//        double k_max = Math.PI / a;
        double k_min = 0;
        double k_max = 2.0 * Math.PI / a;


        int count = 0;
        for (double k = k_min; k < k_max - 0.00001; k += k_step) {
            result[count] = k;
            count += 1;
        }
        return result;

    }
}
