public class MaxOfThreeTestCases {

    public static int solve(int a, int b, int c) {

        int ans = a;

        if (a > b && a > c) {
            ans = a;
        } else if (b > c) {
            ans = b;
        } else {
            ans = c;
        }
        return ans;

    }

    public static void main(String[] args) {

        int[][] testCases = {

                // ---------- Basic ----------
                { 5, 3, 2 },
                { 3, 5, 2 },
                { 3, 2, 5 },

                // ---------- All equal ----------
                { 5, 5, 5 },
                { 0, 0, 0 },
                { -3, -3, -3 },

                // ---------- Two equal (max duplicates) ----------
                { 5, 5, 3 },
                { 5, 3, 5 },
                { 3, 5, 5 },

                // ---------- Two equal (not max) ----------
                { 2, 2, 5 },
                { 5, 2, 2 },
                { 2, 5, 2 },

                // ---------- Negative numbers ----------
                { -1, -2, -3 },
                { -3, -1, -2 },
                { -10, -5, -7 },

                // ---------- Mixed positive & negative ----------
                { -5, 10, 3 },
                { 7, -2, 4 },
                { -8, -2, 0 },

                // ---------- Zeros ----------
                { 0, 5, 3 },
                { 5, 0, 3 },
                { 3, 5, 0 },
                { 0, 0, 7 },

                // ---------- Large numbers ----------
                { 1000000, 999999, 888888 },
                { Integer.MAX_VALUE, 0, -1 },
                { Integer.MIN_VALUE, -1, 0 },

                // ---------- Random order ----------
                { 9, 4, 7 },
                { 15, 30, 20 },
                { 99, 100, 98 },

                // ---------- Edge stress ----------
                { 1, -1000, 500 },
                { 100, 100, 99 },
                { 99, 100, 100 }
        };

        for (int i = 0; i < testCases.length; i++) {
            int a = testCases[i][0];
            int b = testCases[i][1];
            int c = testCases[i][2];

            System.out.println("Test Case " + (i + 1));
            System.out.println("Input : " + a + ", " + b + ", " + c);

            // 👉 call YOUR solution here
            // example:
            // solve(a, b, c);

            int max = solve(a, b, c);
            System.out.println("Max of Numbers: " + max);

            System.out.println("----------------------");
        }
    }
}

/* 52. Find the maximum of three numbers? */