import java.util.Arrays;

public class rotate_array_by_1 {

    public static void swap(int[] arr1, int a, int b) {
        int temp = arr1[a];
        arr1[a] = arr1[b];
        arr1[b] = temp;
    }

    public static void rotate(int[] arr) {
        // code here

        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, i, i - 1);
        }

    }

    public static void main(String[] args) {

        int[] input = { 1, 2, 3, 4, 5 };

        System.out.println("Input: " + Arrays.toString(input));
        rotate(input);
        System.out.println("Output: " + Arrays.toString(input));

    }
}

/*
 * Rotate Array by One
 * Difficulty: BasicAccuracy: 69.6%Submissions: 357K+Points: 1Average Time: 20m
 * Given an array arr, rotate the array by one position in clockwise direction.
 * 
 * Examples:
 * 
 * Input: arr[] = [1, 2, 3, 4, 5]
 * Output: [5, 1, 2, 3, 4]
 * Explanation: If we rotate arr by one position in clockwise 5 come to the
 * front and remaining those are shifted to the end.
 * Input: arr[] = [9, 8, 7, 6, 4, 2, 1, 3]
 * Output: [3, 9, 8, 7, 6, 4, 2, 1]
 * Explanation: After rotating clock-wise 3 comes in first position.
 * Constraints:
 * 1<=arr.size()<=105
 * 0<=arr[i]<=105
 * 
 * Expected Complexities
 * Topic Tags
 * Related Articles
 */