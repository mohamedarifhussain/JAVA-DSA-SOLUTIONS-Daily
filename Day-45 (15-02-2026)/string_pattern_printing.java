public class string_pattern_printing {

    public static void solve(String input) {

        int len = input.length();

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                System.out.print("  ");
            }

            for (int j = len / 2; j < ((len / 2) + i + 1); j++) {
                System.out.print(input.charAt(j % len));
            }
            System.out.println();

        }

    }

    public static void main(String[] args) {

        String[] testInputs = {

                // -------- Basic ----------
                "PROGRAM",
                "ABCDE",
                "HELLO",
                "MADAM",
                "ROTATOR",
                "LEVEL",
                "CODING",
                "ZOHOZ",

                // -------- Palindrome ----------
                "RACECAR",
                "ABCDEDCBA",

                // -------- Single character ----------
                "X",

                // -------- Repeated characters ----------
                "AAAAA",

                // -------- Mixed ----------
                "DATASCI",
                "12321",
                "ABCDEGFED",

                // -------- Longer strings ----------
                "INTERVIEW",
                "ALGORITHMS",
                "DEVELOPMENT",
                "PROGRAMMING",

                // -------- Edge but valid ----------
                "A",
                "BBB",
                "CCCCC",

                // -------- Zoho tricky ----------
                "KNOWLEDGE",
                "ENGINEERING",
                "COMPUTERS",
                "TECHNOLOGY"
        };

        int tc = 1;
        for (String input : testInputs) {
            System.out.println("Test Case " + tc++);
            System.out.println("Input  : " + input);
            solve(input);
            System.out.println("---------------------------");
            System.out.println();
        }
    }
}



/* 78. Given an odd length word which should be printed from the middle of the word.
The output should be in the following pattern.
Example:
Input: PROGRAM
Output:
 G
 GR
 GRA
 GRAM
 GRAMP
 GRAMPR
GRAMPRO */
