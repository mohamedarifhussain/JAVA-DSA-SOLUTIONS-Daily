public class longest_distance_between_same_character {

    public static int max_distance_between_same_character(String s) {

        int[] alpha = new int[26];

        char[] arr = s.toCharArray();

        for (int i = 0; i < 26; i++)
            alpha[i] = -1;

        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            if (alpha[arr[i] - 97] == -1) {
                alpha[arr[i] - 97] = i;
            }
        }

        for (int i = s.length() - 1; i >= 0; i--) {

            int len = (i - alpha[arr[i] - 97] - 1);
            if (max < len)
                max = len;

        }

        return max;
    }

    public static void main(String[] args) {

        String s = "abcccccbba";

        int len = max_distance_between_same_character(s);

        System.out.println("Input String : " + s);
        System.out.println("Output : " + len);

    }

}

/*
 * 20. Print longest sequence between same character (zoho no.20)
 * Ex I/p abcccccbba
 * O/p 8 (from a to a)
 * I/p aaaaaaaa
 * O/p 6
 */