import java.util.*;

public class remove_duplicate_row {

        static void solve(int[][] mat) {

                System.out.println("Output Matrix: ");

                HashMap<Integer, Integer> map = new HashMap<>();

                int row = mat.length, col = (row > 0) ? mat[0].length : -1;

                for (int i = 0; i < row; i++) {

                        ArrayList<Integer> arr = new ArrayList<>();

                        int sum = 0;
                        for (int j = 0; j < col; j++) {
                                sum = sum * 10 + mat[i][j];
                                arr.add(mat[i][j]);
                        }

                        if (map.getOrDefault(sum, -1) == -1) {
                                System.out.println(arr);
                                map.put(sum, i);
                        }

                }

                System.out.println();

        }

        static void printMatrix(int[][] matrix) {

                for (int[] row : matrix) {
                        System.out.println(Arrays.toString(row));
                }
        }

        public static void main(String[] args) {

                ArrayList<int[][]> tests = new ArrayList<>();

                // 1. Given example
                tests.add(new int[][] {
                                { 1, 0, 1 },
                                { 1, 1, 0 },
                                { 1, 1, 1 },
                                { 1, 0, 1 }
                });

                // 2. All unique
                tests.add(new int[][] {
                                { 1, 0, 0 },
                                { 0, 1, 0 },
                                { 0, 0, 1 }
                });

                // 3. All identical
                tests.add(new int[][] {
                                { 1, 1, 1 },
                                { 1, 1, 1 },
                                { 1, 1, 1 },
                                { 1, 1, 1 }
                });

                // 4. Single row
                tests.add(new int[][] {
                                { 1, 0, 1, 0 }
                });

                // 5. Single column
                tests.add(new int[][] {
                                { 1 },
                                { 0 },
                                { 1 },
                                { 0 },
                                { 1 }
                });

                // 6. Two identical rows
                tests.add(new int[][] {
                                { 0, 0, 0, 0, 0 },
                                { 0, 0, 0, 0, 0 }
                });

                // 7. Alternating duplicates
                tests.add(new int[][] {
                                { 1, 0, 1, 0 },
                                { 0, 1, 0, 1 },
                                { 1, 0, 1, 0 },
                                { 0, 1, 0, 1 },
                                { 1, 0, 1, 0 }
                });

                // 8. All zeros
                tests.add(new int[][] {
                                { 0, 0, 0, 0 },
                                { 0, 0, 0, 0 },
                                { 0, 0, 0, 0 }
                });

                // 9. All ones
                tests.add(new int[][] {
                                { 1, 1, 1, 1 },
                                { 1, 1, 1, 1 },
                                { 1, 1, 1, 1 }
                });

                // 10. Mixed complex
                tests.add(new int[][] {
                                { 1, 0, 1, 1 },
                                { 0, 1, 1, 0 },
                                { 1, 0, 1, 1 },
                                { 1, 1, 0, 0 },
                                { 0, 1, 1, 0 },
                                { 1, 1, 1, 1 }
                });

                // 11. Empty matrix
                tests.add(new int[][] {});

                // 12. 1x1
                tests.add(new int[][] {
                                { 0 }
                });

                // 13. Many repeats
                tests.add(new int[][] {
                                { 1, 0, 0 },
                                { 0, 1, 1 },
                                { 1, 0, 0 },
                                { 0, 1, 1 },
                                { 1, 0, 0 },
                                { 0, 1, 1 },
                                { 1, 0, 0 },
                                { 0, 1, 1 }
                });

                // 14. Large width rows
                tests.add(new int[][] {
                                { 1, 0, 1, 0, 1, 0, 1, 0 },
                                { 1, 0, 1, 0, 1, 0, 1, 0 },
                                { 0, 1, 0, 1, 0, 1, 0, 1 }
                });

                // 15. All unique large
                tests.add(new int[][] {
                                { 1, 0, 0, 0, 0 },
                                { 0, 1, 0, 0, 0 },
                                { 0, 0, 1, 0, 0 },
                                { 0, 0, 0, 1, 0 },
                                { 0, 0, 0, 0, 1 }
                });

                // 16. Duplicate first and last
                tests.add(new int[][] {
                                { 1, 0, 0 },
                                { 0, 1, 1 },
                                { 1, 1, 0 },
                                { 1, 0, 0 }
                });

                // 17. Random
                tests.add(new int[][] {
                                { 1, 1, 0, 1, 0 },
                                { 0, 1, 1, 0, 1 },
                                { 1, 1, 0, 1, 0 },
                                { 1, 0, 0, 0, 1 },
                                { 0, 1, 1, 0, 1 },
                                { 0, 0, 0, 1, 1 }
                });

                // 18. One row repeated many times
                tests.add(new int[][] {
                                { 1, 0 },
                                { 1, 0 },
                                { 1, 0 },
                                { 0, 1 },
                                { 1, 0 }
                });

                // 19. Stress small repeating
                tests.add(new int[][] {
                                { 1, 0, 1 },
                                { 0, 1, 0 },
                                { 1, 0, 1 },
                                { 0, 1, 0 },
                                { 1, 0, 1 },
                                { 0, 1, 0 },
                                { 1, 0, 1 },
                                { 0, 1, 0 },
                                { 1, 0, 1 },
                                { 0, 1, 0 }
                });

                // 20. Checkerboard
                tests.add(new int[][] {
                                { 1, 0, 1, 0 },
                                { 0, 1, 0, 1 },
                                { 1, 0, 1, 0 },
                                { 0, 1, 0, 1 }
                });

                for (int t = 0; t < tests.size(); t++) {
                        System.out.println("Test Case " + (t + 1));

                        int[][] input = tests.get(t);

                        printMatrix(input);

                        solve(input); // your method

                }

        }

}

/*
 * 56. Given a two dimensional array which consists of only 0’s and 1’s. Print
 * the matrix
 * without duplication.
 * Ex. INPUT :
 * 
 * Enter Row Size : 4
 * Enter column size : 3
 * Enter the matrix :
 * 1 0 1
 * 1 1 0
 * 1 1 1
 * 1 0 1
 * 
 * OUTPUT :
 * 
 * Unique Matrix :
 * 1 0 1
 * 1 1 0
 * 
 * 1 1 1
 */
