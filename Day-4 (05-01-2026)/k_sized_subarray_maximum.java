import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class k_sized_subarray_maximum {
    

    public static ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {
        // code here
        ArrayDeque<Integer> que = new ArrayDeque<>();
        
        ArrayList<Integer> result = new ArrayList<>();
        
        for(int i=0;i<k;i++){
            
            while(que.size()!=0 && arr[que.getLast()] < arr[i]){
                que.removeLast();
            }
            que.add(i);
            
        }
        
        result.add(arr[que.getFirst()]);
        
        for(int i=k;i<arr.length;i++){
            
            while(que.size()!=0 && !(i-k+1 <= que.getFirst())){
                que.removeFirst();
            }
            
            while(que.size()!=0 && arr[que.getLast()] < arr[i]){
                que.removeLast();
            }
            que.add(i);
            
            result.add(arr[que.getFirst()]);
            
        }
        
        return result;
        
        
    }


    public static void main(String[] args) {
        

        int[] arr = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        int k = 3;

        ArrayList<Integer> result = maxOfSubarrays(arr, k);
        System.out.println("Input: arr: " + Arrays.toString(arr) + " k: " + k);
        System.out.println("Output: " + result);
    }
}


/* K Sized Subarray Maximum
Difficulty: MediumAccuracy: 26.04%Submissions: 418K+Points: 4
Given an array arr[] of positive integers and an integer k. You have to find the maximum value for each contiguous subarray of size k. Return an array of maximum values corresponding to each contiguous subarray.

Examples:

Input: arr[] = [1, 2, 3, 1, 4, 5, 2, 3, 6], k = 3
Output: [3, 3, 4, 5, 5, 5, 6]
Explanation: 
1st contiguous subarray [1, 2, 3], max = 3
2nd contiguous subarray [2, 3, 1], max = 3
3rd contiguous subarray [3, 1, 4], max = 4
4th contiguous subarray [1, 4, 5], max = 5
5th contiguous subarray [4, 5, 2], max = 5
6th contiguous subarray [5, 2, 3], max = 5
7th contiguous subarray [2, 3, 6], max = 6
Input: arr[] = [5, 1, 3, 4, 2], k = 1
Output: [5, 1, 3, 4, 2]
Explanation: When k = 1, each element in the array is its own subarray, so the output is simply the same array
Constraints:
1 ≤ arr.size() ≤ 106
1 ≤ k ≤ arr.size()
0 ≤ arr[i] ≤ 109

Expected Complexities
Time Complexity: O(n)
Auxiliary Space: O(k) */