public class number_to_words {

    static String[] ones = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine" };

    static String[] teens = { "", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
            "Eighteen", "Nineteen" };

    static String[] tens = { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };

    public static String words(int n) {

        String result = "";

        if (n >= 1000) {
            result += "," + words(n % 1000);
            n = n % 1000;
        }

        int temp = n;

        int hundred = temp / 100;

        if (hundred > 0)
            result = result + ones[hundred] + ",Hundred";

        temp = n % 100;
        boolean isTeen = false;
        if (temp > 10 && temp < 20) {
            result = result + "," + teens[temp - 10];
            isTeen = true;
        }

        else if (temp >= 20 || temp == 10) {
            result = result + "," + tens[temp / 10];
        }

        temp = n % 10;

        if (temp > 0 && !isTeen) {
            result = result + "," + ones[temp];
        }

        return result;
    }

    public static String numberToWords(int num) {

        if (num == 0)
            return "Zero";

        String output = "";
        int temp = num;

        int billion = temp / 1000000000;

        if (billion > 0) {
            output = output + words(billion) + ",Billion";
        }

        temp = num % 1000000000;

        int million = temp / 1000000;

        if (million > 0) {
            output = output + "," + words(million) + ",Million";
        }

        temp = num % 1000000;

        int thousand = temp / 1000;

        if (thousand > 0) {
            output = output + "," + words(thousand) + ",Thousand";
        }
        temp = num % 1000;

        if (temp > 0) {
            output = output + "," + words(temp);
        }

        String fin = "";

        for (char ch : output.toCharArray()) {

            if (ch == ',') {
                if (fin.length() > 0) {
                    if (fin.charAt(fin.length() - 1) != ' ') {
                        fin += ' ';
                    }
                }
            } else {
                fin += ch;
            }
        }

        return fin;

    }

    public static void main(String[] args) {

        int[] testCases = {
                0,
                5,
                9,
                10,
                11,
                15,
                19,
                20,
                21,
                99,
                100,
                101,
                110,
                115,
                121,
                199,
                200,
                256,
                999,
                1000,
                1001,
                1010,
                1100,
                1234,
                2000,
                5001,
                9999,
                10000,
                10001,
                10101,
                11000,
                12345,
                99999,
                100000,
                100001,
                101010,
                110000,
                999999,
                1000000,
                1000001,
                1234567,
                9999999,
                10000000,
                100000000,
                123456789,
                1000000000,
                2147483647 // Integer.MAX_VALUE
        };

        int tc = 1;
        for (int n : testCases) {
            System.out.println("Test Case " + tc++);
            System.out.println("Input  : " + n);
            System.out.println("Output : " + numberToWords(n));
            System.out.println("----------------------------------");
        }
    }
}

/*
 * 273. Integer to English Words
 * Solved
 * Hard
 * Topics
 * premium lock icon
 * Companies
 * Hint
 * Convert a non-negative integer num to its English words representation.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: num = 123
 * Output: "One Hundred Twenty Three"
 * Example 2:
 * 
 * Input: num = 12345
 * Output: "Twelve Thousand Three Hundred Forty Five"
 * Example 3:
 * 
 * Input: num = 1234567
 * Output:
 * "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 * 
 * 
 * Constraints:
 * 
 * 0 <= num <= 231 - 1
 * 
 * Seen this question in a real interview before?
 * 1/5
 * Yes
 * No
 * Accepted
 * 572,958/1.6M
 * 
 */