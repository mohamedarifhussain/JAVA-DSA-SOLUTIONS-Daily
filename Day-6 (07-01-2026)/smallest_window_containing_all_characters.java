
public class smallest_window_containing_all_characters {
    
    public static String smallestWindow(String s, String p) {
        // code here
        
        int[] alpha_s = new int[26];
        
        int[] alpha_p = new int[26];
         
        
        char[] arr_p = p.toCharArray();
        char[] arr_s = s.toCharArray();
        
        
        int len_p =  arr_p.length;
        for(int i=0;i<len_p;i++){
           alpha_p[arr_p[i]-'a']++;
        }
        
        int c = len_p;
        
        int len_s = arr_s.length;
        
        int minlen = Integer.MAX_VALUE;
        
        int left=0,right;
        int ml=-1,mr=-1;
        for(int i=0;i<len_s;i++){
            
            right=i;
            
            if(alpha_s[arr_s[right]-'a']+1 <= alpha_p[arr_s[right]-'a']){
                c--;
            }
            
            alpha_s[arr_s[right]-'a']++;
            
            while(c==0){
                if(minlen>(right-left+1)){
                    ml = left;
                    mr = right;
                    minlen = (right-left+1);
                }
                
                if(alpha_p[arr_s[left]-'a']!=0 && alpha_s[arr_s[left]-'a']==alpha_p[arr_s[left]-'a']){
                    c++;
                }
                alpha_s[arr_s[left]-'a']--;
                left++;
            }
            
        }
        
        if(ml==-1 && mr==-1) return "";
        
        return s.substring(ml,mr+1);
    } 




    public static void main(String[] args) {
        
        String s="timetopractice",p="toc";

        String output = smallestWindow(s, p);

        System.out.println("Input: s="+s+", p="+p);
        System.out.println("Output: "+output);
    }
}


/* Smallest window containing all characters
Difficulty: HardAccuracy: 30.19%Submissions: 190K+Points: 8Average Time: 30m
Given two strings s and p. Find the smallest substring in s consisting of all the characters (including duplicates) of the string p. Return empty string in case no such substring is present.
If there are multiple such substring of the same length found, return the one with the least starting index.

Examples:

Input: s = "timetopractice", p = "toc"
Output: "toprac"
Explanation: "toprac" is the smallest substring in which "toc" can be found.
Input: s = "zoomlazapzo", p = "oza"
Output: "apzo"
Explanation: "apzo" is the smallest substring in which "oza" can be found.
Input: s = "zoom", p = "zooe"
Output: ""
Explanation: No substring is present containing all characters of p.
Constraints: 
1 ≤ s.length(), p.length() ≤ 106
s, p consists of lowercase english letters */
