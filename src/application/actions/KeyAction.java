package application.actions;

import application.EnumDirection;
import javafx.scene.input.KeyCode;

public class KeyAction {
	
	private KeyCode key;
	private EnumDirection keyDirection;
	
	public KeyAction(KeyCode key, EnumDirection keyDirection) {
		this.key = key;
		this.keyDirection = keyDirection;
	}
	
	public KeyCode getKey() {
		return this.key;
	}
	
	public EnumDirection getDirection() {
		return this.keyDirection;
	}

}
