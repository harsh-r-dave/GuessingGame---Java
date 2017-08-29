package helperPack;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {

	static int remainingChance = 10;
	static int score = remainingChance * 10;
	static int userNumber = 0;
	static int randomNumber = 0;
	static String playAgain;
	static int flag = 0;

	// variables used to generate random number
	static int range = 0;	
	int min = 0;
	int max = 100;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		if(request.getParameter("play_music") != null) {
			String file_path = request.getParameter("file_path");
			PlayMusicHelper.playMusic(file_path);
		}
		else if(request.getParameter("stop_music") != null) {
			PlayMusicHelper.stopMusic();
		}
		else if (request.getParameter("check") != null) {
			int user_number = Integer.parseInt(request.getParameter("user_number"));
			remainingChance = GGHelper.getRemainingChance();
			score = GGHelper.getScore();

			if(flag == 0) {
				// initialize variables
				remainingChance = 10;
				score = remainingChance * 10;

				// set a random number to challenge
				randomNumber = random(0, 100);
				System.out.println(randomNumber);
				flag++;
			}
			else {
				if(remainingChance > 0) {
					GGHelper.playGame(user_number, randomNumber);	
				}
				else {
					GGHelper.wantToPlayAgain();
				}
			}
		}
	}
	
	// generate random number in particular range
	private static int random (int min, int max)
	{
		range = (max - min) + 1;
		// set a random number to challenge
		return (int)(Math.random() * range) + min;
	}
}