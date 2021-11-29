/* Group 8
 * ------------------------------------------
 * Main:
 * This class handles the launching of the application/game. The user will be taken to the 
 * main menu where they will have a choice between starting the game or going to the
 * leaderboards to see other users.
 */

// imported packages
package application;

// imported libraries
import java.io.File;
import java.net.URL;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			URL url = new File("src/application/view/MainMenu.fxml").toURI().toURL(); 	// url grabs main.fxml
//			URL url = new File("src/application/view/Game.fxml").toURI().toURL(); 	// url grabs main.fxml
			AnchorPane root = (AnchorPane)FXMLLoader.load(url);		// anchor pane loads main.fxml
			Scene scene = new Scene(root,800,800);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	

}
