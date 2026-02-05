import java.util.*;

public class sort_elements_by_frequency {

    static int[] solve(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<int[]> que = new PriorityQueue<>((a, b) -> {
            if (b[1] != a[1])
                return b[1] - a[1]; // freq desc
            return a[0] - b[0]; // value asc
        });

        for (int key : map.keySet()) {
            int[] n = new int[2];

            n[0] = key;
            n[1] = map.get(key);
            que.add(n);
        }

        int ind = 0;

        while (!que.isEmpty()) {
            int k = que.peek()[0];
            int o = que.peek()[1];

            for (int i = 0; i < o; i++) {
                nums[ind] = k;
                ind++;
            }

            que.remove();
        }

        return nums;
    }

    public static void main(String[] args) {

        int[][] testCases = {

                // 1. Given example
                { 2, 2, 3, 4, 5, 12, 2, 3, 3, 3, 12 },

                // 2. Given example 2
                { 0, -1, 2, 1, 0 },

                // -------------------------
                // BASIC
                // -------------------------

                // 3. single element
                { 5 },

                // 4. two same
                { 7, 7 },

                // 5. two different
                { 7, 3 },

                // -------------------------
                // ALL UNIQUE
                // -------------------------

                // 6. all unique
                { 1, 2, 3, 4, 5 },

                // 7. negatives unique
                { -5, -4, -3, -2, -1 },

                // -------------------------
                // ALL SAME
                // -------------------------

                // 8. all same
                { 9, 9, 9, 9, 9 },

                // -------------------------
                // DUPLICATES MIX
                // -------------------------

                // 9. simple mix
                { 1, 1, 2, 2, 2, 3 },

                // 10. multiple ties
                { 4, 4, 5, 5, 6, 6 },

                // 11. heavy one number
                { 10, 10, 10, 10, 2, 3, 4 },

                // 12. alternating duplicates
                { 1, 2, 1, 2, 1, 2 },

                // -------------------------
                // NEGATIVES
                // -------------------------

                // 13. negatives repeated
                { -1, -1, -2, -2, -2, -3 },

                // 14. mixed positive negative
                { -2, 3, -2, 4, 3, 3, 4 },

                // -------------------------
                // ZERO CASES
                // -------------------------

                // 15. many zeros
                { 0, 0, 0, 1, 2, 3 },

                // 16. zeros and negatives
                { 0, -1, 0, -1, -1, 2 },

                // -------------------------
                // RANDOM
                // -------------------------

                // 17. random large
                { 5, 3, 9, 5, 3, 5, 1, 9, 9, 9, 2, 2 },

                // 18. random uneven
                { 8, 6, 7, 6, 8, 6, 5, 5, 5, 5, 1 },

                // -------------------------
                // ORDER TRAPS
                // -------------------------

                // 19. already sorted ascending
                { 1, 1, 2, 2, 2, 3, 3, 3, 3 },

                // 20. descending input
                { 9, 8, 8, 7, 7, 7, 6, 6, 6, 6 },

                // -------------------------
                // EDGE
                // -------------------------

                // 21. empty
                {},

                // 22. large values
                { 100000, 100000, 5, 5, 5, 10, 10 },

                // 23. single repeated at ends
                { 4, 1, 2, 3, 4, 4 },

                // 24. many duplicates scattered
                { 2, 5, 2, 3, 5, 2, 4, 3, 5, 3, 5 },

                // 25. stress test small
                { 1, 1, 1, 2, 2, 3, 3, 3, 3, 4, 4, 5 }
        };

        for (int i = 0; i < testCases.length; i++) {
            int[] input = Arrays.copyOf(testCases[i], testCases[i].length);

            System.out.println("Test Case " + (i + 1));
            System.out.println("Input  : " + Arrays.toString(input));
            System.out.println("Output : " + Arrays.toString(solve(input)));
            System.out.println("----------------------");
        }

    }

}

/* 
35. Sort the array elements in descending order according to their frequency of occurrence
Input : [ 2 2 3 4 5 12 2 3 3 3 12 ]
Output : 3 3 3 3 2 2 2 12 12 4 5

Explanation : 3 occurred 4 times, 2 occurred 3 times, 12 occurred 2 times, 4 occurred 1
time, 5 occurred 1 time
Input : [ 0 -1 2 1 0 ]
Output : 0 0 -1 1 2

sort single occurrence elements in ascending order */