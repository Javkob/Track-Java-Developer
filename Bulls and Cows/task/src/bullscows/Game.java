package bullscows;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Game {

    private final Scanner scanner = new Scanner(System.in);
    private int size;
    private int symbols;
    private List<Integer> secretCode = new ArrayList<>();

    public boolean inputSecretCodeParameters() {
        System.out.println("Input the length of the secret code:");
        String str = scanner.nextLine();
        try {
            size = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            System.out.printf("Error: \"" + str + "\" isn't a valid number.");
            return false;
        }
        System.out.println("Input the number of possible symbols in the code:");
        str = scanner.nextLine();
        try {
            symbols = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            System.out.printf("Error: \"" + str + "\" isn't a valid number.");
            return false;
        }
        if (symbols > 36) {
            System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).\n");
            return false;
        }
        if (symbols < 1) {
            System.out.println("Error: minimum number of possible symbols in the code is 1.\n");
            return false;
        }
        if (size < 1) {
            System.out.println("Error: minimum length of secret code is 1.\n");
            return false;
        }
        if (size > symbols) {
            System.out.printf("Error: it's not possible to generate a code with a length of %d with %d unique symbols.\n"
                    , size, symbols);
            return false;
        }
        return true;
    }

    public void prepareSecretCode() {
        Random random = new Random();
        while (secretCode.size() < size) {
            int randomDigit = random.nextInt(symbols - 1);
            if (!secretCode.contains(randomDigit)) {
                secretCode.add(randomDigit);
            }
        }
        System.out.printf("The secret is prepared: ****** (%s)."
                , symbols < 11 ? String.format("0-%d", symbols - 1)
                        : String.format("0-9, a-%s", Integer.toString(symbols - 1, symbols)));
    }

    public void run() {
        System.out.println("Okay, let's start a game!");
        long bulls = 0;
        int turn = 1;
        while (bulls != size) {
            System.out.printf("Turn %d:\n", turn);
            //Map answer to separate symbols and convert to list
            List<Integer> answer = scanner.nextLine().chars().mapToObj(x -> Character.digit(x, symbols))
                    .collect(Collectors.toList());

            bulls = IntStream.range(0, secretCode.size()).filter(i -> secretCode.get(i) == answer.get(i)).count();
            long cows = answer.stream().filter(x -> secretCode.contains(x)).count() - bulls;

            System.out.println("Turn " + turn + ":");
            turn++;
            if (cows > 0 && bulls > 0) {
                System.out.println("Grade: " + bulls + " bull(s) and " + cows + " cow(s).");
            } else if (cows > 0) {
                System.out.println("Grade: " + cows + " cow(s).");
            } else if (cows == 0 && bulls == 0) {
                System.out.println("Grade: " + "None.");
            } else if (bulls > 0) {
                System.out.println("Grade: " + bulls + " bull(s).");
            }
        }
            System.out.println("Grade: " + bulls + " bulls");
            System.out.println("Congratulations! You guessed the secret code.");
    }
}
