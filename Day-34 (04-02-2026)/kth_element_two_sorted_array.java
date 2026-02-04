import java.util.*;


public class kth_element_two_sorted_array {
    



    public static int kthElement(int a[], int b[], int k) {
        // code here
        
        int result=0;
        int i=0,j=0;
        
        int n=a.length,m=b.length;
        
        for(int d=0;d<k;d++){
            
            if(i<n){
                
                if(j<m && a[i]>b[j]){
                    result = b[j];
                    j++;
                }
                else{
                    result=a[i];
                    i++;
                }
                
            }
            
            else if(j<m){
                result = b[j];
                j++;
            }
        }
        
        return result;
    }


    public static void main(String[] args) {
        

        int[] a = {2, 3, 6, 7, 9};
        int[] b = {1, 4, 8, 10};
        int k = 5;

        System.out.println("Array A: " + Arrays.toString(a));
        System.out.println("Array B: " + Arrays.toString(b));
        System.out.println("k = " + k);

        int output = kthElement(a, b, k);

        System.out.println("K-th element: " + output);
    }
}

/* K-th element of two Arrays
Difficulty: MediumAccuracy: 37.4%Submissions: 392K+Points: 4Average Time: 15m
Given two sorted arrays a[] and b[] and an element k, the task is to find the element that would be at the kth position of the combined sorted array.

Examples :

Input: a[] = [2, 3, 6, 7, 9], b[] = [1, 4, 8, 10], k = 5
Output: 6
Explanation: The final combined sorted array would be [1, 2, 3, 4, 6, 7, 8, 9, 10]. The 5th element of this array is 6.
Input: a[] = [1, 4, 8, 10, 12], b[] = [5, 7, 11, 15, 17], k = 6
Output: 10
Explanation: Combined sorted array is [1, 4, 5, 7, 8, 10, 11, 12, 15, 17]. The 6th element of this array is 10.
Constraints:
1 ≤ a.size(), b.size() ≤ 106
1 ≤ k ≤ a.size() + b.size()
0 ≤ a[i], b[i] ≤ 108
 */

