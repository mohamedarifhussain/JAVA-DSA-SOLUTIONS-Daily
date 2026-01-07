public class smallest_distinct_window {
    

     public static int findSubString(String str) {
        // code here
        
        int[] alpha = new int[256];
        
        int c=0;
        
        char[] arr = str.toCharArray();
        
        int len  = arr.length;
        
        for(int i=0;i<len;i++){ 
            if(alpha[arr[i]]==0){
                alpha[arr[i]]=-1;
                c++;
            }
        }
        
        int minlen = Integer.MAX_VALUE;
        
        int left=0,right=0;
        
        for(int i=0;i<len;i++){
            
            right=i;
            if(alpha[arr[right]]==-1 || alpha[arr[right]]==0){
                c--;
            }
            
            if(alpha[arr[right]]==-1) alpha[arr[right]]++;
            alpha[arr[right]]++;
            
            while(c==0){
            minlen = Math.min(minlen,right-left+1);
            
            if(alpha[arr[left]]==1) c++;
              
            
            alpha[arr[left]]--;
            left++;
            }
        }
        
        
        
        
        
        return minlen;
    }


    public static void main(String[] args) {
        
        String str = "aabcbcdbca";

        int output = findSubString(str);

        System.out.println("Input: str = "+str);
        System.out.println("Output: "+output);

    }
}


/* Smallest distinct window
Difficulty: MediumAccuracy: 31.85%Submissions: 121K+Points: 4
Given a string str, your task is to find the length of the smallest window that contains all the characters of the given string at least once.

Example:

Input: str = "aabcbcdbca"
Output: 4
Explanation: Sub-String "dbca" has the smallest length that contains all the characters of str.
Input: str = "aaab"
Output: 2
Explanation: Sub-String "ab" has the smallest length that contains all the characters of str.
Input: str = "geeksforgeeks"
Output: 7
Explanation: There are multiple substring with smallest length that contains all characters of str, "eksforg" and "ksforge". 
Constraints:
1 ≤ str.size() ≤ 105
str contains only lower-case english alphabets. */


