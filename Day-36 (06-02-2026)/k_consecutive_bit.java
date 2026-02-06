import java.util.ArrayList;
import java.util.Arrays;

public class k_consecutive_bit {
    


    static ArrayList<Integer> solve(int[] nums,int k){



        ArrayList<Integer> result = new ArrayList<>();


        int time = 0;


        for(int i=0;i<nums.length;i++){

            result.add(nums[i]);

            if(nums[i]==0) time=0;

            else {
                time++;
                if(time==k) {result.add(0); time=0;}
            }


        }
        

        return result;

    }





    public static void main(String[] args) {
        
    // =========================
    // Main testing driver
    // =========================

        int[][] bitsCases = {
            {1,0,1,1,0,1,1,0,1,1,1,1},
            {1},
            {0},
            {0,0,0,0},
            {1,1,1,1},
            {1,1,1,1,1},
            {1,0,1,1},
            {1,0,1,0,1},
            {0,1,1},
            {1,1,0,0},
            {1,1,0,1,1,0,1,1},
            {1,1,1,1,1,1},
            {0,1,1,1,0,1,1,1,1,0},
            {},
            {1,1,1,1,1,1,1,1,1,1}
        };

        int[] kCases = {
            2,1,1,2,2,2,1,3,2,2,2,3,3,2,2
        };


        for (int i = 0; i < bitsCases.length; i++) {

            int[] input = Arrays.copyOf(bitsCases[i], bitsCases[i].length);
            int k = kCases[i];

            System.out.println("Test Case " + (i + 1));
            System.out.println("Input  : " + Arrays.toString(bitsCases[i]));
            System.out.println("K      : " + k);
            System.out.println("Output : " + solve(input,k));
            System.out.println("----------------------------------");
        }
    


    }
}

/* 
41. Insert 0 after consecutive (K times) of 1 is found.
Example:
Input:
Number of bits: 12
Bits: 1 0 1 1 0 1 1 0 1 1 1 1
Consecutive K: 2
Output:
1 0 1 1 0 0 1 1 0 0 1 1 0 1 1 0
 */