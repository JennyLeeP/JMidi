package application;

import java.util.HashMap;
import java.util.Map;

public class ActionMap {

    private static Map<Integer, ActionEvent> actionMap = new HashMap<Integer, ActionEvent>();
    
    
    public static ActionEvent addAction(Integer midiKey, ActionEvent action) {
    	return actionMap.put(midiKey, action);
    }
    
    public static ActionEvent removeAction(Integer midiKey) {
    	return actionMap.remove(midiKey);
    }

	public static boolean containsKey(int keyIndex) {
		return actionMap.containsKey(keyIndex);
	}

	public static boolean handleAction(int keyIndex) {
		return actionMap.get(keyIndex).handleAction();
	}
}
