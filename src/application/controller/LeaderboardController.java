package application.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Comparator;

import application.model.Player;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LeaderboardController {
	// AnchorPane for main screen
	@FXML
	private AnchorPane mainPane2;

	// title label
	@FXML
	private Label gameOverLabel;

	// AnchorPane for current screen
	@FXML
	private AnchorPane pane;

	// Table: name column
	@FXML
	private TableColumn<String, Player> nameColumn;

	// Table view holds leaderboard names and scores
	@FXML
	private TableView<Player> leaderboardTable;

	// TableL: score column
	@FXML
	private TableColumn<Player, Player> scoreColumn;

	public void initialize() throws FileNotFoundException {
		// array list of player objects to be displayed in leaderboard
		ObservableList<Player> players = FXCollections.observableArrayList();
		try {
			// Reading player data from a csv file
			// creates player object from data and adds it to array list
			File file = new File("src/scores.csv");
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = "";
			String[] tempArr;
			while ((line = br.readLine()) != null) {
				tempArr = line.split(",");
				Player temp = new Player(tempArr[0], tempArr[1]);
				players.add(temp);
			}
			br.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		// Sorting ArrayList by score, descending
		players.sort(Comparator.comparing(Player::getScore).reversed());

		// initializing the table columns
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		scoreColumn.setCellValueFactory(new PropertyValueFactory<>("score"));

		// Setting the table to display player arrayList
		leaderboardTable.setItems((ObservableList<Player>) players);

	}

	// button switches to main menu screen
	public void handleMainMenuButton(ActionEvent event) throws IOException {
		URL url = new File("src/Game.fxml").toURI().toURL();
		mainPane2 = FXMLLoader.load(url);
		Scene scene = new Scene(mainPane2);// pane you are GOING TO show
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();// pane you are ON
		window.setScene(scene);
		window.show();
	}

}
