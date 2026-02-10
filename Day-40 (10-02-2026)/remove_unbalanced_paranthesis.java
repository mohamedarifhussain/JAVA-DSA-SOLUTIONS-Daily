import java.util.Stack;

public class remove_unbalanced_paranthesis {

    public static String solve(String s) {

        String output = "";

        int[] arr = new int[s.length()];

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            int ind = i;

            if (s.charAt(ind) == ')') {
                if (st.isEmpty()) {
                    arr[ind] = 1;

                } else {
                    boolean isExpo = false;
                    if (!(s.charAt(st.peek()) == '(')) {
                        while (!st.isEmpty() && s.charAt(st.peek()) != '(') {
                            isExpo = true;
                            st.pop();
                        }

                        if (st.isEmpty())
                            arr[ind] = 1;

                        else if (!isExpo) {
                            arr[ind] = 1;
                            arr[st.peek()] = 1;
                            st.pop();
                        } else {
                            st.pop();
                        }
                    } else {
                        st.pop();
                    }
                }

            } else {
                st.push(i);
            }

        }

        while (!st.isEmpty()) {
            if(s.charAt(st.peek())=='(' || s.charAt(st.peek())==')')
            arr[st.peek()] = 1;
            st.pop();
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0)
                output = output + s.charAt(i);
        }

        return output;

    }

    public static void main(String[] args) {

        String[][] tests = {

                // -------- Given examples --------
                { "((abc)((de))", "((abc)(de))" },
                { "(((ab)", "(ab)" },

                // -------- Basic balanced --------
                { "(a+b)", "(a+b)" },
                { "((a+b))", "((a+b))" },

                // -------- Extra opening --------
                { "((a)", "(a)" },
                { "(((a+b)", "(a+b)" },
                { "(((", "" },

                // -------- Extra closing --------
                { "a+b)", "a+b" },
                { "))(a+b)", "(a+b)" },
                { ")))", "" },

                // -------- Mixed imbalance --------
                { "(()))(", "()()" },
                { "((a+b))(", "((a+b))" },
                { "((a+b)))", "((a+b))" },
                { "())(()", "()()" },

                // -------- Letters only --------
                { "abc", "abc" },
                { "(abc", "abc" },
                { "abc)", "abc" },

                // -------- Nested complex --------
                { "((abc)((de)))", "((abc)((de)))" },
                { "((abc)((de)))))", "((abc)((de)))" },
                { "((((abc)((de))", "((abc)(de))" },

                // -------- Edge small --------
                { "(", "" },
                { ")", "" },
                { "()", "()" },
                { "()()", "()()" },

                // -------- Multiple groups --------
                { "(a)(b)(c)", "(a)(b)(c)" },
                { "((a))(b))(", "((a))(b)" },
                { "((a)(b)(c)", "(a)(b)(c)" },

                // -------- Deep nesting --------
                { "((((a))))", "((((a))))" },
                { "(((((a))))", "((((a))))" },
                { "((((a)))))", "((((a))))" },

                // -------- Empty --------
                { "", "" },

                // -------- Only parentheses --------
                { "(()", "()" },
                { "())", "()" },
                { "()(()", "()()" },
                { "())()(", "()()" },

                // -------- Zoho tricky --------
                { "((x+y)*(z)))))", "((x+y)*(z))" },
                { "(((x)))(((", "(((x)))" },
                { ")(x+y)(", "(x+y)" },
                { "((a+b)(c+d)))((e)", "((a+b)(c+d))(e)" }
        };

        int caseNo = 1;

        for (String[] t : tests) {
            System.out.println("Test Case " + caseNo++);
            System.out.println("Input  : \"" + t[0] + "\"");
            System.out.println("Output : \"" + solve(t[0]) + "\"");
            System.out.println("---------------------------");
        }
    }
}