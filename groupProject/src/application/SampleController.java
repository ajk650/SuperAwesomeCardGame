package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class SampleController {

    @FXML
    private AnchorPane mainScreen;

    @FXML
    private Button startBtn;

    @FXML
    private Button leaderBtn;

    @FXML
    private Button settingsBtn;

    @FXML
    void startHandle(ActionEvent event) {
    	System.out.println("Game Start Button");
    }

    @FXML
    void leaderHandle(ActionEvent event) {
    	System.out.println("Leaderboard Button");
    }

    @FXML
    void settingsHandle(ActionEvent event) {
    	System.out.println("Settings Button");
    }

}
