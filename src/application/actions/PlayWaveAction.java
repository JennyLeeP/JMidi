package application.actions;

import java.nio.file.Path;

import application.ActionEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class PlayWaveAction implements ActionEvent {

	private Path path;
	
	public PlayWaveAction(Path path) {
		this.path = path;
	}
	
	@Override
	public boolean handleAction() {
		Media soundFile = new Media("file:///"+path.toString().replace("\\", "/"));
		MediaPlayer player = new MediaPlayer(soundFile);
		player.setVolume(0.5);
		player.setAutoPlay(true);
		return true;
	}

}
