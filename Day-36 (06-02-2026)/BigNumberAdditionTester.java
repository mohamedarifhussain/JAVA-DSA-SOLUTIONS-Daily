import java.util.*;

public class BigNumberAdditionTester {

    // 🔴 Replace with your solution
    static int[] solve(int[] num1, int[] num2) {


        int[] result = new int[Math.max(num1.length,num2.length)+1];

        int rem=0;

        int p1= num1.length-1;
        int p2 = num2.length-1;

        int point = result.length-1;

        while(p1>=0 && p2>=0){

            int ans = (num1[p1] + num2[p2] + rem);
            rem = ans/10;

            result[point]= (ans%10);
            p1--;
            p2--;
            point--;

        }

        while(p1>=0){
            int ans = (num1[p1]+rem);
            rem = ans/10;
            result[p1]=ans%10;
            p1--;
            point--;
        }
        while(p2>=0){
            int ans = (num2[p2]+rem);
            rem = ans/10;
            result[p2]=ans%10;
            p2--;
            point--;

        }

        result[0] = (result[0]==0)? rem: result[0];


        return result; // dummy
    }

    static void print(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {

        int[][][] testCases = {

                // 1 Given example
                {
                    {9,2,8,1,3,5,6,7,3,1,1,6},
                    {7,8,4,6,2,1,9,9,7}
                },

                // 2 equal length
                {
                    {1,2,3},
                    {4,5,6}
                },

                // 3 carry inside
                {
                    {5,9,9},
                    {4,0,2}
                },

                // 4 carry at last
                {
                    {9,9,9},
                    {1}
                },

                // 5 single digit
                {
                    {5},
                    {7}
                },

                // 6 both zero
                {
                    {0},
                    {0}
                },

                // 7 different length
                {
                    {1,0,0,0},
                    {9}
                },

                // 8 long carry chain
                {
                    {9,9,9,9,9,9},
                    {1}
                },

                // 9 no carry
                {
                    {1,1,1,1},
                    {2,2,2,2}
                },

                // 10 one empty
                {
                    {},
                    {1,2,3}
                },

                // 11 leading zeros
                {
                    {0,0,1,2},
                    {0,0,3,4}
                },

                // 12 large numbers
                {
                    {1,2,3,4,5,6,7,8,9,0,1,2,3,4,5},
                    {9,8,7,6,5,4,3,2,1}
                },

                // 13 alternating digits
                {
                    {1,0,1,0,1,0},
                    {9,0,9,0,9,0}
                },

                // 14 both long
                {
                    {5,4,3,2,1,0,9,8,7,6},
                    {4,5,6,7,8,9,0,1,2,3}
                },

                // 15 many zeros
                {
                    {0,0,0,0,0},
                    {0,0,0}
                }
        };


        for(int i=0;i<testCases.length;i++){

            int[] a = testCases[i][0];
            int[] b = testCases[i][1];

            System.out.println("Test Case " + (i+1));
            System.out.print("Input A : "); print(a);
            System.out.print("Input B : "); print(b);

            int[] result = solve(a,b);

            System.out.print("Output  : ");
            print(result);

            System.out.println("----------------------------");
        }
    }
}

/* 
72. Adding 2 numbers
GIven 2 huge numbers as seperate digits, store them in array
and process them and calculate the sum of 2 numbers and store
the result in an array and print the sum.
Input:
Number of digits:12
9 2 8 1 3 5 6 7 3 1 1 6
Number of digits:9
7 8 4 6 2 1 9 9 7
Output :
9 2 8 9 2 0 2 9 5 1 1 3 */