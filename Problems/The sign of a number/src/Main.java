import java.util.Scanner;

public class Main {

    public static int sign(Integer number) {
        // write your code here
        return number.compareTo(0);
    }

    /* Do not change code below */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        System.out.println(sign(n));
    }
}