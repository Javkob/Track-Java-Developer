import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        String alphabet = "abcdefghijklmopqrstuvwxyz";
        String[] letters = alphabet.split("");
        String[] inputLetters = input.split("");
       if(alphabet.contains(input)){
           System.out.println("true");
       }else{
           System.out.println("false");
       }

    }
}