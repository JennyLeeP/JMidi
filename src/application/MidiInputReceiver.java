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
    public String name;

    public MidiInputReceiver(String name) {
	this.name = name;
    }

    @Override
    public void close() {}

    @Override
    public void send(MidiMessage message, long timeStamp) {

	byte[] aMsg = message.getMessage();

	int b = aMsg[1];
	int v = aMsg[2];

	if (v < 65) return;
	if (Action.actionMap.containsKey(b)){
	    if (Action.actionMap.get(b).getType() == EnumActionType.KEYBIND){
		//FIXME getKeysPressed method is WRONG
		Action.actionMap.get(b).handleAction(b, Action.actionMap.get(b).getKeysPressed());
	    } else {
	    Action.actionMap.get(b).handleAction(b, Action.actionMap.get(b).getPath());
	    }
	}
	Platform.runLater(new Runnable(){
	    @Override
	    public void run() {updateGui(b, v);}
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