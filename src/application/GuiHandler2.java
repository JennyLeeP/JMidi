package application;


import java.io.File;
import java.nio.file.Path;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
/**
 * 
 * @author JennyLeeP
 *
 */
public class GuiHandler2 {

    BorderPane root;
    public static Label status;
    public static Button start;
    public static Button stop;
    public static ChoiceBox<String> midiSelect;
    private static VBox vbutrows;
    public static Stage dialog;
    public static Label buttonInput;
    private static Label warnText;
    private String fileName;
    private Path filePath;
    private Multimap<KeyCode,EnumDirection> keysPressed2 = LinkedHashMultimap.create();
    //public static ObservableList<HBox> buttonRows = FXCollections.observableArrayList();// TODO List added to track HBox's.

    public GuiHandler2(BorderPane root) {
	this.root = root;
    }
    /**
     * Takes in the root object can be whatever you want it to be, in this case a BorderPane. 
     * Adds objects and elements to it and returns it back to the main scene.
     * @param root
     * @return
     */

    public BorderPane buildWindow(BorderPane root) {

	/* Root - BorderPane Top */
	HBox startPanel = new HBox();
	midiSelect = new ChoiceBox<String>(FXCollections.observableList(MidiHandler.getAvailableMidi()));
	midiSelect.getSelectionModel().selectFirst();
	start = new Button("Start Midi");
	stop = new Button("Stop");
	stop.setDisable(true);
	status = new Label();
	status.setPrefWidth(70);
	status.setAlignment(Pos.CENTER);
	Separator sep = new Separator();
	sep.setOrientation(Orientation.VERTICAL);
	ChoiceBox<String> profile = new ChoiceBox<String>(FXCollections.observableArrayList("Choose Profile"));
	profile.getItems().addAll("One","Two","Three","New");
	profile.getSelectionModel().selectFirst();
	profile.setPrefWidth(175);
	Button save = new Button("Save");
	Button delete = new Button("Delete");
	Separator sep2 = new Separator();
	sep2.setOrientation(Orientation.VERTICAL);
	Button add = new Button("Add");
	startPanel.setAlignment(Pos.CENTER_LEFT);
	startPanel.setSpacing(10);
	startPanel.setPadding(new Insets(5,5,5,5));
	startPanel.getChildren().addAll(midiSelect,start,stop,status,sep,profile,save,delete,sep2,add);
	start.setOnAction(e -> {MidiHandler.startMidi(midiSelect.getSelectionModel().getSelectedItem());});
	stop.setOnAction(e -> {MidiHandler.stopMidi(midiSelect.getSelectionModel().getSelectedItem());});
	save.setOnAction(e -> {  
	    // open folder browser 
	    // save the profile to file
	    // add name to profile selector collection, switch to this new name in selector.	
	});
	delete.setOnAction(e -> {
	    //delete selected profile, confirmation dialog.
	});
	add.setOnAction(e -> {
	    if (MidiHandler.isStarted()){
		warnText.setText("");
		ruleSetModal();
		//testModal();
	    }else {
		warnText.setText("* Select and Start Midi Device, before pressing 'ADD'.");
	    }
	});

	root.setTop(startPanel);

	/* Root - BorderPane Center */
	ScrollPane buttonPane = new ScrollPane();
	HBox header = new HBox();

	header.setBorder(new Border(new BorderStroke(Color.LIGHTGRAY, BorderStrokeStyle.SOLID, null, new BorderWidths(0,0,1,0))));
	header.setSpacing(10);
	header.setPadding(new Insets(5,5,5,5));
	Label label1 = new Label("Control Name");
	label1.setPrefWidth(150);
	label1.setAlignment(Pos.CENTER);
	Separator sep3 = new Separator();
	sep3.setOrientation(Orientation.VERTICAL);
	Label label2 = new Label("Midi");
	label2.setPrefWidth(50);
	label2.setAlignment(Pos.CENTER);
	Separator sep4 = new Separator();
	sep4.setOrientation(Orientation.VERTICAL);
	Label label3 = new Label("Action");
	label3.setPrefWidth(100);
	label3.setAlignment(Pos.CENTER);
	Separator sep5 = new Separator();
	sep5.setOrientation(Orientation.VERTICAL);
	Label label4 = new Label("KeyBind / File");
	//label4.setId("awesomeLabel");
	label4.setPrefWidth(300);
	label4.setAlignment(Pos.CENTER);
	Separator sep6 = new Separator();
	sep6.setOrientation(Orientation.VERTICAL);
	Label label5 = new Label();
	label5.setPrefWidth(134);
	header.getChildren().addAll(label1,sep3,label2,sep4,label3,sep5,label4,sep6,label5);
	vbutrows = new VBox();
	vbutrows.getChildren().add(header);
	buttonPane.setContent(vbutrows);
	root.setCenter(buttonPane);
	/* Root - BorderPane Bottom */

	warnText = new Label();
	warnText.setAlignment(Pos.CENTER);
	warnText.setTextFill(Color.RED);
	root.setBottom(warnText);
	return root;

    } 
    private void ruleSetModal(){

	dialog = new Stage();
	dialog.initModality(Modality.APPLICATION_MODAL);
	dialog.setResizable(false);
	BorderPane modalRoot = new BorderPane();
	HBox namingHBox,contNumHBox,actionBox,chosenItem,fileHBox;
	Separator sep1,sep2;
	Button create,cancel,browse;
	ToggleButton learnB;
	VBox dialogVbox,keyVBox = new VBox(5);// was 20
	TextField name,path;
	TextArea keybindTA;
	
	sep1 = new Separator();
	sep2 = new Separator();
	namingHBox = new HBox();
	contNumHBox = new HBox();
	actionBox = new HBox();
	
	chosenItem = new HBox();
	keyVBox = new VBox(5);
	dialogVbox = new VBox(5);
	name = new TextField();
	keybindTA = new TextArea();
	keybindTA.setId("keys");
	keybindTA.setEditable(false);
	keybindTA.setDisable(true);
	
	FileChooser fileChooser = new FileChooser();
	fileHBox = new HBox();
	fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Wave Files", "*.wav"));
	path = new TextField();
	path.setEditable(false);
	path.setDisable(true);
	browse = new Button("Browse");
	browse.setDisable(true);
	fileHBox.getChildren().addAll(new Label("File: "), path, browse);
	
	
	ChoiceBox<String> actionDrop = new ChoiceBox<String>();
	create = new Button("Create");
	cancel = new Button("Cancel");
	learnB = new ToggleButton("Learn");
	learnB.setDisable(true);
	
	Label warnTextDialog = new Label();

	sep1.setOrientation(Orientation.VERTICAL);
	actionDrop.getItems().addAll("Choose Action","Key / Macro","Wave Sound");
	actionDrop.getSelectionModel().selectFirst();

	dialogVbox.setSpacing(10);
	dialogVbox.setPadding(new Insets(5,5,5,5));

	

	buttonInput = new Label();
	buttonInput.setAlignment(Pos.CENTER);

	warnTextDialog.setTextFill(Color.RED);
	warnTextDialog.setAlignment(Pos.CENTER);
	warnTextDialog.setPrefWidth(190);

	
	namingHBox.getChildren().addAll(new Label("Name: "), name);
	contNumHBox.getChildren().addAll(new Label("Midi #: "),buttonInput);
	actionBox.getChildren().addAll(actionDrop, create,cancel);
	actionBox.setSpacing(5);
	dialogVbox.getChildren().addAll(namingHBox,contNumHBox,actionBox,chosenItem,sep2,fileHBox,warnTextDialog);

	
	keyVBox.getChildren().addAll(new Label("Keybind / Macro"),keybindTA,learnB);

	
	modalRoot.setLeft(dialogVbox);
	modalRoot.setCenter(sep1);
	modalRoot.setRight(keyVBox);
	modalRoot.setPadding(new Insets(10,10,10,10));
	Scene dialogScene = new Scene(modalRoot, 490, 220);
	dialog.setScene(dialogScene);
	dialog.setTitle("Add new Rule");
	dialogScene.getStylesheets().add(getClass().getResource("cyborg_dark.css").toExternalForm());
	dialog.show();

	actionDrop.setOnAction(e-> {

	    if (actionDrop.getSelectionModel().getSelectedItem() == "Key / Macro") {
		learnB.setDisable(false);
		browse.setDisable(true);
	    }else if (actionDrop.getSelectionModel().getSelectedItem() == "Wave Sound"){
		learnB.setDisable(true);
		browse.setDisable(false);
	    }else {

	    }
	});
	learnB.setOnAction(e-> {
	    if (learnB.isSelected()) {
		//keysToUse.clear();
		keybindTA.clear();
		keybindTA.setDisable(false);
		keybindTA.requestFocus();
	    }else {
		keybindTA.setDisable(true);
	    }
	});
	browse.setOnAction(e-> {
	    File selectedFile = fileChooser.showOpenDialog(dialog);
	    if (selectedFile != null){
		
		fileName = selectedFile.getName();
		filePath = selectedFile.toPath();
		
		path.setText(fileName);
		
	    }
	});
	keybindTA.setOnKeyPressed(e-> {
	    KeyCode keyCode = e.getCode();
	    keysPressed2.put(keyCode, EnumDirection.DOWN);
	    keybindTA.appendText(keyCode.name()+" ");
	    keybindTA.appendText(AwesomeIcons.ICON_ARROW_DOWN+"\n\r");
	});
	keybindTA.setOnKeyReleased(e-> {
	    KeyCode keyCode = e.getCode();
	    keysPressed2.put(keyCode, EnumDirection.UP);
	    keybindTA.appendText(keyCode.name()+" ");
	    keybindTA.appendText(AwesomeIcons.ICON_ARROW_UP+"\n\r");
	});
	create.setOnAction(e -> {  //TODO Change if's to be in series not nested.
	    if (name.getText().isEmpty()){
		warnTextDialog.setText("*Invalid Rule Name");
		return;
	    }
	    if (buttonInput.getText().isEmpty()) {
		warnTextDialog.setText("*Press midi device Button.");
		return;
	    }
	    if (actionDrop.getSelectionModel().getSelectedItem() == "Key / Macro") {
		if (!keybindTA.getText().isEmpty()) { 
		    addControlRow(name.getText(), buttonInput.getText(), actionDrop.getValue(), keybindTA.getText().replaceAll("(\\r|\\n)", ","));
		    Action.actionMap.put(stringToInt(buttonInput.getText()), new Action(EnumActionType.KEYBIND, keysPressed2));
		    //keysPressed2.clear();
		    dialog.close();
		}else {
		    warnTextDialog.setText("*Invalid Keybind or Macro");
		    return;
		}
	    } else if (actionDrop.getSelectionModel().getSelectedItem() == "Wave Sound") {
		if (!path.getText().isEmpty()) {
		    addControlRow(name.getText(), buttonInput.getText(), actionDrop.getValue(), fileName);
		    Action.actionMap.put(stringToInt(buttonInput.getText()), new Action(EnumActionType.FILE, filePath));
		    dialog.close();   
		} else {
		    warnTextDialog.setText("*Invalid File Path");
		    return;
		}
	    } 
	});
	cancel.setOnAction(e -> {dialog.close();});
    }
    
    private Integer stringToInt(String text) {
	try{
	    return Integer.parseInt(text.trim());
	}catch(NumberFormatException e){
	    return 0;
	}
    }
    private void addControlRow(String name,String butId, String actionType, String action) {
	HBox bboxContainer = new HBox();
	//buttonRows.add(bboxContainer);// TODO Not sure if correct technique to access HBox's later from separate class.
	Separator sep1,sep2,sep3,sep4;
	Label blabel,bval,actionTypeLabel,actionLabel;
	bboxContainer.setSpacing(10);
	bboxContainer.setPadding(new Insets(5,5,5,5));
	blabel = new Label(name);
	blabel.setAlignment(Pos.CENTER);
	blabel.setPrefHeight(25);
	blabel.setPrefWidth(150);
	sep1 = new Separator();
	sep1.setOrientation(Orientation.VERTICAL);
	bval = new Label(butId);
	bval.setAlignment(Pos.CENTER);
	bval.setPrefWidth(50);
	bval.setPrefHeight(30);
	sep2 = new Separator();
	sep2.setOrientation(Orientation.VERTICAL);
	actionTypeLabel = new Label(actionType);
	actionTypeLabel.setPrefWidth(100);
	actionTypeLabel.setAlignment(Pos.CENTER);
	sep3 = new Separator();
	sep3.setOrientation(Orientation.VERTICAL);
	sep4 = new Separator();
	sep4.setOrientation(Orientation.VERTICAL);
	actionLabel = new Label(action);
	actionLabel.setId("awesomeLabel");
	actionLabel.setPrefWidth(300);
	actionLabel.setAlignment(Pos.CENTER);
	Button deleteRow = new Button("Delete");
	bboxContainer.getChildren().addAll(blabel,sep1,bval,sep2,actionTypeLabel,sep3,actionLabel,sep4,deleteRow);
	vbutrows.getChildren().add(bboxContainer);
	deleteRow.setOnAction(e -> {
	    vbutrows.getChildren().remove(bboxContainer);
	    Action.actionMap.remove(stringToInt(bval.getText()));
	});
    }
}
