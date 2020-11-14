import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scan = new Scanner(System.in);
        int currentMax = 0;
        while (scan.hasNext()) {
            int x = scan.nextInt();
            if (x % 4 == 0 && x > currentMax) {
                currentMax = x;
            }
        }
        System.out.println(currentMax);
    }
}