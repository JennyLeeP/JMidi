package application;

import java.nio.file.Path;

import javax.sound.midi.MidiMessage;

import com.google.common.collect.Multimap;

import javafx.scene.input.KeyCode;

public interface ActionEvent {
    
    void handleAction(int button, Path path);

    void handleAction(int button, Multimap<KeyCode, EnumDirection> keysPressed);

}
