package bullscows;

import java.util.Random;

public class GameController {

    private static final String SYMBOLS = "0123456789abcdefghijklmnopqrstuvwxyz";

    String secretCodeGenerator(int secretCodeLength,int symbolsRange){

        Random random = new Random();
        StringBuilder secretCode = new StringBuilder(secretCodeLength);

        while(secretCode.length()!=secretCodeLength) {
            String symbol = String.valueOf(SYMBOLS.charAt(random.nextInt(symbolsRange)));
            if (!String.valueOf(secretCode).contains(symbol)) {
                secretCode.append(symbol);
            }
        }

        return secretCode.toString();
    }

    String starsLengthGenerator(int secretCodeLength){
        return "*".repeat(secretCodeLength);
    }

    String

}
