import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class group_anagram {

    public static String freqFunction(String s1) {

        String output = "";

        int[] freq = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            freq[s1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            output += (Integer.toString(freq[i]) + "#");
        }

        return output;
    }

    public static List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> result = new ArrayList<>();

        HashMap<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {

            String f = freqFunction(strs[i]);

            if (map.get(f) == null) {
                map.put(f, new ArrayList<>(Arrays.asList(strs[i])));
            } else {
                map.get(f).add(strs[i]);
            }
        }

        for (String k : map.keySet()) {
            List<String> ans = new ArrayList<>();
            for (String s : map.get(k))
                ans.add(s);

            result.add(ans);
        }

        return result;
    }

    public static void main(String[] args) {

        String[][] testCases = {

                // Test 1
                { "eat", "tea", "tan", "ate", "nat", "bat" },

                // Test 2
                { "abc", "bca", "cab", "xyz", "zyx", "foo" },

                // Test 3
                { "a" },

                // Test 4
                { "aa", "bb", "ab", "ba" },

                // Test 5
                { "listen", "silent", "enlist", "google", "gogole" },

                // Test 6
                { "rat", "tar", "art", "star", "tars", "cheese" },

                // Test 7
                {},

                // Test 8
                { "zzz", "zzz", "zzz" },

                // Test 9
                { "abcd", "dcba", "bcad", "dacb", "xy", "yx" },

                // Test 10
                { "hello", "world" }
        };

        int t = 1;

        for (String[] input : testCases) {

            System.out.println("Test Case " + t++);

            System.out.println("Input  : " + Arrays.toString(input));

            List<List<String>> output = groupAnagrams(input);

            System.out.println("Output : " + output);

            System.out.println("----------------------------------");
        }
    }
}

/*
 * 49. Group Anagrams
 * Solved
 * Medium
 * Topics
 * premium lock icon
 * Companies
 * Given an array of strings strs, group the anagrams together. You can return
 * the answer in any order.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * 
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 
 * Explanation:
 * 
 * There is no string in strs that can be rearranged to form "bat".
 * The strings "nat" and "tan" are anagrams as they can be rearranged to form
 * each other.
 * The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to
 * form each other.
 * Example 2:
 * 
 * Input: strs = [""]
 * 
 * Output: [[""]]
 * 
 * Example 3:
 * 
 * Input: strs = ["a"]
 * 
 * Output: [["a"]]
 * 
 * 
 * 
 * Constraints:
 * 
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] consists of lowercase English letters.
 */