import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class permutation_of_string{

    public static void perm_optimal_hashmap(HashMap<Character,Integer> mp,String a,int len,ArrayList<String> ans){
        
        if(a.length()==len){
            ans.add(a);
            return;
        }
        
        for(char ch : mp.keySet()){
            
            if(mp.get(ch)>0){
                mp.put(ch,mp.get(ch)-1);
                perm_optimal_hashmap(mp,a+ch,len,ans);
                mp.put(ch,mp.get(ch)+1);
            }
        }
        
    }
    

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        
        ArrayList<String> str = new ArrayList<>();
         
        
        HashMap<Character,Integer> mp = new HashMap<>();
        
        
        for(char ch : s.toCharArray()){
            
            if(mp.get(ch)!=null){
                mp.put(ch,mp.get(ch)+1);
            }
            else{
                mp.put(ch,1);
            }
        }
        
        perm_optimal_hashmap(mp,"",s.length(),str);

        System.out.println(str);
        
        
    }
}


/* 
Given a string s, which may contain duplicate characters, your task is to generate and return an array of all unique permutations of the string. You can return your answer in any order.

Examples:

Input: s = "ABC"
Output: ["ABC", "ACB", "BAC", "BCA", "CAB", "CBA"]
Explanation: Given string ABC has 6 unique permutations.
Input: s = "ABSG"
Output: ["ABGS", "ABSG", "AGBS", "AGSB", "ASBG", "ASGB", "BAGS", "BASG", "BGAS", "BGSA", "BSAG", "BSGA", "GABS", "GASB", "GBAS", "GBSA", "GSAB", "GSBA", "SABG", "SAGB", "SBAG", "SBGA", "SGAB", "SGBA"]
Explanation: Given string ABSG has 24 unique permutations.
Input: s = "AAA"
Output: ["AAA"]
Explanation: No other unique permutations can be formed as all the characters are same.
Constraints:
1 <= s.size() <= 9
s contains only Uppercase english alphabets

Expected Complexities
Time Complexity: O(n! * n)
Auxiliary Space: O(n) 

*/