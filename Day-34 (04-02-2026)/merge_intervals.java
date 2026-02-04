import java.util.*;

public class merge_intervals {
    



    public static int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));       
        
        int i=0,j=1;

        while(j<intervals.length){

            if(i<j && j<intervals.length){

                int a = intervals[i][0];
                int b = intervals[i][1];
                int c = intervals[j][0];
                int d = intervals[j][1];

                if((a<=c && c<=b) || (c<=b && b<=d)){
                    intervals[i][0] = Math.min(a,b);
                    intervals[i][1]= Math.max(b,d);   
                    intervals[j][0]=-1;
                    intervals[j][1]=-1;   
                }
                else{
                    i=j;
                }
                j++;
            }
           

        }

        int ind=0,count=0;

        for(int[] r: intervals){
            if(r[0]!=-1){
                count++;
            }
        }
        int[][] result = new int[count][2];
        for(int[] r: intervals){
            if(r[0]!=-1){
                result[ind] = r;
                ind++;
            }
        }

        return result;
        
    }



    public static void main(String[] args) {
        
        int[][] intervals = {
        {1,3},
        {2,6},
        {8,10},
        {15,18}
    };

    System.out.println("Input:");
    for(int[] row : intervals){
        System.out.println(Arrays.toString(row));
    }

    int[][] output = merge(intervals);

    System.out.println("\nMerged Output:");
    for(int[] row : output){
        System.out.println(Arrays.toString(row));
    }
    }

}


/* 56. Merge Intervals
Solved
Medium
Topics
premium lock icon
Companies
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

 

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
Example 3:

Input: intervals = [[4,7],[1,4]]
Output: [[1,7]]
Explanation: Intervals [1,4] and [4,7] are considered overlapping.
 

Constraints:

1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104
  */
