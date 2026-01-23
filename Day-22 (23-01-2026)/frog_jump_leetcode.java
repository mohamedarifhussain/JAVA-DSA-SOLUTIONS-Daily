import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class frog_jump_leetcode {
    
    public static boolean isValid(HashMap<Integer, ArrayList<Integer>> map, int ind, int prev) {

        for (int i : map.get(ind)) {
            if (i == ind + prev)
                return false;
        }
        return true;

    }

    public static boolean cross(HashMap<Integer, ArrayList<Integer>> map, int target, int ind, int prev) {

        if (ind > target)
            return false;

        if (ind == target) {
            return true;
        }

        if (!(map.get(ind + prev + 1) == null) && isValid(map, ind, prev + 1)) {
            map.get(ind).add(ind + prev + 1);
            if (cross(map, target, ind + prev + 1, prev + 1)) {
                return true;
            }

        }

        if (!(map.get(ind + prev) == null) && isValid(map, ind, prev)) {
            map.get(ind).add(ind + prev);
            if (cross(map, target, ind + prev, prev)) {
                return true;
            }

        }

        if ((prev > 1) && !(map.get(ind + prev - 1) == null) && isValid(map, ind, prev - 1)) {
            map.get(ind).add(ind + prev - 1);
            if (cross(map, target, ind + prev - 1, prev - 1))
                return true;

        }

        return false;

    }

    public static boolean canCross(int[] stones) {

        if (stones[1] != 1)
            return false;

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 1; i < stones.length; i++) {
            map.put(stones[i], new ArrayList<>());
        }

        return cross(map, stones[stones.length - 1], 1, 1);

    }

    public static void main(String[] args) {
        
        int[] input = {0,1,3,5,6,8,12,17};
        boolean output = canCross(input);

        
        System.out.println("Input: "+Arrays.toString(input));
        System.out.println("Output: "+output);
    }
}

/* 403. Frog Jump
Solved
Hard
Topics
premium lock icon
Companies
A frog is crossing a river. The river is divided into some number of units, and at each unit, there may or may not exist a stone. The frog can jump on a stone, but it must not jump into the water.

Given a list of stones positions (in units) in sorted ascending order, determine if the frog can cross the river by landing on the last stone. Initially, the frog is on the first stone and assumes the first jump must be 1 unit.

If the frog's last jump was k units, its next jump must be either k - 1, k, or k + 1 units. The frog can only jump in the forward direction.

 

Example 1:

Input: stones = [0,1,3,5,6,8,12,17]
Output: true
Explanation: The frog can jump to the last stone by jumping 1 unit to the 2nd stone, then 2 units to the 3rd stone, then 2 units to the 4th stone, then 3 units to the 6th stone, 4 units to the 7th stone, and 5 units to the 8th stone.
Example 2:

Input: stones = [0,1,2,3,4,8,9,11]
Output: false
Explanation: There is no way to jump to the last stone as the gap between the 5th and 6th stone is too large.
 

Constraints:

2 <= stones.length <= 2000
0 <= stones[i] <= 231 - 1
stones[0] == 0
stones is sorted in a strictly increasing order. */