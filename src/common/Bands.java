package common;


/**
 * User: Vladimir Iglovikov
 * Date: 8/15/14
 */
public class Bands {
    public static double bands_square(final double kx, final double ky, final double a, final double t) {
        return -2 * t * (Math.cos(a * kx) + Math.cos(a * ky));
    }

    public static double bands_chain(final double kx, final double a, final double t) {
        return -2 * t * Math.cos(a * kx);
    }
    public static double bands_triangle(final double kx, final double ky, final double a, final double t) {
        return -2 * t * (Math.cos(a * kx) + Math.cos(a * ky) + Math.cos(a * (kx + ky)));
    }
    public static double[] bands_Lieb(final double kx, final double ky, final double a, final double t) {
        int num_bands = 3;
        double band0 = 0;
        double band1 = -2 * t * Math.sqrt(Math.pow(Math.cos(a / 2.0 * kx), 2) + Math.pow(Math.cos(a / 2.0 * ky), 2));
        double band2 = -band1;
        double[] result = new double[num_bands];
        result[0] = band0;
        result[1] = band1;
        result[2] = band2;
        return result;
    }

    public static double[] bands_Lieb1(final double kx, final double ky, final double a, final double t) {
        int num_bands = 5;
        double band0 = 0;
        double band1 = -1;
        double band2 = 1;
        double band3 = -Math.sqrt(5 + 2 * Math.cos(a * kx) + 2 * Math.cos(a * ky));
        double band4 = -band3;
        double[] result = new double[num_bands];
        result[0] = band0;
        result[1] = band1;
        result[2] = band2;
        result[3] = band3;
        result[4] = band4;
        return result;
    }

    public static double[] bands_kagome(final double kx, final double ky, final double a, final double t) {
        int num_bands = 3;
        double band0 = t * (-1 - Math.sqrt(3 + 2 * Math.cos(a * kx) + 2 * Math.cos(a * (kx - ky)) + 2 * Math.cos(a * ky)));
        double band1 = t * (-1 + Math.sqrt(3 + 2 * Math.cos(a * kx) + 2 * Math.cos(a * (kx - ky)) + 2 * Math.cos(a * ky)));
        double band2 = 2 * t;
        double[] result = new double[num_bands];
        result[0] = band0;
        result[1] = band1;
        result[2] = band2;
        return result;
    }

    public static double[] bands_honeycomb(final double kx, final double ky, final double a, final double t) {
        int num_bands = 2;
        double band0 = -2 * t * Math.sqrt(1 + 4 * Math.cos(a / Math.sqrt(2) * (kx + ky)) * Math.cos(a / Math.sqrt(2) * (kx - ky)) + 4 * Math.pow(Math.cos(a / Math.sqrt(2) * (kx + ky)), 2));
        double band1 = -band0;
        double[] result = new double[num_bands];
        result[0] = band0;
        result[1] = band1;
        return result;
    }

    public static double[] bands_ladder(final double kx, final double a, final double t) {
        int num_bands = 2;
        double band0 = -2 * t * Math.cos(kx * a) - t;
        double band1 = -2 * t * Math.cos(kx * a) + t;

        double[] result = new double[num_bands];
        result[0] = band0;
        result[1] = band1;
        return result;
    }

    public static double gamma_Lieb(final int x, final int y, final double kx, final double ky, final double a) {
        double result = 0;
        if (x == 0) {
            if (y == 0) {
                result = 0;
            } else if (y == 1) {
                result = -Math.cos(ky) / (Math.sqrt(1 + Math.pow(Math.cos(ky), 2) / Math.pow(Math.cos(kx), 2)) * Math.cos(kx));
            } else if (y == 2) {
                result = Math.pow(1 + Math.pow(Math.cos(ky), 2) / Math.pow(Math.cos(kx), 2), -1.0 / 2.0);
            }
        } else if (x == 1) {
            if (y == 0) {
                result = (-Math.pow(Math.cos(kx), 2) / (Math.sqrt(Math.pow(Math.cos(kx), 2) + Math.pow(Math.cos(ky), 2)) * Math.cos(ky)) - Math.cos(ky) / Math.sqrt(Math.pow(Math.cos(kx), 2) + Math.pow(Math.cos(ky), 2))) / Math.sqrt(Math.pow(-Math.pow(Math.cos(kx), 2) / (Math.sqrt(Math.pow(Math.cos(kx), 2) + Math.pow(Math.cos(ky), 2)) * Math.cos(ky)) - Math.cos(ky) / Math.sqrt(Math.pow(Math.cos(kx), 2) + Math.pow(Math.cos(ky), 2)), 2) + Math.pow(Math.cos(kx), 2) / Math.pow(Math.cos(ky), 2) + 1);
            } else if (y == 1) {
                result = Math.cos(kx) / (Math.sqrt(Math.pow(-Math.pow(Math.cos(kx), 2) / (Math.sqrt(Math.pow(Math.cos(kx), 2) + Math.pow(Math.cos(ky), 2)) * Math.cos(ky)) - Math.cos(ky) / Math.sqrt(Math.pow(Math.cos(kx), 2) + Math.pow(Math.cos(ky), 2)), 2) + Math.pow(Math.cos(kx), 2) / Math.pow(Math.cos(ky), 2) + 1) * Math.cos(ky));
            } else if (y == 2) {
                result = Math.pow(Math.pow(-Math.pow(Math.cos(kx), 2) / (Math.sqrt(Math.pow(Math.cos(kx), 2) + Math.pow(Math.cos(ky), 2)) * Math.cos(ky)) - Math.cos(ky) / Math.sqrt(Math.pow(Math.cos(kx), 2) + Math.pow(Math.cos(ky), 2)), 2) + Math.pow(Math.cos(kx), 2) / Math.pow(Math.cos(ky), 2) + 1, -1.0 / 2.0);
            }
        } else if (x == 2) {
            if (y == 0) {
                result = (Math.pow(Math.cos(kx), 2) / (Math.sqrt(Math.pow(Math.cos(kx), 2) + Math.pow(Math.cos(ky), 2)) * Math.cos(ky)) + Math.cos(ky) / Math.sqrt(Math.pow(Math.cos(kx), 2) + Math.pow(Math.cos(ky), 2))) / Math.sqrt(Math.pow(Math.pow(Math.cos(kx), 2) / (Math.sqrt(Math.pow(Math.cos(kx), 2) + Math.pow(Math.cos(ky), 2)) * Math.cos(ky)) + Math.cos(ky) / Math.sqrt(Math.pow(Math.cos(kx), 2) + Math.pow(Math.cos(ky), 2)), 2) + Math.pow(Math.cos(kx), 2) / Math.pow(Math.cos(ky), 2) + 1);
            } else if (y == 1) {
                result = Math.cos(kx) / (Math.sqrt(Math.pow(Math.pow(Math.cos(kx), 2) / (Math.sqrt(Math.pow(Math.cos(kx), 2) + Math.pow(Math.cos(ky), 2)) * Math.cos(ky)) + Math.cos(ky) / Math.sqrt(Math.pow(Math.cos(kx), 2) + Math.pow(Math.cos(ky), 2)), 2) + Math.pow(Math.cos(kx), 2) / Math.pow(Math.cos(ky), 2) + 1) * Math.cos(ky));
            } else if (y == 2) {
                result = Math.pow(Math.pow(Math.pow(Math.cos(kx), 2) / (Math.sqrt(Math.pow(Math.cos(kx), 2) + Math.pow(Math.cos(ky), 2)) * Math.cos(ky)) + Math.cos(ky) / Math.sqrt(Math.pow(Math.cos(kx), 2) + Math.pow(Math.cos(ky), 2)), 2) + Math.pow(Math.cos(kx), 2) / Math.pow(Math.cos(ky), 2) + 1, -1.0 / 2.0);
            }
        }
        return result;
    }

}
