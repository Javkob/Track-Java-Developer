import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        double s = (a+b+c)/2.0;
        double x = (s * (s - a) * (s - b) * (s - c));
        double area = Math.sqrt(x);
        System.out.println(area);
        // put your code here
    }
}