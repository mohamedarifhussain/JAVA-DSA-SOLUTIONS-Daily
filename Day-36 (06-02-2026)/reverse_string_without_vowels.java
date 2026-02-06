import java.util.HashMap;

public class reverse_string_without_vowels {

    static String solve(String s) {

        if (s.length() <= 1)
            return s;

        char[] ch = s.toCharArray();

        int left = 0, right = ch.length - 1;

        HashMap<Character, Integer> map = new HashMap<>();

        map.put('a', 1);
        map.put('e', 1);
        map.put('i', 1);
        map.put('o', 1);
        map.put('u', 1);

        map.put('A', 1);
        map.put('E', 1);
        map.put('I', 1);
        map.put('O', 1);
        map.put('U', 1);

        while (left < right) {

            int l = map.getOrDefault(ch[left], 0);
            int r = map.getOrDefault(ch[right], 0);

            if (l == 1 && r == 1) {
                swap(ch, left, right);
                left++;
                right--;
            } else if (l == 0 && r == 0) {
                left++;
                right--;
            } else {
                if (l == 0)
                    left++;
                if (r == 0)
                    right--;
            }

        }

        return new String(ch);

    }

    static void swap(char[] ch, int l, int r) {
        char temp = ch[l];
        ch[l] = ch[r];
        ch[r] = temp;
    }

    public static void main(String[] args) {

        String[] testCases = {
                "abcdef",
                "hello",
                "leetcode",
                "a",
                "b",
                "",
                "aeiou",
                "AEIOU",
                "AaEeIiOoUu",
                "xyz",
                "programming",
                "zoho",
                "JAVA",
                "Umbrella",
                "aabbccddeeff",
                "race car",
                "123aei456",
                "why",
                "Queue",
                "Beautiful",
                "rhythm",
                "Aa",
                "aeiobcdfu",
                "mississippi",
                "The Quick Brown Fox"
        };

        for (int i = 0; i < testCases.length; i++) {
            System.out.println("Test Case no: " + (i + 1));
            System.out.println("Input  : " + testCases[i]);
            System.out.println("Output : " + solve(testCases[i]));
            System.out.println("-------------------");
            System.out.println();
        }

    }
}

/*
 * 69. Given a string, reverse only vowels in it; leaving rest of the string as
 * it is.
 * Input : abcdef
 * Output : ebcdaf
 */