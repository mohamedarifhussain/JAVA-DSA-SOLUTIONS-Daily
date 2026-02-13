public class reverseString_recursion {


    public static String reverseString(String s){
        if(s.length()==0){
            return "";
        }

        return reverseString(s.substring(1)) + s.charAt(0);
    }


    public static String reverse(String str){

        if(str.isEmpty()){
            return str;
        }

        int ind = -1;

        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' '){
                ind = i;
                break;
            }
        }

        if(ind==-1){
            return str;
        }

        String firstWord = str.substring(0,ind);

        return reverse(str.substring(ind+1)) + " "+firstWord;
    }

    public static void main(String[] args) {

        String[] testCases = {

            // Basic
            "one two three",
            "hello world",
            "java is fun",

            // Single word
            "hello",
            "zoho",

            // Two words
            "one two",
            "first last",

            // Multiple words
            "this is a recursion problem",
            "zoho interview question practice",
            "practice makes a man perfect",

            // Leading and trailing spaces
            "  one two three  ",
            "   hello world",
            "java is fun   ",

            // Multiple spaces between words
            "one   two    three",
            "this    is     zoho",

            // Empty and space-only
            "",
            " ",
            "     ",

            // Mixed case
            "One Two Three",
            "ZOHO Interview Round",

            // Numbers as words
            "one 1 two 2 three 3",
            "2024 is coming",

            // Special characters inside words
            "hello@world zoho#interview",
            "a+b c-d e*f",

            // Long sentence
            "recursion is very important for solving interview problems",

            // Repeated words
            "one one one",
            "test test case test",

            // Edge tricky cases
            "a",
            "a b",
            "a   b   c",
            "   a   b   c   "
        };

        int tc = 1;
        for (String input : testCases) {
            System.out.println("Test Case " + tc++);
            System.out.println("Input  : \"" + input + "\"");

            // 👉 Call your recursive function here
            String output = reverse(input);

            System.out.println("Output : "+output);
            System.out.println("---------------------------");
        }


        System.out.println(reverseString("Arif"));
    }
}


/* 87. Given a string, change the order of words in the string (last string should come first).
Should use RECURSION

Sample: one two three
Output : three two one  */