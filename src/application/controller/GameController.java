package application.controller;

import application.model.Cards;
import application.model.Game;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class GameController {
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

}
