import java.util.Arrays;

public class maximum_path_sum_in_matrix {

    public static int maxi(int i, int j, int r, int c, int[][] dp, int[][] mat) {

        if (j < 0 || j == c || i == r) {
            return Integer.MIN_VALUE;
        }

        if (dp[i][j] != -1)
            return dp[i][j];

        int left = maxi(i + 1, j - 1, r, c, dp, mat);
        int down = maxi(i + 1, j, r, c, dp, mat);
        int right = maxi(i + 1, j + 1, r, c, dp, mat);

        int res = Math.max(left, Math.max(down, right));

        dp[i][j] = mat[i][j] + ((res == Integer.MIN_VALUE) ? 0 : res);

        return dp[i][j];

    }

    public static int maxiTabulation(int[][] mat) {

        int r = mat.length, c = mat[0].length;
        int ans = Integer.MIN_VALUE;

        for (int i = r - 2; i >= 0; i--) {
            for (int j = 0; j < c; j++) {

                int left = (j - 1 < 0) ? Integer.MIN_VALUE : mat[i + 1][j - 1];
                int down = mat[i + 1][j];
                int right = (j + 1 == c) ? Integer.MIN_VALUE : mat[i + 1][j + 1];

                int res = Math.max(left, Math.max(down, right));

                mat[i][j] = mat[i][j] + ((Integer.MIN_VALUE == res) ? 0 : res);

                ans = Math.max(ans, mat[i][j]);
            }
        }

        if (ans == Integer.MIN_VALUE) {
            for (int i = 0; i < c; i++) {
                ans = Math.max(ans, mat[0][i]);
            }
        }

        return ans;

    }

    public int maximumPathDP(int[][] mat) {
        // code here

        int r = mat.length, c = mat[0].length;

        int ans = Integer.MIN_VALUE;

        int[][] dp = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {

                dp[i][j] = -1;

            }
        }

        for (int j = 0; j < c; j++) {

            ans = Math.max(ans, maxi(0, j, r, c, dp, mat));

        }

        return ans;

    }

    public static void main(String[] args) {
        int[][] input = {
                { 3, 6, 1 },
                { 2, 3, 4 },
                { 5, 5, 1 }
        };

        System.out.println("Input: ");

        for (int[] row : input) {
            System.out.println(Arrays.toString(row));
        }
        int output = maxiTabulation(input);

        System.out.println("Output: " + output);

    }
}

/*
 * Maximum path sum in matrix
 * Difficulty: MediumAccuracy: 42.59%Submissions: 121K+Points: 4
 * You are given a matrix mat[][] of size n x m where each element is a positive
 * integer. Starting from any cell in the first row, you are allowed to move to
 * the next row, but with specific movement constraints. From any cell (r, c) in
 * the current row, you can move to any of the three possible positions :
 * 
 * (r+1, c-1) — move diagonally to the left.
 * (r+1, c) — move directly down.
 * (r+1, c+1) — move diagonally to the right.
 * Find the maximum sum of any path starting from any column in the first row
 * and ending at any column in the last row, following the above movement
 * constraints.
 * 
 * Examples :
 * 
 * Input: mat[][] = [[3, 6, 1], [2, 3, 4], [5, 5, 1]]
 * Output: 15
 * Explaination: The best path is (0, 1) -> (1, 2) -> (2, 1). It gives the
 * maximum sum as 15.
 * Input: mat[][] = [[2, 1, 1], [1, 2, 2]]
 * Output: 4
 * Explaination: The best path is (0, 0) -> (1, 1). It gives the maximum sum as
 * 4.
 * Input: mat[][] = [[25]]
 * Output: 25
 * Explaination: (0, 0) is the only cell in mat[][], so maximum path sum will be
 * 25.
 * Constraints:
 * 1 ≤ mat.size() ≤ 500
 * 1 ≤ mat[i].size() ≤ 500
 * 1 ≤ mat[i][j] ≤ 1000
 */
