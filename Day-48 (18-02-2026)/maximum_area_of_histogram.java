import java.util.Arrays;
import java.util.*;

public class maximum_area_of_histogram {
    

    public static int solve(int[] arr){
        int len = arr.length;
      
        int max=0;
        
        int[] left = new int[len];
        int[] right = new int[len];
        
        
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        
        for(int i=0;i<len;i++){
            
            
            while(!s1.isEmpty() && arr[s1.peek()]>arr[len-i-1]){
                
                // System.out.println(s1);
                s1.pop();
            }
            
            if(s1.isEmpty()){
                s1.push(len-i-1);
                right[len-i-1] = len;
            }
            else{
                right[len-i-1] = s1.peek();
                s1.push(len-i-1);
            }
            
            while(!s2.isEmpty() && arr[s2.peek()]>=arr[i]){
                s2.pop();
            }
            
            if(s2.isEmpty()){
                s2.push(i);
                left[i] = -1;
            }
            else{
                left[i] = s2.peek();
                s2.push(i);
            }
        }
        
        // System.out.println(Arrays.toString(left));
        // System.out.println(Arrays.toString(right));
        for(int i=0;i<len;i++){
            
            int num = right[i]-left[i]-1;
            max = (max<num*arr[i])? num*arr[i]:max;
            
        }
        
        return max;
    }

    public static void main(String[] args) {
        
        int[] input = {2,1,5,6,2,3};

        int output = solve(input);

        System.out.println("Input: "+Arrays.toString(input));
        System.out.println("Output: "+output);
    }
}


/* 84. Largest Rectangle in Histogram
Solved
Hard
Topics
premium lock icon
Companies
Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

 

Example 1:


Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.
Example 2:


Input: heights = [2,4]
Output: 4
 

Constraints:

1 <= heights.length <= 105
0 <= heights[i] <= 104
 
Seen this question in a real interview before?
1/5
Yes
No
Accepted
1,477,670/3M
Acceptance Rate
49.3%
Topics
icon
Companies */