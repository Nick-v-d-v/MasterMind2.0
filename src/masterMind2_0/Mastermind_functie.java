package masterMind2_0;

import java.util.*;

public class Mastermind_functie {
    private Scanner input;
    private static final int CODE_LENGTH = 4;
    private static final int MAX_ATTEMPTS = 10;

    // Constructor
    public Mastermind_functie() {
        this.input = new Scanner(System.in);
    }

    // Make these methods public so they can be accessed from MastermindGame
    public String[] generateComputerColors() {
        String[] colors = {"Yellow", "Red", "Blue", "Green", "Purple", "Orange"};
        List<String> colorList = Arrays.asList(colors);
        Collections.shuffle(colorList);

        String[] computerColors = new String[CODE_LENGTH];
        for (int i = 0; i < CODE_LENGTH; i++) {
            computerColors[i] = colorList.get(i);
        }
        return computerColors;
    }

    public void playGame(String[] computerColors) {
        printInstructions();

        for (int attempt = 1; attempt <= MAX_ATTEMPTS; attempt++) {
            System.out.println("\nAttempt " + attempt + " of " + MAX_ATTEMPTS);
            String[] userColors = getUserInput();
            int colorsRight = checkGuess(userColors, computerColors);

            if (colorsRight == CODE_LENGTH) {
                System.out.println("You win!");
                return;
            }

            printAvailableColors();
        }

        System.out.println("You lost!");
        System.out.println("The correct code was: " + String.join(", ", computerColors));
    }

    private void printInstructions() {
        System.out.println(
            "Guess the code using the following colors: Blue, Green, Yellow, Purple, Orange, and Red " +
            "(Use capital letters. You get 10 attempts before you lose. " +
            "Black = Good White = Good but at the wrong place"
        );
    }

    private String[] getUserInput() {
        String[] userColors = new String[CODE_LENGTH];
        for (int i = 0; i < CODE_LENGTH; i++) {
            System.out.println("Color " + (i + 1) + ":");
            userColors[i] = input.nextLine();
        }
        return userColors;
    }

    private int checkGuess(String[] userColors, String[] computerColors) {
        int colorsRight = 0;
        
        for (int i = 0; i < CODE_LENGTH; i++) {
            String result = checkColor(userColors[i], computerColors, i);
            System.out.println(result);
            if (result.equals("black")) {
                colorsRight++;
            }
        }
        
        return colorsRight;
    }

    private String checkColor(String userColor, String[] computerColors, int position) {
        if (userColor.equals(computerColors[position])) {
            return "black";
        }
        
        for (int i = 0; i < CODE_LENGTH; i++) {
            if (i != position && userColor.equals(computerColors[i])) {
                return "white";
            }
        }
        
        return "-";
    }

    private void printAvailableColors() {
        System.out.println("Colors to choose from: Blue, Green, Yellow, Purple, Orange, and Red.");
    }
}