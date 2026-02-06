import java.util.*;

public class print_fibo_num_in_an_array {

    static ArrayList<Integer> solve(int[] nums) {

        ArrayList<Integer> result = new ArrayList<>();

        HashMap<Integer, Boolean> map = new HashMap<>();

        int len = nums.length;

        int mx = Integer.MIN_VALUE;

        for (int i = 0; i < len; i++) {

            map.put(nums[i], false);

            mx = Math.max(mx, nums[i]);

        }

        int f1 = 0, f2 = 1, last = f1;

        if (!(map.get(f1) == null)) {
            map.put(f1, true);
            result.add(f1);

        }

        int f3 = f2 + f1;

        while (f3 < mx) {
            f3 = f2 + f1;
            last = f3;
            if (!(map.get(f3) == null)) {
                if (map.get(f3) == false) {
                    result.add(f3);
                    map.put(f3, true);
                }
            }

            f1 = f2;
            f2 = f3;

        }

        if (f3 != last && f3 == mx) {
            map.put(f3, true);
            result.add(f3);
        }

        return result;

    }

    public static void main(String[] args) {

        int[][] testCases = {

                // 1. Given example
                { 2, 10, 4, 8 },

                // 2. Given example
                { 1, 10, 6, 8, 13, 21 },

                // -----------------------
                // BASIC
                // -----------------------

                // 3. single fib
                { 5 },

                // 4. single non-fib
                { 7 },

                // 5. two numbers both fib
                { 1, 2 },

                // 6. two numbers none fib
                { 4, 6 },

                // -----------------------
                // MIXED SMALL
                // -----------------------

                // 7
                { 0, 1, 2, 3, 4, 5, 6 },

                // 8
                { 7, 8, 9, 10, 11, 12, 13 },

                // 9
                { 14, 15, 16, 17, 18, 19, 20 },

                // -----------------------
                // DUPLICATES
                // -----------------------

                // 10
                { 1, 1, 1, 2, 2, 3, 4, 5 },

                // 11
                { 8, 8, 8, 9, 9 },

                // -----------------------
                // ZERO CASES
                // -----------------------

                // 12
                { 0, 0, 0, 1, 1 },

                // -----------------------
                // NEGATIVES
                // -----------------------

                // 13
                { -1, -2, -3, 1, 2, 3, 5 },

                // -----------------------
                // RANDOM
                // -----------------------

                // 14
                { 34, 21, 22, 35, 55, 89, 90 },

                // 15
                { 100, 144, 145, 233, 377 },

                // 16
                { 50, 60, 70, 80 },

                // -----------------------
                // LARGE VALUES
                // -----------------------

                // 17
                { 610, 987, 1597, 2584, 5000 },

                // -----------------------
                // ALL FIB
                // -----------------------

                // 18
                { 0, 1, 1, 2, 3, 5, 8, 13, 21, 34 },

                // -----------------------
                // NONE FIB
                // -----------------------

                // 19
                { 4, 6, 7, 9, 10, 11 },

                // -----------------------
                // EDGE
                // -----------------------

                // 20 empty
                {},

                // 21 single zero
                { 0 },

                // 22 big mix
                { 3, 1000, 5, 2000, 8, 13, 999, 21 },

                // 23 descending order
                { 34, 21, 13, 8, 5, 3, 2, 1 },

                // 24 repeating mix
                { 2, 4, 2, 6, 8, 8, 10, 13 },

                // 25 stress
                { 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610 }
        };

        for (int i = 0; i < testCases.length; i++) {
            int[] input = testCases[i];

            System.out.println("Test Case " + (i + 1));
            System.out.println("Input  : " + Arrays.toString(input));
            System.out.println("Output : " + solve(input));
            System.out.println("----------------------");
        }

    }
}

/* 
38. Print only numbers which is present in Fibonacci series (0 1 1 2 3 5 8 ……..)
Example:
Input: 2 10 4 8
Output: 2 8
Input: 1 10 6 8 13 21
Output: 1 8 13 21 */