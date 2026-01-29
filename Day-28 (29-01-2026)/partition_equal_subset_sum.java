import java.util.Arrays;

public class partition_equal_subset_sum {
    

    static boolean subSet(int sum,int totalSum,int ind,int[] arr,int[][] dp){
        
        if(sum==totalSum-sum) return true;
        
        if(ind>=arr.length || sum>totalSum-sum) return false;
        
        if(dp[ind][sum]!=0) return dp[ind][sum]==1;
        
        if(subSet(sum+arr[ind],totalSum,ind+1,arr,dp)) {
            
            dp[ind][sum]=1;
            return true;
        }
        
        if(subSet(sum,totalSum,ind+1,arr,dp)) {
            dp[ind][sum]=1;
            return true;
            
        }
        dp[ind][sum]=-1;
        return false;
        
    }
    
    static boolean equalPartition(int arr[]) {
        // code here
        int sum = 0;
        
        for(int i=0;i<arr.length;i++) sum+=arr[i];
        
        int[][] dp = new int[arr.length+1][sum+1];
         
        return subSet(0,sum,0,arr,dp);
    }
    public static void main(String[] args) {
        
        int[] input = {1, 5, 11, 5};
        boolean output = equalPartition(input);

        System.out.println("Input: "+Arrays.toString(input));
        System.out.println("Output: "+output);
    }
}

/* Partition Equal Subset Sum
Difficulty: MediumAccuracy: 30.24%Submissions: 282K+Points: 4
Given an array arr[], determine if it can be partitioned into two subsets such that the sum of elements in both parts is the same.

Note: Each element must be in exactly one subset.

Examples:

Input: arr = [1, 5, 11, 5]
Output: true
Explanation: The two parts are [1, 5, 5] and [11].
Input: arr = [1, 3, 5]
Output: false
Explanation: This array can never be partitioned into two such parts.
Constraints:
1 ≤ arr.size ≤ 100
1 ≤ arr[i] ≤ 200
 */


