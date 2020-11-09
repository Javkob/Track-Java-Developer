import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        double a, b, c, x1, x2;
        Scanner scanner = new Scanner(System.in);

        a = scanner.nextDouble();
        b = scanner.nextDouble();
        c = scanner.nextDouble();

        x1 = (-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a);
        x2 = (-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a);

        System.out.println(Math.min(x1, x2));
        System.out.println(Math.max(x1, x2));

        //x = (-b ± sqrt(b^2 - 4ac)) / 2a
    }
}