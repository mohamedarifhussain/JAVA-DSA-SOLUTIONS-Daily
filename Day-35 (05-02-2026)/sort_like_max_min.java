import java.util.Arrays;

public class sort_like_max_min {

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int[] sort(int[] nums) {

        int len = nums.length;

        for (int i = 0; i < len; i++) {

            if (i % 2 == 0) {

                int maxInd = i;

                for (int j = i + 1; j < len; j++) {
                    if (nums[maxInd] < nums[j]) {
                        maxInd = j;
                    }
                }

                swap(nums, i, maxInd);

            } else {
                int minInd = i;

                for (int j = i + 1; j < len; j++) {
                    if (nums[minInd] > nums[j]) {
                        minInd = j;
                    }
                }

                swap(nums, i, minInd);

            }

        }

        return nums;

    }

    public static void main(String[] args) {

        int[][] testCases = {

                // 1. Given example
                { 1, 2, 3, 4, 5, 6, 7 },

                // ---------------------
                // BASIC
                // ---------------------

                // 2. Even count
                { 1, 2, 3, 4, 5, 6 },

                // 3. Two elements
                { 1, 2 },

                // 4. Single element
                { 5 },

                // 5. Three elements
                { 10, 20, 30 },

                // ---------------------
                // ORDER VARIATIONS
                // ---------------------

                // 6. Already descending
                { 9, 8, 7, 6, 5, 4, 3 },

                // 7. Random order
                { 4, 1, 7, 3, 9, 2, 6 },

                // 8. Reverse random
                { 50, 10, 40, 20, 30 },

                // ---------------------
                // DUPLICATES
                // ---------------------

                // 9. All same
                { 5, 5, 5, 5, 5 },

                // 10. Many duplicates
                { 1, 1, 2, 2, 3, 3, 4, 4 },

                // 11. Duplicates with odd length
                { 2, 2, 2, 3, 3, 4, 4 },

                // ---------------------
                // NEGATIVES
                // ---------------------

                // 12. All negatives
                { -7, -6, -5, -4, -3, -2, -1 },

                // 13. Mixed negative + positive
                { -10, -5, 0, 5, 10, 15 },

                // ---------------------
                // EDGE VALUES
                // ---------------------

                // 14. Includes zero
                { 0, 1, 2, 3, 4, 5 },

                // 15. Large numbers
                { 100, 200, 300, 400, 500 },

                // ---------------------
                // SPECIAL PATTERNS
                // ---------------------

                // 16. Alternate high-low
                { 100, 1, 90, 2, 80, 3, 70, 4 },

                // 17. Prime count
                { 11, 22, 33, 44, 55 },

                // 18. Already arranged
                { 7, 1, 6, 2, 5, 3, 4 },

                // ---------------------
                // BOUNDARIES
                // ---------------------

                // 19. Empty
                {},

                // 20. Large stress
                { 23, 44, 12, 9, 78, 55, 32, 11, 90, 1, 66, 5 }
        };

        for (int i = 0; i < testCases.length; i++) {
            int[] input = Arrays.copyOf(testCases[i], testCases[i].length);

            System.out.println("Test Case " + (i + 1));
            System.out.println("Input  : " + Arrays.toString(input));
            System.out.println("Output : " + Arrays.toString(sort(input)));
            System.out.println("-------------------------");
        }

    }

}
/*
 * 106. Given an array of integers, rearrange the array in such a way that the
 * first element
 * is first maximum and second element is first minimum.
 * Eg.) Input : {1, 2, 3, 4, 5, 6, 7}
 * Output : {7, 1, 6, 2, 5, 3, 4}
 */