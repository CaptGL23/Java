/*
    Daniel J. Litten II
    Southwestern College - Professional Studies
    CSCI 431 - Java Programming Principles II
    Mr. Terrell Hebert
    April 15, 2022
*/

/*
    This GUI translates latin words to english.  It has
    three buttons, one for each latin word to translate.
    When the user clicks a button, the application displays
    the English translation in a Label.
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class LatinTranslator extends Application
{
    // Field for the Label control
    private Label myLabel;

    public static void main(String[] args)
    {
        // Launch the application.
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        // Create a Label control
        myLabel = new Label("Click which word you would like to translate to English.");

        // Create three Button components.
        Button button1 = new Button("Sinister");
        Button button2 = new Button("Dexter");
        Button button3 = new Button("Medium");

        //Register the event handlers
        button1.setOnAction(new ButtonClickHandler1());
        button2.setOnAction(new ButtonClickHandler2());
        button3.setOnAction(new ButtonClickHandler3());

        // Create an VBox.
        VBox vbox = new VBox(10, myLabel, button1, button2, button3);
        vbox.setPadding(new Insets(10));

        // Create a Scene with the VBox as its root node.
        // The Scene is 400 pixels wide by 200 pixels high.
        Scene scene = new Scene(vbox, 400, 200);

        // Set the scene's alignment to center
        vbox.setAlignment(Pos.CENTER);

        // Add the Scene to the Stage.
        primaryStage.setScene(scene);

        // Set the stage title.
        primaryStage.setTitle("Latin Translator");

        // Show the window.
        primaryStage.show();
    }

    /**
     * Event handler class for button1
     */
    class ButtonClickHandler1 implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event)
        {
            myLabel.setText("Left");
        }
    }
    /**
     * Event handler class for button2
     */
    class ButtonClickHandler2 implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event)
        {
            myLabel.setText("Right");
        }
    }

    /**
     * Event handler class for button3
     */
    class ButtonClickHandler3 implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event)
        {
            myLabel.setText("Center");
        }
    }
}