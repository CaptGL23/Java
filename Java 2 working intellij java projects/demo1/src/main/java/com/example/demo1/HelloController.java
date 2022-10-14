
package com.example.demo1;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label sinisterText;

    @FXML
    private Label dexterText;

    @FXML
    private Label mediumText;

    @FXML
    protected void onSinisterButtonClick()
    {
        sinisterText.setText("Left");
    }

    @FXML
    protected void onDexterButtonClick()
    {
        dexterText.setText("Right");
    }

    @FXML
    protected void onMediumButtonClick()
    {
        mediumText.setText("Center");
    }
}
