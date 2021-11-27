package application.controller;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import application.model.Cards;
import application.model.Game;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GameController {
	 private Stage stage;
	 private Scene scene;
    @FXML
    private TextArea player2Card;

    @FXML
    private TextArea player1Card;

    @FXML
    private Button drawButton;

    @FXML
    private TextArea outcome;
    @FXML
	private StackPane stackPane;

    @FXML
    void handleDrawButton(ActionEvent event) {
		Cards testCard1= new Cards();
		Cards testCard2 = new Cards();
		
		System.out.println("[**] testCard1:");
		testCard1 = testCard1.createCard();
		System.out.println("[**] testCard2:");
		testCard2 = testCard2.createCard();
		Game newGame = new Game();
		
		if( testCard1.cardType == "ATTACK" && testCard2.cardType == "ATTACK" )
	    {
			newGame.AttackAttack(testCard1,testCard2, player1Card, player2Card, outcome);
	    }	
		else if( testCard1.cardType == "ATTACK" && testCard2.cardType == "DEFEND" )
	    {
			newGame.AttackDefend(testCard1,testCard2, player1Card, player2Card, outcome);
	    }
		else if( testCard1.cardType == "ATTACK" && testCard2.cardType == "RUN" )
	    {
			newGame.AttackRun(testCard1,testCard2, player1Card, player2Card, outcome);
	    }
		else if( testCard1.cardType == "DEFEND" && testCard2.cardType == "ATTACK" )
	    {
			newGame.DefendAttack(testCard1,testCard2, player1Card, player2Card, outcome);
	    }
		else if( testCard1.cardType == "DEFEND" && testCard2.cardType == "DEFEND" )
	    {
			newGame.DefendDefend(testCard1,testCard2, player1Card, player2Card, outcome);
	    }
		else if( testCard1.cardType == "DEFEND" && testCard2.cardType == "RUN" )
	    {
			newGame.DefendRun(testCard1,testCard2, player1Card, player2Card, outcome);
	    }
		else if( testCard1.cardType == "RUN" && testCard2.cardType == "RUN" )
	    {
			newGame.RunRun(testCard1,testCard2, player1Card, player2Card, outcome);
	    }
		
		
    }
	@FXML
	private void endGame(ActionEvent event) throws IOException {
		  URL url = new File("src/GameOver.fxml").toURI().toURL();
		  AnchorPane root = FXMLLoader.load(url);
		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
	}

}
