import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class minimum_absolute_difference {
    

    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        
        Arrays.sort(arr);

        List<List<Integer>> ans = new ArrayList<>();

        int min = Integer.MAX_VALUE;

        for(int i=0;i<arr.length-1;i++){
            int temp = arr[i+1]-arr[i];
            min = Math.min(min,temp);
            
        }

        for(int i=0;i<arr.length-1;i++){
            int temp = arr[i+1]-arr[i];
            if(temp==min){
                ans.add(new ArrayList<>(Arrays.asList(arr[i],arr[i+1])));
            }
        }

        return ans;

    }

    public static void main(String[] args) {
        
        int[] input = {1,3,6,10,15};

        List<List<Integer>> output = minimumAbsDifference(input);

        System.out.println("Input: "+Arrays.toString(input));

        System.out.println("Output "+output);
    }
}

/* 1200. Minimum Absolute Difference
Solved
Easy
Topics
premium lock icon
Companies
Hint
Given an array of distinct integers arr, find all pairs of elements with the minimum absolute difference of any two elements.

Return a list of pairs in ascending order(with respect to pairs), each pair [a, b] follows

a, b are from arr
a < b
b - a equals to the minimum absolute difference of any two elements in arr
 

Example 1:

Input: arr = [4,2,1,3]
Output: [[1,2],[2,3],[3,4]]
Explanation: The minimum absolute difference is 1. List all pairs with difference equal to 1 in ascending order.
Example 2:

Input: arr = [1,3,6,10,15]
Output: [[1,3]]
Example 3:

Input: arr = [3,8,-10,23,19,-4,-14,27]
Output: [[-14,-10],[19,23],[23,27]]
 

Constraints:

2 <= arr.length <= 105
-106 <= arr[i] <= 106 */
