public class X_pattern {

    public static void solve(String s) {

        for (int i = 0; i < s.length(); i++) {

            int left = i;
            int right = s.length() - i - 1;
            for (int j = 0; j < s.length(); j++) {

                if (left == right && left == j) {
                    System.out.print(s.charAt(left));
                } else if (left == j || right == j) {
                    System.out.print(s.charAt(j));
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {

        String input = "geeksforgeeks";

        solve(input);
    }
}


/* 113. Write a program to print the following output for the given input. You can assume the
string is of odd length
Eg 1: Input: 12345
 Output:
1 5
 2 4
 3
 2 4
1 5
Eg 2: Input: geeksforgeeks
 Output:
g s
 e k
 e e
 k e
 s g
 f r
 o
 f r
 s g
 k e
 e e
 e k
g s  */
