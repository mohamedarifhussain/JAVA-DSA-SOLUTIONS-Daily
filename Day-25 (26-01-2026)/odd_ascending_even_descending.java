import java.util.*;

public class odd_ascending_even_descending {

    static void swap(int i, int j, int[] arr) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }

    static int[] sort(int[] arr) {

        int len = arr.length;

        int c = 0;

        for(int i=0;i<len;i++){
            if( arr[i]%2==1 || arr[i]%2==-1) c++;
            
        }
        
        for (int i = 0; i < c; i++) {
            
            int ind = i;
            for(int j=i;j<len;j++){
                if(arr[j]%2==1 || arr[j]%2==-1){
                    if(arr[ind]%2==0 || arr[ind]>arr[j])
                    ind = j;
                }
            }
            
            swap(i, ind, arr);
        }


        for(int i=c;i<len;i++){
            int ind = i;
            for(int j=i;j<len;j++){
                if(arr[ind]<arr[j]){
                    ind = j;
                }
            }
            
            swap(i, ind, arr);
        }

        
        return arr;

    }

    public static void main(String[] args) {

        int[][] testCases = {
                { 5, 8, 11, 6, 2, 1, 7 },
                { 9, 7, 5, 3, 1 },
                { 8, 6, 4, 2 },
                { 5 },
                { 8 },
                { 2, 1 },
                { 1, 3, 5, 8, 6, 4 },
                { 11, 9, 7, 2, 4, 6, 8 },
                { 0, 5, 2, 7, 4 },
                { 0, 0, 1, 3, 2, 4 },
                { -5, -2, -7, -8, 3, 4 },
                { -9, -7, -5, -3 },
                { -10, -6, -2, -4 },
                { 5, 5, 2, 2, 7, 7, 4, 4 },
                { 100, 101, 102, 103, 104 },
                { 1, 2, 3, 4, 5, 6, 7, 8 },
                { 12, 3, 17, 8, 9, 14, 21 },
                { 3, 3, 3, 3 },
                { 6, 6, 6, 6 },
                {},
                { 0 },
                { 23, 44, 12, 9, 78, 55, 32, 11, 90, 1 }
        };

        for (int i = 0; i < testCases.length; i++) {
            int[] input = Arrays.copyOf(testCases[i], testCases[i].length);

            System.out.println("Test Case " + (i + 1));
            System.out.println("Input  : " + Arrays.toString(input));
            System.out.println("Output : " + Arrays.toString(sort(input)));
            System.out.println("--------------------------------");

        }
    }
}
/*
 * 21.sort the array odd numbers in ascending and even numbers in descending.
 * I/p 5 8 11 6 2 1 7
 * O/p 1 5 7 11 8 6 2
 */
