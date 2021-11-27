package application.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

import application.model.Cards;
import application.model.Game;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GameController implements Initializable{
//    @FXML
//    private TextArea player2Card;
//
//    @FXML
//    private TextArea player1Card;

    @FXML
    private AnchorPane gameMenu;
    
    @FXML
    private Button drawButton;

    @FXML
    private TextArea outcome;
    
    @FXML
    private ImageView p1Image;
    
    @FXML
    private ImageView p2Image;
    
    @FXML
    private Text p1Value;
    
    @FXML
    private Text p2Value;
    
    @FXML
    private Text p1HText;
    
    @FXML
    private Text p2HText;
    
    @FXML
    private ProgressBar p1HP;
    
    @FXML
    private ProgressBar p2HP;
    
    @FXML
    private Button pLoseButton;
    
  //The BigDecimal(BD) class gives its user complete control over rounding behavior
    public double maxHealth = 1.0;
    public int pLose = 0;
  	public BigDecimal progress = new BigDecimal(String.format("%.2f", maxHealth)); //set to 2 decimal places and start at 1.0
  	public BigDecimal p1Health = new BigDecimal(String.format("%.2f", maxHealth)); //set to 2 decimal places and start at 1.0
  	public BigDecimal p2Health = new BigDecimal(String.format("%.2f", maxHealth)); //set to 2 decimal places and start at 1.0
  	public BigDecimal[] pHealth = new BigDecimal[2];
  	public BigDecimal test = new BigDecimal(String.format("%.2f", 0.00)); //set to 2 decimal places and start at 1.0

    @FXML
    BigDecimal[] handleDrawButton(ActionEvent event) throws FileNotFoundException {
		Cards p1Card= new Cards();
		Cards p2Card = new Cards();
		
		System.out.println("[**] testCard1:");
		p1Card = p1Card.createCard();
		System.out.println("[**] testCard2:");
		p2Card =  p2Card.createCard();
		Game newGame = new Game();
		
		if( p1Card.cardType == "ATTACK" &&  p2Card.cardType == "ATTACK" )
	    {
			pHealth = newGame.AttackAttack(p1Card, p2Card, p1Image, p1Value, p2Image, p2Value, outcome, p1HP, p2HP, p1Health, p2Health, pHealth, p1HText, p2HText,maxHealth);
			System.out.println("[**] pHealth[0] = p1Health | " + pHealth[0]);
			System.out.println("[**] pHealth[1] = p2Health | " + pHealth[1]);
			p1Health = pHealth[0];
			p2Health = pHealth[1];
			System.out.println("[**] pHealth[0] = p1Health | " + pHealth[0]);
			System.out.println("[**] pHealth[1] = p2Health | " + pHealth[1]);
			pLose = newGame.hpCheck(p1Health,p2Health,pLose);
			if(pLose == 1) {
				pLoseButton.fire();
			}

			//			newGame.AttackAttack(testCard1,testCard2, player1Card, player2Card, outcome);
//			return pHealth;
	    }	
		else if( p1Card.cardType == "ATTACK" &&  p2Card.cardType == "DEFEND" )
	    {
			p2Health = newGame.AttackDefend(p1Card, p2Card, p1Image, p1Value, p2Image, p2Value, outcome, p2HP, p1Health, p2Health, p1HText, p2HText, maxHealth);
			pLose = newGame.hpCheck(p1Health,p2Health,pLose);
			if(pLose == 1) {
				pLoseButton.fire();
			}
			pHealth[0] = p1Health;
			pHealth[1] = p2Health;
//			newGame.AttackDefend(testCard1,testCard2, player1Card, player2Card, outcome);
	    }
		else if( p1Card.cardType == "ATTACK" &&  p2Card.cardType == "RUN" )
	    {
			p2Health = newGame.AttackRun(p1Card, p2Card, p1Image, p1Value, p2Image, p2Value, outcome, p2HP, p1Health, p2Health, p1HText, p2HText, maxHealth);
			System.out.println("[**] pHealth[0] = p1Health | " + pHealth[0]);
			System.out.println("[**] pHealth[1] = p2Health | " + pHealth[1]);
			pHealth[0] = p1Health;
			pHealth[1] = p2Health;
			System.out.println("[**] pHealth[0] = p1Health | " + pHealth[0]);
			System.out.println("[**] pHealth[1] = p2Health | " + pHealth[1]);
			pLose = newGame.hpCheck(p1Health,p2Health,pLose);
			if(pLose == 1) {
				pLoseButton.fire();
			}
//			newGame.AttackRun(testCard1,testCard2, player1Card, player2Card, outcome);
	    }
		else if( p1Card.cardType == "DEFEND" &&  p2Card.cardType == "ATTACK" )
	    {
			p1Health = newGame.DefendAttack(p1Card, p2Card, p1Image, p1Value, p2Image, p2Value, outcome, p1HP, p1Health, p2Health, p1HText, p2HText, maxHealth);
			System.out.println("[**] pHealth[0] = p1Health | " + pHealth[0]);
			System.out.println("[**] pHealth[1] = p2Health | " + pHealth[1]);
			pHealth[0] = p1Health;
			pHealth[1] = p2Health;
			System.out.println("[**] pHealth[0] = p1Health | " + pHealth[0]);
			System.out.println("[**] pHealth[1] = p2Health | " + pHealth[1]);
			pLose = newGame.hpCheck(p1Health,p2Health,pLose);
			if(pLose == 1) {
				pLoseButton.fire();
			}
//			newGame.DefendAttack(testCard1,testCard2, player1Card, player2Card, outcome);
	    }
		else if( p1Card.cardType == "DEFEND" &&  p2Card.cardType == "DEFEND" )
	    {
			newGame.DefendDefend(p1Card, p2Card, p1Image, p1Value, p2Image, p2Value, outcome, p1Health, p2Health, p1HText, p2HText, maxHealth);
			System.out.println("[**] pHealth[0] = p1Health | " + pHealth[0]);
			System.out.println("[**] pHealth[1] = p2Health | " + pHealth[1]);
			pHealth[0] = p1Health;
			pHealth[1] = p2Health;
			System.out.println("[**] pHealth[0] = p1Health | " + pHealth[0]);
			System.out.println("[**] pHealth[1] = p2Health | " + pHealth[1]);
			pLose = newGame.hpCheck(p1Health,p2Health,pLose);
			if(pLose == 1) {
				pLoseButton.fire();
			}
//			pHealth[0] = p1Health;
//			pHealth[1] = p2Health;
//			newGame.DefendDefend(testCard1,testCard2, player1Card, player2Card, outcome);
	    }
		else if( p1Card.cardType == "DEFEND" &&  p2Card.cardType == "RUN" )
	    {
			newGame.DefendRun(p1Card, p2Card, p1Image, p1Value, p2Image, p2Value, outcome, p1Health, p2Health, p1HText, p2HText, maxHealth);
			System.out.println("[**] pHealth[0] = p1Health | " + pHealth[0]);
			System.out.println("[**] pHealth[1] = p2Health | " + pHealth[1]);
			pHealth[0] = p1Health;
			pHealth[1] = p2Health;
			System.out.println("[**] pHealth[0] = p1Health | " + pHealth[0]);
			System.out.println("[**] pHealth[1] = p2Health | " + pHealth[1]);
			pLose = newGame.hpCheck(p1Health,p2Health,pLose);
			if(pLose == 1) {
				pLoseButton.fire();
			}
//			newGame.DefendRun(testCard1,testCard2, player1Card, player2Card, outcome);
	    }
		else if( p1Card.cardType == "RUN" &&  p2Card.cardType == "ATTACK" )
	    {
			p1Health = newGame.RunAttack(p1Card, p2Card, p1Image, p1Value, p2Image, p2Value, outcome, p1HP, p1Health, p2Health, p1HText, p2HText, maxHealth);
			System.out.println("[**] pHealth[0] = p1Health | " + pHealth[0]);
			System.out.println("[**] pHealth[1] = p2Health | " + pHealth[1]);
			pHealth[0] = p1Health;
			pHealth[1] = p2Health;
			System.out.println("[**] pHealth[0] = p1Health | " + pHealth[0]);
			System.out.println("[**] pHealth[1] = p2Health | " + pHealth[1]);
			pLose = newGame.hpCheck(p1Health,p2Health,pLose);
			if(pLose == 1) {
				pLoseButton.fire();
			}
//			newGame.RunRun(testCard1,testCard2, player1Card, player2Card, outcome);
	    }
		else if( p1Card.cardType == "RUN" &&  p2Card.cardType == "DEFEND" )
	    {
			newGame.RunDefend(p1Card, p2Card, p1Image, p1Value, p2Image, p2Value, outcome, p1Health, p2Health, p1HText, p2HText, maxHealth);
			System.out.println("[**] pHealth[0] = p1Health | " + pHealth[0]);
			System.out.println("[**] pHealth[1] = p2Health | " + pHealth[1]);
			pHealth[0] = p1Health;
			pHealth[1] = p2Health;
			System.out.println("[**] pHealth[0] = p1Health | " + pHealth[0]);
			System.out.println("[**] pHealth[1] = p2Health | " + pHealth[1]);
			pLose = newGame.hpCheck(p1Health,p2Health,pLose);
			if(pLose == 1) {
				pLoseButton.fire();
			}
			pHealth[0] = p1Health;
			pHealth[1] = p2Health;
//			newGame.RunRun(testCard1,testCard2, player1Card, player2Card, outcome);
	    }
		else if( p1Card.cardType == "RUN" &&  p2Card.cardType == "RUN" )
	    {
			newGame.RunRun(p1Card, p2Card, p1Image, p1Value, p2Image, p2Value, outcome, p1Health, p2Health, p1HText, p2HText, maxHealth);
			System.out.println("[**] pHealth[0] = p1Health | " + pHealth[0]);
			System.out.println("[**] pHealth[1] = p2Health | " + pHealth[1]);
			pHealth[0] = p1Health;
			pHealth[1] = p2Health;
			System.out.println("[**] pHealth[0] = p1Health | " + pHealth[0]);
			System.out.println("[**] pHealth[1] = p2Health | " + pHealth[1]);
			pLose = newGame.hpCheck(p1Health,p2Health,pLose);
			if(pLose == 1) {
				pLoseButton.fire();
			}
//			newGame.RunRun(testCard1,testCard2, player1Card, player2Card, outcome);
	    }
		return pHealth;
		
		
    }

    @FXML
    private void handlePLose(ActionEvent event) throws IOException {
    	System.out.println("[**] A player has lost.");
    	
    	URL url = new File("src/application/view/GameOver.fxml").toURI().toURL();
    	FXMLLoader parent = new FXMLLoader(url);
        Parent root = parent.load();
        
        GameOverController go = parent.getController();
        Scene scene = new Scene(root);	
        scene.getStylesheets().add(getClass().getResource("src/application/application.css").toExternalForm());
//        scene.getStylesheets().add("src/application/application.css");
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();	
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		p1HP.setStyle("-fx-accent: #1dc582");		//can also use hex values
		p1HP.setProgress(p1Health.doubleValue()); 	// range from 0.0 - 1.0
		p2HP.setStyle("-fx-accent: #1dc582");		//can also use hex values
		p2HP.setProgress(p2Health.doubleValue()); 	// range from 0.0 - 1.0
		if((test.doubleValue()*100) <= 0) {
			System.out.println("Test game over | test = " + test.doubleValue()*100 + " < 0");
		}
	}

}
