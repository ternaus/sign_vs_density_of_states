import common.Rho;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * User: Vladimir Iglovikov
 * Date: 8/15/14
 */
public class rhoGenerator {
    public rhoGenerator() {
        super();
    }

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        final double a = 1;

//        final double temperature = 1.0 / 8.0;
        final double temperature = 0;
        int max_kx = 2000;
        int max_ky = 2000;

        double mu_min = -4;
        double mu_max = 4;
        double mu_step = 0.01;
        String modelName = "square";
//        String modelName = "triangle";
//        String modelName = "Lieb";
//                String modelName = "kagome";
//                String modelName = "honeycomb";
//                String modelName = "chain";
        final double t = 1;
        String outName = "rho_" + modelName + "_kx_" + max_kx + "_ky_" + max_ky + "_T_" + temperature + ".txt";

        PrintWriter writer = new PrintWriter(outName, "UTF-8");

        for (double mu = mu_min; mu <= mu_max; mu += mu_step) {
            double x = Rho.rho(max_kx, max_ky, mu, temperature, a, t, modelName);
            writer.println(mu + " " + x);
        }
        writer.close();
    }
}
