import java.util.Arrays;

public class move_zeros_merge_duplicate {

    public static int[] moveZerosMergeDuplicates(int[] nums) {

        int x = 0;
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {

            if (nums[i] != 0) {
                if (nums[i] == nums[i + 1]) {
                    nums[i] += nums[i];
                    nums[i + 1] = 0;
                }
                if (x < i && (nums[x] == 0 && nums[i] != 0)) {
                    nums[x] = nums[i];
                    nums[i] = 0;
                }
                x++;
            }
            else{
                if(nums[x]!=0 && nums[i+1]==0){
                    x=i+1;
                }
            }
        }
        if (x < (len - 1) && (nums[x] == 0 && nums[len - 1] != 0)) {
            nums[x] = nums[len - 1];
            nums[len - 1] = 0;
            x++;
        }

        return nums;

    }

    public static void main(String[] args) {

        int[][] testCases = {
                { 0, 0, 0, 0 },
                { 5 },
                { 0 },
                { 1, 2, 3, 4, 5 },
                { 2, 2, 2, 2 },
                { 2, 0, 2, 2 },
                { 1, 1, 2, 2, 3, 3 },
                { 0, 4, 4, 5, 0 },
                { 2, 2, 2 },
                { 100000, 100000, 0 },
                { 3, 3, 0, 3, 3 },
                { 4, 2, 12, 8, 0, 0 },
                { 0, 1, 1, 0, 2, 2, 2, 0, 3 },
                { 1, 1, 1, 1, 1, 1 }
        };

        for (int i = 0; i < testCases.length; i++) {
            int[] input = Arrays.copyOf(testCases[i], testCases[i].length);
            int[] output = moveZerosMergeDuplicates(input);

            System.out.println("Test Case " + (i + 1));
            System.out.println("Input  : " + Arrays.toString(testCases[i]));
            System.out.println("Output : " + Arrays.toString(output));
            System.out.println("--------------------------------");
        }
    }
}

/* 4.Given an array as input, The condition is if the number is repeated you must add the
number and put the next index value to 0. If the number is 0 print it at the last.
Eg: arr[] = { 0, 2, 2, 2, 0, 6, 6, 0, 8}
Output: 4 2 12 8 0 0 0 0 0 . */
