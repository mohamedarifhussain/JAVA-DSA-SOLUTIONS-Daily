import java.util.*;

public class GreaterThanPreviousTest {

    // 👉 Replace this with YOUR solution
    static void solve(int[] arr) {

        int mx = Integer.MIN_VALUE;

        for (int i : arr) {
            if (mx < i) {
                System.out.print(i + " ");
                mx = i;
            }
        }
        System.out.println();

    }

    public static void main(String[] args) {

        int[][] testCases = {

                { 2, -3, -4, 5, 9, 7, 8 },
                { 1, 2, 3, 4, 5 },
                { 9, 8, 7, 6, 5 },
                { 5, 5, 5, 5 },
                { 10 },
                { 2, 5 },
                { 5, 2 },
                { -5, -4, -3, -2, -1 },
                { -2, -5, -1, -3, 0 },
                { 3, 3, 3, 4, 4, 5 },
                { 4, 1, 6, 2, 7, 3 },
                { -10, -20, 100, 50, 200 },
                { 0, 0, 1, 0, 2, 0, 3 },
                { 1000, 10, 2000, 20, 3000 },
                { 8, 3, 4, 10, 2, 12, 11, 15 },
                {},
                { 0, 0, 0 },
                { 1, 100, 2, 200, 3, 300 },
                { 50, 10, 20, 30, 40 },
                { 5, 1, 5, 1, 5, 1, 10 }
        };

        for (int i = 0; i < testCases.length; i++) {

            int[] input = testCases[i];

            System.out.println("Test Case " + (i + 1));
            System.out.println("Input  : " + Arrays.toString(input));
            System.out.println("Output : ");
            solve(input);
            System.out.println("--------------------------------");
        }
    }
}

/*
 * 94. You’re given an array. Print the elements of the array which are greater
 * than its previous elements in
 * the array.
 * Input : 2, -3, -4, 5, 9, 7, 8 Output: 2 5 9 You should solve this question in
 * O(n) time.
 */