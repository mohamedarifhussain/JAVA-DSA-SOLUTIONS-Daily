import java.util.ArrayList;

public class word_boggle {

    public static boolean search(char[][] grid, String word, int l, int i, int j, int[][] vis, int[][] path) {

        if (l == word.length()) {
            return true;
        }

        vis[i][j] = 1;

        for (int k = 0; k < path.length; k++) {

            int x = path[k][0];
            int y = path[k][1];

            if (valid(i + x, j + y, vis) && grid[i + x][j + y] == word.charAt(l)) {
                if (search(grid, word, l + 1, i + x, j + y, vis, path)) {
                    vis[i][j] = 0;
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

        if (vis[i][j] == 1)
            return false;
        return true;
    }

    public static void main(String[] args) {

        char[][] board = {
                { 'G', 'I', 'Z' },
                { 'U', 'E', 'K' },
                { 'Q', 'S', 'E' }
        };

        String[] dictionary = {
                "GEEKS",
                "FOR",
                "QUIZ",
                "GO"
        };

        int m = board.length, n = board[0].length;

        int[][] vis = new int[m][n];
        int[][] path = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 }, { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };

        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (String s : dictionary) {
                    if (!ans.contains(s) && s.charAt(0) == board[i][j]) {
                        if (search(board, s, 1, i, j, vis, path)) {
                            ans.add(s);
                        }
                    }
                }
            }
        }

        System.out.println(ans);

    }
}

/*
 * Word Boggle
 * Difficulty: MediumAccuracy: 15.85%Submissions: 91K+Points: 4Average Time: 20m
 * Given a dictionary of N distinct words and an R x C board where each cell
 * contains one character, find all possible words from the dictionary that can
 * be formed by a sequence of adjacent characters on the board.
 * 
 * 
 * We can move to any of the 8 adjacent cells (horizontally, vertically, or
 * diagonally). A cell may be used only once while forming a single word.
 * 
 * Examples :
 * 
 * Input: N = 1, dictionary = ["CAT"], R = 3, C = 3,
 * board[][] = [[C, A, P], [A, N, D], [T, I, E]]
 * Output: CAT
 * Explanation:
 * 
 * Input: N = 4, dictionary = ["GEEKS","FOR","QUIZ","GO"], R = 3, C = 3,
 * board[][] = [[G, I, Z], [U, E, K], [Q, S, E]]
 * Output: GEEKS QUIZ
 * Explanation:
 * 
 * Constraints:
 * 1 ≤ N ≤ 15
 * 1 ≤ R, C ≤ 50
 * 1 ≤ length of Word ≤ 60
 * Each word can consist of both lowercase and uppercase letters.
 */
