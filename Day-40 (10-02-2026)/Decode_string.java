import java.util.*;

public class Decode_string {

    public static char alpha(String str) {
        if (str.charAt(0) == '0')
            return '*';
        if (str.length() == 1) {
            int n = Integer.parseInt(str);
            return (char) (n + 64);
        } else {
            int n = Integer.parseInt(str);
            if (n > 26)
                return '*';
            return (char) (n + 64);
        }
    }

    public static void solve(String s, int i, String ans, ArrayList<String> result) {

        if (i == s.length()) {
            if (i != 0)
                result.add(ans);
            return;
        }

        char ch = alpha("" + s.charAt(i));
        if (ch != '*')
            solve(s, i + 1, ans + ch, result);

        if (i + 1 < s.length()) {
            ch = alpha("" + s.charAt(i) + s.charAt(i + 1));
            if (ch != '*') {
                solve(s, i + 2, ans + ch, result);
            }

        }

    }

    public static void main(String[] args) {

        String[] inputs = {

                // ---- Given examples ----
                "121",
                "1234",

                // ---- Basic ----
                "1",
                "2",
                "9",

                // ---- Zero handling ----
                "0",
                "10",
                "20",
                "30",
                "101",
                "100",

                // ---- Two digits ----
                "11",
                "12",
                "26",
                "27",

                // ---- Multiple combos ----
                "111",
                "1111",
                "2222",

                // ---- Mixed ----
                "226",
                "2125",
                "2612",

                // ---- tricky zeros ----
                "1010",
                "110",
                "2101",
                "1001",

                // ---- larger ----
                "123123",
                "111111",

                // ---- invalids ----
                "",
                "00",
                "301",
                "012",

                // ---- edge Zoho style ----
                "9999",
                "2626",
                "121212",
                "11106",
                "2611055971756562"
        };

        int[] expected = {

                // given
                3,
                3,

                // basic
                1,
                1,
                1,

                // zero
                0,
                1,
                1,
                0,
                1,
                0,

                // two digits
                2,
                2,
                2,
                1,

                // combos
                3,
                5,
                5,

                // mixed
                3,
                5,
                4,

                // tricky zero
                1,
                1,
                1,
                0,

                // larger
                9,
                13,

                // invalid
                0,
                0,
                0,
                0,

                // edge
                1,
                4,
                13,
                2,
                4
        };

        for (int i = 0; i < inputs.length; i++) {

            ArrayList<String> r = new ArrayList<>();

            System.out.println("Test Case " + (i + 1));
            System.out.println("Input  : \"" + inputs[i] + "\"");
            System.out.println("Output : " + expected[i]);
            solve(inputs[i], 0, "", r);
            System.out.println("Decoded String: " + r + ", Count: " + r.size());
            System.out.println("---------------------------");
        }
    }
}

/*
 * 19. Let 1 represent ‘A’, 2 represents ‘B’, etc. Given a digit sequence, count
 * the number of
 * possible decodings of the given digit sequence.
 * Examples:
 * Input: digits[] = “121”
 * Output: 3 // The possible decodings are “ABA”, “AU”, “LA”
 * Input: digits[] = “1234” Output: 3
 * // The possible decodings are “ABCD”, “LCD”, “AWD”
 */