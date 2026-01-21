import java.util.*;

public class seperate_zeros_ones {

    public static int[] seperateZerosOnesSingleTraverse(int[] nums) {

        int zero = 0;

        int len = nums.length;

        for (int i = 0; i < len; i++) {

            while (zero < len && nums[zero] == 0) {
                zero++;
            }
            if (zero == len)
                return nums;

            if (zero < i && nums[zero] != 0 && nums[i] == 0) {
                nums[zero] = 0;
                nums[i] = 1;
            }

        }
        return nums;

    }

    public static void main(String[] args) {

        int[][] testCases = {

                // 1. All zeros
                { 0, 0, 0, 0 },

                // 2. All ones
                { 1, 1, 1, 1 },

                // 3. Single zero
                { 0 },

                // 4. Single one
                { 1 },

                // 5. Already separated (best case)
                { 0, 0, 0, 1, 1, 1 },

                // 6. Reverse order (worst case)
                { 1, 1, 1, 0, 0, 0 },

                // 7. Alternating values
                { 0, 1, 0, 1, 0, 1 },

                // 8. Starts with 1, ends with 0
                { 1, 0 },

                // 9. Minimal mixed case
                { 0, 1 },

                // 10. Random distribution
                { 1, 0, 1, 1, 0, 0, 1, 0 },

                // 11. Only one zero among ones
                { 1, 1, 1, 1, 0, 1, 1 },

                // 12. Only one one among zeros
                { 0, 0, 0, 0, 1, 0, 0 },

                // 13. Large block of zeros then ones
                { 0, 0, 0, 0, 0, 1, 1, 1, 1 },

                // 14. Large block of ones then zeros
                { 1, 1, 1, 1, 1, 0, 0, 0, 0 },

                // 15. Stress alternating (Zoho favorite)
                { 1, 0, 1, 0, 1, 0, 1, 0 },

                // 16. Two elements – both zero
                { 0, 0 },

                // 17. Two elements – both one
                { 1, 1 },

                // 18. Two elements – mixed
                { 1, 0 },

                // 19. Long random case
                { 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0 },

                // 20. Already sorted minimal
                { 0, 1 }
        };

        for (int i = 0; i < testCases.length; i++) {
            int[] input = Arrays.copyOf(testCases[i], testCases[i].length);
            int[] output = seperateZerosOnesSingleTraverse(input);

            System.out.println("Test Case " + (i + 1));
            System.out.println("Input  : " + Arrays.toString(testCases[i]));
            System.out.println("Output : " + Arrays.toString(output));
            System.out.println("--------------------------------");
        }

    }
}



/* 24. Separate 0s and 1s in single array traversal
 */