package bullscows;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static String pseudoRandomNumberGenerator(int secretCodeLenght){
        //spaghetti :)
        final StringBuilder output = new StringBuilder();
        Random random = new Random();
        String code = "";
        long pseudoRandomNumber = random.nextLong();
        if(secretCodeLenght <=10){

            code = String.valueOf(pseudoRandomNumber);
            code = code.replace("0","");
            for (int i = 0; i < code.length(); i++) {
                String character = code.substring(i, i + 1);
                if (output.indexOf(character) < 0) // if not contained
                    output.append(character);
            }
                code = output.toString().substring(0,secretCodeLenght);
            return code;
        }else{
            return "Error: can't generate a secret number with a length of 11 because there aren't enough unique digits.";
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String secretCode = "";
        String input = "";
        System.out.println("Please, enter the secret code's length:");
        int secretCodeLenght = scanner.nextInt();
        secretCode = pseudoRandomNumberGenerator(secretCodeLenght);
        String[] partsOfSecretCode = secretCode.split("");
        String[] partsOfInput;
        int turn = 1;
        if (secretCodeLenght>10){
            System.out.println(pseudoRandomNumberGenerator(secretCodeLenght));
        }else {
            System.out.println("Okay, let's start a game!");
            while (!input.contains(secretCode)) {
                System.out.println("Turn " + turn + ":");
                turn++;
                input = scanner.next();
                int bull = 0;
                int cow = 0;
                partsOfInput = input.split("");
                for (int i = 0; i < secretCodeLenght; i++) {
                    if (partsOfInput[i].equals(partsOfSecretCode[i])) {
                        bull++;
                    }
                }
                for (int j = 0; j < secretCodeLenght; j++) {
                    for (int k = 0; k < secretCodeLenght; k++) {
                        if (partsOfInput[j].equals(partsOfSecretCode[k])) {
                            cow++;
                        }
                    }
                }
                cow = cow - bull;
                if (cow > 0 && bull > 0) {
                    System.out.println("Grade: " + bull + " bull(s) and " + cow + " cow(s).");
                } else if (secretCode.contains(input)) {
                    System.out.println("Grade: " + bull + " bulls");
                    System.out.println("Congratulations! You guessed the secret code.");
                } else if (cow > 0) {
                    System.out.println("Grade: " + cow + " cow(s).");
                } else if (cow == 0 && bull == 0) {
                    System.out.println("Grade: " + "None.");
                } else if (bull > 0) {
                    System.out.println("Grade: " + bull + " bull(s).");
                }
            }
        }
    }
}
