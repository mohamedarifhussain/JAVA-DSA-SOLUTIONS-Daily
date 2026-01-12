import java.util.Arrays;

public class coin_changes_gfg {

    static int cnt;

    public static void possible(int ind, int sum, int target, int[] coins) {

        if (sum == target) {
            cnt++;
            return;
        }
        for (int i = ind; i < coins.length; i++) {
            if (sum + coins[i] <= target) {
                possible(i, sum + coins[i], target, coins);
            } else {
                break;
            }
        }

    }

    public static int count(int coins[], int sum) {
        // code here.
        cnt = 0;

        Arrays.sort(coins);

        possible(0, 0, sum, coins);

        return cnt;
    }

    public static void main(String[] args) {

        int[] coins = { 2, 5, 3, 6 };
        int sum = 10;

        int ways = count(coins, sum);

        System.out.println("Input: coins=" + Arrays.toString(coins) + " , sum=" + sum);
        System.out.println("Output: ways=" + ways);
    }
}

/*
 * Coin Change (Count Ways)
 * Difficulty: MediumAccuracy: 43.1%Submissions: 307K+Points: 4
 * Given an integer array coins[ ] representing different denominations of
 * currency and an integer sum, find the number of ways you can make sum by
 * using different combinations from coins[ ].
 * Note: Assume that you have an infinite supply of each type of coin.
 * Therefore, you can use any coin as many times as you want.
 * Answers are guaranteed to fit into a 32-bit integer.
 * 
 * Examples:
 * 
 * Input: coins[] = [1, 2, 3], sum = 4
 * Output: 4
 * Explanation: Four Possible ways are: [1, 1, 1, 1], [1, 1, 2], [2, 2], [1, 3].
 * Input: coins[] = [2, 5, 3, 6], sum = 10
 * Output: 5
 * Explanation: Five Possible ways are: [2, 2, 2, 2, 2], [2, 2, 3, 3], [2, 2,
 * 6], [2, 3, 5] and [5, 5].
 * Input: coins[] = [5, 10], sum = 3
 * Output: 0
 * Explanation: Since all coin denominations are greater than sum, no
 * combination can make the target sum.
 * Constraints:
 * 1 <= sum <= 103
 * 1 <= coins[i] <= 104
 * 1 <= coins.size() <= 103
 */
