import java.util.*;

public class longest_continuous_range {
    
     public static int longestConsecutive(int[] nums) {

        if (nums.length == 0)
            return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 1));
        }
        int maxlen = 1;
        for (int i : map.keySet()) {
            int l = 0;
            int ind = i;
            if (map.get(ind - 1) == null) {
                while (!(map.get(ind) == null)) {
                    l++;
                    ind++;
                }
                maxlen = Math.max(maxlen, l);
            }

        }

        return maxlen;
    }

    public static void main(String[] args) {
        
        int[] input = {0,3,7,2,5,8,4,6,0,1};

        int output = longestConsecutive(input);

        System.out.println("Input: "+Arrays.toString(input));
        System.out.println("Output: "+output);

    }
}

/* 128. Longest Consecutive Sequence
Solved
Medium
Topics
premium lock icon
Companies
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

 

Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
Example 3:

Input: nums = [1,0,1,2]
Output: 3
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
 */
