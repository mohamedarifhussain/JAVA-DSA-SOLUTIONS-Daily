
public class count_number_characters_by_writing_number_in_a_paper {


    public static long solve(long n ){

        long count = 0;
        long num = 1;
        long denominator = 10;
        for(long i=1;i<=n;i++){
            if(i/denominator > 0){
                num++;
                denominator = denominator*10;
            }
            count+=num;
        }

        return count;
    }

     public static long optimal(long n) {

        if(n <= 0) return 0;

        long digits = 0;
        long start = 1;      // 1, 10, 100 ...
        long len = 1;        // digit length

        while(start * 10 <= n) {

            long count = 9 * start;   // numbers in this block
            digits += count * len;

            start *= 10;
            len++;
        }

        // remaining numbers
        digits += (n - start + 1) * len;

        return digits;
    }


    public static void main(String[] args) {

        long[][] tests = {

            // ---------- BASIC ----------
            {0, 0},
            {1, 1},
            {5, 5},
            {9, 9},

            // ---------- FIRST TRANSITION (1 → 2 digit) ----------
            {10, 11},
            {11, 13},
            {19, 29},
            {20, 31},

            // ---------- FULL 2-digit BLOCK ----------
            {99, 189},

            // ---------- 2 → 3 digit transition ----------
            {100, 192},
            {101, 195},
            {109, 219},
            {110, 222},   // tricky one
            {111, 225},

            // ---------- RANDOM SMALL ----------
            {123, 261},
            {250, 642},
            {500, 1392},

            // ---------- FULL 3-digit BLOCK ----------
            {999, 2889},

            // ---------- 3 → 4 digit transition ----------
            {1000, 2893},
            {1001, 2897},
            {1010, 2933},

            // ---------- RANDOM MEDIUM ----------
            {1234, 3829},
            {5000, 18893},
            {9999, 38889},

            // ---------- 4 → 5 digit transition ----------
            {10000, 38894},
            {10001, 38899},

            // ---------- LARGE ----------
            {50000, 238894},
            {99999, 488889},

            // ---------- 5 → 6 digit transition ----------
            {100000, 488895},
            {100001, 488901},

            // ---------- VERY LARGE (break O(n)) ----------
            {1000000, 5888896},
            {9999999, 68888889},
            {10000000, 68888897},

            // ---------- EXTREME LARGE ----------
            {100000000, 788888898},
            {1000000000L, 8888888899L},

            // ---------- SUPER LARGE (only optimal works) ----------
            {1000000000000L, 11888888888890L}
        };

        int caseNo = 1;

        for(long[] t : tests){

            System.out.println("Test Case " + caseNo++);
            System.out.println("Input  : " + t[0]);
            System.out.println("Expected Output : " + t[1]);
            System.out.println("Your Output: "+optimal(t[1]));
            System.out.println("---------------------------");
        }
    }
}



/* 
96. You’re given a number n. If write all the numbers from 1 to n in a paper, we have to find the number of
characters written on the paper.For example if n=13, the output should be 18 if n = 101, the output should
be 195 */