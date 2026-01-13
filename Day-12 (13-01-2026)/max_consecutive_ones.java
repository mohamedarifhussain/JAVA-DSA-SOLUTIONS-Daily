import java.util.Arrays;

public class max_consecutive_ones {
    
    public static int findMaxConsecutiveOnes(int[] nums) {

        int maxlen = 0;
        int left = 0;

        for (int i = 0; i < nums.length; i++) {

            int right = i;

            if (nums[right] == 0) {
                left = right + 1;
            } else {
                maxlen = Math.max(maxlen, right - left + 1);
            }
            
        }
        return maxlen;
    }
    public static void main(String[] args) {
        int[] nums = {1,1,0,1,1,1};
        int output = findMaxConsecutiveOnes(nums);

        System.out.println("Input: nums="+Arrays.toString(nums));
        System.out.println("Output: largest Consecutive Ones = "+output);
    }
}
/* 
485. Max Consecutive Ones
Solved
Easy
Topics
premium lock icon
Companies
Hint
Given a binary array nums, return the maximum number of consecutive 1's in the array.

 

Example 1:

Input: nums = [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
Example 2:

Input: nums = [1,0,1,1,0,1]
Output: 2
 

Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1. */