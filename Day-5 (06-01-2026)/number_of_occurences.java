import java.util.*;
public class number_of_occurences {
 
    static int Binary(int[] arr,int target){
        
        int left=0,right=arr.length-1;
        
        while(left<=right){
            
            int mid = (left + (right-left)/2);
            
            if(arr[mid]>=target){
                right = mid-1;
            }
            else{
                left = mid+1;
            }
            
        }
        
        int l = left;
        
        left=0;
        right = arr.length;
        
        
        while(left<=right){
            
            int mid = (left + (right-left)/2);
            
            if(mid>=arr.length) break;
            
            if(arr[mid]<=target){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
            
        }
        
        int r = left;
        
    
        return r-l;
        
    }




    public static void main(String[] args) {
        
        int[] arr = {1, 1, 2, 2, 2, 2, 3};
        int target = 2;

        int output = Binary(arr, target);
        System.out.println("Input: arr[]="+Arrays.toString(arr)+" , target = "+target);
        System.out.println("Output "+ output);
    }
}

/* 
Number of occurrence
Difficulty: EasyAccuracy: 59.34%Submissions: 373K+Points: 2Average Time: 20m
Given a sorted array, arr[] and a number target, you need to find the number of occurrences of target in arr[]. 

Examples :

Input: arr[] = [1, 1, 2, 2, 2, 2, 3], target = 2
Output: 4
Explanation: target = 2 occurs 4 times in the given array so the output is 4.
Input: arr[] = [1, 1, 2, 2, 2, 2, 3], target = 4
Output: 0
Explanation: target = 4 is not present in the given array so the output is 0.
Input: arr[] = [8, 9, 10, 12, 12, 12], target = 12
Output: 3
Explanation: target = 12 occurs 3 times in the given array so the output is 3.
Constraints:
1 ≤ arr.size() ≤ 106
1 ≤ arr[i] ≤ 106
1 ≤ target ≤ 106

Expected Complexities
Time Complexity: O(log n)
Auxiliary Space: O(1) */