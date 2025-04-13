package lingo;

import java.util.*;

public class Lingo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] woorden = {"appel", "stoel", "plant", "broek", "kaars", "regen", "piano", "kaart", "fiets", "snoep"};
        
        Random random = new Random();
        String geheimWoord = woorden[random.nextInt(woorden.length)];

        System.out.println("Je hebt 5 pogingen om het woord te raden.");
        System.out.println("Correct = juiste plek, Deels correct = verkeerde plek, - = niet in het woord");

        for (int poging = 1; poging <= 5; poging++) {

            System.out.print("Poging " + poging + ": ");
            String gok = input.nextLine().toLowerCase();

            if (gok.length() != 5) {
                System.out.println("Gebruik precies 5 letters.");
            }

            int lettersGoed = 0;

            for (int i = 0; i < 5; i++) {
                char letter = gok.charAt(i);
                
                if (letter == geheimWoord.charAt(i)) {
                    System.out.println(letter + " = Correct");
                    lettersGoed++;
                } else if (geheimWoord.contains(String.valueOf(letter))) {
                    System.out.println(letter + " = Deels correct");
                } else {
                    System.out.println(letter + " = -");
                }
            }

            if (lettersGoed == 5) {
                System.out.println("Je hebt gewonnen! Het geheime woord was: " + geheimWoord);
                break;
            }

            if (poging == 5) {
                System.out.println("Je hebt verloren! Het geheime woord was: " + geheimWoord);
            }
        }

        input.close();
    }
}
