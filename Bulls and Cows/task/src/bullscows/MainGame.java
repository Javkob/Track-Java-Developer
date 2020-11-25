package bullscows;

import java.util.Scanner;

public class MainGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameController gameController = new GameController();
        int length = scanner.nextInt();
        int range = scanner.nextInt();
        System.out.println(gameController.secretCodeGenerator(length, range));
        System.out.println(gameController.starsLengthGenerator(length));

//        Game game = new Game();
//        if(game.inputSecretCodeParameters()) {
//            game.prepareSecretCode();
//            game.run();
//        }
    }
}
