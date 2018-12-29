package application;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import javafx.scene.input.KeyCode;

public class KeyBoard {

    private static Robot robot;

    public static void typeKeys(KeyCode code, EnumDirection dir) {
	try {
	    robot = new Robot();
	    if (dir == EnumDirection.DOWN){
		robot.keyPress(getKeyVK_Code(code));
	    }else if (dir == EnumDirection.UP){
		robot.keyRelease(getKeyVK_Code(code));
	    }else {
		
	    }
	    
	    
	} catch (AWTException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	
    }
    private static int getKeyVK_Code(KeyCode keycode) {
	switch(keycode) {
	case A: 		return KeyEvent.VK_A;
	case B: 		return KeyEvent.VK_B;
	case C: 		return KeyEvent.VK_C;
	case D: 		return KeyEvent.VK_D;
	case E: 		return KeyEvent.VK_E;
	case F: 		return KeyEvent.VK_F;
	case G: 		return KeyEvent.VK_G;
	case H: 		return KeyEvent.VK_H;
	case I: 		return KeyEvent.VK_I;
	case J: 		return KeyEvent.VK_J;
	case K: 		return KeyEvent.VK_K;
	case L: 		return KeyEvent.VK_L;
	case M: 		return KeyEvent.VK_M;
	case N: 		return KeyEvent.VK_N;
	case O: 		return KeyEvent.VK_O;
	case P: 		return KeyEvent.VK_P;
	case Q: 		return KeyEvent.VK_Q;
	case R: 		return KeyEvent.VK_R;
	case S: 		return KeyEvent.VK_S;
	case T: 		return KeyEvent.VK_T;
	case U: 		return KeyEvent.VK_U;
	case V: 		return KeyEvent.VK_V;
	case W: 		return KeyEvent.VK_W;
	case X: 		return KeyEvent.VK_X;
	case Y: 		return KeyEvent.VK_Y;
	case Z: 		return KeyEvent.VK_Z;
	case ACCEPT: 		return KeyEvent.VK_ACCEPT;
	case ADD: 		return KeyEvent.VK_ADD;
	case AGAIN: 		return KeyEvent.VK_AGAIN;
	case ALL_CANDIDATES: 	return KeyEvent.VK_ALL_CANDIDATES;
	case ALPHANUMERIC: 	return KeyEvent.VK_ALPHANUMERIC;
	case ALT: 		return KeyEvent.VK_ALT;
	case ALT_GRAPH: 	return KeyEvent.VK_ALT_GRAPH;
	case AMPERSAND: 	return KeyEvent.VK_AMPERSAND;
	case ASTERISK: 		return KeyEvent.VK_ASTERISK;
	case AT:		return KeyEvent.VK_AT;
	case BACK_QUOTE: 	return KeyEvent.VK_BACK_QUOTE;
	case BACK_SLASH: 	return KeyEvent.VK_BACK_SLASH;
	case BACK_SPACE: 	return KeyEvent.VK_BACK_SPACE;
	case BEGIN: 		return KeyEvent.VK_BEGIN;
	case BRACELEFT: 	return KeyEvent.VK_BRACELEFT;
	case BRACERIGHT: 	return KeyEvent.VK_BRACERIGHT;
	case CANCEL: 		return KeyEvent.VK_CANCEL;
	case CAPS: 		return KeyEvent.VK_CAPS_LOCK;
	case CIRCUMFLEX: 	return KeyEvent.VK_CIRCUMFLEX;
	case CLEAR: 		return KeyEvent.VK_CLEAR;
	case CLOSE_BRACKET: 	return KeyEvent.VK_CLOSE_BRACKET;
	case CODE_INPUT: 	return KeyEvent.VK_CODE_INPUT;
	case COLON: 		return KeyEvent.VK_COLON;
	case CONTROL: 		return KeyEvent.VK_CONTROL;
	case COMMA: 		return KeyEvent.VK_COMMA;
	case COMMAND: 		return KeyEvent.VK_ALT;
	case COMPOSE: 		return KeyEvent.VK_COMPOSE;
	case CONTEXT_MENU: 	return KeyEvent.VK_CONTEXT_MENU;
	case CONVERT: 		return KeyEvent.VK_CONVERT;
	case COPY: 		return KeyEvent.VK_COPY;
	case CUT: 		return KeyEvent.VK_CUT;
	case DEAD_ABOVEDOT: 	return KeyEvent.VK_DEAD_ABOVEDOT;
	case DEAD_ABOVERING: 	return KeyEvent.VK_DEAD_ABOVERING;
	case DEAD_ACUTE: 	return KeyEvent.VK_DEAD_ACUTE;
	case DEAD_BREVE: 	return KeyEvent.VK_DEAD_BREVE;
	case DEAD_CARON: 	return KeyEvent.VK_DEAD_CARON;
	case DEAD_CEDILLA: 	return KeyEvent.VK_DEAD_CEDILLA;
	case DEAD_CIRCUMFLEX: 	return KeyEvent.VK_DEAD_CIRCUMFLEX;
	case DEAD_DIAERESIS: 	return KeyEvent.VK_DEAD_DIAERESIS;
	case DEAD_DOUBLEACUTE: 	return KeyEvent.VK_DEAD_ACUTE;
	case DEAD_GRAVE: 	return KeyEvent.VK_DEAD_GRAVE;
	case DEAD_IOTA: 	return KeyEvent.VK_DEAD_IOTA;
	case DEAD_MACRON: 	return KeyEvent.VK_DEAD_MACRON;
	case DEAD_OGONEK: 	return KeyEvent.VK_DEAD_OGONEK;
	case DEAD_SEMIVOICED_SOUND: return KeyEvent.VK_DEAD_SEMIVOICED_SOUND;
	case DEAD_TILDE: 	return KeyEvent.VK_DEAD_TILDE;
	case DEAD_VOICED_SOUND: return KeyEvent.VK_DEAD_VOICED_SOUND;
	case DECIMAL: 		return KeyEvent.VK_DECIMAL;
	case DELETE: 		return KeyEvent.VK_DELETE;
	case DIGIT0: 		return KeyEvent.VK_0;
	case DIGIT1: 		return KeyEvent.VK_1;
	case DIGIT2: 		return KeyEvent.VK_2;
	case DIGIT3: 		return KeyEvent.VK_3;
	case DIGIT4: 		return KeyEvent.VK_4;
	case DIGIT5: 		return KeyEvent.VK_5;
	case DIGIT6: 		return KeyEvent.VK_6;
	case DIGIT7: 		return KeyEvent.VK_7;
	case DIGIT8: 		return KeyEvent.VK_8;
	case DIGIT9: 		return KeyEvent.VK_9;
	case DIVIDE: 		return KeyEvent.VK_DIVIDE;
	case DOLLAR: 		return KeyEvent.VK_DOLLAR;
	case DOWN: 		return KeyEvent.VK_DOWN;
	case END: 		return KeyEvent.VK_END;
	case ENTER: 		return KeyEvent.VK_ENTER;
	case EQUALS: 		return KeyEvent.VK_EQUALS;
	case ESCAPE: 		return KeyEvent.VK_ESCAPE;
	case EURO_SIGN: 	return KeyEvent.VK_EURO_SIGN;
	case EXCLAMATION_MARK:  return KeyEvent.VK_EXCLAMATION_MARK;
	case F1: 		return KeyEvent.VK_F1;
	case F2: 		return KeyEvent.VK_F2;
	case F3: 		return KeyEvent.VK_F3;
	case F4: 		return KeyEvent.VK_F4;
	case F5: 		return KeyEvent.VK_F5;
	case F6: 		return KeyEvent.VK_F6;
	case F7: 		return KeyEvent.VK_F7;
	case F8: 		return KeyEvent.VK_F8;
	case F9: 		return KeyEvent.VK_F9;
	case F10: 		return KeyEvent.VK_F10;
	case F11: 		return KeyEvent.VK_F11;
	case F12: 		return KeyEvent.VK_F12;
	case F13: 		return KeyEvent.VK_F13;
	case F14: 		return KeyEvent.VK_F14;
	case F15: 		return KeyEvent.VK_F15;
	case F16: 		return KeyEvent.VK_F16;
	case F17: 		return KeyEvent.VK_F17;
	case F18: 		return KeyEvent.VK_F18;
	case F19: 		return KeyEvent.VK_F19;
	case F20: 		return KeyEvent.VK_F20;
	case F21: 		return KeyEvent.VK_F21;
	case F22: 		return KeyEvent.VK_F22;
	case F23: 		return KeyEvent.VK_F23;
	case F24: 		return KeyEvent.VK_F24;
	case FINAL: 		return KeyEvent.VK_FINAL;
	case FIND: 		return KeyEvent.VK_FIND;
	case FULL_WIDTH: 	return KeyEvent.VK_FULL_WIDTH;
	case GREATER: 		return KeyEvent.VK_GREATER;
	case HALF_WIDTH: 	return KeyEvent.VK_HALF_WIDTH;
	case HELP: 		return KeyEvent.VK_HELP;
	case HIRAGANA: 		return KeyEvent.VK_HIRAGANA;
	case HOME: 		return KeyEvent.VK_HOME;
	case INPUT_METHOD_ON_OFF: return KeyEvent.VK_INPUT_METHOD_ON_OFF;
	case INSERT: 		return KeyEvent.VK_INSERT;
	case INVERTED_EXCLAMATION_MARK: return KeyEvent.VK_INVERTED_EXCLAMATION_MARK;
	case JAPANESE_HIRAGANA: return KeyEvent.VK_JAPANESE_HIRAGANA;
	case JAPANESE_KATAKANA: return KeyEvent.VK_JAPANESE_KATAKANA;
	case JAPANESE_ROMAN: 	return KeyEvent.VK_JAPANESE_ROMAN;
	case KANA: 		return KeyEvent.VK_KANA;
	case KANA_LOCK: 	return KeyEvent.VK_KANA_LOCK;
	case KANJI: 		return KeyEvent.VK_KANJI;
	case KATAKANA: 		return KeyEvent.VK_KATAKANA;
	case KP_DOWN: 		return KeyEvent.VK_KP_DOWN;
	case KP_LEFT: 		return KeyEvent.VK_KP_LEFT;
	case KP_RIGHT: 		return KeyEvent.VK_KP_RIGHT;
	case KP_UP: 		return KeyEvent.VK_KP_UP;
	case LEFT: 		return KeyEvent.VK_LEFT;
	case LEFT_PARENTHESIS:  return KeyEvent.VK_LEFT_PARENTHESIS;
	case LESS: 		return KeyEvent.VK_LESS;
	case META: 		return KeyEvent.VK_META;
	case MINUS: 		return KeyEvent.VK_MINUS;
	case MODECHANGE: 	return KeyEvent.VK_MODECHANGE;
	case MULTIPLY: 		return KeyEvent.VK_MULTIPLY;
	case NONCONVERT: 	return KeyEvent.VK_NONCONVERT;
	case NUMBER_SIGN: 	return KeyEvent.VK_NUMBER_SIGN;
	case NUMPAD0: 		return KeyEvent.VK_NUMPAD0;
	case NUMPAD1: 		return KeyEvent.VK_NUMPAD1;
	case NUMPAD2: 		return KeyEvent.VK_NUMPAD2;
	case NUMPAD3: 		return KeyEvent.VK_NUMPAD3;
	case NUMPAD4: 		return KeyEvent.VK_NUMPAD4;
	case NUMPAD5: 		return KeyEvent.VK_NUMPAD5;
	case NUMPAD6: 		return KeyEvent.VK_NUMPAD6;
	case NUMPAD7: 		return KeyEvent.VK_NUMPAD7;
	case NUMPAD8: 		return KeyEvent.VK_NUMPAD8;
	case NUMPAD9: 		return KeyEvent.VK_NUMPAD9;
	case NUM_LOCK: 		return KeyEvent.VK_NUM_LOCK;
	case OPEN_BRACKET: 	return KeyEvent.VK_OPEN_BRACKET;
	case PAGE_DOWN: 	return KeyEvent.VK_PAGE_DOWN;
	case PAGE_UP: 		return KeyEvent.VK_PAGE_UP;
	case PASTE: 		return KeyEvent.VK_PASTE;
	case PAUSE: 		return KeyEvent.VK_PAUSE;
	case PERIOD: 		return KeyEvent.VK_PERIOD;
	case PLUS: 		return KeyEvent.VK_PLUS;
	case PREVIOUS_CANDIDATE:return KeyEvent.VK_PREVIOUS_CANDIDATE;
	case PRINTSCREEN: 	return KeyEvent.VK_PRINTSCREEN;
	case PROPS: 		return KeyEvent.VK_PROPS;
	case QUOTE: 		return KeyEvent.VK_QUOTE;
	case QUOTEDBL: 		return KeyEvent.VK_QUOTEDBL;
	case RIGHT: 		return KeyEvent.VK_RIGHT;
	case RIGHT_PARENTHESIS: return KeyEvent.VK_RIGHT_PARENTHESIS;
	case ROMAN_CHARACTERS: 	return KeyEvent.VK_ROMAN_CHARACTERS;
	case SCROLL_LOCK: 	return KeyEvent.VK_SCROLL_LOCK;
	case SEMICOLON: 	return KeyEvent.VK_SEMICOLON;
	case SEPARATOR: 	return KeyEvent.VK_SEPARATOR;
	case SHIFT: 		return KeyEvent.VK_SHIFT;
	case SLASH: 		return KeyEvent.VK_SLASH;
	case SPACE: 		return KeyEvent.VK_SPACE;
	case STOP: 		return KeyEvent.VK_STOP;
	case SUBTRACT: 		return KeyEvent.VK_SUBTRACT;
	case TAB: 		return KeyEvent.VK_TAB;
	case UNDEFINED: 	return KeyEvent.VK_UNDEFINED;
	case UNDERSCORE: 	return KeyEvent.VK_UNDERSCORE;
	case UNDO: 		return KeyEvent.VK_UNDO;
	case UP: 		return KeyEvent.VK_UP;
	case WINDOWS: 		return KeyEvent.VK_WINDOWS;
	default: throw new IllegalArgumentException("Cannot find KeyCode for " + keycode);
	}
    }
}
