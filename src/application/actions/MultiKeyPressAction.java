package application.actions;

import java.util.ArrayList;
import java.util.List;

import application.ActionEvent;
import application.KeyBoard;

public class MultiKeyPressAction implements ActionEvent {

	private List<KeyAction> actionList = new ArrayList<KeyAction>();
	
	public MultiKeyPressAction(List<KeyAction> actionList) {
		this.actionList = actionList;
	}
	
	@Override
	public boolean handleAction() {
		for (KeyAction currAction:actionList){
		    KeyBoard.typeKeys(currAction.getKey(), currAction.getDirection());
		}
		return true;
	}
	
	public String toString() {
		StringBuilder output = new StringBuilder();
		for (KeyAction currAction:actionList) {
			if (output.length() > 0) output.append(", ");
			output.append(currAction);
		}
		return output.toString();
	}

}
