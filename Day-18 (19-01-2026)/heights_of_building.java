import java.util.Arrays;

public class heights_of_building {

    public static int longest(int arr[]) {
        // write code here
        
        int maxheight=0;
        int count=0;
        
        for(int i=0;i<arr.length;i++){
            
            if(maxheight <= arr[i]){
                maxheight = arr[i];
                count++;
            }
            
        }
        
        return count;
    }


    public static void main(String[] args) {
        int[] arr = {3, 4, 1, 0, 6, 2, 3};
        int output = longest(arr);

        System.out.println("Input: "+Arrays.toString(arr));
        System.out.println("Output: "+output);
    }
    
}
