package application.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;

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
import javafx.stage.Stage;

public class GameOverController {
	 private Stage stage;
	 private Scene scene;
    @FXML
    private TextField nameInput;
    @FXML
    private TextField scoreInput;
	@FXML
	private Label gameOverLabel;

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
	public void initialize() throws FileNotFoundException {
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

    @FXML
    void submit(ActionEvent event) throws IOException {
    String file = "src/players.csv";
    String name = nameInput.getText();
    String score = scoreInput.getText();
	//Player mike = new Player("michael","100");
	savePlayerScore(name,score,file);
	  URL url = new File("src/Game.fxml").toURI().toURL();
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

}
