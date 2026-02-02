import java.util.*;
public class reverse_rotate_matrix {
    
    public static void reverse(int[] arr,int start,int end){
        
        while(start<end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            
            start++;
            end--;
        }
    }
    
    public static void rotate(int[] arr,int k){
        reverse(arr,0,k-1);
        reverse(arr,k,arr.length-1);
        reverse(arr,0,arr.length-1);
    }
    
    public static int[][] rotateMatrix(int k, int mat[][]) {
        // code here
        
        k = k%mat[0].length;
        
        int[] ind = new int[mat[0].length];
        
        for(int i=0;i<ind.length;i++) ind[i]=i;
        
        rotate(ind,k);
        
        int[][] result=new int[mat.length][ind.length];
        
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<ind.length;j++){
                result[i][j] = mat[i][ind[j]];
            }
        }
        
        return result;
        
        
    }

    public static void main(String[] args) {
    

    

        int k = 2;

        int[][] mat = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        // Printing
        System.out.println("k = " + k);
        System.out.println("Matrix:");

        for (int[] row : mat) {
            System.out.println(Arrays.toString(row));
        }
    
        System.out.println();

        System.out.println("Output: ");

        int[][] output = rotateMatrix(k, mat);

        for(int[] row : output){
            System.out.println(Arrays.toString(row));
        }
}

    
}
/* 
Rotate Each Row of Matrix K Times
Difficulty: MediumAccuracy: 41.89%Submissions: 43K+Points: 4Average Time: 30m
You are given an integer k and matrix mat. Rotate the elements of the given matrix to the left k times and return the resulting matrix.

Examples:

Input: k=1, mat=[[1,2,3]
                 [4,5,6]
                 [7,8,9]]
Output: [[2, 3, 1]
         [5, 6, 4]
         [8, 9, 7]]
Explanation: Rotate the matrix by one
1 2 3       2 3 1
4 5 6  =>  5 6 4
7 8 9       8 9 7
Input: k=2, mat=[[1, 2, 3]
                 [4, 5, 6]
                 [7, 8, 9]]
Output: [[3, 1, 2]
         [6, 4, 5]
         [9, 7, 8]]
Explanation: After rotating the matrix looks like
1 2 3       2 3 1       3 1 2
4 5 6  =>  5 6 4  =>   6 4 5
7 8 9       8 9 7       9 7 8
Expected Time Complexity: O(n*m)
Expected Auxillary Space: O(n*m)

Constraints:
1<=k<=104
1<= mat.size(), mat[0].size, mat[i][j] <=1000


 */