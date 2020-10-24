package bullscows;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String secretCode = "9305";
        String input = "";
        int turn = 1;
        String[] partsOfSecretCode = secretCode.split("");
        String[] partsOfInput;
        input = scanner.next();
        int bull = 0;
        int cow = 0;
        partsOfInput = input.split("");
        for (int i = 0; i < 4; i++) {
            if (partsOfInput[i].equals(partsOfSecretCode[i])) {
                bull++;
            }
        }
        for (int j = 0; j < 4; j++) {
            for (int k = 0; k < 4; k++) {
                if (partsOfInput[j].equals(partsOfSecretCode[k])) {
                    cow++;
                }
            }
        }
        cow=cow-bull;
        if(cow>0 && bull>0){
            System.out.println("Grade: "+bull + " bull(s) and "+cow+" cow(s)."+" The secret code is "+secretCode+".");
        }else if(cow>0){
            System.out.println("Grade: "+cow+" cow(s)."+" The secret code is "+secretCode+".");
        }else if(cow==0 && bull==0){
            System.out.println("Grade: "+"None."+" The secret code is "+secretCode+".");
        }else if(bull>0){
            System.out.println("Grade: "+bull + " bull(s)."+" The secret code is "+secretCode+".");
        }

    }
}
