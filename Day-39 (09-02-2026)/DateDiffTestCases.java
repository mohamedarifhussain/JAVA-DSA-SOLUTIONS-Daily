public class DateDiffTestCases {


    static boolean isLeap(int year){

        if(year%400 == 0) return true;
        else if(year%100==0) return false;
        else if(year%4==0) return true;

        return false;

    }

    public static String solve(int[] d1,int[] d2){

        int[] month = {0,31,28,31,30,31,30,31,31,30,31,30,31};


        int days = 0, months=0, year=0;

        while(d2[0] < d1[0]){

            int add = 0;

            if((d2[1]-1==2) && isLeap(d2[2])){
                add += 29;
            }
            else{
                add +=  month[((d1[1]-1 == 0)? 12 : d1[1]-1)];
            }

            d2[0] += add;

            d2[1]-=1;
            
        }

        while(d2[1] < d1[1]){
            d2[1] += 12;
            d2[2]-=1;

        }

        days = d2[0]-d1[0];
        months = d2[1]-d1[1];
        year = d2[2]-d1[2];

        return year+" years, "+months+" months, "+days+" days.";

    }

    public static void main(String[] args) {

        // date1 -> {day, month, year}
        int[][] date1 = {

            {10,2,2014},
            {10,2,2000},
            {10,2,2000},

            {1,5,2020},
            {10,5,2020},

            {1,1,2020},
            {1,1,2020},

            {28,2,2020},
            {29,2,2020},
            {1,3,2019},

            {28,2,2019},

            {31,1,2020},
            {30,4,2021},

            {15,8,2019},

            {1,1,2000},
            {15,6,1995},

            {28,2,1900},
            {28,2,2000},

            {31,12,2020},
            {31,3,2021},

            {5,7,2022},
            {9,9,1999},
            {25,12,2010},

            {29,2,2016}
        };


        int[][] date2 = {

            {10,3,2015},
            {10,3,2000},
            {10,2,2000},

            {10,5,2020},
            {20,5,2020},

            {1,12,2020},
            {31,12,2020},

            {1,3,2020},
            {1,3,2020},
            {1,3,2020},

            {1,3,2019},

            {1,3,2020},
            {1,5,2021},

            {10,2,2020},

            {1,1,2025},
            {10,9,2020},

            {1,3,1900},
            {1,3,2000},

            {1,1,2021},
            {30,4,2021},

            {18,11,2024},
            {9,9,2009},
            {1,1,2011},

            {28,2,2017}
        };



        // PRINT
        for(int i=0;i<date1.length;i++){

            System.out.println("Test Case " + (i+1));
            System.out.println("Date2 : " + java.util.Arrays.toString(date2[i]));
            System.out.println("Date1 : " + java.util.Arrays.toString(date1[i]));
            System.out.println("Difference : "+ solve(date1[i],date2[i]) );
            System.out.println("--------------------------");

           
        }
    }
}
/* 
18. Given two dates, find total number of days between them.
Input: dt1 = {10, 2, 2014} dt2 = {10, 3, 2015}
Output: 393
dt1 represents “10-Feb-2014” and dt2 represents “10-Mar-2015” The difference is 365 +
28
Input: dt1 = {10, 2, 2000} dt2 = {10, 3, 2000}
Output: 29
Note that 2000 is a leap year
Input: dt1 = {10, 2, 2000} dt2 = {10, 2, 2000}
Output: 0
Both dates are same
Input: dt1 = {1, 2, 2000}; dt2 = {1, 2, 2004};
Output: 1461
Number of days is 365*4 + 
 */