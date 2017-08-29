package standAloneClass;

import  sun.audio.*;    //import the sun.audio package

import  java.io.*;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class PlayMusic {
	static MediaPlayer player;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// WORKING

		new javafx.embed.swing.JFXPanel();
		String file_name = "C:\\Users\\harsh\\J2EE-Luna\\Group4_Proj2\\src\\standAloneClass\\Don\'t_Let_Me_Down.mp3";
		String uri = new File(file_name).toURI().toString();
		player = new MediaPlayer(new Media(uri));
		player.play();

		/*
		String path;
		Media media;
		MediaPlayer mediaPlayer = null;
		MediaView mediaView = null;

		FileChooser fc = new FileChooser();
		fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("*.mp3","*.mp3"));
		File file = fc.showOpenDialog(null);
		path = file.getAbsolutePath();
		path = path.replace("\\", "/");
		media = new Media(new File(path).toURI().toString());
		mediaPlayer.stop();
		mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setAutoPlay(true);
		mediaView.setMediaPlayer(mediaPlayer);
		 */


		// NOT WORKING
		/*
		 InputStream in = new FileInputStream(file_name);
		AudioStream as = new AudioStream(in);         
		AudioPlayer.player.start(as);
		AudioPlayer.player.stop(as); 

		 */

	}
}
