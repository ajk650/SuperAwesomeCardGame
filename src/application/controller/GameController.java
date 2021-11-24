package application.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import application.model.Cards;
import application.model.Game;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class GameController {
	// temporary for button to game over screen
	@FXML
	private AnchorPane mainPane2;

	@FXML
	private TextArea player2Card;

	@FXML
	private TextArea player1Card;

	@FXML
	private Button drawButton;

	@FXML
	private TextArea outcome;

	@FXML
	void handleDrawButton(ActionEvent event) {
		Cards testCard1 = new Cards();
		Cards testCard2 = new Cards();

		System.out.println("[**] testCard1:");
		testCard1 = testCard1.createCard();
		System.out.println("[**] testCard2:");
		testCard2 = testCard2.createCard();
		Game newGame = new Game();

		if (testCard1.cardType == "ATTACK" && testCard2.cardType == "ATTACK") {
			newGame.AttackAttack(testCard1, testCard2, player1Card, player2Card, outcome);
		} else if (testCard1.cardType == "ATTACK" && testCard2.cardType == "DEFEND") {
			newGame.AttackDefend(testCard1, testCard2, player1Card, player2Card, outcome);
		} else if (testCard1.cardType == "ATTACK" && testCard2.cardType == "RUN") {
			newGame.AttackRun(testCard1, testCard2, player1Card, player2Card, outcome);
		} else if (testCard1.cardType == "DEFEND" && testCard2.cardType == "ATTACK") {
			newGame.DefendAttack(testCard1, testCard2, player1Card, player2Card, outcome);
		} else if (testCard1.cardType == "DEFEND" && testCard2.cardType == "DEFEND") {
			newGame.DefendDefend(testCard1, testCard2, player1Card, player2Card, outcome);
		} else if (testCard1.cardType == "DEFEND" && testCard2.cardType == "RUN") {
			newGame.DefendRun(testCard1, testCard2, player1Card, player2Card, outcome);
		} else if (testCard1.cardType == "RUN" && testCard2.cardType == "RUN") {
			newGame.RunRun(testCard1, testCard2, player1Card, player2Card, outcome);
		}

	}

	// temp button to go to game over screen
	public void handleGameOver(ActionEvent event) throws IOException {
		URL url = new File("src/GameOver.fxml").toURI().toURL();
		mainPane2 = FXMLLoader.load(url);
		Scene scene = new Scene(mainPane2);// pane you are GOING TO show
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();// pane you are ON
		window.setScene(scene);
		window.show();
	}

}
