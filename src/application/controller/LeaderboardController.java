package application.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
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
	
	public MediaPlayer playAudio;
	public Media audio;

	// public ArrayList<Player> players;

	public void initialize() throws FileNotFoundException {
		try {
			playAudio = play(playAudio, "leaderboard.wav");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ObservableList<Player> players = FXCollections.observableArrayList();
		try {
			File file = new File("src/players.csv");
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
		playAudio.pause();
		URL url = new File("src/application/view/mainmenu.fxml").toURI().toURL();
		mainPane2 = FXMLLoader.load(url);
		Scene scene = new Scene(mainPane2);// pane you are GOING TO show
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();// pane you are ON
		window.setScene(scene);
		window.show();
	}
	
	public MediaPlayer play(MediaPlayer playAudio, String audioTrack) throws MalformedURLException {
		
		URL url = new File("resources/audio/" + audioTrack).toURI().toURL();

		//audio = new Media("./audio/rick.mp3"); //does not work need to use URL like Anchor pane
		audio = new Media(url.toString());
		
		playAudio = new MediaPlayer(audio);
		playAudio.setVolume(0.15);
		playAudio.play();
//		System.out.println("[**] playAudio play: " + playAudio);
		return playAudio;
	}

}
