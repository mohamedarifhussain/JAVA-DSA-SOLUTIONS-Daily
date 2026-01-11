public class solve_suduko_hard {

    public static boolean solveSudoku(char[][] board) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (int k = 0; k < 9; k++) {
                        if (valid(board, i, j, (char) ('1' + k))) {
                            board[i][j] = (char) ('1' + k);
                            if (solveSudoku(board)) {
                                return true;
                            }
                            board[i][j]='.';
                        }
                    }
                    return false;
                }
            }
        }

        return true;

    }

    public static boolean valid(char[][] board, int i, int j, char num) {

        for (int x = 0; x < 9; x++) {
            if (board[i][x] == num)
                return false;
            if (board[x][j] == num)
                return false;
        }

        int r = (i / 3) * 3;
        int c = (j / 3) * 3;
        for (int x = r; x < r + 3; x++) {
            for (int y = c; y < c + 3; y++) {
                if (board[x][y] == num)
                    return false;
            }
        }

        return true;

    }

    public static void printSudoku(char[][] board) {

        for (int i = 0; i < 9; i++) {
        if (i % 3 == 0 && i != 0) {
            System.out.println("---------------------");
        }
        for (int j = 0; j < 9; j++) {

            if (j % 3 == 0 && j != 0) {
                System.out.print("| ");
            }

            System.out.print(board[i][j] + " ");
        }
        System.out.println();
    }
    }

    public static void main(String[] args) {

        char[][] board = {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };

        System.out.println("Input Sudoku");
        System.out.println();
        printSudoku(board);

        solveSudoku(board);
        System.out.println();
        System.out.println("Output Sudoku");
        System.out.println();
        printSudoku(board);
        

    }

}
