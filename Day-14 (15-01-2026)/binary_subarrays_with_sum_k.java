import java.util.*;

public class binary_subarrays_with_sum_k {
    
    public static int numSubarraysWithSum(int[] nums, int goal) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.get(sum - goal) != null) {
                count += map.get(sum - goal);
            }
            if (sum == goal)
                count++;
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;

    }

    public static void main(String[] args) {

        int[] binary = {1,0,1,0,1};
        int goal = 2;
        int output  = numSubarraysWithSum(binary, goal);

        System.out.println("Input: Array="+Arrays.toString(binary)+", goal="+goal);
        System.out.println("Output: "+ output);
        
    }
}

/* 930. Binary Subarrays With Sum
Solved
Medium
Topics
premium lock icon
Companies
Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.

A subarray is a contiguous part of the array.

 

Example 1:

Input: nums = [1,0,1,0,1], goal = 2
Output: 4
Explanation: The 4 subarrays are bolded and underlined below:
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
Example 2:

Input: nums = [0,0,0,0,0], goal = 0
Output: 15
 

Constraints:

1 <= nums.length <= 3 * 104
nums[i] is either 0 or 1.
0 <= goal <= nums.length
 */