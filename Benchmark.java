/**
 * Benchmark -- run this file to generate all experimental data.
 *
 * IMPORTANT NOTE:
 * Large exponent values overflow Java long numerically.
 * However, the benchmark still correctly measures:
 * 1) multiplication counts
 * 2) asymptotic behavior
 * 3) runtime scaling
 */

public class Benchmark {

    static final int[] SIZES  = {8, 64, 256, 1024, 4096, 16384};
    static final long  BASE   = 2;
    static final int   TRIALS = 1000;
    static final int   WARMUP = 200;

    public static void main(String[] args) {

        System.out.println("============================================================");
        System.out.println("     Fast Exponentiation -- Benchmark Results");
        System.out.println("============================================================");

        System.out.println(
                padRight("n", 10)
              + padRight("LinearMults", 18)
              + padRight("FastMults", 16)
              + padRight("LinearAvg(ns)", 18)
              + padRight("FastAvg(ns)", 18)
              + "MultSpeedup"
        );

        System.out.println("-------------------------------------------------------------------------------");

        StringBuilder csv = new StringBuilder();
        csv.append("n,LinearMults,FastMults,LinearAvg(ns),FastAvg(ns),MultSpeedup\n");

        for (int n : SIZES) {

            for (int i = 0; i < WARMUP; i++) {
                LinearExponentiation.linearPow(BASE, n);
                FastExponentiation.fastPow(BASE, n);
            }

            long linearTotal = 0;

            for (int t = 0; t < TRIALS; t++) {

                long start = System.nanoTime();

                LinearExponentiation.linearPow(BASE, n);

                linearTotal += System.nanoTime() - start;
            }

            long fastTotal = 0;

            for (int t = 0; t < TRIALS; t++) {

                long start = System.nanoTime();

                FastExponentiation.fastPow(BASE, n);

                fastTotal += System.nanoTime() - start;
            }

            long linearAvg = linearTotal / TRIALS;
            long fastAvg   = fastTotal / TRIALS;

            int linearMults = LinearExponentiation.countMultiplications(n);
            int fastMults   = FastExponentiation.countMultiplications(n);

            double multSpeedup = (double) linearMults / fastMults;

            System.out.println(
                    padRight(String.valueOf(n), 10)
                  + padRight(String.valueOf(linearMults), 18)
                  + padRight(String.valueOf(fastMults), 16)
                  + padRight(String.valueOf(linearAvg), 18)
                  + padRight(String.valueOf(fastAvg), 18)
                  + String.format("%.1fx", multSpeedup)
            );

            csv.append(
                    n + ","
                  + linearMults + ","
                  + fastMults + ","
                  + linearAvg + ","
                  + fastAvg + ","
                  + String.format("%.1fx", multSpeedup)
                  + "\n"
            );
        }

        System.out.println("-------------------------------------------------------------------------------");
        System.out.println();
        System.out.println(csv.toString());
    }

    static String padRight(String s, int width) {

        if (s.length() >= width) {
            return s + " ";
        }

        StringBuilder sb = new StringBuilder(s);

        while (sb.length() < width) {
            sb.append(' ');
        }

        return sb.toString();
    }
}
