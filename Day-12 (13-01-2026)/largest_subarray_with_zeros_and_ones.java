import java.util.Arrays;
import java.util.HashMap;

public class largest_subarray_with_zeros_and_ones {
    
    public static int maxLen(int[] arr) {
        // Your code here
        
        int zeros = 0;
        int ones = 0;
        
        int maxlen = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i=0;i<arr.length;i++){
            
            if(arr[i]==0) zeros++;
            else ones++;
            
            int dif = ones-zeros;
            
            if(map.get(dif)!=null){
              maxlen = Math.max(maxlen, i - map.get(dif));  
            }
            else{
                map.put(dif,i);
            }
            
            if(zeros==ones){
                maxlen = Math.max(maxlen,zeros+ones);
            }
        }
        
        return maxlen;
        
        
    }

    public static void main(String[] args) {
        
        int[] binary = {1, 0, 1, 1, 1, 0, 0};
        int output = maxLen(binary);

        System.out.println("Input: "+Arrays.toString(binary));
        System.out.println("Output: "+output);
    }
}


/* Largest subarray of 0's and 1's
Difficulty: EasyAccuracy: 32.96%Submissions: 130K+Points: 2Average Time: 20m
Given an array arr of 0s and 1s. Find and return the length of the longest subarray with equal number of 0s and 1s.

Examples:

Input: arr[] = [1, 0, 1, 1, 1, 0, 0]
Output: 6
Explanation: arr[1...6] is the longest subarray with three 0s and three 1s.
Input: arr[] = [0, 0, 1, 1, 0]
Output: 4
Explnation: arr[0...3] or arr[1...4] is the longest subarray with two 0s and two 1s.
Input: arr[] = [0]
Output: 0
Explnation: There is no subarray with an equal number of 0s and 1s.
Constraints:
1 <= arr.size() <= 105
0 <= arr[i] <= 1

Expected Complexities
Time Complexity: O(n)
Auxiliary Space: O(n) */