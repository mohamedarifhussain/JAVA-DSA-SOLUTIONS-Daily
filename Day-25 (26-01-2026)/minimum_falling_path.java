import java.util.Arrays;

public class minimum_falling_path {
    

    public static int minFallingPathSum(int[][] matrix) {
        
        int r = matrix.length, c = matrix[0].length;

        int ans = Integer.MAX_VALUE;

        for(int i=r-2;i>=0;i--){

            for(int j=0;j<c;j++){

                int left = (j-1<0)? Integer.MAX_VALUE: matrix[i+1][j-1];
                int down = matrix[i+1][j];
                int right = (j+1==c)? Integer.MAX_VALUE: matrix[i+1][j+1];

                matrix[i][j] = matrix[i][j] + Math.min(left,Math.min(down,right));

            }

        }

            for(int i=0;i<c;i++){
                ans = Math.min(ans,matrix[0][i]);
            }
        

        return ans;

    }

    public static void main(String[] args) {
        
        int[][] input = {
            {2, 1, 3},
            {6, 5, 4},
            {7, 8, 9}
        };

        System.out.println("Input: ");

        for (int[] row : input) {
            System.out.println(Arrays.toString(row));
        }

        int output = minFallingPathSum(input);

        

        System.out.println("Output: " + output);
    }
    
}

/* 931. Minimum Falling Path Sum
Solved
Medium
Topics
premium lock icon
Companies
Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.

A falling path starts at any element in the first row and chooses the element in the next row that is either directly below or diagonally left/right. Specifically, the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).

 

Example 1:


Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
Output: 13
Explanation: There are two falling paths with a minimum sum as shown.
Example 2:


Input: matrix = [[-19,57],[-40,-5]]
Output: -59
Explanation: The falling path with a minimum sum is shown.
 

Constraints:

n == matrix.length == matrix[i].length
1 <= n <= 100
-100 <= matrix[i][j] <= 100 */