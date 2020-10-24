import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String date = scanner.next();
        String[] parts= date.split("-");
        System.out.println(parts[1] + "/" + parts[2] + "/" + parts[0]);
    }
}