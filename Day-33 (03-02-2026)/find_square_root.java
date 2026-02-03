
public class find_square_root {
    

    static int floorSqrt(int n) {
        // code here
        if(n==0 || n==1){
            return n;
        }
        
        
        int low=1,high=n;
        
        
        while(low<=high){
            int mid = (low+high)/2;
            
            if(mid*mid==n){
                return mid;
            }
            else if(mid*mid < n){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        
        int low2=low-1;
        
        if(low2*low2<n){
            return low2;
        }
        
        return low;
    }

    public static void main(String[] args) {
        
        int input = 97;

        int output = floorSqrt(input);

        System.out.println("Input: "+input);
        System.out.println("Output: "+output);
    }
}
/* 
Square Root
Difficulty: EasyAccuracy: 54.03%Submissions: 361K+Points: 2Average Time: 20m
Given a positive integer n, find the square root of n. If n is not a perfect square, then return the floor value.

Floor value of any number is the greatest Integer which is less than or equal to that number.

Examples:

Input: n = 4
Output: 2
Explanation: Since, 4 is a perfect square, so its square root is 2.
Input: n = 11
Output: 3
Explanation: Since, 11 is not a perfect square, floor of square root of 11 is 3.
Input: n = 1
Output: 1
Explanation: 1 is a perfect sqaure, so its square root is 1.
Constraints:
1 ≤ n ≤ 3*104

 */
