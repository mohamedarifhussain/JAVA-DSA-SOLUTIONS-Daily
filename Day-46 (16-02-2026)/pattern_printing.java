
public class pattern_printing {

    public static void solve(int n) {

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < (n - 1); j++) {
                if (i >= j) {
                    System.out.print(n - j);
                } else {
                    System.out.print(n - i);
                }
            }

            for (int j = n - 1; j >= 0; j--) {
                if (i > j) {
                    System.out.print(n - j);
                } else {
                    System.out.print(n - i);
                }
            }

            System.out.println();

        }

        for (int i = n - 2; i >= 0; i--) {

            for (int j = 0; j < (n - 1); j++) {
                if (i >= j) {
                    System.out.print(n - j);
                } else {
                    System.out.print(n - i);
                }
            }

            for (int j = n - 1; j >= 0; j--) {
                if (i > j) {
                    System.out.print(n - j);
                } else {
                    System.out.print(n - i);
                }
            }

            System.out.println();

        }

    }

    public static void main(String[] args) {

        int[] input = { 1, 2, 3, 4, 5, 6, 9 };

        int t = 0;

        for (int n : input) {
            System.out.println("Test Case no : " + ++t);
            solve(n);

            System.out.println("----------------------------------------------------");
            System.out.println();

        }
    }
}

// Pattern Printing.

/*
 * 4444444
 * 4333334
 * 4322234
 * 4321234
 * 4322234
 * 4333334
 * 4444444
 */