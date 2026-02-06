import java.util.Arrays;

public class move_zeros_merge_duplicates
 {
    

static int[] solve(int[] nums){
    int x = 0;
        int len = nums.length;
        
        for(int i=0;i<len-1;i++){
            
            if(nums[i]!=0){
                if(nums[i]==nums[i+1]){
                    nums[i]+=nums[i];
                    nums[i+1]=0;
                }
                
                if(x<i && (nums[x]==0 && nums[i]!=0)){
                    nums[x] = nums[i];
                    nums[i] = 0;
                }
                x++;
            }
            else{
                if(nums[x]!=0 && nums[i+1]==0){
                    x=i+1;
                } 
            }
            
        }
        
        if(x<(len-1) && (nums[x]==0 && nums[len-1]!=0)){
            nums[x] = nums[len-1];
            nums[len-1] = 0;
            x++;
        }
        
        return nums;

    }

    public static void main(String[] args) {
       
int[][] testCases = {

            {2, 2, 0, 4, 0, 8},
            {0, 2, 2, 2, 0, 6, 6, 0, 0, 8},
            {1, 1},
            {5},
            {0},
            {},
            {0,0,0,0},
            {1,2,3,4},
            {4,4},
            {3,3,3},
            {2,2,4,4},
            {1,1,2,2,3,3},
            {8,8,8,8},
            {2,2,2,2,2},
            {2,0,2},
            {0,2,2,0,2},
            {0,0,3,3},
            {5,5,0,0},
            {1000000,1000000},
            {4,4,0,4,4,4,0,4}
        };

        for (int i = 0; i < testCases.length; i++) {

            int[] input = Arrays.copyOf(testCases[i], testCases[i].length);

            System.out.println("Test Case " + (i + 1));
            System.out.println("Input  : " + Arrays.toString(input));

            int[] output = solve(input);

            System.out.println("Output : " + Arrays.toString(output));
            System.out.println("----------------------------------");
        }
    }

    }


/* Given an array arr. Return the modified array in such a way that if the current and next numbers are valid numbers and are equal then double the current number value and replace the next number with 0. After the modification, rearrange the array such that all 0's are shifted to the end.

Note:

Assume ‘0’ as the invalid number and all others as a valid number.
The sequence of the valid numbers is present in the same order.
Example:

Input: arr[] = [2, 2, 0, 4, 0, 8] 
Output: [4, 4, 8, 0, 0, 0] 
Explanation: At index 0 and 1 both the elements are the same. So, we will change the element at index 0 to 4 and the element at index 1 is 0 then we will shift all the zeros to the end of the array. So, the array will become [4, 4, 8, 0, 0, 0].
Input: arr[] = [0, 2, 2, 2, 0, 6, 6, 0, 0, 8] 
Output: [4, 2, 12, 8, 0, 0, 0, 0, 0, 0]
Explanation: At index 5 and 6 both the elements are the same. So, we will change the element at index 5 to 12 and the element at index 6 is 0. We will change the element at index 1 to 4 and the element at index 2 is 0. Then we shift all the zeros to the end of the array. So, array will become [4, 2, 12, 8, 0, 0, 0, 0, 0, 0].
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)

Constraints:
1 ≤ arr.size() ≤ 105
1 ≤ arr[i] ≤ 106
  */
