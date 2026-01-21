public class count_odd_even_digits {

    public static void countOddEvenDigits(int num) {

        int odd = 0;
        int even = 0;
        if (num == 0)
            even++;
        while (num != 0) {

            if (num % 2 == 0)
                even++;
            else
                odd++;
            num /= 10;

        }
        System.out.println("ODD=" + odd + " EVEN=" + even);
    }

    public static void main(String[] args) {

        int[] testCases = {
                1234567, // normal mixed
                13579, // all odd
                24680, // all even
                7, // single odd
                8, // single even
                102030, // contains zero
                0, // IMPORTANT edge case
                987654321, // large number
                44444, // repeated even digit
                1221, // palindrome
                -123 // negative number (conceptual)
        };

        for (int i = 0; i < testCases.length; i++) {
            System.out.println("Test Case " + (i + 1));
            System.out.println("Input : " + testCases[i]);
            countOddEvenDigits(testCases[i]);
            System.out.println("----------------------------");
        }
    }
}

/*
 * 53. Print the total number of odd and even digits in the given number.
 * 
 * Ex. Input : 1234567
 * 
 * Output : ODD 4
 * EVEN 3
 */
