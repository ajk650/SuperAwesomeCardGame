package application.controller;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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
    void startHandle(ActionEvent event) throws IOException {
    	System.out.println("Game Start Button");
    	URL url = new File("src/application/view/Game.fxml").toURI().toURL();
    	FXMLLoader parent = new FXMLLoader(url);
        Parent root = parent.load();
        
        GameController gc = parent.getController();
        Scene scene = new Scene(root);	
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();	
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
