import java.util.ArrayList;
import java.util.Arrays;

public class max_consecutive_ones_3 {
    
    public static int longestOnes(int[] nums, int k) {

        ArrayList<Integer> arr = new ArrayList<>();
        int left = 0;
        int maxlen = 0;

        for (int i = 0; i < nums.length; i++) {
            int right = i;
            if (nums[right] == 0) {
                if (k > 0) {
                    if (arr.size() == k) {
                        int ind = arr.get(0);
                        arr.remove(0);
                        arr.add(right);
                        if (left <= ind)
                            left = ind + 1;
                    } else {
                        arr.add(right);
                    }
                } else {
                    left = right + 1;
                }
            }
            maxlen = Math.max(maxlen, right - left + 1);

        }
        return maxlen;
    }


    public static void main(String[] args) {
        
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k=2;
        int output = longestOnes(nums, k);


        System.out.println("Input: nums="+Arrays.toString(nums)+", k="+k);
        System.out.println("Output: "+output);
    }
}

/* 1004. Max Consecutive Ones III
Solved
Medium
Topics
premium lock icon
Companies
Hint
Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

 

Example 1:

Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
Example 2:

Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10
Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 

Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1.
0 <= k <= nums.length
 */