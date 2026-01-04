import java.math.BigInteger;

public class largest_number_in_k_swaps {

    public static String findMaxNum(char[] arr1, int z, int k, int j) {

        String res = new String(arr1);

        String s1;

        BigInteger n1;
        BigInteger n2;

        while (z < k && j < arr1.length) {
            int ind = j;
            int max = j;
            for (int x = j; x < arr1.length; x++) {

                if (arr1[max] < arr1[x]) {
                    max = x;
                }

            }
            if (max != j) {

                for (int x = j; x < arr1.length; x++) {

                    if (arr1[max] == arr1[x]) {
                        swap(arr1, ind, x);

                        s1 = findMaxNum(arr1, z + 1, k, j + 1);
                        n1 = new BigInteger(res);
                        n2 = new BigInteger(s1);

                        if (n1.compareTo(n2) < 0) {
                            res = s1;
                        }

                        swap(arr1, ind, x);

                        s1 = findMaxNum(arr1, z + 1, k, j + 1);
                        n1 = new BigInteger(res);
                        n2 = new BigInteger(s1);

                        if (n1.compareTo(n2) < 0) {
                            res = s1;
                        }

                    }

                }
            }

            j++;

        }

        return res;

    }

    public static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        String num = "1234567";
        int k = 4;

        System.out.println("Input : num: " + num + " k: " + k);
        System.out.println("Output: " + findMaxNum(num.toCharArray(), 0, k, 0));
    }
}

/*
 * Largest number in K swaps
 * Difficulty: MediumAccuracy: 18.84%Submissions: 128K+Points: 4Average Time:
 * 30m
 * Given a number k and string s of digits denoting a positive integer, build
 * the largest number possible by performing swap operations on the digits of s
 * at most k times.
 * 
 * Examples :
 * 
 * Input: s = "1234567", k = 4
 * Output: 7654321
 * Explanation: Three swaps can make the input 1234567 to 7654321, swapping 1
 * with 7, 2 with 6 and finally 3 with 5.
 * Input: s = "3435335", k = 3
 * Output: 5543333
 * Explanation: Three swaps can make the input 3435335 to 5543333, swapping 3
 * with 5, 4 with 5 and finally 3 with 4.
 * Input: s = "1034", k = 2
 * Output: 4301
 * Explanation: Two swaps can make the input 1034 to 4301, swapping 1 with 4 and
 * finally 0 with 3.
 * Constraints:
 * 1 ≤ s.size() ≤ 15
 * 1 ≤ k ≤ 7
 * 
 * Expected Complexities
 * Time Complexity: O((n ^ 2) ^ k)
 * Auxiliary Space: O(n)
 */