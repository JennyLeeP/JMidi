package application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * 
 * @author JennyLeeP
 *
 */
public class JMidiMain extends Application 
{
    private double xOffset = 0;
    private double yOffset = 0;
    private String Title = "JMidi";
    @Override
    public void start(Stage primaryStage) 
    {
	try {
	    BorderPane wrap = new BorderPane();
	    wrap.setOnMousePressed(e-> { 
		xOffset = e.getSceneX();
		yOffset = e.getSceneY();
	    });
	    wrap.setOnMouseDragged(e-> {
		primaryStage.setX(e.getScreenX() - xOffset);
		primaryStage.setY(e.getScreenY() - yOffset);
	    });
	    BorderPane root = new BorderPane();
	    /*    Header     */
	    HBox headerBox = new HBox();
	    StackPane stack = new StackPane();
	    HBox innerbox = new HBox();
	    innerbox.setId("header");
	    HBox.setHgrow(stack, Priority.ALWAYS);
	    Label title = new Label(Title);
	    title.setId("Title");
	    innerbox.setAlignment(Pos.CENTER);
	    HBox btnBox = new HBox();
	    Button settings = new Button(AwesomeIcons.ICON_COG);
	    settings.setId("set-btn");
	    Button min = new Button(AwesomeIcons.ICON_MINUS);
	    min.setId("min-btn");
	    Button close = new Button(AwesomeIcons.ICON_REMOVE);
	    close.setId("close-btn");
	    btnBox.getChildren().addAll(settings,min,close);
	    btnBox.setAlignment(Pos.CENTER_RIGHT);
	    innerbox.getChildren().add(title);
	    stack.getChildren().addAll(innerbox,btnBox);
	    headerBox.getChildren().add(stack);
	    close.setOnAction(e-> {
		Platform.exit();
	    });
	    min.setOnAction(e-> {
		primaryStage.setIconified(true);
	    });
	    //   End Header 




	    Scene scene = new Scene(wrap,850,400);
	    scene.getStylesheets().add(getClass().getResource("cyborg_dark.css").toExternalForm());
	    scene.setFill(Color.TRANSPARENT);
	    GuiHandler handler = new GuiHandler(root);
	    handler.buildWindow(root);
	    wrap.setCenter(root);
	    wrap.setTop(headerBox);
	    Image icon = new Image("/icons/cyber-bunny-icon.png");
	    primaryStage.initStyle(StageStyle.TRANSPARENT);
	    primaryStage.getIcons().add(icon);
	    primaryStage.setTitle(Title);
	    primaryStage.setScene(scene);
	    primaryStage.show();
	} catch(Exception e) {
	    e.printStackTrace();
	}


    }
    @Override
    public void stop(){
	System.out.println("Stage is closing - Cleaning Up before we go.");
	MidiHandler.stopMidi(GuiHandler.midiSelect.getSelectionModel().getSelectedItem());
	Platform.exit();
	/*
		while (MidiHandler.hasStopped())
		{
			Platform.exit();
		}
	 */
    }
    public static void main(String[] args) {
	launch(args);
    }
}
