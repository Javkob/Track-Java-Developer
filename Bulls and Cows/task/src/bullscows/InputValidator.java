package bullscows;

public class InputValidator {

    Messages messages = new Messages();

    void validateIfOnlyDigits(String userInput) {
        if (!userInput.matches("[0-9]+")){
            messages.displayMessageErrorValidNumber(userInput);
            System.exit(0);
        }
    }
}
