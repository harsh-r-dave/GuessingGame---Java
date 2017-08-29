package ggHelperJsp;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class GGHelper {

	int remainingChance;
	int score = remainingChance * 10;
	int userNumber = 0;
	int randomNumber = 0;

	// variables used to generate random number
	int range = 0;	
	int min = 0;
	int max = 100;
	public int alreadyguessed[];

	// variable to hold music player
	static MediaPlayer player;
	
	public void GGHelper()
	{
		alreadyguessed = new int[10];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// method to play music of user's choice
	public static void playMusic(String file_path) {
		new javafx.embed.swing.JFXPanel();
		String file_name = file_path;
		String uri = new File(file_name).toURI().toString();
		player = new MediaPlayer(new Media(uri));
		player.play();
	}

	// method to stop current music
	public static void stopMusic() {
		player.stop();
	}

	// set initial remaining chance to zero
	public void setInitialRemainingChance(int initialChance) {
		remainingChance = initialChance;
		System.out.println("initial " + remainingChance);
	}
	// method to return user's remaining chance
	public int getRemainingChance() {
		System.out.println("get remain "+remainingChance);
		return remainingChance;
	}
	// method to set user's remaining chance
	public void deductRemainingChance() {
		remainingChance--;
		System.out.println("deduct remain "+remainingChance);
	}
	
	public void loadGame()
	{
		
	}

	// method to return user's score
	public int getScore() {
		return 0;
	}
	// method to set user's score
	public void setScore() {

	}
	
	// method to set user number
	public void setUserNumber(int userNumber) {
		
	}

	// method containing game logic
	public void playGame() {
		System.out.println("YES");
	}

	// method to set random number
	public void setRandomNumber() {
		randomNumber = random(min, max);
	}
	
	// method to get random number
	public int getRandomNumber() {
		return randomNumber;
	}
	
	// generate random number in particular range
	private int random(int min, int max)
	{
		range = (max - min) + 1;
		// set a random number to challenge
		return (int)(Math.random() * range) + min;
	}
}
