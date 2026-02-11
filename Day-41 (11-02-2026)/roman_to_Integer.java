import java.util.*;

public class roman_to_Integer {

    // 👉 Paste YOUR function here
    // Example signature:
    public static int romanToInt(String s) {
        
        HashMap<Character,Integer> map = new HashMap<>();

        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int count = 0;

        int len = s.length();

        for(int i=0;i<s.length();i++){

            if(i+1<len){
                char cur = s.charAt(i);
                char next = s.charAt(i+1);
                if(cur=='I' && (next=='V' || next=='X')) {
                    count += (map.get(next)-map.get(cur));
                    i++;
                }
                else if(cur=='X' && (next=='L' || next=='C')){
                    count += (map.get(next)-map.get(cur));
                    i++;
                }
                else if(cur=='C' && (next=='D' || next=='M')){
                    count += (map.get(next)-map.get(cur));
                    i++;
                }
                else{
                    count+=map.get(cur);
                }
            }
            else{
                count+=map.get(s.charAt(i));
            }

        }

        return count;

    }

    public static void main(String[] args) {

        String[] tests = {

                // ---------- BASIC ----------
                "I",
                "II",
                "III",
                "V",
                "X",

                // ---------- SIMPLE ADDITION ----------
                "VIII", // 8
                "XV", // 15
                "XXVII", // 27
                "LVIII", // 58

                // ---------- SUBTRACTION (single pair) ----------
                "IV", // 4
                "IX", // 9
                "XL", // 40
                "XC", // 90
                "CD", // 400
                "CM", // 900

                // ---------- MIXED ----------
                "XIV", // 14
                "XIX", // 19
                "XLIV", // 44
                "XCIX", // 99
                "CDXLIV", // 444
                "CMXCIX", // 999

                // ---------- COMPLEX ----------
                "MCMXCIV", // 1994
                "MMXXIV", // 2024
                "MCMLXXXVII", // 1987
                "MMMDCCCLXXXVIII", // 3888

                // ---------- EDGE CASES ----------
                "MMMCMXCIX", // 3999 (max limit)
                "C", // 100
                "D", // 500
                "M", // 1000

                // ---------- TRICKY PATTERNS ----------
                "IXIX", // 18
                "XLXL", // 80
                "CMCM", // 1800
                "MCDLXXVI", // 1476
                "DCCCXC", // 890
        };

        for (String s : tests) {
            System.out.println(s + " -> " + romanToInt(s));
        }
    }
}

/*
 * 13. Roman to Integer
 * Solved
 * Easy
 * Topics
 * premium lock icon
 * Companies
 * Hint
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D
 * and M.
 * 
 * Symbol Value
 * I 1
 * V 5
 * X 10
 * L 50
 * C 100
 * D 500
 * M 1000
 * For example, 2 is written as II in Roman numeral, just two ones added
 * together. 12 is written as XII, which is simply X + II. The number 27 is
 * written as XXVII, which is XX + V + II.
 * 
 * Roman numerals are usually written largest to smallest from left to right.
 * However, the numeral for four is not IIII. Instead, the number four is
 * written as IV. Because the one is before the five we subtract it making four.
 * The same principle applies to the number nine, which is written as IX. There
 * are six instances where subtraction is used:
 * 
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "III"
 * Output: 3
 * Explanation: III = 3.
 * Example 2:
 * 
 * Input: s = "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 * Example 3:
 * 
 * Input: s = "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 15
 * s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
 * It is guaranteed that s is a valid roman numeral in the range [1, 3999].
 */