public class count_occurences_of_anagrams {
    


    static int search(String pat, String txt) {
        
        int plen = pat.length();
        int tlen = txt.length();
        if (plen > tlen) return 0;

        int[] patFreq = new int[26];
        int[] winFreq = new int[26];

        for (int i = 0; i < plen; i++) {
            patFreq[pat.charAt(i) - 'a']++;
            winFreq[txt.charAt(i) - 'a']++;
        }

        int matches = 0;

        for (int i = 0; i < 26; i++) {
            if (patFreq[i] == winFreq[i]) matches++;
        }

        int result = 0;

        if (matches == 26) result++;

        for (int i = plen; i < tlen; i++) {

            int right = txt.charAt(i) - 'a';        
            int left  = txt.charAt(i - plen) - 'a'; 

            winFreq[right]++;
            if (winFreq[right] == patFreq[right]) matches++;
            else if (winFreq[right] == patFreq[right] + 1) matches--;

            winFreq[left]--;
            if (winFreq[left] == patFreq[left]) matches++;
            else if (winFreq[left] == patFreq[left] - 1) matches--;

            if (matches == 26) result++;
        }

        return result;
    }

    public static void main(String[] args) {
        
        String text="forxxorfxdofr";
        String pattern="for";

        int output = search(pattern,text);

        System.out.println("Input: text= \""+text+"\", pattern=\""+pattern+"\"");
        System.out.println("Output: "+output);
    }
}


/* Count Occurences of Anagrams
Difficulty: MediumAccuracy: 48.09%Submissions: 102K+Points: 4
Given a word pat and a text txt. Return the count of the occurrences of anagrams of the word in the text.

Example 1:

Input: txt = "forxxorfxdofr", pat = "for"
Output: 3
Explanation: for, orf and ofr appears in the txt, hence answer is 3.
Example 2:

Input: txt = "aabaabaa", pat = "aaba"
Output: 4
Explanation: aaba is present 4 times in txt.
Constraints:
1 <= |pat| <= |txt| <= 105
Both strings contain lowercase English letters.

Expected Complexities
Time Complexity: O(n)
Auxiliary Space: O(1)
 */