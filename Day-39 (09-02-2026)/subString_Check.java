public class subString_Check {

    static int solve(String s1, String s2) {

        if(s2.length()==0) return -1;

        for (int i = 0; i < s1.length() - s2.length() + 1; i++) {

            if (s1.charAt(i) == s2.charAt(0)) {
                boolean result = true;
                for (int j = i; j < i + s2.length(); j++) {
                    if (s1.charAt(j) != s2.charAt(j-i)) {
                        result = false;
                    }
                }
                if (result)
                    return i;
            }

        }
        return -1;

    }

    public static void main(String[] args) {

        String[][] testCases = {

                // ---------- Given examples ----------
                { "test123string", "123" },
                { "testing12", "1234" },

                // ---------- Basic ----------
                { "hello", "he" },
                { "hello", "lo" },
                { "hello", "ll" },
                { "hello", "world" },

                // ---------- Whole string ----------
                { "java", "java" },

                // ---------- Single character ----------
                { "abcdef", "a" },
                { "abcdef", "f" },
                { "abcdef", "z" },

                // ---------- Repeated characters ----------
                { "aaaaaa", "aaa" },
                { "aaaaaa", "aaaa" },
                { "aaaaaa", "b" },

                // ---------- Multiple matches (first index expected) ----------
                { "abcabcabc", "abc" },
                { "ababab", "aba" },
                { "mississippi", "issi" },

                // ---------- Pattern at edges ----------
                { "startmiddleend", "start" },
                { "startmiddleend", "end" },

                // ---------- Numbers ----------
                { "123456789", "456" },
                { "111222333", "222" },
                { "111222333", "444" },

                // ---------- Case sensitivity ----------
                { "HelloWorld", "world" },
                { "HelloWorld", "World" },

                // ---------- Spaces ----------
                { "hello world", "world" },
                { "hello world", "o w" },
                { "hello world", "  " },

                // ---------- Special characters ----------
                { "abc@123#xyz", "@123" },
                { "abc@123#xyz", "#x" },
                { "abc@123#xyz", "$" },

                // ---------- Edge cases ----------
                { "", "" },
                { "", "a" },
                { "a", "" },
                { "short", "longerstring" },

                // ---------- Large pattern ----------
                { "aaaaaaaaaaaaaaaaaaab", "aaab" },
                { "zzzzzzzzzzzzzz", "zzz" },

                // ---------- Random ----------
                { "zohointerview", "view" },
                { "programming", "gram" },
                { "datastructures", "struct" },
                { "datastructures", "algo" }
        };

        for (int i = 0; i < testCases.length; i++) {

            String s1 = testCases[i][0];
            String s2 = testCases[i][1];

            System.out.println("Test Case " + (i + 1));
            System.out.println("String1 : \"" + s1 + "\"");
            System.out.println("String2 : \"" + s2 + "\"");

            // 👉 CALL YOUR METHOD HERE
            int index = solve(s1, s2);
            System.out.println("Output  : " + index);

            System.out.println("----------------------------");
        }
    }
}

/* 
112. Find if a String2 is substring of String1. If it is, return the index of the first occurrence. else return -1. Eg 1:Input: String 1: test123string String 2: 123 Output: 4 Eg 2: Input: String 1: testing12 String 2: 1234 Output: -1 */