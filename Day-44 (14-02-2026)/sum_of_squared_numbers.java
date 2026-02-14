public class sum_of_squared_numbers {

    public static boolean isSquare(int n){

        if(n==0 || n==1) return true;

        int left = 1;
        int right = n;

        while(left<right){

            int mid = left + (right-left)/2;

            int square = mid * mid;
            if(square==n) return true;

            if(square > n){
                right = mid-1;
            }
            else{
                left = mid+1;
            }

        }


        return (left*left==n);



    }

    public static int solve2(int num){

        if(num==0) return 1;

        int total = 0;

        for(int i=0;i*i<= num/2;i++){
            if(isSquare(num-(i*i))){
                total++;
            }
        }

        return total;
    }

    public static int solve1(int num){

        if(num==0) return 1;

        boolean[] square = new boolean[num+1];

        int total = 0;

        for(int i=0;i*i<=num;i++){
            square[i*i] = true;
        }


        for(int i=0;i*i<= num/2; i++){
            if(square[ num - (i*i)]) {
                // System.out.println("a="+(num - (i*i))+", b="+(i*i));
                total++;
            }
        }

        return total;


    }

    public static void main(String[] args) {

        int[] testInputs = {

            // ---------- Basic ----------
            0,      // 0^2 + 0^2
            1,      // 1^2 + 0^2
            2,      // 1^2 + 1^2
            3,
            4,      // 2^2 + 0^2
            5,      // 2^2 + 1^2

            // ---------- Small ----------
            8,
            9,
            10,
            13,
            16,
            18,
            20,
            25,
            26,

            // ---------- Medium ----------
            32,
            34,
            36,
            40,
            41,
            45,
            50,
            52,
            58,

            // ---------- Perfect Squares ----------
            49,
            64,
            81,
            100,
            121,

            // ---------- No-solution cases ----------
            7,
            11,
            14,
            15,
            19,
            23,

            // ---------- Large ----------
            65,
            85,
            100,
            130,
            145,
            169,
            200,
            250,
            325,

            // ---------- Very Large (Zoho edge focus) ----------
            500,
            625,
            800,
            1000,
            1024,
            2000,
            5000,
            10000
        };


        int tc = 1;
        for (int n : testInputs) {
            System.out.println("Test Case " + tc++);
            System.out.println("Input  : " + n);

            // 👉 CALL YOUR METHOD HERE
            int count = solve2(n);

            System.out.println("Output : "+count);
            System.out.println("---------------------------");
            System.out.println();
        }
    }
}


/* 1. Sum of Squares Count
Given a number, find the number of possible ways to represent it as the sum of squares of two non-negative integers.  */