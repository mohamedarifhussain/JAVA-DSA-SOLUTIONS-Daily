public class count_ways_to_nth_stairs {

    static int countUniqueWays(int n) {
        return 1 + n / 2;
    }

    public static void main(String[] args) {

        int input = 17;
        int output = countUniqueWays(input);

        System.out.println("Input: " + input);
        System.out.println("Output: " + output);

    }

}

/*
 * Count ways to N'th Stair(Order does not matter)
 * Difficulty: MediumAccuracy: 50.49%Submissions: 72K+Points: 4Average Time: 30m
 * There are n stairs, and a person standing at the bottom wants to reach the
 * top. The person can climb either 1 stair or 2 stairs at a time. Count the
 * number of ways, the person can reach the top (order does not matter).
 * Note: Order does not matter means for n = 4:- {1 2 1},{2 1 1},{1 1 2} are
 * considered same.
 * 
 * Examples :
 * 
 * Input: n = 4
 * Output: 3
 * Explanation: Three ways to reach at 4th stair. They are {1, 1, 1, 1}, {1, 1,
 * 2}, {2, 2}.
 * Input: n = 5
 * Output: 3
 * Explanation: Three ways to reach at 5th stair. They are {1, 1, 1, 1, 1}, {1,
 * 1, 2, 1} and {1, 2, 2}.
 * Expected Time Complexity: O(1)
 * Expected Space Complexity: O(1)
 * 
 * Constraints:
 * 1 ≤ n ≤ 104
 */