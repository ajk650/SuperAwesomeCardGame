/* Group 8
 * ------------------------------------------
 * LeaderboardController:
 * This controller controls the leaderboard portions after being chosen from the main menu.
 * A CSV file is opened and read showing all of the players who have won and their
 * respective scores.
 * Music played represents an tavern-like theme where the user gets to rest and lookaround.
 */

// imported packages
package application.controller;

// imported libraries
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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class LeaderboardController {
	@FXML
	private AnchorPane mainPane2;

	@FXML
	private AnchorPane pane;
	
    @FXML
    private ImageView MainMenuButton;

	@FXML
	private TableColumn<String, Player> nameColumn;

	@FXML
	private TableView<Player> leaderboardTable;

	@FXML
	private TableColumn<Player, Player> scoreColumn;
	
	public MediaPlayer playAudio;
	public Media audio;

	// public ArrayList<Player> players;

	/* on start load in data from the csv file and print them to the table view 
	 * columns named player and score and sorts them by player score
	 */
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

	// handleMainMenuButton sends the user back to the main menu page
	public void handleMainMenuButton(MouseEvent event) throws IOException {
		playAudio.pause();
		URL url = new File("src/application/view/mainmenu.fxml").toURI().toURL();
		mainPane2 = FXMLLoader.load(url);
		Scene scene = new Scene(mainPane2);// pane you are GOING TO show
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();// pane you are ON
		window.setScene(scene);
		window.show();
	}
	
	// Take in a MediaPlayer and string to the audio track and play the specified audio
	public MediaPlayer play(MediaPlayer playAudio, String audioTrack) throws MalformedURLException {
		
		URL url = new File("resources/audio/" + audioTrack).toURI().toURL();

		//audio = new Media("./audio/rick.mp3"); //does not work need to use URL like Anchor pane
		audio = new Media(url.toString());
		
		playAudio = new MediaPlayer(audio);
		playAudio.setVolume(0.2);
		playAudio.play();
//		System.out.println("[**] playAudio play: " + playAudio);
		return playAudio;
	}

}
