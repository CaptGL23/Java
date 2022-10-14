/*
    Daniel J. Litten II
    Southwestern College - Professional Studies
    CSCI 431 - Java Programming Principles II
    Mr. Terrell Hebert
    April 15, 2022
*/

/*
    This GUI lets the user enter their first, middle,
    and last name, as well as their preferred title.
    There are buttons that display the user's name
    formatted in various ways.
 */

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class NameFormatter extends Application
{
    // Fields
    private TextField firstNameTextField;
    private TextField middleNameTextField;
    private TextField lastNameTextField;
    private TextField prefTitleTextField;
    private Label resultLabel;

    public static void main(String[] args)
    {
        // Launch the application.
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        // Create Labels to display a prompt.
        Label fNpromptLabel = new Label("Enter your first name:");
        Label mNpromptLabel = new Label("Enter your middle name:");
        Label lNpromptLabel = new Label("Enter your last name:");
        Label pTpromptLabel = new Label("Enter your preferred title (Mr., Mrs., Ms., Dr., etc.:");

        // Create 4 TextField for input.
        firstNameTextField = new TextField();
        middleNameTextField = new TextField();
        lastNameTextField = new TextField();
        prefTitleTextField = new TextField();

        // Create Buttons to display the user's name formatted differently.
        Button button1 = new Button("Preferred title, First Middle Last");
        Button button2 = new Button("First Middle Last");
        Button button3 = new Button("First Last");
        Button button4 = new Button("Last, First Middle, Preferred title");
        Button button5 = new Button("Last, First Middle");
        Button button6 = new Button("Last, First");

        // Register the event handlers.
        button1.setOnAction(new ButtonClickHandler1());
        button2.setOnAction(new ButtonClickHandler2());
        button3.setOnAction(new ButtonClickHandler3());
        button4.setOnAction(new ButtonClickHandler4());
        button5.setOnAction(new ButtonClickHandler5());
        button6.setOnAction(new ButtonClickHandler6());

        // Create an empty Label to display the result.
        resultLabel = new Label();

        // Put the promptLabels and the TextFields in HBoxes.
        HBox hbox1 = new HBox(10, fNpromptLabel, firstNameTextField);
        HBox hbox2 = new HBox(10, mNpromptLabel, middleNameTextField);
        HBox hbox3 = new HBox(10, lNpromptLabel, lastNameTextField);
        HBox hbox4 = new HBox(10, pTpromptLabel, prefTitleTextField);
        HBox hbox5 = new HBox(10, button1, button2, button3);
        HBox hbox6 = new HBox(10, button4, button5, button6);

        // Put the HBoxes and resultLabel in a VBox.
        VBox vbox = new VBox(10, hbox1, hbox2, hbox3, hbox4, hbox5, hbox6, resultLabel);

        // Set the VBox's alignment to center.
        vbox.setAlignment(Pos.CENTER);

        // Set the VBox's padding to 10 pixels.
        vbox.setPadding(new Insets(10));

        // Create a Scene.
        Scene scene = new Scene(vbox);

        // Add the Scene to the Stage.
        primaryStage.setScene(scene);

        // Set the stage title.
        primaryStage.setTitle("Name Formatter");

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
            // Get required Text fields
            String first = firstNameTextField.getText();
            String middle = middleNameTextField.getText();
            String last = lastNameTextField.getText();
            String prefTitle = prefTitleTextField.getText();

            // Display the results
            resultLabel.setText(prefTitle + " " + first + " " + middle + " " + last);
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
            // Get required Text fields
            String first = firstNameTextField.getText();
            String middle = middleNameTextField.getText();
            String last = lastNameTextField.getText();

            // Display the results
            resultLabel.setText(first + " " + middle + " " + last);
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
            // Get required Text fields
            String first = firstNameTextField.getText();
            String last = lastNameTextField.getText();

            // Display the results
            resultLabel.setText(first + " " + last);
        }
    }

    /**
     * Event handler class for button4
     */
    class ButtonClickHandler4 implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event)
        {
            // Get required Text fields
            String first = firstNameTextField.getText();
            String middle = middleNameTextField.getText();
            String last = lastNameTextField.getText();
            String prefTitle = prefTitleTextField.getText();

            // Display the results
            resultLabel.setText(last + ", " + first + " " + middle + ", " + prefTitle);
        }
    }
    /**
     * Event handler class for button5
     */
    class ButtonClickHandler5 implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event)
        {
            // Get required Text fields
            String first = firstNameTextField.getText();
            String middle = middleNameTextField.getText();
            String last = lastNameTextField.getText();

            // Display the results
            resultLabel.setText(last + ", " + first + " " + middle);
        }
    }

    /**
     * Event handler class for button6
     */
    class ButtonClickHandler6 implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event)
        {
            // Get required Text fields
            String first = firstNameTextField.getText();
            String middle = middleNameTextField.getText();
            String last = lastNameTextField.getText();

            // Display the results
            resultLabel.setText(last + ", " + first);
        }
    }
}
