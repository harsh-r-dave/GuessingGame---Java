package standAloneClass;

import java.util.Scanner;

public class GuessingGame {

	static int remainingChance = 10;
	static int score = remainingChance * 10;
	static int userNumber = 0;
	static int randomNumber = 0;
	static String playAgain;

	// variables used to generate random number
	static int range = 0;	
	int min = 0;
	int max = 100;

	static Scanner userInput = new Scanner (System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		playGame();
	}

	// generate random number in particular range
	private static int random (int min, int max)
	{
		range = (max - min) + 1;
		// set a random number to challenge
		return (int)(Math.random() * range) + min;
	}

	// method containing game logic
	private static void playGame() {
		// initialize variables
		remainingChance = 10;
		score = remainingChance * 10;

		// set a random number to challenge
		randomNumber = random(0, 100);
		System.out.println(randomNumber);

		// get the first number from user
		System.out.println("Enter your guess: ");
		userNumber = Math.round(userInput.nextInt());

		for(int i=0; i<10; i++) {
			/* if the guess is correct, game ends
			 * else take next input */

			if(randomNumber == userNumber) {
				System.out.println("Congratulations! You won!");
				System.out.println("Your score is: " + score);
				wantToPlayAgain();
				break;
			}
			else if(randomNumber > userNumber) {
				System.out.println("The number you entered is less than the "
						+ "number chosen by program");

				remainingChance--;
				score = remainingChance * 10;

				System.out.println("=========Result=========");
				System.out.println("Remaining chance: " + remainingChance);
				System.out.println("Score: " + score);
				System.out.println("Try again!");
				System.out.println("========================");

				// check for the remaining chance
				if  (remainingChance == 0) {
					System.out.println("=========================");	
					System.out.println("========GAME OVER========");
					System.out.println("=========================");
					wantToPlayAgain();
					break;
				}

				// ask for the next guess
				System.out.println("Enter your guess: ");
				userNumber = Math.round(userInput.nextInt());
			}
			else if(randomNumber < userNumber) {
				System.out.println("The number you entered is greater than the "
						+ "number chosen by program");

				remainingChance--;
				score = remainingChance * 10;


				System.out.println("=========Result=========");
				System.out.println("Remaining chance: " + remainingChance);
				System.out.println("Score: " + score);
				System.out.println("Try again!");
				System.out.println("========================");

				// check for the remaining chance
				if  (remainingChance == 0) {
					System.out.println("=========================");	
					System.out.println("========GAME OVER========");
					System.out.println("=========================");
					wantToPlayAgain();
					break;
				}

				// ask for the next guess
				System.out.println("Enter your guess: ");
				userNumber = Math.round(userInput.nextInt());
			}	
		}
	}

	private static void wantToPlayAgain() {
		System.out.println("=========================");
		System.out.println("Do you want to play again? (y/n)");
		playAgain = userInput.nextLine();
		if (playAgain.equals("y") || playAgain.equals("Y")) {
			playGame();
		}
		else if (playAgain.equals("n") || playAgain.equals("N")) {
			System.out.println("Good-bye!");
		}
		else {
			wantToPlayAgain();
		}
	}
}