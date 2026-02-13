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

        
        printPascalTriangle(5);
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
