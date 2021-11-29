/* Group 8
 * ------------------------------------------
 * GameController:
 * This controller controls the game buttons, outputs of text and visible designs of the game.
 * Players can draw cards and their HP may/may not be reduced based on the conditions
 * of the cards drawn to the players.
 * Music played represents a battle theme for the two users who are dueling.
 */

// imported package
package application.controller;

// imported libraries
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class GameController implements Initializable{
//    @FXML
//    private TextArea player2Card;
//
//    @FXML
//    private TextArea player1Card;
	
	private Stage stage;
	private Scene scene;
	public MediaPlayer playAudio;
	public Media audio;
    
	@FXML
    private TextArea player2Card;

    @FXML
    private AnchorPane gameMenu;

    @FXML
    private ImageView drawButton;
    
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

    @FXML
	private StackPane stackPane;

    /*
     * handleDrawButton starts the game off with 2 cards, 1 for each respective player.
     * Each consists of a % chance of getting Defend, Attack, or Run cards with values 
     * between 1-10 multiplied times 10. Based on the cards they go through certain
     * conditions and their output is displayed to the program. A check for health points
     * is also called to see if any players have fallen.
     */
    @FXML
    BigDecimal[] handleDrawButton(MouseEvent event) throws FileNotFoundException {
		Cards p1Card= new Cards();
		Cards p2Card = new Cards();
		
		System.out.println("[**] testCard1:");
		p1Card = p1Card.createCard();
		System.out.println("[**] testCard2:");
		p2Card =  p2Card.createCard();
		Game newGame = new Game();
		
		// player1 ATTACK | player2 ATTACK
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
				System.out.println("[**] pLost = " + pLose);
				pLoseButton.fire();
			}
			else if(pLose == 2) {
				System.out.println("[**] pLost = " + pLose);
				pLoseButton.fire();
			}
			else if(pLose == 3) {
				System.out.println("[**] pLost = " + pLose);
				pLoseButton.fire();
			}
	    }	
		// player1 ATTACK | player2 DEFEND
		else if( p1Card.cardType == "ATTACK" &&  p2Card.cardType == "DEFEND" )
	    {
			p2Health = newGame.AttackDefend(p1Card, p2Card, p1Image, p1Value, p2Image, p2Value, outcome, p2HP, p1Health, p2Health, p1HText, p2HText, maxHealth);
			pLose = newGame.hpCheck(p1Health,p2Health,pLose);
			if(pLose == 1) {
				System.out.println("[**] pLost = " + pLose);
				pLoseButton.fire();
			}
			else if(pLose == 2) {
				System.out.println("[**] pLost = " + pLose);
				pLoseButton.fire();
			}
			else if(pLose == 3) {
				System.out.println("[**] pLost = " + pLose);
				pLoseButton.fire();
			}
			pHealth[0] = p1Health;
			pHealth[1] = p2Health;
	    }
		// player1 ATTACK | player2 RUN
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
				System.out.println("[**] pLost = " + pLose);
				pLoseButton.fire();
			}
			else if(pLose == 2) {
				System.out.println("[**] pLost = " + pLose);
				pLoseButton.fire();
			}
			else if(pLose == 3) {
				System.out.println("[**] pLost = " + pLose);
				pLoseButton.fire();
			}
	    }
		// player1 DEFEND | player2 ATTACK
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
				System.out.println("[**] pLost = " + pLose);
				pLoseButton.fire();
			}
			else if(pLose == 2) {
				System.out.println("[**] pLost = " + pLose);
				pLoseButton.fire();
			}
			else if(pLose == 3) {
				System.out.println("[**] pLost = " + pLose);
				pLoseButton.fire();
			}
	    }
		// player1 DEFEND | player2 DEFEND
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
				System.out.println("[**] pLost = " + pLose);
				pLoseButton.fire();
			}
			else if(pLose == 2) {
				System.out.println("[**] pLost = " + pLose);
				pLoseButton.fire();
			}
			else if(pLose == 3) {
				System.out.println("[**] pLost = " + pLose);
				pLoseButton.fire();
			}
	    }
		// player1 DEFEND | player2 RUN
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
				System.out.println("[**] pLost = " + pLose);
				pLoseButton.fire();
			}
			else if(pLose == 2) {
				System.out.println("[**] pLost = " + pLose);
				pLoseButton.fire();
			}
			else if(pLose == 3) {
				System.out.println("[**] pLost = " + pLose);
				pLoseButton.fire();
			}
	    }
		// player1 RUN | player2 ATTACK
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
				System.out.println("[**] pLost = " + pLose);
				pLoseButton.fire();
			}
			else if(pLose == 2) {
				System.out.println("[**] pLost = " + pLose);
				pLoseButton.fire();
			}
			else if(pLose == 3) {
				System.out.println("[**] pLost = " + pLose);
				pLoseButton.fire();
			}
	    }
		// player1 RUN | player2 DEFEND
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
				System.out.println("[**] pLost = " + pLose);
				pLoseButton.fire();
			}
			else if(pLose == 2) {
				System.out.println("[**] pLost = " + pLose);
				pLoseButton.fire();
			}
			else if(pLose == 3) {
				System.out.println("[**] pLost = " + pLose);
				pLoseButton.fire();
			}
	    }
		// player1 RUN | player2 RUN
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
			// p1 lost
			if(pLose == 1) {
				System.out.println("[**] pLost = " + pLose);
				pLoseButton.fire();
			}
			else if(pLose == 2) {
				System.out.println("[**] pLost = " + pLose);
				pLoseButton.fire();
			}
			else if(pLose == 3) {
				System.out.println("[**] pLost = " + pLose);
				pLoseButton.fire();
			}
	    }
		return pHealth;
		
		
    }

    /*
     * handlePLose sends the user to a game over screen once a player has lost
     */
    @FXML
    private void handlePLose(ActionEvent event) throws IOException {
    	System.out.println("[**] A player has lost.");
    	
    	URL url = new File("src/application/view/GameOver.fxml").toURI().toURL();
    	FXMLLoader parent = new FXMLLoader(url);
        Parent root = parent.load();
        playAudio.pause();
        GameOverController go = parent.getController();
        go.hpScore(pLose, pHealth);
        Scene scene = new Scene(root);	
//        scene.getStylesheets().add(getClass().getResource("src/application/application.css").toExternalForm());
//        scene.getStylesheets().add("src/application/application.css");
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();	
    }
    
    // Override initialize method
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		p1HP.setStyle("-fx-accent: #1dc582");		//can also use hex values
		p1HP.setProgress(p1Health.doubleValue()); 	// range from 0.0 - 1.0
		p2HP.setStyle("-fx-accent: #1dc582");		//can also use hex values
		p2HP.setProgress(p2Health.doubleValue()); 	// range from 0.0 - 1.0
		try {
			playAudio = play(playAudio, "battletheme.mp3");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
