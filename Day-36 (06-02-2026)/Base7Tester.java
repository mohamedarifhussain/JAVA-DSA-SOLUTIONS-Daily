
public class Base7Tester {

    // 🔴 Replace with your solution
    static String solve(int n){

        if(n==0) return "0";

        boolean sign = (n<0)? true: false;

        if(sign) n= -1*n;

        String s="";

        while(n!=0){

            int num = n%7;
            s = ((char)('0'+num)) + s;
            n/=7;

        }

        if(sign) return "-" + s;

        return s;
    }

    public static void main(String[] args) {

        int[] testCases = {
                0,1,6,7,8,
                13,14,15,
                49,50,100,343,
                999,1000,5000,
                -7,-15,2401,
                2147483647,196
        };

        for(int i=0;i<testCases.length;i++){

            int n = testCases[i];

            System.out.println("Test Case " + (i+1));
            System.out.println("Input  : " + n);
            System.out.println("Output : " + solve(n));
            System.out.println("------------------");
        }
    }
}


/* 47. Given a large number convert it to the base 7 */