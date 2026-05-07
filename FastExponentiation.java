public class FastExponentiation {

    /**
     * Computes a^n using exponentiation by squaring
     * (decrease-and-conquer).
     *
     * Time:  Theta(log n)
     * Space: Theta(log n) due to recursive call stack
     */
    public static long fastPow(long a, int n) {

        if (n < 0) {
            throw new IllegalArgumentException("Exponent must be nonnegative.");
        }

        if (n == 0) {
            return 1;
        }

        long half = fastPow(a, n / 2);

        if (n % 2 == 0) {
            return half * half;
        } else {
            return a * half * half;
        }
    }

    /**
     * Counts the exact number of multiplications performed
     * by fastPow().
     */
    public static int countMultiplications(int n) {

        if (n < 0) {
            throw new IllegalArgumentException("Exponent must be nonnegative.");
        }

        if (n == 0) {
            return 0;
        }

        if (n % 2 == 0) {
            return 1 + countMultiplications(n / 2);
        }

        return 2 + countMultiplications(n / 2);
    }
}
