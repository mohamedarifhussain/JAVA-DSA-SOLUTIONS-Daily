import java.util.ArrayList;
import java.util.Arrays;

public class combinationSum {

    static void solve(int[] nums, int ind, int target, ArrayList<Integer> result) {

        if (target == 0) {
            System.out.println(result);
            return;
        }

        if (target < 0)
            return;

        for (int i = ind; i < nums.length; i++) {
            result.add(nums[i]);
            solve(nums, i + 1, target - nums[i], result);
            result.remove(result.size() - 1);
        }

    }

    public static void main(String[] args) {

        int[][] arrays = {
                { 8, 3, 4, 7, 9 },
                { 5, 2, 6 },
                { 1, 2, 3, 4, 5 },
                { 2, 4, 6 },
                { 1, 2, 3 },
                {},
                { 2, 2, 3 },
                { 1, 1, 1, 1 },
                { 0, 0, 7 },
                { -1, 2, 3, 4 },
                { 10, 20, 30, 40 },
                { 4, 1, 3, 2 },
                { 9, 8, 7 },
                { 1, 2, 3, 4, 5, 6 },
                { 5, 5, 5, 5 },
                { 3, 8, 4, 2, 6 },
                { 100, 200, 300 },
                { 7, 1, 5, 3 },
                { 1, 2, 2, 3 },
                { 1, 1, 2, 2, 3, 3 }
        };

        int[] targets = {
                7, 5, 5, 5, 6, 5, 4, 2, 7, 3, 50, 5, 9, 7, 10, 10, 600, 8, 4, 4
        };

        for (int i = 0; i < arrays.length; i++) {

            int[] input = Arrays.copyOf(arrays[i], arrays[i].length);
            int target = targets[i];

            System.out.println("Test Case " + (i + 1));
            System.out.println("Input  : " + Arrays.toString(input));
            System.out.println("Target : " + target);
            System.out.print("Output : ");
            solve(input, 0, target, new ArrayList<>());

            System.out.println("----------------------------------");
        }

    }
}

/*
 * 77. Given unsorted array find all solve of the element
 * for a given sum. Order should be maintained.
 * Input :
 * 8 3 4 7 9
 * N=7
 * Output
 * {3 4 } {7}
 */