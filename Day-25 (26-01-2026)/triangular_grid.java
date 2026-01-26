import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class triangular_grid {
    

    public static int minimumTotal(List<List<Integer>> input) {
        
        int len = input.get(input.size()-1).size();
        int[][] dp = new int[len][len];

        
        for(int i=0;i<len;i++){
            dp[len-1][i] = input.get(len-1).get(i);
        }

        for(int i=len-2;i>=0;i--){
            for(int j=0;j<i+1;j++){
                int sum =  input.get(i).get(j);
                dp[i][j] = sum + Math.min(dp[i+1][j],dp[i+1][j+1]);
            }
        }

        return dp[0][0];
    }

     public static void printinput(List<List<Integer>> input) {

        int n = input.size();

        for (int i = 0; i < n; i++) {

            // spaces for input shape
            for (int s = 0; s < n - i - 1; s++) {
                System.out.print(" ");
            }

            for (int val : input.get(i)) {
                System.out.print(val + " ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        List<List<Integer>> input = new ArrayList<>();

        input.add(Arrays.asList(2));
        input.add(Arrays.asList(3, 4));
        input.add(Arrays.asList(6, 5, 7));
        input.add(Arrays.asList(4, 1, 8, 3));

        System.out.println("Input:");
        printinput(input);

        int output = minimumTotal(input);

        System.out.println("Output: "+output);
    }
}

/* 120. Triangle
Solved
Medium
Topics
premium lock icon
Companies
Given a triangle array, return the minimum path sum from top to bottom.

For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.

 

Example 1:

Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
Output: 11
Explanation: The triangle looks like:
   2
  3 4
 6 5 7
4 1 8 3
The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
Example 2:

Input: triangle = [[-10]]
Output: -10
 

Constraints:

1 <= triangle.length <= 200
triangle[0].length == 1
triangle[i].length == triangle[i - 1].length + 1
-104 <= triangle[i][j] <= 104
 

Follow up: Could you do this using only O(n) extra space, where n is the total number of rows in the triangle?
 
 */
