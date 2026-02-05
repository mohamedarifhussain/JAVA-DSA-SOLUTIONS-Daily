import java.util.Arrays;
import java.util.*;

public class merge_two_sorted_array_without_dupllicate {

    static ArrayList<Integer> solve(int[] arr1, int[] arr2) {

        int left = 0, right = 0;

        ArrayList<Integer> result = new ArrayList<>();

        while (left < arr1.length && right < arr2.length) {
            int num;
            if (arr1[left] < arr2[right]) {
                num = arr1[left];
                left++;
            } else {
                num = arr2[right];
                right++;
            }

            if (result.size() != 0) {
                if (result.get(result.size() - 1) != num)
                    result.add(num);
            } else {
                result.add(num);
            }

        }

        while (left < arr1.length) {
            int num = arr1[left];
            if (result.size() != 0) {
                if (result.get(result.size() - 1) != num)
                    result.add(num);
            } else {
                result.add(num);
            }
            left++;
        }

        while (right < arr2.length) {
            int num = arr2[right];
            if (result.size() != 0) {
                if (result.get(result.size() - 1) != num)
                    result.add(num);
            } else {
                result.add(num);
            }
            right++;
        }

        return result;
    }

    public static void main(String[] args) {

        int[][] arr1Cases = {

                // 1. Basic example
                { 1, 3, 5, 7 },

                // 2. Empty first
                {},

                // 3. Single element
                { 5 },

                // 4. All duplicates across arrays
                { 1, 2, 3 },

                // 5. No overlap
                { 1, 2, 3 },

                // 6. All same values
                { 4, 4, 4, 4 },

                // 7. Negative numbers
                { -5, -3, -1 },

                // 8. Large numbers
                { 100, 200, 300 },

                // 9. Alternating overlap
                { 1, 4, 7, 10 },

                // 10. Many duplicates inside itself
                { 1, 1, 2, 2, 3, 3 },

                // 11. Only one element repeated
                { 9, 9, 9 },

                // 12. Already continuous range
                { 1, 2, 3, 4, 5 },

                // 13. Reverse size difference
                { 1 },

                // 14. Mixed negative & positive
                { -10, -5, 0, 5 },

                // 15. Stress small
                { 2, 6, 8 }
        };

        int[][] arr2Cases = {

                { 2, 4, 6, 8 },
                { 1, 2, 3 },
                {},
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 4, 4, 4 },
                { -4, -2, 0 },
                { 150, 250, 350 },
                { 2, 3, 8, 11 },
                { 2, 2, 3, 3, 4, 4 },
                { 9, 9 },
                { 6, 7, 8 },
                { 2, 3, 4, 5, 6 },
                { -3, 1, 10 },
                { 1, 3, 5 }
        };

        for (int i = 0; i < arr1Cases.length; i++) {
            System.out.println("Test Case " + (i + 1));
            System.out.println("Arr1 : " + Arrays.toString(arr1Cases[i]));
            System.out.println("Arr2 : " + Arrays.toString(arr2Cases[i]));
            System.out.println("Output: " + solve(arr1Cases[i], arr2Cases[i]));
            System.out.println("-----------------------");
        }

    }
}


/* 6.Two sorted arrays will be given. Create an array consisting of the elements of two arrays
with duplicate elements removed in sorted order.
Note: Use only one loop. No sorting. */