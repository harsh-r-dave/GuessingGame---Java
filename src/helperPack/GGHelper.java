package helperPack;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/ServletGG")
public class GGHelper extends HttpServlet {

	static int remainingChance = 10;
	static int score = remainingChance * 10;
	static int userNumber = 0;
	static int randomNumber = 0;
	static String playAgain = "y";


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println();
	}

	// method containing game logic
	public static void playGame(int user_number, int random) {

		userNumber = user_number;
		randomNumber = random;

		if(randomNumber == userNumber) {
			System.out.println("Congratulations! You won!");
			System.out.println("Your score is: " + score);
			//wantToPlayAgain();

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
				//wantToPlayAgain();

			}

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
				//wantToPlayAgain();

			}

		}	
	}
	
	public static int getRemainingChance() {
		return remainingChance;
	}
	
	public static int getScore() {
		return score;
	}


	public static void wantToPlayAgain() {
		System.out.println("=========================");
		System.out.println("Do you want to play again? (y/n)");
			//playAgain = userInput.nextLine();
		if (playAgain.equals("y") || playAgain.equals("Y")) {
					playGame(10, 100);
		}
		else if (playAgain.equals("n") || playAgain.equals("N")) {
			System.out.println("Good-bye!");
		}
		else {
			wantToPlayAgain();
		}
	}
}
