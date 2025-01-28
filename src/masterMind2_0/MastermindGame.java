package masterMind2_0;

public class MastermindGame {
    public static void main(String[] args) {
        Mastermind_functie game = new Mastermind_functie();
        String[] secretCode = game.generateComputerColors();
        game.playGame(secretCode);
    }
}