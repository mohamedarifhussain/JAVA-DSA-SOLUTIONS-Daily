import java.util.Arrays;
import java.util.HashMap;

public class subarrays_with_k_different_integers {
    
    public static int function(int[] nums, int k) {
        if (k <= 0)
            return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int count = 0;
        while (right < nums.length) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            if (map.size() < k)
                count += (right - left) + 1;
            while (map.size() > k) {
                if (map.get(nums[left]) == 1) {
                    map.remove(nums[left]);
                } else {
                    map.put(nums[left], map.get(nums[left]) - 1);
                }
                left++;
            }
            if (map.size() == k)
                count += (right - left) + 1;
            right++;
        }
        return count;
    }

    public static int subarraysWithKDistinct(int[] nums, int k) {
        int res1 = function(nums, k);
        int res2 = function(nums, k - 1);
        return res1 - res2;
    }

    public static void main(String[] args) {
        
        int[] nums = {1,2,1,2,3};
        int k=2;

        int output = subarraysWithKDistinct(nums, k);

        System.out.println("Input: nums="+Arrays.toString(nums)+", k="+k);
        System.out.println("Output: "+output);
    }
}

/* 992. Subarrays with K Different Integers
Solved
Hard
Topics
premium lock icon
Companies
Hint
Given an integer array nums and an integer k, return the number of good subarrays of nums.

A good array is an array where the number of different integers in that array is exactly k.

For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
A subarray is a contiguous part of an array.

 

Example 1:

Input: nums = [1,2,1,2,3], k = 2
Output: 7
Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]
Example 2:

Input: nums = [1,2,1,3,4], k = 3
Output: 3
Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].
 

Constraints:

1 <= nums.length <= 2 * 104
1 <= nums[i], k <= nums.length */
