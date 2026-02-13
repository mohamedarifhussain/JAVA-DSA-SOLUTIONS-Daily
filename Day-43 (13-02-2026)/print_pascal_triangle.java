public class print_pascal_triangle {

    public static void printPascalTriangle(int n) {

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
            }

            int val = 1;

            for (int j = 0; j <= i; j++) {
                System.out.print(val + " ");

                val = val * (i - j) / (j + 1);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        
        int[] testCases = {

                // -------- Basic ----------
                1,
                2,
                3,
                4,
                5,
                6,

                // -------- End of 2-digit ----------
                7,
                8,
                9,
                10,
                11,
                12,
                13,
                14,

                // -------- Start of 4-digit ----------
                15,
                16,
                17,
                18,

                // -------- Random ----------
                20,

                
        };

        int tc = 1;
        for (int n : testCases) {
            System.out.println("Test Case " + tc++);
            System.out.println("Input  : n = " + n);

            // 👉 CALL YOUR METHOD HERE
            

            System.out.println("Output : ");
            printPascalTriangle(n);
            System.out.println("---------------------------");
            System.out.println();
        }
    }
}

/*
 * 55. Print the following pattern
 * Ex. INPUT : 5
 * OUTPUT :
 * 1
 * 1 1
 * 1 2 1
 * 1 3 3 1
 * 1 4 6 4 1
 * Ex. INPUT : 7
 * OUTPUT :
 * 1
 * 1 1
 * 1 2 1
 * 1 3 3 1
 * 1 4 6 4 1
 * 1 5 10 10 5 1
 * 1 6 15 20 15 6 1
 */
