package common;

/**
 * User: Vladimir Iglovikov
 * Date: 8/15/14
 */
public class Rho {
    public static double rho(final int max_kx, final int max_ky, final double mu, final double temperature, final double a, final double t, final String lattice_name) {
        double result = 0;
        if (lattice_name == "square") {
            int num_bands = 1;
            int num_sites = num_bands * max_kx * max_ky;
            for (double kx: Krange.krange(max_kx, a)) {
                for (double ky: Krange.krange(max_ky, a)) {
                    double band = Bands.bands_square(kx, ky, a, t);
                    result += common.Fermi.fermi(band - mu, temperature);
                }
            }
            result *= 2.0 / num_sites;

        } else if (lattice_name == "triangle") {
            int num_bands = 1;
            int num_sites = num_bands * max_kx * max_ky;
            for (double kx: Krange.krange(max_kx, a)) {
                for (double ky: Krange.krange(max_ky, a)) {
                    double band = Bands.bands_triangle(kx, ky, a, t) - mu;
                    result += common.Fermi.fermi(band, temperature);
                }
            }
            result *= 2.0 / num_sites;

        } else if (lattice_name == "chain") {
            int num_bands = 1;
            int num_sites = num_bands * max_kx;
            for (double kx : Krange.krange(max_kx, a)) {
                double band = Bands.bands_chain(kx, a, t) - mu;
                result += common.Fermi.fermi(band, temperature);
            }
            result *= 2.0 / num_sites;

        } else if (lattice_name == "ladder") {
            int num_bands = 2;
            int num_sites = num_bands * max_kx;
            for (double kx : Krange.krange(max_kx, a)) {
                for (double band : Bands.bands_ladder(kx, a, t)) {
                    result += common.Fermi.fermi(band - mu, temperature);
                }
            }
            result *= 2.0 / num_sites;

        } else if (lattice_name == "Lieb") {
            int num_bands = 3;
            int num_sites = num_bands * max_kx * max_ky;
            for (double kx: Krange.krange(max_kx, a)) {
                for (double ky: Krange.krange(max_ky, a)) {
                    for (double band: Bands.bands_Lieb(kx, ky, a, t)) {
                        result += common.Fermi.fermi(band - mu, temperature);
                    }
                }
            }
            result *= 2.0 / num_sites;
        } else if (lattice_name == "honeycomb") {
            int num_bands = 2;
            int num_sites = num_bands * max_kx * max_ky;
            for (double kx : Krange.krange(max_kx, a)) {
                for (double ky : Krange.krange(max_ky, a)) {
                    for (double band : Bands.bands_honeycomb(kx, ky, a, t)) {
                        result += common.Fermi.fermi(band - mu, temperature);
                    }
                }
            }
            result *= 2.0 / num_sites;
        } else if (lattice_name == "kagome") {
            int num_bands = 3;
            int num_sites = num_bands * max_kx * max_ky;
            for (double kx : Krange.krange(max_kx, a)) {
                for (double ky : Krange.krange(max_ky, a)) {
                    for (double band : Bands.bands_kagome(kx, ky, a, t)) {
                        result += common.Fermi.fermi(band - mu, temperature);
                    }
                }
            }
            result *= 2.0 / num_sites;
        } else if (lattice_name == "Lieb1") {
            int num_bands = 5;
            int num_sites = num_bands * max_kx * max_ky;
            for (double kx : Krange.krange(max_kx, a)) {
                for (double ky : Krange.krange(max_ky, a)) {
                    for (double band : Bands.bands_Lieb1(kx, ky, a, t)) {
                        result += common.Fermi.fermi(band - mu, temperature);
                    }
                }
            }
            result *= 2.0 / num_sites;
        }


        return result;
    }
}
