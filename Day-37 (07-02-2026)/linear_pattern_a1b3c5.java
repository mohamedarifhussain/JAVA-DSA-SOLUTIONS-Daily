
public class linear_pattern_a1b3c5 {

    // 🔴 Put YOUR solution here

    static boolean isAlpha(char s) {
        return ('A' <= s && s <= 'Z') || ('a' <= s && s <= 'z');
    }

    static int stringToNumber(String num) {

        int n = 0;
        for (char ch : num.toCharArray()) {
            n = n * 10 + (ch - '0');
        }
        return n;
    }

    static String solve(String s) {
        if (s.equals(""))
            return s;

        String result = "";

        int i = 0;

        while (i < s.length()) {
            // String add = "";
            String alpha = "";
            String num = "";

            while (i < s.length() && isAlpha(s.charAt(i))) {
                alpha = alpha + s.charAt(i);
                i++;
            }

            while (i < s.length() && '0' <= s.charAt(i) && s.charAt(i) <= '9') {
                num = num + s.charAt(i);
                i++;
            }

            if (!alpha.equals("")) {
                for (int j = 0; j < stringToNumber(num); j++) {
                    result = result + alpha;
                }
            }

        }

        return result;

    }

    public static void main(String[] args) {

        String[] inputs = {

                "a1b10",
                "b3c6d15",
                "a5",
                "z1",
                "x99",
                "a2b3c4",
                "a2b12c3",
                "m10n20",
                "p1q2r3s4",
                "k50",
                "a1b1c1d1e1f1",
                "A3B2",
                "y25",
                "a2a3a4",
                "t11u2v9",
                "",
                "10",
                "a9b8c7d6e5f4g3h2i1",
                "z99y99",
                "a10b1c20d2"
        };

        for (int i = 0; i < inputs.length; i++) {

            System.out.println("Test Case " + (i + 1));
            System.out.println("Input  : \"" + inputs[i] + "\"");

            String output = solve(inputs[i]);

            System.out.println("Output : \"" + output + "\"");
            System.out.println("----------------------------------");
        }
    }
}

/*
 * 115. Write a program to give the following output for the given input Eg 1:
 * Input: a1b10 Output: abbbbbbbbbb Eg: 2: Input: b3c6d15 Output:
 * bbbccccccddddddddddddddd The number varies from 1 to 99.
 */