import java.util.*;

public class sieve_of_eratosthenes{


     public static int[] sieve(int n) {
        // code here
        boolean[] primes = new boolean[n+1];
        
        int count=0;
        
        for(int i=2;i<=n;i++){
            
            if(!primes[i]){
                count++;
                
                for(int j=i+i;j<=n;j+=i){
                    primes[j]=true;
                }
            }
            
        }
        
        int ind=0;
        int[] result = new int[count];
        
        for(int i=2;i<=n;i++){
            if(!primes[i]){
                result[ind]=i;
                ind++;
            }
        }
        
        return result;
        
        
    }

    public static void main(String[] args) {
        
        int input = 10;

        int[] output = sieve(input);

        System.out.println("Input: "+input);
        System.out.println("Output: "+Arrays.toString(output));
    }
}
/* 
Sieve of Eratosthenes
Difficulty: MediumAccuracy: 47.43%Submissions: 75K+Points: 4
Given a positive integer n, calculate and return all prime numbers less than or equal to n using the Sieve of Eratosthenes algorithm.
A prime number is a natural number greater than 1 that has no positive divisors other than 1 and itself.

Examples:

Input: n = 10
Output: [2, 3, 5, 7]
Explanation: Prime numbers less than equal to 10 are 2, 3, 5 and 7.
Input: n = 35
Output: [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31]
Explanation: Prime numbers less than equal to 35 are 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 and 31.
Constraints:
1 ≤ n ≤ 104
 */
