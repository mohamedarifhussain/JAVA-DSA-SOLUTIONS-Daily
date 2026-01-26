import java.util.Arrays;

public class minimum_falling_path_ii {

    public static int minFallingPathSum(int[][] matrix) {

        int r = matrix.length, c = matrix[0].length;

        int ans = Integer.MAX_VALUE;

        for (int i = r - 2; i >= 0; i--) {

            int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;

            for (int j = 0; j < c; j++) {

                if (min1 > matrix[i + 1][j]) {
                    min2 = min1;
                    min1 = matrix[i + 1][j];
                } else if (min2 > matrix[i + 1][j]) {
                    min2 = matrix[i + 1][j];
                }

            }

            for (int j = 0; j < c; j++) {

                matrix[i][j] = matrix[i][j] + ((matrix[i + 1][j] == min1) ? min2 : min1);

            }

        }

        for (int i = 0; i < c; i++) {
            ans = Math.min(ans, matrix[0][i]);
        }

        return ans;

    }

    public static void main(String[] args) {

        int[][] input = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        int output = minFallingPathSum(input);
        System.out.println("Input: ");

        for (int[] row : input) {
            System.out.println(Arrays.toString(row));
        }

        System.out.println("Output: " + output);

    }

}

/*
 * 1289. Minimum Falling Path Sum II
 * Solved
 * Hard
 * Topics
 * premium lock icon
 * Companies
 * Hint
 * Given an n x n integer matrix grid, return the minimum sum of a falling path
 * with non-zero shifts.
 * 
 * A falling path with non-zero shifts is a choice of exactly one element from
 * each row of grid such that no two elements chosen in adjacent rows are in the
 * same column.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: grid = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: 13
 * Explanation:
 * The possible falling paths are:
 * [1,5,9], [1,5,7], [1,6,7], [1,6,8],
 * [2,4,8], [2,4,9], [2,6,7], [2,6,8],
 * [3,4,8], [3,4,9], [3,5,7], [3,5,9]
 * The falling path with the smallest sum is [1,5,7], so the answer is 13.
 * Example 2:
 * 
 * Input: grid = [[7]]
 * Output: 7
 * 
 * 
 * Constraints:
 * 
 * n == grid.length == grid[i].length
 * 1 <= n <= 200
 * -99 <= grid[i][j] <= 99
 */