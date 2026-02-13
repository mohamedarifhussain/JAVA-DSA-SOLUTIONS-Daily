
public class StudentDataFilterTestCases {

    static void print(int[][] students, int i) {

        for (int j = 0; j < students[0].length; j++) {
            System.out.print(students[i][j] + " ");
        }
        System.out.println();
    }

    static void filterAndPrint(int[][] students, String i1, String i2) {

        int num = 0;

        int start = 2;

        if((i2.charAt(1)=='<' || i2.charAt(1)=='>') && i2.charAt(2)=='='){
            start = 3;
        }

        for (int j = start; j < i2.length(); j++) {
            num = num * 10 + (i2.charAt(j) - '0');
        }

        char ch = i2.charAt(0);

            if(ch=='R'){
                ch = (char)('A'-1);
            }

        


        if (i1.equals("*")) {
            

            for (int i = 0; i < students.length; i++) {
                int mark = students[i][ch - 'A' + 1];
                

                if(start==3){

                    if(i2.charAt(1)=='<' && mark<=num){
                        print(students, i);
                    }
                    else if(i2.charAt(1)=='>' && mark>=num){
                        print(students, i);
                    }
                }

                else if (i2.charAt(1) == '<') {
                    if (mark < num) {
                        print(students, i);
                    }
                } else if (i2.charAt(1) == '>') {
                    if (mark > num) {
                        print(students, i);
                    }
                } else if (i2.charAt(1) == '=') {
                    if (mark == num) {
                        print(students, i);
                    }
                }
                
            }
        } else {


            for (int i = 0; i < students.length; i++) {
                int mark = students[i][ch - 'A' + 1];

                char r = i1.charAt(0);

                if(r=='R'){
                    r = 'A'-1;
                }

                int out = students[i][ r- 'A'+1];

                if(start==3){

                    if(i2.charAt(1)=='<' && mark<=num){
                        System.out.println(out);
                    }
                    else if(i2.charAt(1)=='>' && mark>=num){
                        System.out.println(out);
                    }
                }

                else if (i2.charAt(1) == '<') {
                    if (mark < num) {
                        System.out.println(out);
                    }
                } else if (i2.charAt(1) == '>') {
                    if (mark > num) {
                        System.out.println(out);
                    }
                } else if (i2.charAt(1) == '=') {
                    if (mark == num) {
                        System.out.println(out);
                    }
                }
            }

        }

        System.out.println();

    }

    static int[][] students = {
            { 1, 56, 67, 89 },
            { 2, 89, 54, 90 },
            { 3, 78, 91, 83 },
            { 4, 69, 72, 95 },
            { 5, 90, 90, 90 },
            { 6, 40, 30, 20 },
            { 7, 100, 100, 100 },
            { 8, 0, 0, 0 }
    };

    static String[] headers = { "R", "A", "B", "C" };

    public static void main(String[] args) {

        String[][] testCases = {

                // ---------- BASIC ----------
                { "*", "A>70" },
                { "A", "C<90" },
                { "B", "B>80" },
                { "C", "C=90" },

                // ---------- ROLL NO ----------
                { "R", "R>3" },
                { "*", "R=1" },
                { "*", "R<5" },

                // ---------- EDGE MARKS ----------
                { "*", "A=0" },
                { "*", "B=0" },
                { "*", "C=0" },
                { "*", "A=100" },

                // ---------- ALL FAIL ----------
                { "*", "A>150" },
                { "*", "B<0" },

                // ---------- MULTIPLE MATCH ----------
                { "A", "A>=90" },
                { "*", "B=90" },
                { "C", "C>85" },

                // ---------- SINGLE COLUMN OUTPUT ----------
                { "A", "A>60" },
                { "B", "B<70" },
                { "C", "C>=95" },

                // ---------- ALL FIELDS ----------
                { "*", "C>=83" },
                { "*", "A<=69" },

                // ---------- LOWER BOUND ----------
                { "*", "A>=0" },
                { "*", "B>=0" },
                { "*", "C>=0" },

                // ---------- STRICT ----------
                { "R", "A=56" },
                { "*", "B=54" },
                { "*", "C=95" }
        };



        // filterAndPrint(students, testCases[21][0], testCases[21][1]);

        int tc = 1;

        for (String[] test : testCases) {

            System.out.println("Test Case " + tc++);
            System.out.println("Print Field : " + test[0]);
            System.out.println("Condition   : " + test[1]);
            System.out.println("Output:");

            // 👉 CALL YOUR FUNCTION HERE
            // Example:
            filterAndPrint(students, test[0], test[1]);

            System.out.println("----------------------------------");
        }
    }
}

/*
 * O/P: 2 89 54 90 3 78 91 83 O/P: 56 78 30. Student Data Filter Dynamically
 * display selected fields (Roll No, MarksA, MarksB, MarksC) from a list of
 * students, based on user-specified criteria. R-Rollno, A, B, C - Marks in
 * three subjects RABC 1 56 67 89 2 89 54 90 3 78 91 83 4 69 72 95 Given the
 * list of student records, print the result of the queries based on the
 * following syntax, The first input string has a single character denoting the
 * field to be printed. * - All fields of the selected rows A-Print only field A
 * B -Print only field B C- Print only field C The second string contains the
 * condition - <field><relational_operator><value>. >- Greater than < - Less
 * than = - Equal to I/P: * A>70 I/P: A C<90
 */