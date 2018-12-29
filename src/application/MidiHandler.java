package application;

import java.util.ArrayList;
import java.util.List;

import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Transmitter;

import javafx.scene.paint.Color;
/**
 * 
 * @author JennyLeeP
 *
 */
public class MidiHandler {

	private static MidiDevice device;
	private static MidiDevice.Info[] infos;
	private static List<Transmitter> transmitters;
	public static boolean hasStarted = false;

	/**
	 * 
	 * @return
	 */
	public static ArrayList<String> getAvailableMidi() {

		infos = MidiSystem.getMidiDeviceInfo();
		ArrayList<String> deviceList = new ArrayList<String>();
		for (int i = 0; i < infos.length; i++) {
			try {
				device = MidiSystem.getMidiDevice(infos[i]);
				if (device.getMaxTransmitters() != 0){
					deviceList.add(infos[i].getName());
				}		
			} catch (MidiUnavailableException e) {
				System.out.println("Midi Unavailable in getAvailableMidi() in MidiHandler");
				e.printStackTrace();
			}
		}
		return deviceList;
	}
	/**
	 * 
	 * @param string
	 */
	public static void startMidi(String string){

		for (int i = 0; i < infos.length; i++) {

			if (infos[i].getName() == string){
				try {

					device = MidiSystem.getMidiDevice(infos[i]);

					device.open();

					if (device.isOpen()){
						GuiHandler.start.setDisable(true);
						GuiHandler.stop.setDisable(false);
						GuiHandler.midiSelect.setDisable(true);
						System.out.println(device.getDeviceInfo() +" Was Opened");
						GuiHandler.status.setText("Ready");
						GuiHandler.status.setTextFill(Color.GREEN);
						setHasStarted(true);

					}

					transmitters = device.getTransmitters();

					for(int j = 0; j<transmitters.size();j++) {
						//create a new receiver
						transmitters.get(j).setReceiver(new MidiInputReceiver(device.getDeviceInfo().toString()));
					}

					Transmitter trans = device.getTransmitter();
					trans.setReceiver(new MidiInputReceiver(device.getDeviceInfo().toString()));

				} catch (MidiUnavailableException e) {
					e.printStackTrace();
				}	
			}
		}
	}
	public static void stopMidi(String selectedItem) {

		for (int i = 0; i < infos.length; i++) {

			if (infos[i].getName() == selectedItem){
				try {

					device = MidiSystem.getMidiDevice(infos[i]);
					device.close();
					GuiHandler.start.setDisable(false);
					GuiHandler.stop.setDisable(true);
					GuiHandler.midiSelect.setDisable(false);
					GuiHandler.status.setText("Stopped");
					GuiHandler.status.setTextFill(Color.RED);
					setHasStarted(false);

				} catch (MidiUnavailableException e) {
					e.printStackTrace();
				}	
			}
		}
	}
	public static boolean isStarted() 
	{
		return hasStarted;
	}
	public static void setHasStarted(boolean hasStarted) 
	{
		MidiHandler.hasStarted = hasStarted;
	}
	public static boolean hasStopped() 
	{ 
		if (device.isOpen())
		{
			device.close();
		}
		return !device.isOpen();
	}
}
