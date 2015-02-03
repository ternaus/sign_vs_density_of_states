package common;

import static common.Bands.gamma_Lieb;

/**
 * User: Vladimir Iglovikov
 * Date: 8/15/14
 */
public class X {
    public static double X_square(final int max_kx, final int max_ky, final double qx, final double qy, final double mu, final double a, final double t, final double temperature) {
        double result = 0;
        for (double kx : Krange.krange(max_kx, a)) {
            for (double ky : Krange.krange(max_ky, a)) {
                double band1 = Bands.bands_square(kx, ky, a, t) - mu;
                double band2 = Bands.bands_square(kx + qx, ky + qy, a, t) - mu;
                double fm1 = Fermi.fermi(band1, temperature);
                if (Math.abs(band1 - band2) > 1e-10) {
                    double fm2 = Fermi.fermi(band2, temperature);
                    result += -(fm1 - fm2) / (band1 - band2);
                } else {
                    result += fm1 * (1 - fm1) / temperature;
                }
            }
        }
        int num_sites = max_kx * max_ky;
        return result / num_sites;
    }

    public static double X_triangle(final int max_kx, final int max_ky, final double qx, final double qy, final double mu, final double a, final double t, final double temperature) {
        double result = 0;
        for (double kx : Krange.krange(max_kx, a)) {
            for (double ky : Krange.krange(max_ky, a)) {
                double band1 = Bands.bands_triangle(kx, ky, a, t) - mu;
                double band2 = Bands.bands_triangle(kx + qx, ky + qy, a, t) - mu;
                double fm1 = Fermi.fermi(band1, temperature);
                if (Math.abs(band1 - band2) > 1e-10) {
                    double fm2 = Fermi.fermi(band1, temperature);
                    result += -(fm1 - fm2) / (band1 - band2);
                } else {
                    result += fm1 * (1 - fm1) / temperature;
                }
            }
        }
        int num_sites = max_kx * max_ky;
        return result / num_sites;
    }

    public static double X_Lieb(final int max_kx, final int max_ky, final double qx, final double qy, final double mu, final double a, final double t, final double temperature, final int orbital_a, final int orbital_b) {
        int num_bands = 3;
        int num_sites = num_bands * max_kx * max_ky;
        double result = 0;

        double factor = 0;

        for (double kx : Krange.krange(max_kx, a)) {
            for (double ky : Krange.krange(max_ky, a)) {
                for (int band_number1 = 0; band_number1 < num_bands; band_number1++) {
                    double band1 = Bands.bands_Lieb(kx, ky, a, t)[band_number1] - mu;
                    for (int band_number2 = 0; band_number2 < num_bands; band_number2++) {

                        double band2 = Bands.bands_Lieb(kx + qx, ky + qy, a, t)[band_number2] - mu;
                        double fm1 = Fermi.fermi(band1, temperature);
                        double fm2 = Fermi.fermi(band1, temperature);
                        if (Math.abs(band1 - band2) < 1e-10) {
                            factor = -fm1 * (1 - fm1) / temperature;
                        } else {
                            factor = (fm1 - fm2) / (band1 - band2);
                        }
                        result += factor * gamma_Lieb(orbital_a, band_number1, kx, ky, a) * gamma_Lieb(orbital_a, band_number2, kx + qx, ky + qy, a) * gamma_Lieb(orbital_b, band_number2, kx + qx, ky + qy, a) * gamma_Lieb(orbital_b, band_number1, kx, ky, a);
                    }
                }
            }
        }
        return -result / num_sites;
    }
}
