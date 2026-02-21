import java.util.Arrays;

public class array_subset {
    

    public static boolean isSubset(int a[], int b[]) {
        // Your code here
        
        
        
        for(int i=0;i<b.length;i++){
            
            int has=-1;

            for(int j=0;j<a.length;j++){
                
                
                if(b[i]==a[j]){
                    a[j]=-1;
                    has = 1;
                    break;
                }
                
                
                
            }
            if(has== -1) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        
        int[] input1 = {11, 7, 1, 13, 21, 3, 7, 3};
        int[] input2 = {11, 3, 7, 1, 7};

        System.out.println("Array 1 : "+Arrays.toString(input1));
        System.out.println("Array 2 : "+Arrays.toString(input2));
        System.out.println("Output: "+isSubset(input1, input2)   );
    }
}

/* 

Array Subset
Difficulty: BasicAccuracy: 44.05%Submissions: 524K+Points: 1Average Time: 20m
Given two arrays a[] and b[], your task is to determine whether b[] is a subset of a[].

Examples:

Input: a[] = [11, 7, 1, 13, 21, 3, 7, 3], b[] = [11, 3, 7, 1, 7]
Output: true
Explanation: b[] is a subset of a[]
Input: a[] = [1, 2, 3, 4, 4, 5, 6], b[] = [1, 2, 4]
Output: true
Explanation: b[] is a subset of a[]
Input: a[] = [10, 5, 2, 23, 19], b[] = [19, 5, 3]
Output: false
Explanation: b[] is not a subset of a[]
Constraints:
1 <= a.size(), b.size() <= 105
1 <= a[i], b[j] <= 106

Expected Complexities
Company Tags
AccoliteQualcommGE
Topic Tags
Related Interview Experiences
Related Articles
 */