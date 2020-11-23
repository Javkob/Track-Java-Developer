package bullscows;

public class MainGame {
    public static void main(String[] args) {
        Game game = new Game();
        if(game.inputSecretCodeParameters()) {
            game.prepareSecretCode();
            game.run();
        }
    }
}
