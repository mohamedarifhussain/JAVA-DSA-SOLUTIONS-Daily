public class reverse_string_only_aphaDigits {

    static boolean isAlpha(char ch) {

        return ( ('a'<= ch && ch<='z') || ('A'<= ch && ch<='Z') || ('0'<= ch && ch<='9') );

    }

    static void swap(char[] ch, int i, int j) {
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }

    static String solve(String s) {

        if (s.length() <= 1)
            return s;

        char[] ch = s.toCharArray();

        int left = 0, right = ch.length - 1;

        while (left < right) {

            boolean l = isAlpha(ch[left]);
            boolean r = isAlpha(ch[right]);

            if (l && r) {
                swap(ch, left, right);
                left++;
                right--;
            } else if ( !l && !r ) {
                left++;
                right--;
            } else {
                if ( l )
                    left++;
                if ( r )
                    right--;
            }

        }

        return new String(ch);

    }

    public static void main(String[] args) {

        String[] testCases = {
                "house no : 123@ cbe",
                "abc!de",
                "a,b$c",
                "hello world",
                "123@456",
                "@@@###",
                "a",
                "",
                "   ",
                "ab cd ef",
                "A!B@C#D$",
                "12 34 56",
                "z@o#h$o",
                "Madam, I'm Adam!",
                "Java@2025",
                "No punctuation",
                "!!!abc!!!",
                "1a2b3c4d",
                "   a b c   ",
                "X",
                "x@y",
                "a:b:c:d",
                "Room #42!",
                "Zoho-Interview_2025",
                "((abc))"
        };

        for (int i = 0; i < testCases.length; i++) {
            System.out.println("Test Case " + (i + 1));
            System.out.println("Input  : " + testCases[i]);
            System.out.println("Output : " + solve(testCases[i]));
            System.out.println("----------------------");
        }

    }

}
/* 
85. Given a string, we have to reverse the string without changing the position of
punctuations and spaces.
Sample: house no : 123@ cbe
Output: ebc32 1o : nes@ uoh 
 */