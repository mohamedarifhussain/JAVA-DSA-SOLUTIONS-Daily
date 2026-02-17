import java.util.Arrays;

public class best_time_to_buy_and_sell_stock {

    public static int maxProfit(int[] prices) {

        int[] arr = new int[prices.length];

        int len = prices.length;

        arr[len - 1] = prices[len - 1];

        for (int i = len - 2; i >= 0; i--) {
            arr[i] = Math.max(arr[i + 1], prices[i]);
        }

        int maxLen = 0;

        for (int i = 0; i < len; i++) {
            if (prices[i] < arr[i]) {
                maxLen = Math.max(maxLen, arr[i] - prices[i]);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {

        int[] input = { 7, 1, 5, 3, 6, 4 };

        int output = maxProfit(input);

        System.out.println("Input: " + Arrays.toString(input));
        System.out.println("Output: " + output);
    }
}

/*
 * 121. Best Time to Buy and Sell Stock
 * Solved
 * Easy
 * Topics
 * premium lock icon
 * Companies
 * You are given an array prices where prices[i] is the price of a given stock
 * on the ith day.
 * 
 * You want to maximize your profit by choosing a single day to buy one stock
 * and choosing a different day in the future to sell that stock.
 * 
 * Return the maximum profit you can achieve from this transaction. If you
 * cannot achieve any profit, return 0.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit =
 * 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you
 * must buy before you sell.
 * Example 2:
 * 
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 * 
 * 
 * Constraints:
 * 
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 104
 */
