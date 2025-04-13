package masterMind2_0;

import java.util.*;

public class Mastermind {
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		String[] c = new String[6];

		c[0] = "Yellow";
		c[1] = "Red";
		c[2] = "Blue";
		c[3] = "Green";
		c[4] = "Purple";
		c[5] = "Orange";

		List<String> colorList = Arrays.asList(c);
		Collections.shuffle(colorList);

		String[] computerColors = new String[4];
		for (int i = 0; i < 4; i++) {
			computerColors[i] = colorList.get(i);
		}

		int colorsright = 0;
		System.out.println(
				"Guess the code using the following colors: Blue, Green, Yellow, Purple, Orange, and Red (Use capital letters. You get 10 attempts before you lose. Black = Good   White = Good but at the wrong place");

		for (int rowloop = 1; rowloop <= 10; rowloop++) {
			String[] userColors = new String[4];
			System.out.println("Color one:");
			userColors[0] = input.nextLine();

			System.out.println("Color two:");
			userColors[1] = input.nextLine();

			System.out.println("Color three:");
			userColors[2] = input.nextLine();

			System.out.println("Color four:");
			userColors[3] = input.nextLine();

			colorsright = 0;

			if (userColors[0].equals(computerColors[0])) {
				System.out.println("black");
				colorsright++;
			} else if (userColors[0].equals(computerColors[1]) || userColors[0].equals(computerColors[2])
					|| userColors[0].equals(computerColors[3])) {
				System.out.println("white");
			} else {
				System.out.println("-");
			}

			if (userColors[1].equals(computerColors[0])) {
				System.out.println("white");
			} else if (userColors[1].equals(computerColors[1])) {
				System.out.println("black");
				colorsright++;
			} else if (userColors[1].equals(computerColors[2]) || userColors[1].equals(computerColors[3])) {
				System.out.println("white");
			} else {
				System.out.println("-");
			}

			if (userColors[2].equals(computerColors[0])) {
				System.out.println("white");
			} else if (userColors[2].equals(computerColors[1])) {
				System.out.println("white");
			} else if (userColors[2].equals(computerColors[2])) {
				System.out.println("black");
				colorsright++;
			} else if (userColors[2].equals(computerColors[3])) {
				System.out.println("white");
			} else {
				System.out.println("-");
			}

			if (userColors[3].equals(computerColors[0])) {
				System.out.println("white");
			} else if (userColors[3].equals(computerColors[1])) {
				System.out.println("white");
			} else if (userColors[3].equals(computerColors[2])) {
				System.out.println("white");
			} else if (userColors[3].equals(computerColors[3])) {
				System.out.println("black");
				colorsright++;
			} else {
				System.out.println("-");
			}

			if (colorsright == 4) {
				System.out.println("You win!");
				break;
			}

			System.out.println("Colors to choose from: Blue, Green, Yellow, Purple, Orange, and Red.");
		}

		if (colorsright < 4) {
			System.out.println("You lost.");
		}
	}

}