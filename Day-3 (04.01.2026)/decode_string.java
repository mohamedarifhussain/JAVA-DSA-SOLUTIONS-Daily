public class decode_string {

    static int i;

    static String decode(String s) {

        String str = "";
        String num = "";

        while (i < s.length()) {

            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                num = num + ch;
            } else if (ch == '[') {
                i++;
                String res = decode(s);

                for (int j = 0; j < Integer.parseInt(num); j++) {
                    str = str + res;
                }
                num = "";
            } else if (ch == ']') {
                return str;
            } else {
                str = str + ch;
            }
            i++;
        }

        return str;

    }

    public static void main(String[] args) {
        i = 0;
        String q = "3[b2[ca]]";

        String res = decode(q);

        System.out.println("Input: " + q);
        System.out.println("Output: " + res);
    }
}

/*
 * Decode the string
 * Difficulty: MediumAccuracy: 44.28%Submissions: 69K+Points: 4Average Time: 10m
 * Given an encoded string s, decode it by expanding the pattern k[substring],
 * where the substring inside brackets is written k times. k is guaranteed to be
 * a positive integer, and encodedString contains only lowercase english
 * alphabets. Return the final decoded string.
 * 
 * Note: The test cases are generated so that the length of the output string
 * will never exceed 105 .
 * 
 * Examples:
 * 
 * Input: s = "3[b2[ca]]"
 * Output: "bcacabcacabcaca"
 * Explanation:
 * Inner substring “2[ca]” breakdown into “caca”.
 * Now, new string becomes “3[bcaca]”
 * Similarly “3[bcaca]” becomes “bcacabcacabcaca” which is final result.
 * Input: s = "3[ab]"
 * Output: "ababab"
 * Explanation: The substring "ab" is repeated 3 times giving "ababab".
 * Constraints:
 * 1 ≤ |s| ≤ 105
 * 1 ≤ k ≤ 100
 */