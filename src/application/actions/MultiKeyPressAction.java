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

}
