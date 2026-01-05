import java.util.*;
public class count_distinct_element_in_every_window {

    static ArrayList<Integer> countDistinct(int arr[], int k) {
        // code here
        HashMap<Integer, Integer> mp = new HashMap<>();

        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            mp.put(arr[i], mp.getOrDefault(arr[i], 0) + 1);
        }

        result.add(mp.size());

        for (int i = k; i < arr.length; i++) {

            int freq = mp.get(arr[i - k]);

            if (freq == 1)
                mp.remove(arr[i - k]);
            else
                mp.put(arr[i - k], freq - 1);

            mp.put(arr[i], mp.getOrDefault(arr[i], 0) + 1);

            result.add(mp.size());

        }

        return result;

    }

    public static void main(String[] args) {

        int[] arr = { 1, 2, 1, 3, 4, 2, 3 };
        int k = 4;

        ArrayList<Integer> result = countDistinct(arr, k);

        System.out.println("Input: arr: " + Arrays.toString(arr) + " k: " + k);
        System.out.println("Output: " + result);
    }

}

/*
 * Count distinct elements in every window
 * Difficulty: MediumAccuracy: 41.83%Submissions: 166K+Points: 4Average Time:
 * 20m
 * Given an integer array arr[] and a number k. Find the count of distinct
 * elements in every window of size k in the array.
 * 
 * Examples:
 * 
 * Input: arr[] = [1, 2, 1, 3, 4, 2, 3], k = 4
 * Output: [3, 4, 4, 3]
 * Explanation:
 * First window is [1, 2, 1, 3], count of distinct numbers is 3.
 * Second window is [2, 1, 3, 4] count of distinct numbers is 4.
 * Third window is [1, 3, 4, 2] count of distinct numbers is 4.
 * Fourth window is [3, 4, 2, 3] count of distinct numbers is 3.
 * Input: arr[] = [4, 1, 1], k = 2
 * Output: [2, 1]
 * Explanation:
 * First window is [4, 1], count of distinct numbers is 2.
 * Second window is [1, 1], count of distinct numbers is 1.
 * Input: arr[] = [1, 1, 1, 1, 1], k = 3
 * Output: [1, 1, 1]
 * Explanation: Every window of size 3 in the array [1, 1, 1, 1, 1], contains
 * only the element 1, so the number of distinct elements in each window is 1.
 * Constraints:
 * 1 ≤ k ≤ arr.size() ≤ 105
 * 1 ≤ arr[i] ≤ 105
 */
