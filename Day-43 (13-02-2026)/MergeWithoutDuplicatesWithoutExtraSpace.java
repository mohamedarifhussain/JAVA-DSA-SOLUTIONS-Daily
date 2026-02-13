import java.util.Arrays;

public class MergeWithoutDuplicatesWithoutExtraSpace {

    public static void solve(int[] n1, int[] n2) {

        int prev = Integer.MIN_VALUE;

        int l1 = 0;
        int l2 = 0;

        while (l1 < n1.length && l2 < n2.length) {

            if (n1[l1] <= n2[l2]) {
                if (prev != n1[l1]) {
                    System.out.print(n1[l1] + " ");
                    prev = n1[l1];
                }
                l1++;
            } else {
                if (prev != n2[l2]) {
                    System.out.print(n2[l2] + " ");
                    prev = n2[l2];
                }
                l2++;
            }
        }

        while (l1 < n1.length) {

            if (prev != n1[l1]) {
                System.out.print(n1[l1] + " ");
                prev = n1[l1];
            }
            l1++;

        }

        while (l2 < n2.length) {

            if (prev != n2[l2]) {
                System.out.print(n2[l2] + " ");
                prev = n2[l2];
            }
            l2++;
        }

    }

    public static void main(String[] args) {
        int[][][] testCasesA = {

                // Test Case 1
                { { 2, 4, 5, 6, 7, 9, 10, 13 }, { 2, 3, 4, 5, 6, 7, 8, 9, 11, 15 } },

                // Test Case 2 - No overlap
                { { 1, 3, 5 }, { 2, 4, 6 } },

                // Test Case 3 - One array empty
                { {}, { 1, 2, 3 } },

                // Test Case 4 - Other array empty
                { { 1, 2, 3 }, {} },

                // Test Case 5 - Both empty
                { {}, {} },

                // Test Case 6 - All elements same
                { { 1, 1, 1 }, { 1, 1 } },

                // Test Case 7 - Single elements
                { { 5 }, { 5 } },

                // Test Case 8 - Single different elements
                { { 5 }, { 10 } },

                // Test Case 9 - Negative numbers
                { { -10, -5, -3, -1 }, { -6, -5, -2, 0 } },

                // Test Case 10 - One array subset of another
                { { 1, 2, 3, 4, 5 }, { 2, 3 } },

                // Test Case 11 - Duplicates inside arrays
                { { 1, 1, 2, 2, 3 }, { 2, 2, 3, 4 } },

                // Test Case 12 - Large numbers
                { { 100000, 200000, 300000 }, { 150000, 200000, 350000 } },

                // Test Case 13 - Alternate overlap
                { { 1, 3, 5, 7, 9 }, { 2, 3, 6, 7, 10 } },

                // Test Case 14 - Completely identical arrays
                { { 1, 2, 3 }, { 1, 2, 3 } },

                // Test Case 15 - One element repeated across arrays
                { { 1, 2, 3, 4 }, { 4, 4, 4, 5, 6 } },

                // Test Case 16 - Mixed negatives and positives
                { { -5, -3, 0, 1, 2 }, { -3, 0, 3, 4 } },

                // Test Case 17 - Large size difference
                { { 1 }, { 1, 2, 3, 4, 5, 6, 7, 8 } },

                // Test Case 18 - Zero values
                { { 0, 0, 1 }, { 0, 2, 3 } },

                // Test Case 19 - Only negatives
                { { -9, -7, -5 }, { -8, -6, -4 } },

                // Test Case 20 - Max int values
                { { Integer.MAX_VALUE - 1, Integer.MAX_VALUE }, { Integer.MAX_VALUE } }
        };

        int n = 0;

        for (int[][] t : testCasesA) {

            int[] n1 = t[0];
            int[] n2 = t[1];

            System.out.println("Test Case: " + ++n);
            System.out.println("Array 1: " + Arrays.toString(n1));
            System.out.println("Array 2: " + Arrays.toString(n2));
            System.out.print("Output ");
            solve(n1, n2);
            System.out.println();
            System.out.println();

        }
    }
}

/*
 * 111. Given two sorted arrays, merge them such that the elements are not
 * repeated
 * Eg 1: Input:
 * Array 1: 2,4,5,6,7,9,10,13
 * Array 2: 2,3,4,5,6,7,8,9,11,15
 * Output:
 * Merged array: 2,3,4,5,6,7,8,9,10,11,13,15
 */