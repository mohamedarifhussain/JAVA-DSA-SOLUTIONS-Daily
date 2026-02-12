import java.util.*;

public class spiral_matrix_iv {

    // -------- ListNode Definition --------
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // 👉 Paste YOUR function here
    public static int[][] spiralMatrix(int m, int n, ListNode head) {

        int[][] ans = new int[m][n];

        int left = 0, right = n - 1;
        int top = 0, bottom = m - 1;

        while (left <= right && top <= bottom) {

            for (int i = left; i <= right; i++) {
                ans[top][i] = (head != null) ? head.val : -1;
                if (head != null) head = head.next;
            }
            top++;

            if (top > bottom) break;

            for (int i = top; i <= bottom; i++) {
                ans[i][right] = (head != null) ? head.val : -1;
                if (head != null) head = head.next;
            }
            right--;

            if (left > right) break;

            for (int i = right; i >= left; i--) {
                ans[bottom][i] = (head != null) ? head.val : -1;
                if (head != null) head = head.next;
            }
            bottom--;

            for (int i = bottom; i >= top; i--) {
                ans[i][left] = (head != null) ? head.val : -1;
                if (head != null) head = head.next;
            }
            left++;
        }

        return ans;
    }

    // -------- Helper: create linked list --------
    static ListNode buildList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int x : arr) {
            curr.next = new ListNode(x);
            curr = curr.next;
        }
        return dummy.next;
    }

    // -------- Helper: print matrix --------
    static void printMatrix(int[][] mat) {
        for (int[] row : mat) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void main(String[] args) {

        // ---------- TEST CASE 1: exact fit ----------
        int m1 = 3, n1 = 4;
        int[] list1 = {1,2,3,4,5,6,7,8,9,10,11,12};

        // ---------- TEST CASE 2: list shorter than matrix ----------
        int m2 = 3, n2 = 3;
        int[] list2 = {1,2,3,4,5};

        // ---------- TEST CASE 3: list longer than matrix ----------
        int m3 = 2, n3 = 2;
        int[] list3 = {1,2,3,4,5,6};

        // ---------- TEST CASE 4: single row ----------
        int m4 = 1, n4 = 5;
        int[] list4 = {1,2,3};

        // ---------- TEST CASE 5: single column ----------
        int m5 = 4, n5 = 1;
        int[] list5 = {1,2,3,4,5};

        // ---------- TEST CASE 6: 1x1 ----------
        int m6 = 1, n6 = 1;
        int[] list6 = {7};

        Object[][] tests = {
            {m1, n1, list1},
            {m2, n2, list2},
            {m3, n3, list3},
            {m4, n4, list4},
            {m5, n5, list5},
            {m6, n6, list6}
        };

        int tc = 1;
        for (Object[] t : tests) {
            int m = (int) t[0];
            int n = (int) t[1];
            int[] arr = (int[]) t[2];

            System.out.println("\nTest Case " + tc++);
            System.out.println("m = " + m + ", n = " + n);
            System.out.println("Linked List = " + Arrays.toString(arr));

            ListNode head = buildList(arr);
            int[][] result = spiralMatrix(m, n, head);
            printMatrix(result);
        }
    }
}


/* 
2326. Spiral Matrix IV
Solved
Medium
Topics
premium lock icon
Companies
Hint
You are given two integers m and n, which represent the dimensions of a matrix.

You are also given the head of a linked list of integers.

Generate an m x n matrix that contains the integers in the linked list presented in spiral order (clockwise), starting from the top-left of the matrix. If there are remaining empty spaces, fill them with -1.

Return the generated matrix.

 

Example 1:


Input: m = 3, n = 5, head = [3,0,2,6,8,1,7,9,4,2,5,5,0]
Output: [[3,0,2,6,8],[5,0,-1,-1,1],[5,2,4,9,7]]
Explanation: The diagram above shows how the values are printed in the matrix.
Note that the remaining spaces in the matrix are filled with -1.
Example 2:


Input: m = 1, n = 4, head = [0,1,2]
Output: [[0,1,2,-1]]
Explanation: The diagram above shows how the values are printed from left to right in the matrix.
The last space in the matrix is set to -1.
 
 */