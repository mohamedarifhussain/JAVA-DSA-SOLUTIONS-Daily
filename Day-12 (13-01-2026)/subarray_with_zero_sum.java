import java.util.Arrays;
import java.util.HashMap;

public class subarray_with_zero_sum {
    
    static boolean findsum(int arr[]) {
        // Your code here
        
        HashMap<Integer,Integer> map = new HashMap<>();
        
        int sum=0;
        
        for(int i=0;i<arr.length;i++){
            
            if(arr[i]==0) return true;
            
            sum+=arr[i];
            
            if(sum==0) return true;
            
            if(map.get(sum)!=null) return true;
            
            else{
                map.put(sum,i);
            }
            
        }
        return false;
    }

    public static void main(String[] args) {
        
        int[] arr = {4, 2, -3, 1, 6};
        boolean output = findsum(arr);

        System.out.println("Input: "+Arrays.toString(arr));
        System.out.println("Output: "+output);
    }
}

/* Subarray with 0 sum
Difficulty: MediumAccuracy: 39.79%Submissions: 314K+Points: 4Average Time: 20m
Given an array of integers, arr[]. Find if there is a subarray (of size at least one) with 0 sum. Return true/false depending upon whether there is a subarray present with 0-sum or not. 

Examples:

Input: arr[] = [4, 2, -3, 1, 6]
Output: true
Explanation: 2, -3, 1 is the subarray with a sum of 0.
Input: arr = [4, 2, 0, 1, 6]
Output: true
Explanation: 0 is one of the element in the array so there exist a subarray with sum 0.
Input: arr = [1, 2, -1]
Output: false
Constraints:
1 <= arr.size <= 105
-105 <= arr[i] <= 105

Expected Complexities
Time Complexity: O(n)
Auxiliary Space: O(n)
 */
