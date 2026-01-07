public class smallest_window_containing_0_1_2 {
 
    public static int smallestSubstring(String S) {
        // Code here
        if(S.length()<3) return -1;
        
        int[] num = new int[3];
        
        int c=0;
        
        char[] arr = S.toCharArray();
        
        int len=arr.length;
        
        
        for(int i=0;i<len;i++){
            if(num[arr[i]-'0'] != -1){
                c++;
            }
            num[arr[i]-'0']=-1;
        }
        if(c!=3) return -1;
        
        int minlen = Integer.MAX_VALUE;

        int left=0;
        int right;
        
        for(int i=0;i<len;i++){
            right = i;
            int ind = (arr[right]-'0');
            
            if(num[ind]==-1 || num[ind]==0){
                c--;
            }
            
            if(num[ind]==-1) num[ind]++;
            num[ind]++;
            
            while(c==0){
                int lind =(arr[left]-'0');
                minlen = Math.min(minlen,right-left+1);
                if(num[lind]==1) c++;
                num[lind]--;
                left++;
                
            }
            
        }
        
        return minlen;
    }

    public static void main(String[] args) {
        
        String input="10212";

        int output = smallestSubstring(input);

        System.out.println("Input: S="+input);
        System.out.println("Output: "+output);
    }
}


/* 
Smallest window containing 0, 1 and 2
Difficulty: EasyAccuracy: 49.73%Submissions: 61K+Points: 2
Given a string S consisting of the characters 0, 1 and 2. Your task is to find the length of the smallest substring of string S that contains all the three characters 0, 1 and 2. If no such substring exists, then return -1.

Example 1:

Input:
S = 10212
Output:
3
Explanation:
The substring 102 is the smallest substring
that contains the characters 0, 1 and 2.
Example 2:

Input: 
S = 12121
Output:
-1
Explanation: 
As the character 0 is not present in the
string S, therefor no substring containing
all the three characters 0, 1 and 2
exists. Hence, the answer is -1 in this case.
Your Task:
Complete the function smallestSubstring() which takes the string S as input, and returns the length of the smallest substring of string S that contains all the three characters 0, 1 and 2.

Expected Time Complexity: O( length( S ) )
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ length( S ) ≤ 105
All the characters of String S lies in the set {'0', '1', '2'} */