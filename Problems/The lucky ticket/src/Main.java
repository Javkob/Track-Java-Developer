import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] array= input.split("");
        int sum1 = 0;
        int sum2 = 0;

        for (int i = 0; i < 3; i++) {
            sum1 = sum1 + Integer.valueOf(array[i]);
        }
        for (int j = 3; j < 6; j++) {
            sum2 = sum2 + Integer.valueOf(array[j]);
        }

        System.out.println((sum1==sum2)?"Lucky":"Regular");

    }
}