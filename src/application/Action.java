package application;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import javafx.scene.input.KeyCode;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Action implements ActionEvent {

    static Map<Integer, Action> actionMap = new HashMap<Integer, Action>();
    private EnumActionType type;
    private Path path;
    static Multimap<KeyCode, EnumDirection> keysPressed = ArrayListMultimap.create();
    
    
    public Action(EnumActionType type, Path path) {
	this.type= type;
	this.setPath(path);
    }
    public Action(EnumActionType type, Multimap<KeyCode, EnumDirection> keysPressed) {
	this.type= type;
	this.setKeysPressed(keysPressed);
    }
    @Override
    public void handleAction(int button, Path path) {
	    Media soundFile = new Media("file:///"+path.toString().replace("\\", "/"));
	    MediaPlayer player = new MediaPlayer(soundFile);
	    player.setVolume(0.5);
	    player.setAutoPlay(true);
    }
    @Override
    public void handleAction(int button, Multimap<KeyCode, EnumDirection> keysPressed) {
	//System.out.println(Action.actionMap.get(button).getKeysPressed().asMap().values());
	for (Map.Entry<Integer, Action> actmap:actionMap.entrySet()){
	    System.out.println("Key: "+actmap.getKey());
	    for (int i = 0; i<actmap.getValue().getKeysPressed().size();i++){
		System.out.println(" Key: "+actmap.getValue().getKeysPressed().keys()+" VAl: "+actmap.getValue().getKeysPressed().values());
	    }
	    
	   // System.out.println("Key: "+actmap.getKey() + " Pressed: "+actmap.getValue().getKeysPressed());
	}
	
	
	for (Entry<KeyCode, EnumDirection> map:keysPressed.entries()){
	    KeyCode code = map.getKey();
	    EnumDirection dir = map.getValue();
	    //System.out.println("Code: "+ code + " Dir: "+ dir);
	    //keyMap.put(code, dir);
	}
	
	
    }
    
    public EnumActionType getType() {
        return type;
    }
    
    public void setType(EnumActionType type) {
        this.type = type;
    }
    
    public Multimap<KeyCode, EnumDirection> getKeysPressed() {
	return keysPressed;
    }
    
    public void setKeysPressed(Multimap<KeyCode, EnumDirection> keysPressed) {
	Action.keysPressed = keysPressed;
    }
    
    public Path getPath() {
	return path;
    }
    
    public void setPath(Path path) {
	this.path = path;
    }
}
