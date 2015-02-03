package common;
import common.Bands;
import common.Krange;

/**
 * User: Vladimir Iglovikov
 * Date: 8/18/14
 */
public class Energy {
    public static double energy(final int max_kx, final int max_ky, final double mu, final double temperature, final double a, final double t, final String lattice_name) {
        double result = 0;
        if (lattice_name == "square") {
            int num_bands = 1;
            int num_sites = num_bands * max_kx * max_ky;
            for (double kx : Krange.krange(max_kx, a)) {
                for (double ky : Krange.krange(max_ky, a)) {
                    double band = Bands.bands_square(kx, ky, a, t);
                    result += band / common.Fermi.fermi(band - mu, temperature);
                }
            }
            result /= num_sites;

        } else if (lattice_name == "triangle") {
            int num_bands = 1;
            int num_sites = num_bands * max_kx * max_ky;
            for (double kx : Krange.krange(max_kx, a)) {
                for (double ky : Krange.krange(max_ky, a)) {
                    double band = Bands.bands_triangle(kx, ky, a, t);
                    result += band / common.Fermi.fermi(band - mu, temperature);
                }
            }
            result /= num_sites;

        } else if (lattice_name == "Lieb") {
            int num_bands = 3;
            int num_sites = num_bands * max_kx * max_ky;
            for (double kx : Krange.krange(max_kx, a)) {
                for (double ky : Krange.krange(max_ky, a)) {
                    for (double band : Bands.bands_Lieb(kx, ky, a, t)) {
                        result += band / common.Fermi.fermi(band - mu, temperature);
                    }
                }
            }
            result /= num_sites;
        }


        return result;
    }
}
