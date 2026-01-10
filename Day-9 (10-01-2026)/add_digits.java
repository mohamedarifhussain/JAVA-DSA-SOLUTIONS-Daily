public class add_digits {
    

    public static int addDigits(int num) {
        int result = num;
        while (!(result < 10)) {
            int sum = 0, temp = result;
            while (temp != 0) {
                sum += temp % 10;
                temp /= 10;
            }
            result = sum;
        }
        return result;
    }

    public static void main(String[] args) {
        int num = 25789;

        int output = addDigits(num);

        System.out.println("Input: num="+num);
        System.out.println("Ouput: "+output);
    }
}
