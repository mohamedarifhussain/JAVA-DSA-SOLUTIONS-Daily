
public class substrings_of_k_equals_k_1 {
    

    public static int substrCount(String s, int k) {
        // code here
        int[] alpha = new int[26];
        
        char[] arr = s.toCharArray();
        
        int res=0;
        
        int dis=0;
        for(int i=0;i<k;i++){
            char ch = arr[i];
            if(alpha[ch-97]==0){
                dis++;
            }
            alpha[ch-97]++;
        }
        if(dis==(k-1)) res++;
        
        for(int i=k;i<arr.length;i++){
            
            char c = arr[i-k];
            alpha[c-97]--;
            if(alpha[c-97]==0){
                dis--;
            }
            if(alpha[arr[i]-97]==0){
             dis++;   
            }
            alpha[arr[i]-97]++;
            
            if(dis == (k-1)) res++;
            
        }
        
        return res;
    }



    public static void main(String[] args) {
        
        String s ="aabab";
        int k=3;

        int result = substrCount(s, k);

        System.out.println("Input: String: " + s + " k: " + k);
        System.out.println("Output: " + result);
    }
}


/* Substrings of length k with k-1 distinct elements
Difficulty: MediumAccuracy: 57.85%Submissions: 42K+Points: 4Average Time: 15m
Given a string s consisting only lowercase alphabets and an integer k. Find the count of all substrings of length k which have exactly k-1 distinct characters.

Examples:

Input: s = "abcc", k = 2
Output: 1
Explaination: Possible substring of length k = 2 are,
ab : 2 distinct characters
bc : 2 distinct characters
cc : 1 distinct characters
Only one valid substring so, count is equal to 1.
Input: "aabab", k = 3
Output: 3
Explaination: Possible substring of length k = 3 are, 
aab : 2 distinct charcters
aba : 2 distinct characters
bab : 2 distinct characters
All these substring are valid so, the total count is equal to 3.
Constrains:
1 ≤ s.size() ≤ 105
2 ≤ k ≤ 27

Expected Complexities
Time Complexity: O(n)
Auxiliary Space: O(1)
 */