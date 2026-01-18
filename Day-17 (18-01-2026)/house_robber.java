import java.util.Arrays;

public class house_robber {
    
    // House Rob Dynamic Programming Recurion with dp array.

    public static int houseRob(int ind, int[] nums,int[] dp) {

        if(ind<0) return 0;
        if(ind==0) return nums[ind];


        if(dp[ind]!=0) return dp[ind];
    
        int pick = nums[ind] + houseRob(ind-2,nums,dp);
    
        int notPick = houseRob(ind-1,nums,dp);

        dp[ind] = Math.max(pick,notPick);

        return dp[ind];

    }

    public static int HouseRobMemo(int[] nums) {

        if (nums.length < 2)
            return nums[0];

        int[] dp = new int[nums.length];
        
        houseRob(nums.length-1,nums,dp);


        return dp[nums.length-1];
    }

    // House Rob Dynamic Programming Tabulation with dp array.

    public static int houseRobTabulation(int[] nums){

        if (nums.length < 2)
            return nums[0];

        int[] dp = new int[nums.length];

        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {

            int pick = nums[i] + ((i > 1) ? dp[i - 2] : 0);
            int notpick = dp[i - 1];

            dp[i] = Math.max(pick, notpick);
        }

        return dp[nums.length - 1];
    }


    // House Rob Dynamic Programming Tabulation with Space Optimization

    public static int houseRobOpti(int[] nums){

        if (nums.length < 2)
            return nums[0];


        int prev = nums[0];
        int prev2 = 0;

        int cur=0;

        for (int i = 1; i < nums.length; i++) {

            int pick = nums[i] + prev2;
            int notpick = prev;

            cur = Math.max(pick, notpick);
            prev2 = prev;
            prev = cur;
        }

        return cur;
    }

    public static void main(String[] args) {
        

        int[] input = {2,7,9,3,1};
        int output = houseRobOpti(input);

        System.out.println("Input: "+Arrays.toString(input));
        System.out.println("Output: "+output);
    }
}
/* 
198. House Robber
Solved
Medium
Topics
premium lock icon
Companies
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

 

Example 1:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.
 

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 400 */
