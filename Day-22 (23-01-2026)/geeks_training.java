import java.util.Arrays;

public class geeks_training {

    public static int points(int nin, int ind, int len, int[][] mat, int[][] dp) {

        if (ind == len) {
            return 0;
        }

        if (dp[ind][nin] != -1)
            return dp[ind][nin];
        int maxi = -1;
        for (int i = 0; i < 3; i++) {
            if (i != nin) {
                maxi = Math.max(maxi, mat[ind][i] + points(i, ind + 1, len, mat, dp));
            }
        }
        dp[ind][nin] = maxi;
        return dp[ind][nin];

    }

    public static int maximumPoints(int mat[][]) {
        // code here

        int[][] dp = new int[mat.length][4];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < 4; j++)
                dp[i][j] = -1;
        }

        return points(3, 0, mat.length, mat, dp);

    }

    public static void main(String[] args) {
        int[][] mat = {
                { 1, 2, 5 },
                { 3, 1, 1 },
                { 3, 3, 3 }
        };

        System.out.println("Input: ");
        for (int[] row : mat) {
            System.out.println(Arrays.toString(row));
        }
        int output = maximumPoints(mat);
        System.out.println();
        System.out.println("Output: " + output);

    }
}

/* Geek's Training
Difficulty: MediumAccuracy: 49.98%Submissions: 143K+Points: 4Average Time: 20m
Geek is going for a training program for n days. He can perform any of these activities: Running, Fighting, and Learning Practice. Each activity has some point on each day. As Geek wants to improve all his skills, he can't do the same activity on two consecutive days. Given a 2D matrix mat[][], where mat[i][0], mat[i][1], and mat[i][2] represent the merit points for Running, Fighting, and Learning on the i-th day, determine the maximum total merit points Geek can achieve .

Example:

Input: mat[][]= [[1, 2, 5],
               [3, 1, 1], 
               [3, 3, 3]]
Output: 11
Explanation: Geek will learn a new move and earn 5 point then on second day he will do running and earn 3 point and on third day he will do fighting and earn 3 points so, maximum merit point will be 11.
Input: mat[][]= [[1, 1, 1],
               [2, 2, 2],
               [3, 3, 3]]
Output: 6
Explanation: Geek can perform any activity each day while adhering to the constraints, in order to maximize his total merit points as 6.
Input: mat[][]= [[4, 2, 6]]
Output: 6
Explanation: Geek will learn a new move to make his merit points as 6.
Constraint:
1 ≤ n ≤ 105   
1 ≤  arr[i][j] ≤ 100 */


