import java.util.*;

public class fruits_in_basket {
    

    public static int totalFruitByMe(int[] fruits) {
        
        // Index based removing fruits approach by me.

        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();

        int left=0;
        int maxlen=0;


        for(int i=0;i<fruits.length;i++){

            int right = i;

            
            if(map.get(fruits[right])==null){
                map.put(fruits[right],new ArrayList<>(Arrays.asList(right,right)));
                if(map.size()>2){
                    int first = fruits[right-1];
                    int second = fruits[right];

                    int rem = -1;
                    for(int key : map.keySet()){
                        if(key!=first && key!=second){
                            rem=key;
                        }
                    }
                    int last = map.get(rem).get(1);
                    int start = map.get(first).get(0);
                    map.remove(rem);
                    if(last<start){
                        left=start;
                    }
                    else{
                        left = last+1;
                    }
                }
            }
            else{
                map.get(fruits[right]).set(1,right);
            }

            maxlen = Math.max(maxlen,right-left+1);

        }
        
        return maxlen;
    }

    public static int totalFruit(int[] fruits) {
        
        
        HashMap<Integer,Integer> map = new HashMap<>();

        int left=0;
        int maxlen=0;

        for(int i=0;i<fruits.length;i++){

            int right = i;

            map.put(fruits[right],map.getOrDefault(fruits[right],0)+1);

            while(map.size()>2){
                if(map.get(fruits[left])==1){
                    map.remove(fruits[left]);
                }
                else{
                    map.put(fruits[left],map.get(fruits[left])-1);
                }
                left++;
            }

            maxlen = Math.max(maxlen,right-left+1);

        }
        
        return maxlen;
    }
    public static void main(String[] args) {
        
        int[] fruits = {1,2,3,2,2};
        int output = totalFruit(fruits);

        System.out.println("Input: Fruits="+Arrays.toString(fruits));
        System.out.println("Output: "+output);
    }
}

/* 904. Fruit Into Baskets
Solved
Medium
Topics
premium lock icon
Companies
You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.

You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:

You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
Given the integer array fruits, return the maximum number of fruits you can pick.

 

Example 1:

Input: fruits = [1,2,1]
Output: 3
Explanation: We can pick from all 3 trees.
Example 2:

Input: fruits = [0,1,2,2]
Output: 3
Explanation: We can pick from trees [1,2,2].
If we had started at the first tree, we would only pick from trees [0,1].
Example 3:

Input: fruits = [1,2,3,2,2]
Output: 4
Explanation: We can pick from trees [2,3,2,2].
If we had started at the first tree, we would only pick from trees [1,2]. */
