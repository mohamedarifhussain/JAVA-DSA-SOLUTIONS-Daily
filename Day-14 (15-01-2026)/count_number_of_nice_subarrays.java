import java.util.Arrays;

public class count_number_of_nice_subarrays {
    
    public static int countArrays(int[] nums, int k) {
        if (k < 0)
            return 0;
        int left = 0, right = 0, odd = 0, count = 0;
        while (right < nums.length) {

            if (nums[right] % 2 == 1)
                odd++;

            while (odd > k) {
                if (nums[left] % 2 == 1)
                    odd--;
                left++;
            }

            count = count + (right - left) + 1;
            right++;

        }
        return count;
    }

    public static int numberOfSubarrays(int[] nums, int k) {

        return countArrays(nums, k) - countArrays(nums, k - 1);
    }


    public static void main(String[] args) {
        
        int[] nums = {2,2,2,1,2,2,1,2,2,2};
        int k=2;
        int output = numberOfSubarrays(nums, k);

        System.out.println("Input: nums="+Arrays.toString(nums)+", k="+k);
        System.out.println("Output: "+output);
    }
}
/* 
1248. Count Number of Nice Subarrays
Solved
Medium
Topics
premium lock icon
Companies
Hint
Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.

Return the number of nice sub-arrays.

 

Example 1:

Input: nums = [1,1,2,1,1], k = 3
Output: 2
Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].
Example 2:

Input: nums = [2,4,6], k = 1
Output: 0
Explanation: There are no odd numbers in the array.
Example 3:

Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
Output: 16
 

Constraints:

1 <= nums.length <= 50000
1 <= nums[i] <= 10^5
1 <= k <= nums.length
 */