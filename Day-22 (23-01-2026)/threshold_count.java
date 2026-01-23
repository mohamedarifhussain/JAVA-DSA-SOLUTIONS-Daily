import java.util.Arrays;

public class threshold_count {

    static int solve(int[] arr, int threshold) {
        // write YOUR solution
        int count = 0;

        for (int i = 0; i < arr.length; i++) {

            count += arr[i] / threshold + ((arr[i] % threshold == 0) ? 0 : 1);

        }

        return count;
    }

    public static void main(String[] args) {

        int[][] testArrays = {
                { 5, 8, 10, 13, 6, 2 },
                { 1, 2, 3 },
                { 3, 3, 3 },
                { 4, 4, 4 },
                { 5 },
                { 100 },
                { 6, 9, 12 },
                { 1, 7, 2, 9, 3 },
                { 100, 200, 300 },
                { 0, 5, 10 },
                {},
                { 11, 23, 37, 49, 52 }
        };

        int[] thresholds = { 3, 5, 10 };

        for (int t : thresholds) {
            System.out.println("===== Threshold = " + t + " =====");

            for (int i = 0; i < testArrays.length; i++) {
                int[] input = Arrays.copyOf(testArrays[i], testArrays[i].length);

                System.out.println("Input : " + Arrays.toString(input));
                int output = solve(input, t);
                System.out.println("Count : " + output);
                System.out.println("----------------------");
            }
        }
    }
}

/* 100. Given an array and a threshold value find the o/p
eg) i/p {5,8,10,13,6,2};threshold = 3;
o/p count = 17
explanation:
Number parts counts
5 {3,2} 2
8 {3,3,2} 3
10 {3,3,3,1} 4
13 {3,3,3,3,1} 5
6 {3,3} 2
2 {2} 1

for this input give me all different test cases this qquestion is asked by zoho
 */