import java.util.Arrays;

public class odd_position_even_position_sort {

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

                for (int j = i + 2; j < len; j+=2) {
                    if (nums[maxInd] < nums[j]) {
                        maxInd = j;
                    }
                }

                swap(nums, i, maxInd);

            } else {
                int minInd = i;

                for (int j = i + 2; j < len; j+=2) {
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

        int[][] testCases = { // 1. Given example 1
                { 13, 2, 4, 15, 12, 10, 5 },

                // 2. Given example 2
                { 1, 2, 3, 4, 5, 6, 7, 8, 9 },

                // -------------------------
                // BASIC CASES
                // -------------------------

                // 3. Single element
                { 5 },

                // 4. Two elements
                { 9, 1 },

                // 5. Three elements
                { 5, 3, 1 },

                // 6. Already sorted ascending
                { 1, 2, 3, 4, 5, 6 },

                // 7. Already sorted descending
                { 9, 8, 7, 6, 5, 4 },

                // -------------------------
                // ALL SAME TYPE
                // -------------------------

                // 8. All same numbers
                { 7, 7, 7, 7, 7, 7 },

                // 9. All zeros
                { 0, 0, 0, 0 },

                // -------------------------
                // ODD/EVEN COUNT VARIATIONS
                // -------------------------

                // 10. Odd number of elements
                { 10, 20, 30, 40, 50 },

                // 11. Even number of elements
                { 11, 22, 33, 44, 55, 66 },

                // -------------------------
                // NEGATIVE NUMBERS
                // -------------------------

                // 12. All negatives
                { -1, -2, -3, -4, -5, -6 },

                // 13. Mixed positive and negative
                { -10, 5, -3, 8, -1, 2 },

                // -------------------------
                // DUPLICATES
                // -------------------------

                // 14. Many duplicates
                { 5, 1, 5, 1, 5, 1, 5, 1 },

                // -------------------------
                // RANDOM PATTERNS
                // -------------------------

                // 15. Random mix
                { 12, 7, 3, 14, 9, 2, 11, 6, 5 },

                // 16. Alternating high-low
                { 100, 1, 90, 2, 80, 3, 70, 4 },

                // 17. Large values
                { 1000, 500, 2000, 1500, 3000, 2500 },

                // -------------------------
                // EDGE BOUNDARIES
                // -------------------------

                // 18. Empty array
                {},

                // 19. Two equal elements
                { 4, 4 },

                // 20. Large stress
                { 23, 44, 12, 9, 78, 55, 32, 11, 90, 1, 66, 5, 100, 3 } };

        for (int i = 0; i < testCases.length; i++) {
            int[] input = Arrays.copyOf(testCases[i], testCases[i].length);

            System.out.println("Test Case " + (i + 1));
            System.out.println("Input  : " + Arrays.toString(input));
            System.out.println("Output : " + Arrays.toString(sort(input)));
            System.out.println("--------------------------------");

        }

    }
}

/* 114. Write a program to sort the elements in odd positions in descending order and
elements in ascending order
Eg 1: Input: 13,2 4,15,12,10,5
Output: 13,2,12,10,5,15,4
Eg 2: Input: 1,2,3,4,5,6,7,8,9
Output: 9,2,7,4,5,6,3,8,1
 */