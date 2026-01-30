import java.util.Arrays;

public class minimum_absolute_difference_subset_partition{


     public static int minDifference(int arr[]) {
        // Your code goes here
        
        int dif = Integer.MAX_VALUE;
        
        int sum=0;
        for(int i=0;i<arr.length;i++) sum+=arr[i];
        
        int n = arr.length;
        
        int[][] dp = new int[arr.length][sum+1];
        
        for(int i=0;i<n;i++) dp[i][0] = 1;
        
        for(int ind=1;ind<n;ind++){
            for(int target = 1;target<=sum;target++){
                int notTake = dp[ind-1][target];
                int take = 0;
                
                if(arr[ind] <= target) take = dp[ind-1][target-arr[ind]];
                
                dp[ind][target] = (((notTake + take) > 0)? 1 : 0 );
            }
        }
        
        for(int i = 0;i<sum;i++){
            if(dp[n-1][i]==1){
                dif = Math.min(dif,Math.abs((sum-i)-i));
            }
        }
        
        
        
        return dif;
    }

    public static void main(String[] args) {
        
        int[] input = {1, 6, 11, 5};
        int output = minDifference(input);

        System.out.println("Input: "+Arrays.toString(input));
        System.out.println("Output: "+output);
    }
}

/* Minimum sum partition
Difficulty: HardAccuracy: 38.97%Submissions: 179K+Points: 8
Given an array arr[]  containing non-negative integers, the task is to divide it into two sets set1 and set2 such that the absolute difference between their sums is minimum and find the minimum difference.

Examples:

Input: arr[] = [1, 6, 11, 5]
Output: 1
Explanation: 
Subset1 = {1, 5, 6}, sum of Subset1 = 12 
Subset2 = {11}, sum of Subset2 = 11 
Hence, minimum difference is 1.  
Input: arr[] = [1, 4]
Output: 3
Explanation: 
Subset1 = {1}, sum of Subset1 = 1
Subset2 = {4}, sum of Subset2 = 4
Hence, minimum difference is 3.
Input: arr[] = [1]
Output: 1
Explanation: 
Subset1 = {1}, sum of Subset1 = 1
Subset2 = {}, sum of Subset2 = 0
Hence, minimum difference is 1.
Constraints:
1 ≤ arr.size()*|sum of array elements| ≤ 105
1 <= arr[i] <= 105

 */