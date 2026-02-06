public class binary_pattern {

    static void solve(int n, String s) {

        if (n <= 0) {
            System.out.println(s);
            return;
        }

        solve(n - 1, s + "0 ");
        solve(n - 1, s + "1 ");

    }

    public static void main(String[] args) {

        int[] testCases = {
                1, // smallest valid
                2, // basic
                3, // given example
                0, // edge (empty)
                4, // medium
                5, // bigger
                6, // stress
                7, // heavy (128 rows)
                -1 // invalid input case
        };

        for (int n : testCases) {
            System.out.println("----------------------");
            System.out.println("Input : " + n);
            solve(n, ""); // your pattern printing function
            System.out.println("----------------------");
            System.out.println();
        }

    }

}


/* 39. Print pattern like this
Example:
Input: 1
Output: 0
Input: 2
Output:
0 0
0 1
1 0
1 1
Input: 3
Output:
0 0 0
0 0 1
0 1 0
0 1 1
1 0 0
1 0 1
1 1 0
1 1 1 */