import java.util.*;

public class rotateMatrix {

    static void rotate(int mat[][], int d) {
        // Code Here

        if (d % 360 == 0)
            return;

        for (int k = 1; k <= (d % 360) / 90; k++) {

            int row = mat.length, col = mat[0].length;

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (i < j) {
                        int temp = mat[i][j];
                        mat[i][j] = mat[j][i];
                        mat[j][i] = temp;
                    }
                }
            }

            for (int i = 0; i < row; i++) {
                int left = 0;
                int right = mat[0].length - 1;

                while (left < right) {
                    int temp = mat[i][left];
                    mat[i][left] = mat[i][right];
                    mat[i][right] = temp;
                    left++;
                    right--;
                }
            }
        }

    }

    public static int[][] matrixCopy(int[][] mat) {

        int[][] result = new int[mat.length][mat[0].length];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                result[i][j] = mat[i][j];
            }
        }

        return result;
    }

    public static void main(String[] args) {

        List<int[][]> matrices = new ArrayList<>();
        int[] degrees = { 90, 180, 270, 360 };

        // ---------- 1x1 ----------
        matrices.add(new int[][] {
                { 5 }
        });

        // ---------- 2x2 ----------
        matrices.add(new int[][] {
                { 1, 2 },
                { 3, 4 }
        });

        // ---------- 3x3 ----------
        matrices.add(new int[][] {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        });

        // ---------- 3x3 with random ----------
        matrices.add(new int[][] {
                { 9, 8, 7 },
                { 6, 5, 4 },
                { 3, 2, 1 }
        });

        // ---------- 4x4 ----------
        matrices.add(new int[][] {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 }
        });

        // ---------- negatives ----------
        matrices.add(new int[][] {
                { -1, -2, -3 },
                { -4, -5, -6 },
                { -7, -8, -9 }
        });

        // ---------- zeros ----------
        matrices.add(new int[][] {
                { 0, 0, 0 },
                { 0, 0, 0 },
                { 0, 0, 0 }
        });

        // ---------- duplicates ----------
        matrices.add(new int[][] {
                { 2, 2, 2 },
                { 2, 2, 2 },
                { 2, 2, 2 }
        });

        // ---------- 5x5 large ----------
        matrices.add(new int[][] {
                { 1, 2, 3, 4, 5 },
                { 6, 7, 8, 9, 10 },
                { 11, 12, 13, 14, 15 },
                { 16, 17, 18, 19, 20 },
                { 21, 22, 23, 24, 25 }
        });

        int caseNo = 1;

        for (int[][] matrix : matrices) {

            for (int d : degrees) {

                System.out.println("Test Case " + caseNo++);
                System.out.println("Degree : " + d);

                System.out.println("Input Matrix:");
                print(matrix);

                // 👉 CALL YOUR METHOD HERE

                int[][] copy = matrixCopy(matrix);

                rotate(copy, d);

                System.out.println("Output Matrix:");
                print(copy);

                System.out.println("---------------------------\n");
            }
        }
    }

    static void print(int[][] mat) {
        for (int[] row : mat) {
            System.out.println(Arrays.toString(row));
        }
    }
}

// 91. Write a program to rotate an n*n matrix 90,180,270,360 degree.
// https://www.geeksforgeeks.org/inplace-rotate-square-matrix-by-90-degrees/ is
// the solution for rotating a matrix 90 degree. For rotating the matrix
// 180,270,360 degree, u need to call the same method 2,3,4 times based on the
// input.