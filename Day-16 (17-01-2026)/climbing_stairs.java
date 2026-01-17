public class climbing_stairs {
    
    public static int climbStairs(int n) {

        int c = 0;
        if (n == 1 || n == 2)
            return n;
        int n1 = 1, n2 = 2;
        for (int i = 3; i <= n; i++) {
            c = n1 + n2;
            n1 = n2;
            n2 = c;
        }
        return c;
    }

    public static void main(String[] args) {
        
        int input = 17;
        int output =  climbStairs(input);

        System.out.println("Input: "+input);
        System.out.println("Output: "+output);
    }
}

/* 
70. Climbing Stairs
Solved
Easy
Topics
premium lock icon
Companies
Hint
You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 

Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
 

Constraints:

1 <= n <= 45 */