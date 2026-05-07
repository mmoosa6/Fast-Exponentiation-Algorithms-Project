public class LinearExponentiation {

    /**
     * Computes a^n using naive linear multiplication.
     * Time:  Theta(n)
     * Space: Theta(1)
     */
    public static long linearPow(long a, int n) {

        if (n < 0) {
            throw new IllegalArgumentException("Exponent must be nonnegative.");
        }

        long result = 1;

        for (int i = 0; i < n; i++) {
            result *= a;
        }

        return result;
    }

    /**
     * Returns the exact number of multiplications performed.
     * Always returns n (one multiplication per loop iteration).
     */
    public static int countMultiplications(int n) {

        if (n < 0) {
            throw new IllegalArgumentException("Exponent must be nonnegative.");
        }

        return n;
    }
}
