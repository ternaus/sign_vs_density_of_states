import common.X;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * User: Vladimir Iglovikov
 * Date: 8/15/14
 */
public class X_generator {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        final double a = 1;
        final double t = 1;
        final double temperature = 1.0 / 8.0;
        int max_kx = 99;
        int max_ky = 99;
//        double qx = Math.PI;
        double qy = Math.PI;
        double qx = 0;
//        double qy = 0;


        double mu_min = -6;
        double mu_max = 3;
        double mu_step = 0.1;
//        String modelName = "square";
        String modelName = "triangle";
//        String modelName = "Lieb";
        String outName = "X_" + modelName + "_qx_" + qx + "_qy_" + qy + "_kx_" + max_kx + "_ky_" + max_ky + "_beta_" + (1 / temperature) + ".txt";

        PrintWriter writer = new PrintWriter(outName, "UTF-8");

        for (double mu = mu_min; mu <= mu_max; mu += mu_step) {
            double x = 0;
            if (modelName == "square") {
                x = X.X_square(max_kx, max_ky, qx, qy, mu, a, t, temperature);
                writer.println(mu + " " + x);
            } else if (modelName == "triangle") {
                x = X.X_triangle(max_kx, max_ky, qx, qy, mu, a, t, temperature);
                writer.println(mu + " " + x);
            } else if (modelName == "Lieb") {
                double x00 = X.X_Lieb(max_kx, max_ky, qx, qy, mu, a, t, temperature, 0, 0);
                double x01 = X.X_Lieb(max_kx, max_ky, qx, qy, mu, a, t, temperature, 0, 1);
                double x11 = X.X_Lieb(max_kx, max_ky, qx, qy, mu, a, t, temperature, 1, 1);
                double x12 = X.X_Lieb(max_kx, max_ky, qx, qy, mu, a, t, temperature, 1, 1);
                writer.println(mu + " " + x00 + " " + x01 + " " + x11 + " " + x12);
            }

        }
        writer.close();
    }
}
