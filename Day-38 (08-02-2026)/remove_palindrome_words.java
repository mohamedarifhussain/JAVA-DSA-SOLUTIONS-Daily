import java.util.*;

public class remove_palindrome_words {


    public static boolean isPalindrome(String s){

        int left = 0;
        int right = s.length()-1;

        while(left <= right){
            if(s.charAt(left)!=s.charAt(right)) return false;

            left++;
            right--;
        }
        return true;

    }

    public static String solve(String s){

        String result = "";

        for(int i=0;i<s.length();i++){

            String p = "";

            while(i<s.length() && s.charAt(i)!=' '){
                p += s.charAt(i);
                i++;
            }

            if(!isPalindrome(p)){
                result = result +" "+p;
            }
        }

        return result;

    }

    public static void main(String[] args) {

        String[] tests = {

            // 1 given example
            "He did a good deed",

            // 2 given example
            "Hari speaks malayalam",

            // --------------------
            // BASIC
            // --------------------

            // 3 single palindrome
            "madam",

            // 4 single non palindrome
            "hello",

            // 5 mix small words
            "a b c d",

            // --------------------
            // MULTIPLE PALINDROMES
            // --------------------

            // 6 all palindromes
            "level madam racecar noon civic",

            // 7 alternating
            "wow this is level test",

            // 8 repeated
            "did did did good",

            // --------------------
            // EDGE CASES
            // --------------------

            // 9 empty
            "",

            // 10 spaces only
            "   ",

            // 11 one letter words (all palindromes)
            "a I u e o",

            // --------------------
            // CASE SENSITIVITY
            // --------------------

            // 12 mixed case
            "Madam level Noon",

            // --------------------
            // NUMBERS
            // --------------------

            // 13 numeric palindromes
            "121 12321 456 78987 hello",

            // --------------------
            // PUNCTUATION
            // --------------------

            // 14 punctuation words
            "wow! level? test, deed.",

            // --------------------
            // LONG
            // --------------------

            // 15 long sentence
            "refer to the radar level stats system quickly",

            // --------------------
            // NO PALINDROME
            // --------------------

            // 16 no palindrome words
            "java python coding interview",

            // --------------------
            // ALL SAME
            // --------------------

            // 17 same word many times
            "noon noon noon noon",

            // --------------------
            // MIXED LENGTH
            // --------------------

            // 18 tricky
            "he sees deed kayak good noon bad",

            // --------------------
            // CAPITALS
            // --------------------

            // 19 capitals
            "WOW wow Wow",

            // --------------------
            // REALISTIC
            // --------------------

            // 20 realistic
            "He met level madam at noon and left early"
        };


        for(int i=0;i<tests.length;i++){
            System.out.println("Test Case " + (i+1));
            System.out.println("Input  : \"" + tests[i] + "\"");
            System.out.println("Output : " + solve(tests[i]));
            System.out.println("--------------------------------");
        }
    }


    
}


/* 17. Given a sentence of string, in that remove the palindrome words and print the
remaining.
Input:
He did a good deed
Output:
He good
Input:
Hari speaks malayalam
Output:
Hari speaks */