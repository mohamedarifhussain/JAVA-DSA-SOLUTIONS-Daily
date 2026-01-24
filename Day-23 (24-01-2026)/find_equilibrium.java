import java.util.Arrays;

public class find_equilibrium {

    static void equilibrium(int[] nums) {

        int totSum = 0;

        for (int i = 0; i < nums.length; i++)
            totSum += nums[i];

        int left = 0;

        for (int i = 0; i < nums.length; i++) {

            totSum -= nums[i];
            if (left == totSum) {
                System.out.println("Equilibrium: " + nums[i]);
            }
            left += nums[i];

        }

    }

    public static void main(String[] args) {

        int[][] testCases = {

                // 1. Given example
                { 1, 2, 3, 7, 6 },

                // 2. Single element
                { 5 },

                // 3. Two elements (no equilibrium)
                { 1, 2 },

                // 4. All zeros
                { 0, 0, 0, 0 },

                // 5. All same numbers
                { 5, 5, 5, 5, 5 },

                // 6. Increasing numbers
                { 1, 2, 3, 4, 6 },

                // 7. Decreasing numbers
                { 10, 8, 6, 4, 2 },

                // 8. Multiple possible answers
                { 2, 1, 1, 2, 1, 1, 2 },

                // 9. Negative numbers included
                { -1, 3, -2, 5, -5 },

                // 10. Mixed positive and negative
                { 3, -1, 2, -2, 2, -1, 3 },

                // 11. Equilibrium at first index
                { 0, 1, 2, 3 },

                // 12. Equilibrium at last index
                { 1, 2, 3, 0 },

                // 13. No equilibrium large case
                { 1, 3, 5, 7, 9 },

                // 14. Large values
                { 100, 200, 300, 600 },

                // 15. Duplicates
                { 1, 4, 2, 2, 4, 1 },

                // 16. Only negatives
                { -5, -2, -3, -10 },

                // 17. Alternating pattern
                { 5, -5, 5, -5, 5, -5, 5 },

                // 18. Large array stress
                { 1, 2, 3, 4, 5, 6, 21 },

                // 19. Empty array (boundary)
                {},

                // 20. Single zero
                { 0 }
        };

        for (int i = 0; i < testCases.length; i++) {

            int[] input = Arrays.copyOf(testCases[i], testCases[i].length);

            System.out.println("Test Case " + (i + 1));
            System.out.println("Input  : " + Arrays.toString(input));

            System.out.println("Output : ");

            equilibrium(input);

            System.out.println("--------------------------------");
        }
    }
}

/* /* 23. array of numbers were given to find a number which has same sum of numbers in it’s
either side.
I/p 1, 2, 3, 7, 6
O/p 7(has 1+ 2+3 in left 6 in right ) */
