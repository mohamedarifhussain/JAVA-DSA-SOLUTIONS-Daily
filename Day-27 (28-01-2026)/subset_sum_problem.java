
import java.util.Arrays;


public class subset_sum_problem {

    static Boolean subSet(int ind,int sum,int target,int[] arr){
        
        if(sum==target){
            return true;
        }
        
        if(sum>target) return false;
        
        for(int i=ind;i<arr.length;i++){
            
            if(subSet(i+1,sum+arr[i],target,arr)){
                return true;
            }
            
        }
        return false;
        
    }

    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        
        return subSet(0,0,sum,arr);
        
    }
    

    public static void main(String[] args) {
        
        int[] input = {3, 34, 4, 12, 5, 2};
        int sum = 9;

        boolean output = isSubsetSum(input, sum);

        System.out.println("Input: "+Arrays.toString(input));
        System.out.println("Output: "+output);
    }
}

/* Subset Sum Problem
Difficulty: MediumAccuracy: 32.0%Submissions: 431K+Points: 4
Given an array of positive integers arr[] and a value sum, determine if there is a subset of arr[] with sum equal to given sum. 

Examples:

Input: arr[] = [3, 34, 4, 12, 5, 2], sum = 9
Output: true 
Explanation: Here there exists a subset with target sum = 9, 4+3+2 = 9.
Input: arr[] = [3, 34, 4, 12, 5, 2], sum = 30
Output: false
Explanation: There is no subset with target sum 30.
Input: arr[] = [1, 2, 3], sum = 6
Output: true
Explanation: The entire array can be taken as a subset, giving 1 + 2 + 3 = 6.
Constraints:
1 <= arr.size() <= 200
1<= arr[i] <= 200
1<= sum <= 104 */
