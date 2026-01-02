public class word_search {
    
    public static boolean traverse(char[][] board, int[][] vis, int i, int j, char[] word, int ind, int[][] path) {

        if (ind == word.length) {
            return true;

        }
        vis[i][j] = 1;

        for (int[] p : path) {

            int x = p[0];
            int y = p[1];

            if (valid(i + x, j + y, vis) && vis[i + x][j + y] == 0 && board[i + x][j + y] == word[ind]) {
                if (traverse(board, vis, i + x, j + y, word, ind + 1, path)) {
                    return true;
                }
            }

        }

        vis[i][j] = 0;

        return false;

    }

    public static boolean valid(int i, int j, int[][] vis) {

        if (i < 0 || i >= vis.length)
            return false;
        if (j < 0 || j >= vis[0].length)
            return false;
        return true;
    }



    public static void main(String[] args) {

        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};

        String word = "SEE";
        
        int m = board.length;
        int n = board[0].length;
        int[][] vis = new int[m][n];

        char[] word_a = word.toCharArray();

        boolean ans=false;

        int[][] path = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word_a[0]) {
                    if (traverse(board, vis, i, j, word_a, 1, path)) {
                        ans = true;
                        break;
                    }
                }
            }
        }

        System.out.println(ans);

        
    }
}


/* 
79. Word Search
Solved
Medium
Topics
premium lock icon
Companies
Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

 

Example 1:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
Example 2:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true
Example 3:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false
 

Constraints:

m == board.length
n = board[i].length
1 <= m, n <= 6
1 <= word.length <= 15
board and word consists of only lowercase and uppercase English letters.
  */
