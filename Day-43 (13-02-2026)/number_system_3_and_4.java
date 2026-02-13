
public class number_system_3_and_4 {

    public static String solve(int n) {

        if (n == 0)
            return "-1";

        n = n + 1;

        String output = "";
        while (n != 0) {

            if (n % 2 == 0) {
                output = '3' + output;
            } else {
                output = '4' + output;
            }

            n = n / 2;
        }

        return output.substring(1);
    }

    public static void main(String[] args) {

        int[] testCases = {

                // -------- Basic ----------
                1,
                2,
                3,
                4,
                5,
                6,

                // -------- End of 2-digit ----------
                7,
                8,
                9,
                10,
                11,
                12,
                13,
                14,

                // -------- Start of 4-digit ----------
                15,
                16,
                17,
                18,

                // -------- Random ----------
                20,
                25,
                30,

                // -------- Boundary between lengths ----------
                14, // last 3-digit
                15, // first 4-digit
                30, // last 4-digit
                31, // first 5-digit

                // -------- Medium ----------
                50,
                63,
                64, // power boundary
                65,

                // -------- Large ----------
                100,
                127,
                128,
                129,

                // -------- Very Large (Zoho tricky) ----------
                255,
                256,
                257,

                // -------- Stress ----------
                500,
                1000
        };

        int tc = 1;
        for (int n : testCases) {
            System.out.println("Test Case " + tc++);
            System.out.println("Input  : n = " + n);

            // 👉 CALL YOUR METHOD HERE
            String output = solve(n);

            System.out.println("Output : " + output);
            System.out.println("---------------------------");
        }
    }
}

/*
 * 108.
 * 
 * Form a
 * number system
 * with only 3 and 4.
 * Find the
 * nth number
 * of the
 * number system.Eg.)
 * The numbers
 * are:3,4,33,34,43,44,333,334,343,344,433,434,443,444,3333,3334,3343,3344,3433,
 * 3434,3443,3444…
 * .
 */
