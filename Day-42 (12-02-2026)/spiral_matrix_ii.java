import java.util.*;

public class spiral_matrix_ii {

    // 👉 Paste YOUR function here
    public static int[][] generateMatrix(int n) {

        int num = 1;

        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;

        int[][] ans = new int[n][n];

        while (left <= right && top <= bottom) {

            for (int i = left; i <= right; i++) {
                ans[top][i] = num++;
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                ans[i][right] = num++;
            }
            right--;

            for (int i = right; i >= left; i--) {
                ans[bottom][i] = num++;
            }
            bottom--;

            for (int i = bottom; i >= top; i--) {
                ans[i][left] = num++;
            }
            left++;
        }

        return ans;
    }

    // Helper to print matrix
    static void printMatrix(int[][] mat) {
        for (int[] row : mat) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void main(String[] args) {

        int[] testCases = {
            1,  // smallest
            2,
            3,
            4,
            5,  // odd size
            6,  // even size
            7   // larger odd
        };

        int tc = 1;
        for (int n : testCases) {
            System.out.println("\nTest Case " + tc++ + " : n = " + n);
            int[][] result = generateMatrix(n);
            printMatrix(result);
        }
    }
}


/* 59. Spiral Matrix II
Solved
Medium
Topics
premium lock icon
Companies
Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.

 

Example 1:


Input: n = 3
Output: [[1,2,3],[8,9,4],[7,6,5]]
Example 2:

Input: n = 1
Output: [[1]]
 

Constraints:

1 <= n <= 20 */
