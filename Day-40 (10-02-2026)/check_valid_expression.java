import java.util.*;

public class check_valid_expression {

    public static boolean isAlpha(char i){
        return (i>='a' && i<='z') || (i>='A' && i<='Z');
    }

    public static boolean isOperand(char i){
        return (i=='+') || (i=='-') || (i=='*') || (i=='/') || (i=='^');
    }


    public static String solve(String s){

        Stack<Character> st = new Stack<>();

        char prev = ' ';

        for(int i = 0;i < s.length() ; i++){

            char cur = s.charAt(i);

            if(cur==' ') continue; // Spaces are ignored.

            if(cur=='('){
                st.push(cur);
            }
            else if(isOperand(cur) && (isOperand(prev) || prev=='(')){
                return "Invalid";
            }
            else if(cur==')'){

                if(prev=='(' || prev==' ' || isOperand(prev)) return "Invalid";

                while(!st.isEmpty() && st.peek()!='('){
                    st.pop();
                }
                if(st.isEmpty()) return "Invalid";
                st.pop();
            }
            else if(isAlpha(cur) && ((isAlpha(prev) || prev==' '))){
                return "Invalid";
            }
            else{
                st.push(cur);
            }

            prev =  cur;

        }

        if(st.isEmpty())

        return "Valid";

        return "Invalid";
        

        
    }

    public static void main(String[] args) {

        String[] testCases = {

                // ---------- Given examples ----------
                "(a+b)(a*b)",      // VALID
                "(ab)(ab+)",       // INVALID
                "((a+b)",          // INVALID

                // ---------- Basic valid ----------
                "(a+b)",
                "(a*b)",
                "(a/b)",
                "(a-b)",
                "((a+b)*(c-d))",
                "((a))",
                "(((a+b)))",

                // ---------- Missing bracket ----------
                "(a+b",
                "a+b)",
                "((a+b)*(c-d)",

                // ---------- Empty brackets ----------
                "()",
                "(())",

                // ---------- Consecutive operands ----------
                "(ab)",
                "(abc+d)",

                // ---------- Consecutive operators ----------
                "(a++b)",
                "(a+*b)",
                "(a--b)",
                "(a/**b)",

                // ---------- Operator at wrong place ----------
                "(+a)",
                "(a+)",
                "(*a+b)",
                "(a+b-)",

                // ---------- Operator near bracket ----------
                "(a+(b*))",
                "(a+(*b))",
                "((a+b)+)",
                "((+a+b))",

                // ---------- Complex valid ----------
                "((a+b)*(c+d))",
                "((a+b)*(c-d)/(e+f))",
                "(((a*b)+(c/d))-e)",
                "(a+(b*(c+(d/e))))",

                // ---------- Only operand ----------
                "(a)",

                // ---------- Deep nesting ----------
                "((((((a+b))))))",

                // ---------- Multiple groups ----------
                "(a+b)(c+d)",
                "(a*b)(c/d)(e-f)",

                // ---------- All operators mix ----------
                "(a+b-c*d/e)",

                // ---------- Edge small ----------
                "",
                "(",
                ")",
                "(((",
                ")))",

                // ---------- Weird spacing not allowed cases ----------
                "(a b)",
                "(a + b)"
        };


        int caseNo = 1;

        for (String exp : testCases) {

            System.out.println("Test Case " + caseNo++);
            System.out.println("Input  : \"" + exp + "\"");

            // 👉 CALL YOUR FUNCTION HERE
            // boolean result = isValid(exp);

            // temporarily printing placeholder
            System.out.println("Output :"+solve(exp));

            System.out.println("---------------------------");
        }
    }
}


