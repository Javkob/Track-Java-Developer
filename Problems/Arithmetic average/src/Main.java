import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);

        int sum = 0;
        int count = 0;
        int i;
        int a = sc.nextInt();
        int b = sc.nextInt();

        for ( i = a ; i <= b; i++)
        {
            if (i % 3 == 0) {
                count++;
                sum = sum + i;
            }
        }

        sc.close();

        System.out.println((double) sum/count);
    }
}
