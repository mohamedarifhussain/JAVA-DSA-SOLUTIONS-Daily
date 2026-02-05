import java.util.Arrays;

public class next_greater_element {

    static int[] solve(int[] nums) {

        int len = nums.length;

        int[] result = new int[len];

        for (int i = len - 1; i >= 0; i--) {

            int max = Integer.MAX_VALUE;
            for (int j = i + 1; j < 2 * len; j++) {
                int ind = j % len;
                if (nums[i] < nums[ind]) {
                    max = Math.min(nums[ind], max);
                }

            }
            result[i] = max;

        }

        return result;

    }

    public static void main(String[] args) {

        int[][] testCases = {

                // 1. Given example
                { 6, 3, 9, 10, 8, 2, 1, 15, 7 },

                // -----------------------
                // BASIC
                // -----------------------

                // 2. Increasing order
                { 1, 2, 3, 4, 5 },

                // 3. Decreasing order
                { 5, 4, 3, 2, 1 },

                // 4. Single element
                { 10 },

                // 5. Two elements increasing
                { 3, 8 },

                // 6. Two elements decreasing
                { 8, 3 },

                // -----------------------
                // DUPLICATES
                // -----------------------

                // 7. All duplicates
                { 5, 5, 5, 5 },

                // 8. Mixed duplicates
                { 2, 7, 2, 7, 2 },

                // 9. Many repeated numbers
                { 1, 3, 3, 3, 5, 5, 7 },

                // -----------------------
                // NEGATIVE NUMBERS
                // -----------------------

                // 10. All negatives
                { -5, -4, -3, -2, -1 },

                // 11. Mixed negative + positive
                { -2, 4, -1, 7, 3 },

                // -----------------------
                // RANDOM
                // -----------------------

                // 12. Random order
                { 10, 5, 12, 3, 20, 8 },

                // 13. Alternating high low
                { 9, 1, 8, 2, 7, 3, 6, 4 },

                // 14. Large gaps
                { 100, 10, 500, 50, 1000 },

                // 15. Interleaving
                { 4, 15, 2, 9, 11, 6 },

                // -----------------------
                // EDGE CASES
                // -----------------------

                // 16. Contains zero
                { 0, 2, 1, 5, 3 },

                // 17. Empty
                {},

                // 18. Large values
                { 1000, 2000, 1500, 2500, 1800 },

                // 19. Already max first
                { 100, 1, 2, 3, 4 },

                // 20. Stress small
                { 11, 23, 5, 17, 30, 2 }
        };

        for (int i = 0; i < testCases.length; i++) {
            int[] input = Arrays.copyOf(testCases[i], testCases[i].length);

            System.out.println("Test Case " + (i + 1));
            System.out.println("Input  : " + Arrays.toString(input));
            System.out.println("Output : " + Arrays.toString(solve(input)));
            System.out.println("--------------------");
        }

    }
}


/* 11. Find the next greater element for each element in given array.
input: array[]={6, 3, 9, 10, 8, 2, 1, 15, 7};
output: {7, 5, 10, 15, 9, 3, 2, _, 8} If we are solving this question using sorting, we need to
use any O(nlogn) sorting algorithm
 */