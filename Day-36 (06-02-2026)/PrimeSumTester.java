
public class PrimeSumTester {

    // 🔴 replace with your solution
    static boolean solve(int n){

        if(n<4) return false;

        boolean[] arr = new boolean[n+1];


        for(int i=2;i<=n;i++){

            if(!arr[i]){
                for(int j=i*2;j<=n;j+=i){
                    arr[j]=true;
                }
            }
        }


        for(int i=2;i<=n-2;i++){
            if(!arr[i] && !arr[n-i]) return true;
        }


        return false;
    }

    public static void main(String[] args) {

        int[] testCases = {
            2,3,4,5,6,
            7,8,9,10,11,
            23,34,
            50,100,200,
            27,29,33,
            1,0,-10,
            1000,999,997,10000
        };

        for(int i=0;i<testCases.length;i++){
            int n = testCases[i];

            System.out.println("Test Case " + (i+1));
            System.out.println("Input  : " + n);
            System.out.println("Output : " + (solve(n) ? "YES" : "NO"));
            System.out.println("------------------");
        }
    }
}
/* 
67. Write a program to determine whether a given number can be expressed as sum of
two prime numbers or not.
For example 34 can be expressed as sum of two prime numbers but 23 cannot be.

 */