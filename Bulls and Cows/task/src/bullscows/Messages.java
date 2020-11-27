package bullscows;

public class Messages {
    void displayMessageProvideLengthOfTheSecretCode() {
        System.out.println("Input the length of the secret code:");
    }
    void displayMessageProvideNumberOfPossibleSymbolsInTheCode(){
        System.out.println("Input the number of possible symbols in the code:");
    }
    void displayMessageErrorValidNumber(String input){
        System.out.printf("Error: \"%s\" isn't a valid number.\n",input);
    }
    void displayMessageErrorMaximumNumberOfPossibleSymbolsInCode(){
        System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
    }
    void displayMessageErrorMinimumNumberOfPossibleSymbolsInCode(){
        System.out.println("Error: minimum number of possible symbols in the code is 1.");
    }
    void displayMessageErrorMinimumLengthOfSecretCode(){
        System.out.println("Error: minimum length of secret code is 1.");
    }
    void displayMessageErrorNotPossibleToGenerateCode(int size, int symbols){
        System.out.printf("Error: it's not possible to generate a code with a length of %d with %d unique symbols.\n", size, symbols);
    }
    void displayMessageSecretCodeIsPreparedWithLetters(String stars, char lastSymbol){
        System.out.printf("The secret code is prepared: %s (0-9, a-%c).\n",stars,lastSymbol);
    }
    void displayMessageSecretCodeIsPrepared(String stars,char lastSymbol){
        System.out.printf("The secret code is prepared: %s (0-%c).\n",stars,lastSymbol);
    }
    void displayMessageStartGame(){
        System.out.println("Okay, let's start a game!");
    }
    void displayMessageTurn(int turn){
        System.out.printf("Turn %d:\n",turn);
    }
    void displayMessageGradeBullsAndCows(int bulls,int cows){
        System.out.printf("Grade: %d bull(s) and %d cow(s).\n",bulls,cows);
    }
    void displayMessageGradeBulls(int bulls){
        System.out.printf("Grade: %d bull(s).\n",bulls);
    }
    void displayMessageGradeCows(int cows){
        System.out.printf("Grade: %d cow(s).\n",cows);
    }
    void displayMessageGradeNone(){
        System.out.println("Grade: None.");
    }
    void displayMessageCongratulations(){
        System.out.println("Congratulations! You guessed the secret code.");
    }

}
