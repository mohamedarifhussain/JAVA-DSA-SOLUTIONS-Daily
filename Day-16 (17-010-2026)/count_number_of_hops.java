public class count_number_of_hops {
    

    static int count(int i,int[] dp){
        
    
        
        if(i<1) return 0;
        
        if(i<=2) return i;
        
        if(dp[i]!=0) return dp[i];
        
        dp[i] = count(i-1,dp) + count(i-2,dp) + count(i-3,dp);
        
        return dp[i];
        
    }
    
    
    static int countWays(int n) {
        // add your code here
        if(n<3) return n;
        int[] dp = new int[n+1];
        dp[3]=4;
        
        return count(n,dp);
    }

    public static void main(String[] args) {
        int input = 17;
        int output = countWays(input);

        System.out.println("Input: "+input);
        System.out.println("Output: "+output);
    }
}

/* Count number of hops
Difficulty: EasyAccuracy: 43.93%Submissions: 160K+Points: 2
A frog jumps either 1, 2, or 3 steps to go to the top. In how many ways can it reach the top of nth step.

Examples:

Input: n = 4
Output: 7
Explanation: Below are the 7 ways to reach 4th step:
1 step + 1 step + 1 step + 1 step
1 step + 2 step + 1 step
2 step + 1 step + 1 step
1 step + 1 step + 2 step
2 step + 2 step
3 step + 1 step
1 step + 3 step
Input: n = 2
Output: 2
Explanation: Below are the 2 ways to reach 2nd step:
1 step + 1 step 
2 step 
Input: n = 1
Output: 1
Constraints:
1 ≤ n ≤ 30

Expected Complexities
Time Complexity: O(n)
Auxiliary Space: O(1)
 */