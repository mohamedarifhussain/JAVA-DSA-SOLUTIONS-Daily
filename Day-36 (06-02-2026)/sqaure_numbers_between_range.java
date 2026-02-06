import java.util.ArrayList;
import java.util.List;

public class sqaure_numbers_between_range {
    

    static int squareRoot(int num){


        int left = 1;
        int right = num;

        while(left<right){

            int mid = left + (right-left)/2;

            int ans = mid*mid;

            if(ans==num) return mid;

            else if(ans>num){
                right = mid;
            }
            else{
                left = mid+1;
            }

        }

        return left-1;


    }


    static List<Integer> solve(int a,int b){

        List<Integer> result = new ArrayList<>();



        int num = squareRoot(a);

        if(num*num < a) num++;

        while(num*num <= b){

            result.add(num*num);
            num++;
        }

        return result;

    }


    public static void main(String[] args) {


        int[][] testCases = {

                {20,100},
                {1,10},
                {50,60},
                {49,49},
                {48,49},
                {0,10},
                {2,3},
                {100,100},
                {121,150},
                {150,200},
                {180,199},
                {5,6},
                {16,17},
                {17,24},
                {36,81},
                {1,1},
                {199,200},
                {-10,10},
                {144,144},
                {10,20}
        };

        for(int i = 0; i < testCases.length; i++) {

            int a = testCases[i][0];
            int b = testCases[i][1];

            List<Integer> output = solve(a, b);

            System.out.println("Test Case " + (i+1));
            System.out.println("Input  : a = " + a + ", b = " + b);
            System.out.println("Output : " + output);
            System.out.println("--------------------------");
        }
  

    }
}

/* 99. Given two numbers a and b both < 200 we have to find the square numbers which lie
between a and b(inclusive)
eg) i/p a = 20;b = 100;
 o/p 25,36,49,64,81,100  */