package time;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class MusicPlayer {
	
	private Clip clip;
	
	public MusicPlayer(String song) {
			
		try {
			URL url = this.getClass().getResource(song);
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(url);
			this.clip = AudioSystem.getClip();
			this.clip.open(audioStream);
			this.clip.start();
	
		} catch(Exception e) {	
		}
	}
}