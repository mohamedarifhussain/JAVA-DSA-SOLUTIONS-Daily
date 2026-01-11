public class add_digits {
    

    public static int addDigits(int num) {
        int result = num;
        while (!(result < 10)) {
            int sum = 0, temp = result;
            while (temp != 0) {
                sum += temp % 10;
                temp /= 10;
            }
            result = sum;
        }
        return result;
    }

    public static void main(String[] args) {
        int num = 25789;

        int output = addDigits(num);

        System.out.println("Input: num="+num);
        System.out.println("Ouput: "+output);
    }
}

/* 
258. Add Digits
Solved
Easy
Topics
premium lock icon
Companies
Hint
Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.

 

Example 1:

Input: num = 38
Output: 2
Explanation: The process is
38 --> 3 + 8 --> 11
11 --> 1 + 1 --> 2 
Since 2 has only one digit, return it.
Example 2:

Input: num = 0
Output: 0
 

Constraints:

0 <= num <= 231 - 1
 

Follow up: Could you do it without any loop/recursion in O(1) runtime? */