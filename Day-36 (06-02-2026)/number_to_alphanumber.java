public class number_to_alphanumber {

    static String solve(int n) {

        String s = "";

        while (n > 0) {

            int i = (n % 26) - 1;

            if (i == -1) {
                s = 'Z' + s;
                n--;
            } else
                s = ((char) ('A' + i)) + s;

            n /= 26;

        }

        return s;
    }

    public static void main(String[] args) {

        int[] testCases = {
                1,
                2,
                25,
                26,
                27,
                28,
                52,
                53,
                54,
                701,
                702,
                703,
                704,
                675,
                676,
                677,
                1000,
                18278,
                18279,
                17576,
                17577,
                456976,
                0,
                -5,
                1000000
        };

        for (int i=0;i<testCases.length;i++) {
            int n = testCases[i];
            System.out.println("Test Case: "+(i+1));
            System.out.println("Input  : " + n);
            System.out.println("Output : " + solve(n));
            System.out.println("-------------------");
        }

    }

}

/*
 * 88. Given a number, convert it into corresponding alphabet.
 * Input Output
 * 1 A
 * 26 Z
 * 27 AA
 * 676 ZZZ
 */