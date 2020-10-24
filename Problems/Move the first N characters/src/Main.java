import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner s = new Scanner(System.in);
        String str = s.next();
        int a = s.nextInt();
            if (a < str.length()) {
                System.out.println((str.substring(a) + "" + str.substring(0, a)));
            }else{
                System.out.println(str);
            }

    }
}