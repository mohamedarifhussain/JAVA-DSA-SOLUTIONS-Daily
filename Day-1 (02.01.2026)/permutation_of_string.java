import java.util.ArrayList;
import java.util.HashMap;

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