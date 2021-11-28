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
	@FXML
	private AnchorPane mainPane2;

	@FXML
	private Label gameOverLabel;

	@FXML
	private AnchorPane pane;

	@FXML
	private TableColumn<String, Player> nameColumn;

	@FXML
	private TableView<Player> leaderboardTable;

	@FXML
	private TableColumn<Player, Player> scoreColumn;

	// public ArrayList<Player> players;

	public void initialize() throws FileNotFoundException {
		ObservableList<Player> players = FXCollections.observableArrayList();
		try {
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

		players.sort(Comparator.comparing(Player::getScore).reversed());

		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		scoreColumn.setCellValueFactory(new PropertyValueFactory<>("score"));

		leaderboardTable.setItems((ObservableList<Player>) players);

		leaderboardTable.setStyle("-fx-background-color: black");

		// scoreColumn.setSortType(TableColumn.SortType.ASCENDING);
		// leaderboardTable.getSortOrder().add(scoreColumn);
		// leaderboardTable.sort();

	}

	public void handleMainMenuButton(ActionEvent event) throws IOException {
		URL url = new File("src/Game.fxml").toURI().toURL();
		mainPane2 = FXMLLoader.load(url);
		Scene scene = new Scene(mainPane2);// pane you are GOING TO show
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();// pane you are ON
		window.setScene(scene);
		window.show();
	}

}
