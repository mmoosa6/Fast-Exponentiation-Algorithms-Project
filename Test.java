import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String again = "yes";

        System.out.println("================================================");
        System.out.println("      Fast Exponentiation -- Live Demo");
        System.out.println("================================================");

        while (again.equalsIgnoreCase("yes")) {

            System.out.print("\nEnter base (a): ");
            long a = scanner.nextLong();

            System.out.print("Enter exponent (n): ");
            int n = scanner.nextInt();

            scanner.nextLine();

            if (n < 0) {
                System.out.println("Exponent must be nonnegative.");
                continue;
            }

            if (a > 2 && n > 62) {
                System.out.println("[WARNING] Result may overflow Java long.");
            }

            long start1 = System.nanoTime();

            long linearResult =
                    LinearExponentiation.linearPow(a, n);

            long linearTime =
                    System.nanoTime() - start1;

            long start2 = System.nanoTime();

            long fastResult =
                    FastExponentiation.fastPow(a, n);

            long fastTime =
                    System.nanoTime() - start2;

            int linearMults =
                    LinearExponentiation.countMultiplications(n);

            int fastMults =
                    FastExponentiation.countMultiplications(n);

            System.out.println("\n------------------------------------------------");

            System.out.println("Linear result : " + linearResult);
            System.out.println("Fast result   : " + fastResult);
            System.out.println("Results match : "
                    + (linearResult == fastResult));

            System.out.println("------------------------------------------------");

            System.out.println("Linear time   : "
                    + linearTime + " ns ("
                    + linearMults + " multiplications)");

            System.out.println("Fast time     : "
                    + fastTime + " ns ("
                    + fastMults + " multiplications)");

            if (fastMults > 0) {

                double speedup =
                        (double) linearMults / fastMults;

                System.out.printf(
                        "Multiplication reduction: %.1fx%n",
                        speedup
                );
            }

            System.out.println("------------------------------------------------");

            System.out.print("\nRun another test? (yes/no): ");

            again = scanner.nextLine();
        }

        System.out.println("\nProgram finished.");

        scanner.close();
    }
}
