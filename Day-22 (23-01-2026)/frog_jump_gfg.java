import java.util.Arrays;

public class frog_jump_gfg {
    

    static int jump(int ind,int target,int[] height,int[] dp){
         
         if(ind==target){
             dp[ind] = 0;
             return 0;
         }
         if(dp[ind]!=-1) return dp[ind];
         int left = Integer.MAX_VALUE,right=Integer.MAX_VALUE;
         if(ind+1<=target) left = Math.abs(height[ind]-height[ind+1]) + jump(ind+1,target,height,dp);
         if(ind+2<=target) {right = Math.abs(height[ind]-height[ind+2]) + jump(ind+2,target,height,dp);
         }
         dp[ind] = Math.min(left,right);
         return dp[ind];
         
     }
    
    
    static int minCost(int[] height) {
        // code here
        
        int[] dp = new int[height.length];
        
        for(int i=0;i<height.length;i++) dp[i]=-1;
        
        return jump(0,height.length-1,height,dp);

         
    }

    public static void main(String[] args) {
        int[] input = {30, 20, 50, 10, 40};
        int output = minCost(input);

        System.out.println("Input: "+Arrays.toString(input));
        System.out.println("Output: "+output);
    }
}

/* Frog Jump
Difficulty: MediumAccuracy: 49.55%Submissions: 190K+Points: 4Average Time: 15m
Given an integer array height[] where height[i] represents the height of the i-th stair, a frog starts from the first stair and wants to reach the last stair. From any stair i, the frog has two options: it can either jump to the (i+1)th stair or the (i+2)th stair. The cost of a jump is the absolute difference in height between the two stairs. Determine the minimum total cost required for the frog to reach the last stair.

Example:

Input: heights[] = [20, 30, 40, 20]
Output: 20
Explanation:  Minimum cost is incurred when the frog jumps from stair 0 to 1 then 1 to 3:
jump from stair 0 to 1: cost = |30 - 20| = 10
jump from stair 1 to 3: cost = |20 - 30| = 10
Total Cost = 10 + 10 = 20
Input: heights[] = [30, 20, 50, 10, 40]
Output: 30
Explanation: Minimum cost will be incurred when frog jumps from stair 0 to 2 then 2 to 4:
jump from stair 0 to 2: cost = |50 - 30| = 20
jump from stair 2 to 4: cost = |40 - 50| = 10
Total Cost = 20 + 10 = 30
Constraints:
1 ≤ height.size() ≤ 105
0 ≤ height[i] ≤ 104 */
