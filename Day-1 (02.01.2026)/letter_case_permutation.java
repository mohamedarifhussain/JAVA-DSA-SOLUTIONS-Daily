import java.util.ArrayList;
import java.util.List;

public class letter_case_permutation {
    

    public static void perm(char[] ch,int l,String ans,List<String> res){

        if(l==ch.length){
            res.add(new String(ans));
            return;
        }
        int i=l;
            if(('a'<=ch[i] && ch[i]<='z')  ){
                perm(ch,l+1,ans+ch[i],res);
                perm(ch,l+1,ans+(char)(ch[i]-32),res);
            }
            else if('A'<=ch[i] && ch[i]<='Z'){
                perm(ch,l+1,ans+ch[i],res);
                perm(ch,l+1,ans+(char)(ch[i]+32),res);
            }
            else{
                 perm(ch,l+1,ans+ch[i],res);
            }

    }



    public static void main(String[] args) {

        String s = "a1b2";

        char[] chs = s.toCharArray();

        List<String> res = new ArrayList<>();

        perm(chs,0,"",res);

        System.out.println(res);
        
    }
}


/* 

784. Letter Case Permutation
Solved
Medium
Topics
premium lock icon
Companies
Given a string s, you can transform every letter individually to be lowercase or uppercase to create another string.

Return a list of all possible strings we could create. Return the output in any order.

 

Example 1:

Input: s = "a1b2"
Output: ["a1b2","a1B2","A1b2","A1B2"]
Example 2:

Input: s = "3z4"
Output: ["3z4","3Z4"]
 

Constraints:

1 <= s.length <= 12
s consists of lowercase English letters, uppercase English letters, and digits.

*/
