import java.util.*;

public class spiral_matrix_i {

    // 👉 Paste YOUR function here
    public static List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> ans = new ArrayList<>();

        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;

        while (left <= right && top <= bottom) {

            for (int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }
            top++;

            if (top > bottom) break;

            for (int i = top; i <= bottom; i++) {
                ans.add(matrix[i][right]);
            }
            right--;

            if (left > right) break;

            for (int i = right; i >= left; i--) {
                ans.add(matrix[bottom][i]);
            }
            bottom--;

            for (int i = bottom; i >= top; i--) {
                ans.add(matrix[i][left]);
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

        List<int[][]> testCases = new ArrayList<>();

        // ---------- TEST CASES ----------

        // 1. 3x3 square
        testCases.add(new int[][] {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        });

        // 2. 3x4 rectangle
        testCases.add(new int[][] {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9,10,11,12}
        });

        // 3. 4x3 rectangle
        testCases.add(new int[][] {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9},
            {10,11,12}
        });

        // 4. Single row
        testCases.add(new int[][] {
            {1, 2, 3, 4, 5}
        });

        // 5. Single column
        testCases.add(new int[][] {
            {1},
            {2},
            {3},
            {4}
        });

        // 6. 1x1 matrix
        testCases.add(new int[][] {
            {7}
        });

        // 7. 2x2 matrix
        testCases.add(new int[][] {
            {1, 2},
            {3, 4}
        });

        // 8. 2x3 matrix
        testCases.add(new int[][] {
            {1, 2, 3},
            {4, 5, 6}
        });

        // 9. 3x2 matrix
        testCases.add(new int[][] {
            {1, 2},
            {3, 4},
            {5, 6}
        });

        // 10. Odd dimension 5x5
        testCases.add(new int[][] {
            { 1,  2,  3,  4,  5},
            {16, 17, 18, 19,  6},
            {15, 24, 25, 20,  7},
            {14, 23, 22, 21,  8},
            {13, 12, 11, 10,  9}
        });

        // ---------- RUN TESTS ----------
        int tc = 1;
        for (int[][] matrix : testCases) {
            System.out.println("\nTest Case " + tc++);
            printMatrix(matrix);
            System.out.println("Spiral Order: " + spiralOrder(matrix));
        }
    }
}


/* 54. Spiral Matrix
Solved
Medium
Topics
premium lock icon
Companies
Hint
Given an m x n matrix, return all elements of the matrix in spiral order.

 

Example 1:


Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:


Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100
 
 */