package bullscows;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static String pseudoRandomNumberGenerator(int secretCodeLenght,int symbolsRange){
        //spaghetti :)
        //and more spaghetti X_x
        final StringBuilder output = new StringBuilder();
        Random random = new Random();
        String code = "";
        long pseudoRandomNumber = random.nextLong();
        int lastRandomNum = 0;
        if(secretCodeLenght <=10){
            code = String.valueOf(pseudoRandomNumber);
            code = code.replace("-","");
            for (int i = 0; i < code.length(); i++) {
                String character = code.substring(i, i + 1);
                if (symbolsRange > 10) {
                    int randomNum = ThreadLocalRandom.current().nextInt(10, symbolsRange);
                    if(randomNum!=lastRandomNum){
                        char symbol = Character.forDigit(randomNum, symbolsRange);
                        output.append(symbol);
                        lastRandomNum = randomNum;
                    }else {
                    }
                }
                if (output.indexOf(character) < 0) // if not contained
                    output.append(character);
            }
            code = output.substring(0,secretCodeLenght);
            return code;
        }else{
            return "Error: can't generate a secret number with a length of 11 because there aren't enough unique digits.";
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String secretCode = "";
        String input = "";
        String stars = "";
        String secretCodeLengthString="";
        String symbolRangeString="";
        int secretCodeLength = 0;
        int symbolRange = 0;
        System.out.println("Please, enter the secret code's length:");
        secretCodeLengthString = scanner.nextLine();
        try {
            secretCodeLength = Integer.parseInt(secretCodeLengthString);
        }catch (NumberFormatException e){
            System.out.println("Error: "+'"' + secretCodeLengthString +'"'+ " isn't a valid number.");
            System.exit(0);
        }
        System.out.println("Input the number of possible symbols in the code:");
        symbolRangeString = scanner.nextLine();
        symbolRange = Integer.parseInt(symbolRangeString);
        //Error: maximum number of possible symbols in the code is 36 (0-9, a-z).
        if(secretCodeLength > symbolRange || secretCodeLength == 0){
            System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
            System.exit(0);
        }else if (symbolRange > 36){
            System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
            System.exit(0);
        }
        for (int i = 0; i < secretCodeLength; i++) {
            stars += "*";
        }
        char lastSymbol = Character.forDigit(symbolRange-1, symbolRange);
        System.out.println("The secret is prepared: " +stars +" (0-9, a-"+lastSymbol+").");
        secretCode = pseudoRandomNumberGenerator(secretCodeLength,symbolRange);
        String[] partsOfSecretCode = secretCode.split("");
        String[] partsOfInput;
        int turn = 1;
        if (secretCodeLength>36){
            System.out.println(pseudoRandomNumberGenerator(secretCodeLength,symbolRange));
        }else {
            System.out.println("Okay, let's start a game!");
            while (!input.contains(secretCode)) {
                System.out.println("Turn " + turn + ":");
                turn++;
                input = scanner.next();
                int bull = 0;
                int cow = 0;
                partsOfInput = input.split("");
                for (int i = 0; i < secretCodeLength; i++) {
                    if (partsOfInput[i].equals(partsOfSecretCode[i])) {
                        bull++;
                    }
                }
                for (int j = 0; j < secretCodeLength; j++) {
                    for (int k = 0; k < secretCodeLength; k++) {
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
