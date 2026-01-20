import java.util.Arrays;

public class house_robber_ii {
    

    public static int houserob(int[] nums){

        if (nums.length < 2)
            return nums[0];

        int[] dp = new int[nums.length];

        dp[0] = nums[0];

        for(int i=1;i<nums.length;i++){

            int pick = nums[i];
            if(i>1) pick+=dp[i-2];
            int notpick = dp[i-1];

            dp[i] = Math.max(pick,notpick);

        }

        return dp[nums.length-1];
    }
    public static int rob(int[] nums) {
        
        if (nums.length < 2)
            return nums[0];

        int[] nums1 = new int[nums.length-1];
        int[] nums2 = new int[nums.length-1];

        for(int i=0;i<nums.length;i++){
            if(i!=0) nums1[i-1]=nums[i];
            if(i!=nums.length-1) nums2[i] = nums[i];
        }
       

        return Math.max(houserob(nums1),houserob(nums2));

    }

    public static void main(String[] args) {
        
        int[] input = {1,2,3,1};

        int output = rob(input);

        System.out.println("Input: "+Arrays.toString(input));
        System.out.println("Output: "+output);
    }
}

/* 
213. House Robber II
Solved
Medium
Topics
premium lock icon
Companies
Hint
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

 

Example 1:

Input: nums = [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
Example 2:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 3:

Input: nums = [1,2,3]
Output: 3
 

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 1000 */