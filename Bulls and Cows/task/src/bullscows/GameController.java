package bullscows;

import java.util.Random;
import java.util.Scanner;

public class GameController {

    private Scanner scanner = new Scanner(System.in);
    private Messages messages = new Messages();
    private InputValidator inputValidator = new InputValidator();
    private static final String SYMBOLS = "0123456789abcdefghijklmnopqrstuvwxyz";
    private int bulls;
    private int cows;
    private int turn;
    private String userInput;
    private String secretCode;
    private String secretCodeSize;
    private String secretCodeSymbolRange;

    GameController() {
    }

    void run(){
        provideSecretCodeLengthAndSymbolRange();
        prepareSecretCode();
        provideAnswer();
    }

    void provideSecretCodeLengthAndSymbolRange() {
        provideSecretCodeLength();
        provideSecretCodeSymbolRange();
        inputMessagesCondition(Integer.parseInt(secretCodeSize),Integer.parseInt(secretCodeSymbolRange));
    }

    void prepareSecretCode(){
        secretCodeGenerator();
        checkSecretCodeSymbolRange();
        messages.displayMessageStartGame();
    }

    void provideAnswer(){
        do {
            setTurn(++turn);
            messages.displayMessageTurn(getTurns());
            setUserInput(scanner.nextLine());
            checkBullsAndCows();
            displayBullsAndCows();
            resetBullsAndCows();
        }while (!userInput.contains(secretCode));
        messages.displayMessageCongratulations();
    }

    void checkSecretCodeSymbolRange(){
        if(Integer.parseInt(secretCodeSymbolRange)<11){
            messages.displayMessageSecretCodeIsPrepared(starsLengthGenerator(secretCode.length()),SYMBOLS.charAt(Integer.parseInt(secretCodeSymbolRange)-1));
        }else{
            messages.displayMessageSecretCodeIsPreparedWithLetters(starsLengthGenerator(secretCode.length()),SYMBOLS.charAt(Integer.parseInt(secretCodeSymbolRange)-1));
        }
    }

    void provideSecretCodeLength(){
        messages.displayMessageProvideLengthOfTheSecretCode();
        secretCodeSize = scanner.nextLine();
        inputValidator.validateIfOnlyDigits(secretCodeSize);
        setSecretCodeSize(secretCodeSize);
    }

    void provideSecretCodeSymbolRange(){
        messages.displayMessageProvideNumberOfPossibleSymbolsInTheCode();
        secretCodeSymbolRange = scanner.nextLine();
        inputValidator.validateIfOnlyDigits(secretCodeSymbolRange);
        setSecretCodeSymbolRange(secretCodeSymbolRange);
    }

    public void setSecretCode(String secretCode) {
        this.secretCode = secretCode;
    }

    public void setSecretCodeSize(String secretCodeSize) {
        this.secretCodeSize = secretCodeSize;
    }

    public void setSecretCodeSymbolRange(String secretCodeSymbolRange) {
        this.secretCodeSymbolRange = secretCodeSymbolRange;
    }


    boolean inputMessagesCondition(int size, int symbols){
        if (symbols > 36) {
            messages.displayMessageErrorMaximumNumberOfPossibleSymbolsInCode();
            return false;
        }
        if (symbols < 1) {
            messages.displayMessageErrorMinimumNumberOfPossibleSymbolsInCode();
            return false;
        }
        if (size < 1) {
            messages.displayMessageErrorMinimumLengthOfSecretCode();
            return false;
        }
        if (size > symbols) {
            messages.displayMessageErrorNotPossibleToGenerateCode(size,symbols);
            return false;
        }
        return true;
    }


    void secretCodeGenerator(){

        Random random = new Random();
        StringBuilder secretCodeBuilder = new StringBuilder(Integer.parseInt(secretCodeSize));

        while (secretCodeBuilder.length() != Integer.parseInt(secretCodeSize)) {
            String symbol = String.valueOf(SYMBOLS.charAt(random.nextInt(Integer.parseInt(secretCodeSymbolRange))));
            if (!String.valueOf(secretCodeBuilder).contains(symbol)) {
                secretCodeBuilder.append(symbol);
            }
        }
        setSecretCode(secretCodeBuilder.toString());
    }

    String starsLengthGenerator(int secretCodeLength){
        return "*".repeat(secretCodeLength);
    }

    void checkBullsAndCows(){
        for (int i = 0; i < secretCode.length(); i++) {
            if (userInput.charAt(i) == secretCode.charAt(i)) {
                bulls++;
            } else if (secretCode.contains(userInput.charAt(i) + "")) {
                cows++;
            }
        }
    }

    void displayBullsAndCows(){
        if (cows > 0 && bulls > 0) {
            messages.displayMessageGradeBullsAndCows(bulls,cows);
        } else if (cows > 0) {
            messages.displayMessageGradeCows(cows);
        } else if (cows == 0 && bulls == 0) {
            messages.displayMessageGradeNone();
        } else if (bulls > 0) {
            messages.displayMessageGradeBulls(bulls);
        }
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    int getTurns(){
        return turn;
    }

    void setUserInput(String userInput) {
        this.userInput = userInput;
    }
    void resetBullsAndCows(){
        setBulls(0);
        setCows(0);
    }

    public void setBulls(int bulls) {
        this.bulls = bulls;
    }

    public void setCows(int cows) {
        this.cows = cows;
    }
}
