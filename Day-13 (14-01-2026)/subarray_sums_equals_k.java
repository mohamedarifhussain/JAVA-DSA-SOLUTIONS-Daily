import java.util.Arrays;
import java.util.HashMap;

public class subarray_sums_equals_k {
    
    public static int subarraySum(int[] nums, int k) {
        
        int count=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum=0;

        for(int i=0;i<nums.length;i++){

            sum+=nums[i];
            if(sum==k) count++;
            if(map.get(sum-k)!=null){
                count+=map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);

        }

        return count;
    }


    public static void main(String[] args) {
        int[] nums={1,2,3};
        int k=3;

        int output = subarraySum(nums, k);

        System.out.println("Input: nums="+Arrays.toString(nums)+", k="+k);
        System.out.println("Output: "+output);
    }
}

/* 560. Subarray Sum Equals K
Solved
Medium
Topics
premium lock icon
Companies
Hint
Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.

 

Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2
 

Constraints:

1 <= nums.length <= 2 * 104
-1000 <= nums[i] <= 1000
-107 <= k <= 107 */