import java.util.Arrays;

public class product_of_array_except_self {

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int product = 1, zeros = 0;
        boolean isZero = false, producted = false;

        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                product *= nums[i];
                producted = true;
            } else {

                isZero = true;
                zeros++;
            }
        }
        if (!producted || zeros > 1)
            return result;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                result[i] = product;
            } else {
                if (!isZero)
                    result[i] = product / nums[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[] nums = { 1, 2, 3, 4 };

        int[] output = productExceptSelf(nums);

        System.out.println("Input: nums=" + Arrays.toString(nums));
        System.out.println("Ouput: " + Arrays.toString(output));
    }

}

/*
 * 238. Product of Array Except Self (leetcode 238)
 * Solved
 * Medium
 * Topics
 * premium lock icon
 * Companies
 * Hint
 * Given an integer array nums, return an array answer such that answer[i] is
 * equal to the product of all the elements of nums except nums[i].
 * 
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit
 * integer.
 * 
 * You must write an algorithm that runs in O(n) time and without using the
 * division operation.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 * Example 2:
 * 
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 * 
 * 
 * Constraints:
 * 
 * 2 <= nums.length <= 105
 * -30 <= nums[i] <= 30
 * The input is generated such that answer[i] is guaranteed to fit in a 32-bit
 * integer.
 * 
 * 
 * Follow up: Can you solve the problem in O(1) extra space complexity? (The
 * output array does not count as extra space for space complexity analysis.)
 */