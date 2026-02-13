import java.util.Arrays;

public class addDigits {

    public static int len(int i) {

        int c = 0;

        while (i != 0) {
            c++;
            i /= 10;
        }
        return c;

    }

    public static long solve(int add, int num) {

        if(add==0) return (long)num;

        int l = len(num);

        if(l==0) return (long) add;

        int[] nums = new int[l];

        while (num != 0) {

            nums[l - 1] = (num % 10) + add;
            num /= 10;
            l--;

        }

        System.out.println(Arrays.toString(nums));

        long ans = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] >= 10 && nums[i] % 10 >= 0) {
                ans = ans * 100 + nums[i];
            } else {
                ans = ans * 10 + nums[i];
            }

        }

        return ans;

    }

    public static void main(String[] args) {

        // Each test case: {digit, number}
        int[][] testCases = {

                // -------- Given / Basic ----------
                { 4, 2875 }, // 612119
                { 1, 123 }, // 234
                { 2, 456 }, // 678
                { 3, 789 }, // 101112

                // -------- Single digit numbers ----------
                { 4, 7 }, // 11
                { 9, 1 }, // 10
                { 0, 5 }, // 5

                // -------- Zero inside number ----------
                { 4, 101 }, // 5145
                { 3, 1005 }, // 43138
                { 9, 909 }, // 181818
                { 5, 1000 }, // 61555

                // -------- Carry-over heavy ----------
                { 9, 9 }, // 18
                { 9, 99 }, // 1818
                { 9, 999 }, // 181818
                { 8, 789 }, // 151617
                { 6, 456 }, // 101112

                // -------- digit = 0 ----------
                { 0, 12345 }, // 12345
                { 0, 90807 }, // 90807
                { 0, 0 }, // 0

                // -------- number = 0 ----------
                { 5, 0 }, // 5
                { 9, 0 }, // 9

                // -------- Repeated digits ----------
                { 2, 1111 }, // 3333
                { 5, 2222 }, // 7777
                { 7, 3333 }, // 10101010

                // -------- Mixed digits ----------
                { 2, 908172 }, // 11102294
                { 6, 304050 }, // 91061056
                { 1, 864209 }, // 975310

                // -------- Large number (stress) ----------
                { 4, 999999 }, // 131313131313
                { 8, 123456789 } // 911121314151617
        };

        int tc = 1;
        for (int[] t : testCases) {

            int digit = t[0];
            int number = t[1];

            System.out.println("Test Case " + tc++);
            System.out.println("Digit  : " + digit);
            System.out.println("Number : " + number);

            // 👉 CALL YOUR METHOD HERE
            // Example:
            System.out.println("Output : " + solve(digit, number));

            System.out.println("----------------------------------");
        }
    }
}

/*
 * 29. adding a digit to all the digits of a number eg digit=4, number = 2875,
 * o/p= 612119
 */