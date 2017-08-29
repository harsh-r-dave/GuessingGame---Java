package helperPack;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class PlayMusicHelper {
	
	static MediaPlayer player;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	public static void playMusic(String file_path) {
		new javafx.embed.swing.JFXPanel();
		String file_name = "D:/music.mp3";
		String uri = new File(file_name).toURI().toString();
		player = new MediaPlayer(new Media(uri));
		player.play();
	}
	
	public static void stopMusic() {
		player.stop();
	}
}
