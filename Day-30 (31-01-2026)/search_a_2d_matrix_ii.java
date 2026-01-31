import java.util.*;
public class search_a_2d_matrix_ii {
    

    public static boolean searchMatrix(int[][] mat, int target) {
        
        int row=0,col=mat[0].length-1;

        while(row<mat.length && col>=0){

            int num = mat[row][col];

            if(num>target){
                col--;
            }
            else if(num<target){
                row++;
            }
            else{
                return true;
            }
        }
        
        return false;
    }

    public static void main(String[] args) {
        int[][] input= {
            {1, 4, 7, 11, 15},
            {2, 5, 8, 12, 19},
            {3, 6, 9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
        };

        int target = 5;

        // Printing
        System.out.println("Input:");
        for (int[] row : input) {
            System.out.println(Arrays.toString(row));
        }

        System.out.println("Target = "+target);

        boolean output = searchMatrix(input, target);

        System.out.println("Output: "+output);
    }
}
/* 
240. Search a 2D Matrix II
Solved
Medium
Topics
premium lock icon
Companies
Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
 

Example 1:


Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
Output: true
Example 2:


Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
Output: false
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= n, m <= 300
-109 <= matrix[i][j] <= 109
All the integers in each row are sorted in ascending order.
All the integers in each column are sorted in ascending order.
-109 <= target <= 109
 */