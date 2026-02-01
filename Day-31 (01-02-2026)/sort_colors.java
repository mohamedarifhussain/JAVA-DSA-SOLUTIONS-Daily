import java.util.Arrays;

public class sort_colors {
    

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void sortColors(int[] arr) {

        int i = 0, j = 0, z = 0;

        while (z < arr.length) {
            if (arr[j] > arr[z]) {
                swap(arr, j, z);
            }

            if (arr[i] > arr[j]) {
                swap(arr, i, j);
            }
            if (arr[i] == 0)
                i++;
            if (arr[j] <= 1)
                j++;
            z++;

        }
    }

    public static void main(String[] args) {
        
        int[] input = {2,0,2,1,1,0};


        System.out.println("Input: "+Arrays.toString(input));

        sortColors(input);

        System.out.println("Output: "+Arrays.toString(input));
    }
}


/* 75. Sort Colors
Solved
Medium
Topics
premium lock icon
Companies
Hint
Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.

 

Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Example 2:

Input: nums = [2,0,1]
Output: [0,1,2]
 

Constraints:

n == nums.length
1 <= n <= 300
nums[i] is either 0, 1, or 2.
 

Follow up: Could you come up with a one-pass algorithm using only constant extra space? */