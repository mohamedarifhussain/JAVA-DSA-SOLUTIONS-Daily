import java.util.*;

public class greater_than_previous {


    public static List<Integer> greaterThanPrevious(int[] num){

        int max = Integer.MIN_VALUE;

        List<Integer> ans = new ArrayList<>();

        for(int i=0;i<num.length;i++){

            if(max<num[i]){
                ans.add(num[i]);
                max=num[i];
            }

        }
        return ans;

    }
    
    public static void main(String[] args) {
        int[][] testCases = {

            {2, -3, -4, 5, 9, 7, 8},
            {10},
            {1, 2, 3, 4, 5},
            {9, 8, 7, 6, 5},
            {4, 4, 4, 4},
            {-5, -4, -3, -2, -1},
            {-10, -5, 0, 3, -2, 8},
            {3, 7, 2, 9, 1, 10},
            {100, 1, 2, 3, 4},
            {5, 1, 6, 2, 7, 3, 8},
            {0, 0, 1, 0, 2, 0, 3},
            {2, 5, 5, 5, 7, 7, 9},
            {12, 3, 20, 15, 25, 10, 30},
            {-1, -2, -3, -4},
            {}
        };

        for (int i = 0; i < testCases.length; i++) {

            int[] input = Arrays.copyOf(testCases[i], testCases[i].length);

            System.out.println("Test Case " + (i + 1));
            System.out.println("Input  : " + Arrays.toString(input));

            List<Integer> output = greaterThanPrevious(input);

            System.out.println("Output : " + output);
            System.out.println("--------------------------------");
        }
    }
    
}

/* You’re given an array. Print the elements of the array which are greater than its previous elements in

the array.

Input : 2, -3, -4, 5, 9, 7, 8 Output: 2 5 9 You should solve this question in O(n) time.
 */