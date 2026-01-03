import java.util.ArrayList;
import java.util.Arrays;

public class find_string_in_grid {

    public static boolean search(char[][] grid, String word, int l, int i, int j, int[][] vis, int[] path) {

        if (l == word.length()) {
            return true;
        }

        vis[i][j] = 1;

        int x = path[0];
        int y = path[1];

        if (valid(i + x, j + y, vis) && grid[i + x][j + y] == word.charAt(l)) {
            if (search(grid, word, l + 1, i + x, j + y, vis, path)) {
                vis[i][j] = 0;
                return true;
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

        char[][] grid = {
                { 'a', 'b', 'a', 'b' },
                { 'a', 'b', 'e', 'b' },
                { 'e', 'b', 'e', 'b' }
        };

        String word = "abe";

        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

        int m = grid.length, n = grid[0].length;

        int[][] vis = new int[m][n];

        int[][] path = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 }, { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word.charAt(0) == grid[i][j]) {
                    boolean bool = false;
                    for (int k = 0; k < 8; k++) {
                        if (!bool && search(grid, word, 1, i, j, vis, path[k])) {
                            arr.add(new ArrayList<>(Arrays.asList(i, j)));
                            bool = true;
                        }
                    }
                }
            }
        }

        System.out.println(arr);

    }
}
