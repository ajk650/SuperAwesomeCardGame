package application.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class GameOverController {
	 private Stage stage;
	 private Scene scene;
	 public int pLoseScore;
	 String score;
	 public MediaPlayer playAudio;
	 public Media audio;
	 
	//Media audio = null;
    @FXML
    private TextField nameInput;
    @FXML
    private TextField scoreInput;
	@FXML
	private Label gameOverLabel;

    @FXML
    private Label playerWinLabel;

	@FXML
	private AnchorPane pane;

	@FXML
	private TableColumn<String, Player> nameColumn;

	@FXML
	private TableView<Player> leaderboardTable;

	@FXML
	private TableColumn<Player, String> scoreColumn;

	// public ArrayList<Player> players;
	@FXML
	public void initialize() throws FileNotFoundException, MalformedURLException {
		Random rand = new Random();
		int randNum = rand.nextInt(10);
		System.out.println("[**] Endgame randNum: " + randNum);
		if(randNum == 0 || randNum == 1 || randNum == 2 || randNum == 3) {
			playAudio = play(playAudio, "rick.mp3");
		}
		else {
			playAudio = play(playAudio,"gameover.mp3");
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
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		scoreColumn.setCellValueFactory(new PropertyValueFactory<>("score"));

		leaderboardTable.setItems((ObservableList<Player>) players);
		leaderboardTable.getSortOrder().add(scoreColumn);
		leaderboardTable.sort();
		//leaderboardTable.getColumns().addAll(nameColumn, scoreColumn);

	}

	void hpScore(int pLose, BigDecimal[] pHealth) {
		if(pLose == 1) {
			pLoseScore = (int)(pHealth[1].doubleValue()*100 - pHealth[0].doubleValue()*100);
			playerWinLabel.setText("Player 1 has FALLEN. Player 2 WINS! GAME OVER!");

		}
		else if(pLose == 2) {
			pLoseScore = (int)(pHealth[0].doubleValue()*100 - pHealth[1].doubleValue()*100);
			playerWinLabel.setText("Player 2 has FALLEN. Player 1 WINS! GAME OVER!");
		}
		else if(pLose == 3) {
			pLoseScore = (int)(pHealth[0].doubleValue()*100);
			playerWinLabel.setText("BOTH Players have FALLEN. No winner! GAME OVER!");
		}
		score = Integer.toString(pLoseScore);
		scoreInput.setText(score);
	}
	
    @FXML
    void submit(ActionEvent event) throws IOException {
    playAudio.pause();
    String file = "src/players.csv";
    String name = nameInput.getText();
//    String score = scoreInput.getText();
//    score = Integer.toString(pLoseScore);
//    scoreInput.setText(score);
	//Player mike = new Player("michael","100");
	savePlayerScore(name,score,file);
	URL url = new File("src/application/view/MainMenu.fxml").toURI().toURL();
	AnchorPane root = FXMLLoader.load(url);
	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	scene = new Scene(root);
	stage.setScene(scene);
	stage.show();
    }
	public void savePlayerScore(String name,String score, String file) {
		try {
			
			FileWriter fw = new FileWriter(file,true );
			BufferedWriter br = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(br);
			pw.println(name+","+score);
			pw.flush();
			pw.close();
			System.out.println("this put stuff in the csv!");
		}catch(Exception e){
			System.out.println("this did not put stuff in the csv :(");
		}
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
