public class minimum_window_substring{


    public static String minWindow(String s, String t) {

        int minlen = Integer.MAX_VALUE;
        int[] map = new int[256];

        int count = 0;
        int start = -1, end = -1;

        for (int i = 0; i < t.length(); i++)
            map[t.charAt(i)]++;

        int left = 0, right = 0;

        while (right < s.length()) {

            map[s.charAt(right)]--;

            if (map[s.charAt(right)] >= 0) {
                count++;
            }

            while (count == t.length()) {
                map[s.charAt(left)]++;
                if (map[s.charAt(left)] > 0)
                    count--;

                if (minlen > right - left + 1) {
                    minlen = right - left + 1;
                    start = left;
                }
        
                left++;
            }
            right++;

        }

        return (minlen == Integer.MAX_VALUE) ? "" : s.substring(start, start + minlen);

    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";

        String output = minWindow(s, t);

        System.out.println("Input: s="+s+", t="+t);
        System.out.println("Output: "+output);
    }
}
/* 
76. Minimum Window Substring
Solved
Hard
Topics
premium lock icon
Companies
Hint
Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

 

Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.
Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.
 

Constraints:

m == s.length
n == t.length
1 <= m, n <= 105
s and t consist of uppercase and lowercase English letters.
 

Follow up: Could you find an algorithm that runs in O(m + n) time? */