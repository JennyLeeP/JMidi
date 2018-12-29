package application;

import javax.sound.midi.MidiMessage;
import javax.sound.midi.Receiver;

import javafx.application.Platform;

/**
 * 
 * @author JennyLeeP
 *
 */
public class MidiInputReceiver implements Receiver{

    public MidiInputReceiver(String name) { //TODO remove name in constructor, is this needed to differentiate multiple midi devices?
    }

    @Override
    public void close() {}

    @Override
    public void send(MidiMessage message, long timeStamp) {

	byte[] aMsg = message.getMessage();

	int keyIndex = aMsg[1];
	int keyVelocity = aMsg[2];

	if (keyVelocity < 65) return;
	if (ActionMap.containsKey(keyIndex)){
		ActionMap.handleAction(keyIndex);
	}
	Platform.runLater(new Runnable(){
	    @Override
	    public void run() {updateGui(keyIndex, keyVelocity);}
	});
    }

    private void updateGui(int b, int v) {
	//TODO update main gui here as well.
	if (GuiHandler.dialog != null && GuiHandler.dialog.isShowing()){
	    GuiHandler.buttonInput.requestFocus();
	    GuiHandler.buttonInput.setText(""+b);
	}
    }
}