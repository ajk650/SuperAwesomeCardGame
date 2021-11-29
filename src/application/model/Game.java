/* Group 8
 * ------------------------------------------
 * Game:
 * This class handles the overall game structure and the many various conditions a draw can have.
 * This class also handles the decreasing of hp based on whether a player takes damage.
 */

// imported packages
package application.model;

// imported libraries
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigDecimal;


import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class Game {
	//The BigDecimal(BD) class gives its user complete control over rounding behavior
//  	BigDecimal p1Health = new BigDecimal(String.format("%.2f", 1.0)); //set to 2 decimal places and start at 1.0
//  	BigDecimal p2Health = new BigDecimal(String.format("%.2f", 1.0)); //set to 2 decimal places and start at 1.0
//  	BigDecimal[] pHealth = new BigDecimal[2];
	public BigDecimal y = new BigDecimal("100");
	public BigDecimal x = new BigDecimal("0");
	
	/*
	 * Case in which player 1 and player 2 have attack cards. Both players will attack each other
	 * and lower each other's health bars
	 */
	public BigDecimal[] AttackAttack(Cards p1Card, Cards p2Card, ImageView p1Image, Text p1Value, ImageView p2Image, Text p2Value, TextArea outcome, ProgressBar p1hp, ProgressBar p2hp, BigDecimal p1Health, BigDecimal p2Health, BigDecimal[] pHealth, Text p1HText, Text p2HText, double maxHealth) throws FileNotFoundException {
//	public void AttackAttack(Cards testCard1, Cards testCard2, TextArea player1Card, TextArea player2Card, TextArea outcome) {
		if( p1Card.value > p2Card.value) {
//			System.out.println("[**] Player1 hits for " + testCard1.value + "HP!");
//			System.out.println("[**] Player2 hits for " + testCard2.value + "hp!");
//			System.out.println("[**] Player1 > Player2 | " + testCard1.value + " > " + testCard2.value);
//			System.out.println("[**] Player1 wins round");
			System.out.println("[**] P1 Starting HP: " + p1Health.multiply(y));
			System.out.println("[**] P2 Starting HP: " + p2Health.multiply(y));
			
	    	p1Health = decreaseHpBar(p1Health, p1hp, p2Card.value);
	    	p2Health = decreaseHpBar(p2Health, p2hp, p1Card.value);
	    	
			System.out.println("[**] P1 Ending HP: " + p1Health.multiply(y));
			System.out.println("[**] P2 Ending HP: " + p2Health.multiply(y));
			
	    	String picturePath = "pictures\\attack.png";
	    	Image image = new Image(new FileInputStream(picturePath));
	    	p1Image.setImage(image);
	    	p2Image.setImage(image);
	    	p1Value.setText(""+ p1Card.value);
	    	p2Value.setText(""+ p2Card.value);
	    	p1Value.setFill(Color.web("#378bfc"));
	    	p2Value.setFill(Color.web("#378bfc"));
//	    	decreaseHpBar(p1Health, p1hp, testCard2.value);
//	    	decreaseHpBar(p2Health, p2hp, testCard1.value);
	    	
//			p1Image2.setText(testCard1.cardType + "\n\n" + testCard1.value);
//			p1Value2.setText(testCard2.cardType + "\n\n" + testCard2.value);
//	    	p1HText.setText("Player 1 - " + (p1Health.multiply(y).setScale(0, RoundingMode.DOWN)) + "/" + (int)(maxHealth*100));
//	    	p2HText.setText("Player 2 - " + (p2Health.multiply(y).setScale(0, RoundingMode.DOWN)) + "/" + (int)(maxHealth*100));
			outcome.setText(
					"Player1 hits for " + p1Card.value + "hp! \r\n" +
					"Player2 hits for " + p2Card.value + "hp! \r\n" + 
					"Player1 wins the round!"
			);
			pHealth[0] = p1Health;
			pHealth[1] = p2Health;
			
		}
		else if( p1Card.value < p2Card.value) {
//			System.out.println("[**] Player1 hits for " + testCard1.value + "HP!");
//			System.out.println("[**] Player2 hits for " + testCard2.value + "HP!");
//			System.out.println("[**] Player1 < Player2 | " + testCard1.value + " < " + testCard2.value);
//			System.out.println("[**] Player2 wins round");
			System.out.println("[**] P1 Starting HP: " + p1Health.multiply(y));
			System.out.println("[**] P2 Starting HP: " + p2Health.multiply(y));
			
	    	p1Health = decreaseHpBar(p1Health, p1hp, p2Card.value);
	    	p2Health = decreaseHpBar(p2Health, p2hp, p1Card.value);
	    	
			System.out.println("[**] P1 Ending HP: " + p1Health.multiply(y));
			System.out.println("[**] P2 Ending HP: " + p2Health.multiply(y));
			
	    	String picturePath = "pictures\\attack.png";
	    	Image image = new Image(new FileInputStream(picturePath));
	    	p1Image.setImage(image);
	    	p2Image.setImage(image);
	    	p1Value.setText(""+ p1Card.value);
	    	p2Value.setText(""+ p2Card.value);
	    	p1Value.setFill(Color.web("#378bfc"));
	    	p2Value.setFill(Color.web("#378bfc"));
	    	
//			p1Image2.setText(testCard1.cardType + "\n\n" + testCard1.value);
//			p1Value2.setText(testCard2.cardType + "\n\n" + testCard2.value);
//	    	p1HText.setText("Player 1 - " + (p1Health.multiply(y).setScale(0, RoundingMode.DOWN)) + "/" + (int)(maxHealth*100));
//	    	p2HText.setText("Player 2 - " + (p2Health.multiply(y).setScale(0, RoundingMode.DOWN)) + "/" + (int)(maxHealth*100));
	    	outcome.setText(
					"Player1 hits for " + p1Card.value + "hp! \r\n" +
					"Player2 hits for " + p2Card.value + "hp! \r\n" + 
					"Player2 wins the round!"
			);
			pHealth[0] = p1Health;
			pHealth[1] = p2Health;
		}
		else if( p1Card.value == p2Card.value){
//			System.out.println("[**] Player1 hits for " + testCard1.value + "HP!");
//			System.out.println("[**] Player2 hits for " + testCard2.value + "HP!");
//			System.out.println("[**] testCard1 = testCard2 | " + testCard1.value + " = " + testCard2.value);
//			System.out.println("[**] TIE");
			System.out.println("[**] P1 Starting HP: " + p1Health.multiply(y));
			System.out.println("[**] P2 Starting HP: " + p2Health.multiply(y));
			
	    	p1Health = decreaseHpBar(p1Health, p1hp, p2Card.value);
	    	p2Health = decreaseHpBar(p2Health, p2hp, p1Card.value);
	    	
			System.out.println("[**] P1 Ending HP: " + p1Health.multiply(y));
			System.out.println("[**] P2 Ending HP: " + p2Health.multiply(y));
			
	    	String picturePath = "pictures\\attack.png";
	    	Image image = new Image(new FileInputStream(picturePath));
	    	p1Image.setImage(image);
	    	p2Image.setImage(image);
	    	p1Value.setText(""+ p1Card.value);
	    	p2Value.setText(""+ p2Card.value);
	    	p1Value.setFill(Color.web("#378bfc"));
	    	p2Value.setFill(Color.web("#378bfc"));

	    	
//			p1Image2.setText(testCard1.cardType + "\n\n" + testCard1.value);
//			p1Value2.setText(testCard2.cardType + "\n\n" + testCard2.value);
//	    	p1HText.setText("Player 1 - " + (p1Health.multiply(y).setScale(0, RoundingMode.DOWN)) + "/" + (int)(maxHealth*100));
//	    	p2HText.setText("Player 2 - " + (p2Health.multiply(y).setScale(0, RoundingMode.DOWN)) + "/" + (int)(maxHealth*100));
	    	outcome.setText(
					"Player1 hits for " + p1Card.value + "hp! \r\n" +
					"Player2 hits for " + p2Card.value + "hp! \r\n" + 
					"tie"
			);
			pHealth[0] = p1Health;
			pHealth[1] = p2Health;
		}
		
		return pHealth;
	}	
	
	/*
	 * Case in which player 1 has ATTACK and player 2 has DEFEND. Player 1 can only damage if their
	 * card is higher than player 2's. Otherwise, player 2 can absorb all the damage or absorb only some.
	 */
	public BigDecimal AttackDefend(Cards p1Card, Cards p2Card, ImageView p1Image, Text p1Value, ImageView p2Image, Text p2Value, TextArea outcome, ProgressBar p2hp, BigDecimal p1Health, BigDecimal p2Health, Text p1HText, Text p2HText, double maxHealth) throws FileNotFoundException {
		int dmgDiff1 = p1Card.value - p2Card.value;
//		int dmgDiff2 = p2Card.value - p1Card.value;
		System.out.println("[**] Player1 ATTACKs and Player2 DEFENDs");
		if( p1Card.value > p2Card.value) {
//			System.out.println("[**] Player1 hits for " + testCard1.value + "HP!");
//			System.out.println("[**] Player2 defends for " + testCard2.value + "HP!");
//			System.out.println("[**] Player1 > Player2 | " + testCard1.value + " > " + testCard2.value);
//			System.out.println("[**] Player1 - Player2 | " + testCard1.value + " - " + testCard1.value + " = " + dmgDiff1 + "HP");
//			System.out.println("[**] Player2 absorbs " + testCard2.value + " damage but still takes " + dmgDiff1 + " damage");
//			System.out.println("[**] Player1 wins round");
			System.out.println("[**] P1 Starting HP: " + p1Health.multiply(y));
			System.out.println("[**] P2 Starting HP: " + p2Health.multiply(y));
			// 5 > 3 | 5 - 3 | 2 damage
			

			
	    	String picturePath = "pictures\\attack.png";
	    	Image image = new Image(new FileInputStream(picturePath));
	    	p1Image.setImage(image);
	    	picturePath = "pictures\\defend.png";
	    	image = new Image(new FileInputStream(picturePath));
	    	p2Image.setImage(image);
	    	p1Value.setText(""+ p1Card.value);
	    	p2Value.setText(""+ p2Card.value);
	    	p1Value.setFill(Color.web("#378bfc"));
	    	p2Value.setFill(Color.web("#fc3741"));
	    	// p1attack > p2defend | i.e. 5 > 3 -> 2dmg | p2 takes damage from p1
	    	p2Health = decreaseHpBar(p2Health, p2hp, dmgDiff1);	// hit by p1 | decrease p2 hp

			System.out.println("[**] P1 Ending HP: " + p1Health.multiply(y));
			System.out.println("[**] P2 Ending HP: " + p2Health.multiply(y));
			
//	    	p1HText.setText("Player 1 - " + (p1Health.multiply(y).setScale(0, RoundingMode.DOWN)) + "/" + (int)(maxHealth*100));
//	    	p2HText.setText("Player 2 - " + (p2Health.multiply(y).setScale(0, RoundingMode.DOWN)) + "/" + (int)(maxHealth*100));
			outcome.setText(
					"Player1 hits for " + p1Card.value + "hp! \r\n" +
					"Player2 defends for " + p2Card.value + "hp! \r\n" + 
					"Player2 absorbs " + p2Card.value + " damage but still takes " + dmgDiff1 + " damage!\n" + 
					"Player1 wins the round!"
			);
		}
		else if( p1Card.value < p2Card.value) {
//			System.out.println("[**] Player1 hits for " + p1Card.value + "HP!");
//			System.out.println("[**] Player2 defends for " + p2Card.value + "HP!");
//			System.out.println("[**] Player1 < Player2 | " + p1Card.value + " < " + p2Card.value);
//			System.out.println("[**] Player2 - Player1 | " + p2Card.value + " - " + p1Card.value + " = " + dmgDiff2 + "HP");
//			System.out.println("[**] Player2 absorbs " + p1Card.value + " damage");
//			System.out.println("[**] Player2 wins round");
			System.out.println("[**] P1 Starting HP: " + p1Health.multiply(y));
			System.out.println("[**] P2 Starting HP: " + p2Health.multiply(y));

			
	    	String picturePath = "pictures\\attack.png";
	    	Image image = new Image(new FileInputStream(picturePath));
	    	p1Image.setImage(image);
	    	picturePath = "pictures\\defend.png";
	    	image = new Image(new FileInputStream(picturePath));
	    	p2Image.setImage(image);
	    	p1Value.setText(""+ p1Card.value);
	    	p2Value.setText(""+ p2Card.value);
	    	p1Value.setFill(Color.web("#378bfc"));
	    	p2Value.setFill(Color.web("#fc3741"));
	    	// p1attack < p2defend | i.e. 3 < 5 | p2 absorbs 3 damage (no dmg taken)
			System.out.println("[**] P1 Ending HP: " + p1Health.multiply(y));
			System.out.println("[**] P2 Ending HP: " + p2Health.multiply(y));
	    	
//			player1Card.setText(testCard1.cardType + "\n\n" + testCard1.value);
//			player2Card.setText(testCard2.cardType + "\n\n" + testCard2.value);
//	    	p1HText.setText("Player 1 - " + (p1Health.multiply(y).setScale(0, RoundingMode.DOWN)) + "/" + (int)(maxHealth*100));
//	    	p2HText.setText("Player 2 - " + (p2Health.multiply(y).setScale(0, RoundingMode.DOWN)) + "/" + (int)(maxHealth*100));
			outcome.setText(
					"Player1 hits for " + p1Card.value + "hp! \r\n" +
					"Player2 defends for " + p2Card.value + "hp! \r\n" +
					"Player2 absorbs " + p1Card.value + " damage\n" +
					"Player2 wins the round!"
			);
		}
		else if( p1Card.value == p2Card.value) {
//			System.out.println("[**] Player1 hits for " + p1Card.value + "HP!");
//			System.out.println("[**] Player2 defends for " + p2Card.value + "HP!");
//			System.out.println("[**] Player1 = Player2 | " + p1Card.value + " = " + p2Card.value);
//			System.out.println("[**] Player2 absorbs " + p1Card.value + " damage");
//			System.out.println("[**] TIE");
			System.out.println("[**] P1 Starting HP: " + p1Health.multiply(y));
			System.out.println("[**] P2 Starting HP: " + p2Health.multiply(y));
			
			
	    	String picturePath = "pictures\\attack.png";
	    	Image image = new Image(new FileInputStream(picturePath));
	    	p1Image.setImage(image);
	    	picturePath = "pictures\\defend.png";
	    	image = new Image(new FileInputStream(picturePath));
	    	p2Image.setImage(image);
	    	p1Value.setText(""+ p1Card.value);
	    	p2Value.setText(""+ p2Card.value);
	    	p1Value.setFill(Color.web("#378bfc"));
	    	p2Value.setFill(Color.web("#fc3741"));
	    	// p1attack == p2defend | i.e. 5 == 5 | p2 absorbs 5 damage (no dmg taken)
			System.out.println("[**] P1 Ending HP: " + p1Health.multiply(y));
			System.out.println("[**] P2 Ending HP: " + p2Health.multiply(y));

	    	
//			player1Card.setText(testCard1.cardType + "\n\n" + testCard1.value);
//			player2Card.setText(testCard2.cardType + "\n\n" + testCard2.value);
//	    	p1HText.setText("Player 1 - " + (p1Health.multiply(y).setScale(0, RoundingMode.DOWN)) + "/" + (int)(maxHealth*100));
//	    	p2HText.setText("Player 2 - " + (p2Health.multiply(y).setScale(0, RoundingMode.DOWN)) + "/" + (int)(maxHealth*100));
			outcome.setText(
					"Player1 hits for " + p1Card.value + "hp! \r\n" +
					"Player2 defends for " + p2Card.value + "hp! \r\n" + 
					"Player2 absorbs " + p1Card.value + " damage!\n" + 
					"tie"
			);	
		}
		
		return p2Health;
	}
	
	/*
	 * Case in which player 1 has ATTACK and player 2 has RUN. Player 1 can only damage if their
	 * card is higher than player 2's. Otherwise, player 2 can run away or dodge the attack.
	 */
	public BigDecimal AttackRun(Cards p1Card, Cards p2Card, ImageView p1Image, Text p1Value, ImageView p2Image, Text p2Value, TextArea outcome, ProgressBar p2hp, BigDecimal p1Health, BigDecimal p2Health, Text p1HText, Text p2HText, double maxHealth) throws FileNotFoundException {
//	public void AttackRun(Cards testCard1, Cards testCard2, TextArea player1Card, TextArea player2Card, TextArea outcome) {
		System.out.println("[**] Player1 ATTACKs and Player2 RUNs");
		if( p1Card.value > p2Card.value) {
//			System.out.println("[**] Player1 hits for " + testCard1.value + "HP!");
//			System.out.println("[**] Player2 tries to run but can't escape the oncoming attack!");
//			System.out.println("[**] Player1 > Player2 | " + testCard1.value + " > " + testCard2.value);
//			System.out.println("[**] Player1 wins round");
			System.out.println("[**] P1 Starting HP: " + p1Health.multiply(y));
			System.out.println("[**] P2 Starting HP: " + p2Health.multiply(y));
			// p1attack > p2run | i.e. 5 > 3 -> 5dmg | p2 takes damage from p1
	    	p2Health = decreaseHpBar(p2Health, p2hp, p1Card.value);	// hit by p1 | decrease p2 hp
			
	    	System.out.println("[**] P1 Ending HP: " + p1Health.multiply(y));
			System.out.println("[**] P2 Ending HP: " + p2Health.multiply(y));
			
	    	String picturePath = "pictures\\attack.png";
	    	Image image = new Image(new FileInputStream(picturePath));
	    	p1Image.setImage(image);
	    	picturePath = "pictures\\run.png";
	    	image = new Image(new FileInputStream(picturePath));
	    	p2Image.setImage(image);
	    	p1Value.setText(""+ p1Card.value);
	    	p2Value.setText(""+ p2Card.value); 
	    	p1Value.setFill(Color.web("#378bfc"));
	    	p2Value.setFill(Color.web("#d4d1d1"));

	    	
//			player1Card.setText(testCard1.cardType + "\n\n" + testCard1.value);
//			player2Card.setText(testCard2.cardType + "\n\n" + testCard2.value);
//	    	p1HText.setText("Player 1 - " + (p1Health.multiply(y).setScale(0, RoundingMode.DOWN)) + "/" + (int)(maxHealth*100));
//	    	p2HText.setText("Player 2 - " + (p2Health.multiply(y).setScale(0, RoundingMode.DOWN)) + "/" + (int)(maxHealth*100));
			outcome.setText(
					"Player1 hits for " + p1Card.value + "hp! \r\n" +
					"Player2 tries to run but can't escape the oncoming attack!\n" + 
					"Player1 wins the round!"
			);
			return p2Health;
		}
		else if( p1Card.value < p2Card.value) {
			System.out.println("[**] Player1 hits for " + p1Card.value + "HP but misses!");
			System.out.println("[**] Player2 tries to run and escapes safely!");
			System.out.println("[**] Player1 < Player2 | " + p1Card.value + " < " + p2Card.value);
			System.out.println("[**] Player2 wins round");
			System.out.println("[**] P1 Starting HP: " + p1Health.multiply(y));
			System.out.println("[**] P2 Starting HP: " + p2Health.multiply(y));
			// p1attack < p2run | i.e. 3 < 5 | p2 takes no dmg
			
			System.out.println("[**] P1 Ending HP: " + p1Health.multiply(y));
			System.out.println("[**] P2 Ending HP: " + p2Health.multiply(y));
			
	    	String picturePath = "pictures\\attack.png";
	    	Image image = new Image(new FileInputStream(picturePath));
	    	p1Image.setImage(image);
	    	picturePath = "pictures\\run.png";
	    	image = new Image(new FileInputStream(picturePath));
	    	p2Image.setImage(image);
	    	p1Value.setText(""+ p1Card.value);
	    	p2Value.setText(""+ p2Card.value);
	    	p1Value.setFill(Color.web("#378bfc"));
	    	p2Value.setFill(Color.web("#d4d1d1"));
	    	
//			player1Card.setText(testCard1.cardType + "\n\n" + testCard1.value);
//			player2Card.setText(testCard2.cardType + "\n\n" + testCard2.value);
//	    	p1HText.setText("Player 1 - " + (p1Health.multiply(y).setScale(0, RoundingMode.DOWN)) + "/" + (int)(maxHealth*100));
//	    	p2HText.setText("Player 2 - " + (p2Health.multiply(y).setScale(0, RoundingMode.DOWN)) + "/" + (int)(maxHealth*100));
			outcome.setText(
					"Player1 tries to hit for " + p1Card.value + "hp but misses! \r\n" +
					"Player2 escapes the oncoming attack! \r\n" + 
					"Player2 wins the round!"
			);
		}
		else if( p1Card.value == p2Card.value) {
//			System.out.println("[**] Player1 hits for " + p1Card.value + "HP!");
//			System.out.println("[**] Player2 tries to run!");
//			System.out.println("[**] Player1 = Player2 | " + p1Card.value + " = " + p2Card.value);
//			System.out.println("[**] TIE");
			System.out.println("[**] P1 Starting HP: " + p1Health.multiply(y));
			System.out.println("[**] P2 Starting HP: " + p2Health.multiply(y));
			// p1attack == p2run | i.e. 5 == 5 | p2 takes no damage from p1
			
			System.out.println("[**] P1 Ending HP: " + p1Health.multiply(y));
			System.out.println("[**] P2 Ending HP: " + p2Health.multiply(y));
			
	    	String picturePath = "pictures\\attack.png";
	    	Image image = new Image(new FileInputStream(picturePath));
	    	p1Image.setImage(image);
	    	picturePath = "pictures\\run.png";
	    	image = new Image(new FileInputStream(picturePath));
	    	p2Image.setImage(image);
	    	p1Value.setText(""+ p1Card.value);
	    	p2Value.setText(""+ p2Card.value);
	    	p1Value.setFill(Color.web("#378bfc"));
	    	p2Value.setFill(Color.web("#d4d1d1"));
	    	
//			player1Card.setText(testCard1.cardType + "\n\n" + testCard1.value);
//			player2Card.setText(testCard2.cardType + "\n\n" + testCard2.value);
//	    	p1HText.setText("Player 1 - " + (p1Health.multiply(y).setScale(0, RoundingMode.DOWN)) + "/" + (int)(maxHealth*100));
//	    	p2HText.setText("Player 2 - " + (p2Health.multiply(y).setScale(0, RoundingMode.DOWN)) + "/" + (int)(maxHealth*100));
			outcome.setText(
					"Player1 tries to hit for " + p1Card.value + "hp but misses! \r\n" +
					"Player2 dodges the oncoming attack! \r\n" + 
					"tie"
			);	
		}
		return p2Health;
	}
	
	/*
	 * Case in which player 1 has DEFEND and player 2 has ATTACK. Player 2 can only damage if their
	 * card is higher than player 2's. Otherwise, player 1 can absorb all the damage or take partial damage
	 */
	public BigDecimal DefendAttack(Cards p1Card, Cards p2Card, ImageView p1Image, Text p1Value, ImageView p2Image, Text p2Value, TextArea outcome, ProgressBar p1hp, BigDecimal p1Health, BigDecimal p2Health, Text p1HText, Text p2HText, double maxHealth) throws FileNotFoundException {
//	public void DefendAttack(Cards testCard1, Cards testCard2, TextArea player1Card, TextArea player2Card, TextArea outcome) {
		int dmgDiff1 = p1Card.value - p2Card.value;
		int dmgDiff2 = p2Card.value - p1Card.value;
		System.out.println("[**] Player1 DEFENDs and Player2 ATTACKs");
		if( p1Card.value > p2Card.value) {
//			System.out.println("[**] Player1 defends for " + testCard1.value + "HP!");
//			System.out.println("[**] Player2 attacks for " + testCard2.value + "HP!");
//			System.out.println("[**] Player1 > Player2 | " + testCard1.value + " > " + testCard2.value);
//			System.out.println("[**] Player1 - Player2 | " + testCard1.value + " - " + testCard2.value + " = " + dmgDiff1 + "HP");
//			System.out.println("[**] Player1 absorbs " + testCard2.value + " damage");
//			System.out.println("[**] Player1 wins round");
			System.out.println("[**] P1 Starting HP: " + p1Health.multiply(y));
			System.out.println("[**] P2 Starting HP: " + p2Health.multiply(y));
			// p1defend > p2attack | i.e. 5 > 3 -> 2dmg | p1 absorbs 3 damage from p1 (no dmg)
			
			System.out.println("[**] P1 Ending HP: " + p1Health.multiply(y));
			System.out.println("[**] P2 Ending HP: " + p2Health.multiply(y));
			
	    	String picturePath = "pictures\\defend.png";
	    	Image image = new Image(new FileInputStream(picturePath));
	    	p1Image.setImage(image);
	    	picturePath = "pictures\\attack.png";
	    	image = new Image(new FileInputStream(picturePath));
	    	p2Image.setImage(image);
	    	p1Value.setText(""+ p1Card.value);
	    	p2Value.setText(""+ p2Card.value);
	    	p2Value.setFill(Color.web("#378bfc"));
	    	p1Value.setFill(Color.web("#fc3741"));
			
//			player1Card.setText(testCard1.cardType + "\n\n" + testCard1.value);
//			player2Card.setText(testCard2.cardType + "\n\n" + testCard2.value);
//	    	p1HText.setText("Player 1 - " + (p1Health.multiply(y).setScale(0, RoundingMode.DOWN)) + "/" + (int)(maxHealth*100));
//	    	p2HText.setText("Player 2 - " + (p2Health.multiply(y).setScale(0, RoundingMode.DOWN)) + "/" + (int)(maxHealth*100));
			outcome.setText(
					"Player1 defends for " + p1Card.value + "hp! \r\n" +
					"Player2 hits for " + p2Card.value + "hp! \r\n" + 
					"Player1 absorbs " + p2Card.value + " damage!\r\n" + 
					"Player1 wins the round!"
			);
		}
		else if( p1Card.value < p2Card.value) {
//			System.out.println("[**] Player1 defends for " + testCard1.value + "HP!");
//			System.out.println("[**] Player2 attacks for " + testCard2.value + "HP!");
//			System.out.println("[**] Player1 < Player2 | " + testCard1.value + " < " + testCard2.value);
//			System.out.println("[**] Player1 - Player2 | " + testCard1.value + " - " + testCard2.value + " = " + Math.abs(dmgDiff1) + "HP");
//			System.out.println("[**] Player1 absorbs " + testCard1.value + " damage " + "but still takes " + Math.abs(dmgDiff1) + " damage");
//			System.out.println("[**] Player2 wins round");
			System.out.println("[**] P1 Starting HP: " + p1Health.multiply(y));
			System.out.println("[**] P2 Starting HP: " + p2Health.multiply(y));
			// p1defend < p2attack | i.e. 3 < 5 -> 5 - 3 = |-2| = 2 dmg | p1 takes damagediff from p2
	    	p1Health = decreaseHpBar(p1Health, p1hp, dmgDiff2);	// hit by p2 | decrease p1 hp
			
	    	System.out.println("[**] P1 Ending HP: " + p1Health.multiply(y));
			System.out.println("[**] P2 Ending HP: " + p2Health.multiply(y));
			
	    	String picturePath = "pictures\\defend.png";
	    	Image image = new Image(new FileInputStream(picturePath));
	    	p1Image.setImage(image);
	    	picturePath = "pictures\\attack.png";
	    	image = new Image(new FileInputStream(picturePath));
	    	p2Image.setImage(image);
	    	p1Value.setText(""+ p1Card.value);
	    	p2Value.setText(""+ p2Card.value);
	    	p2Value.setFill(Color.web("#378bfc"));
	    	p1Value.setFill(Color.web("#fc3741"));
	    	
//			player1Card.setText(testCard1.cardType + "\n\n" + testCard1.value);
//			player2Card.setText(testCard2.cardType + "\n\n" + testCard2.value);
//	    	p1HText.setText("Player 1 - " + (p1Health.multiply(y).setScale(0, RoundingMode.DOWN)) + "/" + (int)(maxHealth*100));
//	    	p2HText.setText("Player 2 - " + (p2Health.multiply(y).setScale(0, RoundingMode.DOWN)) + "/" + (int)(maxHealth*100));
			outcome.setText(
					"Player1 defends for " + p1Card.value + "hp! \r\n" +
					"Player2 hits for " + p2Card.value + "hp! \r\n" + 
					"Player1 absorbs " + p1Card.value + " damage " + "but still takes " + Math.abs(dmgDiff1) + " damage!\n"+ 
					"Player2 wins the round!"
			);
		}
		else if( p1Card.value == p2Card.value){
//			System.out.println("[**] Player1 defends for " + testCard1.value + "HP!");
//			System.out.println("[**] Player2 defends for " + testCard2.value + "HP!");
//			System.out.println("[**] Player1 = Player2 | " + testCard1.value + " = " + testCard2.value);
//			System.out.println("[**] TIE");
			System.out.println("[**] P1 Starting HP: " + p1Health.multiply(y));
			System.out.println("[**] P2 Starting HP: " + p2Health.multiply(y));
			// p1defend == p2attack | i.e. 5 == 5 -> 5 - 5 = 0 = 0 dmg | p1 takes absorbs ALL dmg from p2 (no dmg)
			
			System.out.println("[**] P1 Ending HP: " + p1Health.multiply(y));
			System.out.println("[**] P2 Ending HP: " + p2Health.multiply(y));
			
	    	String picturePath = "pictures\\defend.png";
	    	Image image = new Image(new FileInputStream(picturePath));
	    	p1Image.setImage(image);
	    	picturePath = "pictures\\attack.png";
	    	image = new Image(new FileInputStream(picturePath));
	    	p2Image.setImage(image);
	    	p1Value.setText(""+ p1Card.value);
	    	p2Value.setText(""+ p2Card.value);
	    	p2Value.setFill(Color.web("#378bfc"));
	    	p1Value.setFill(Color.web("#fc3741"));
	    	
//			player1Card.setText(testCard1.cardType + "\n\n" + testCard1.value);
//			player2Card.setText(testCard2.cardType + "\n\n" + testCard2.value);
//	    	p1HText.setText("Player 1 - " + (p1Health.multiply(y).setScale(0, RoundingMode.DOWN)) + "/" + (int)(maxHealth*100));
//	    	p2HText.setText("Player 2 - " + (p2Health.multiply(y).setScale(0, RoundingMode.DOWN)) + "/" + (int)(maxHealth*100));
			outcome.setText(
					"Player1 defends for " + p1Card.value + "HP! \r\n" +
					"Player2 hits for " + p2Card.value + "HP! \r\n" + 
					"Player1 absorbs " + p1Card.value + " damage!\n" + 
					"tie"
			);	
		}
		
		return p1Health;
	}
	
	/*
	 * Case in which player 1 has DEFEND and player 2 has DEFEND.
	 * Both players defend and nothing happens
	 */
	public void DefendDefend(Cards p1Card, Cards p2Card, ImageView p1Image, Text p1Value, ImageView p2Image, Text p2Value, TextArea outcome, BigDecimal p1Health, BigDecimal p2Health, Text p1HText, Text p2HText, double maxHealth) throws FileNotFoundException {
//	public void DefendDefend(Cards testCard1, Cards testCard2, TextArea player1Card, TextArea player2Card, TextArea outcome) {
		System.out.println("[**] Player1 defends for " + p1Card.value + "HP!");
		System.out.println("[**] Player2 defends for " + p2Card.value + "HP!");
		System.out.println("[**] Both players defend! No damage taken!");
		System.out.println("[**] P1 Starting HP: " + p1Health.multiply(y));
		System.out.println("[**] P2 Starting HP: " + p2Health.multiply(y));
		
		System.out.println("[**] P1 Ending HP: " + p1Health.multiply(y));
		System.out.println("[**] P2 Ending HP: " + p2Health.multiply(y));
		
    	String picturePath = "pictures\\defend.png";
    	Image image = new Image(new FileInputStream(picturePath));
    	p1Image.setImage(image);
    	picturePath = "pictures\\defend.png";
    	image = new Image(new FileInputStream(picturePath));
    	p2Image.setImage(image);
    	p1Value.setText(""+ p1Card.value);
    	p2Value.setText(""+ p2Card.value);
    	p2Value.setFill(Color.web("#fc3741"));
    	p1Value.setFill(Color.web("#fc3741"));
    	
//		player1Card.setText(testCard1.cardType + "\n\n" + testCard1.value);
//		player2Card.setText(testCard2.cardType + "\n\n" + testCard2.value);
//    	p1HText.setText("Player 1 - " + (p1Health.multiply(y).setScale(0, RoundingMode.DOWN)) + "/" + (int)(maxHealth*100));
//    	p2HText.setText("Player 2 - " + (p2Health.multiply(y).setScale(0, RoundingMode.DOWN)) + "/" + (int)(maxHealth*100));
		outcome.setText(
				"Player1 defends for " + p1Card.value + "hp! \r\n" +
				"Player2 defends for " + p2Card.value + "hp! \r\n" + 
				"Both players defend! No damage taken!"
		);
	}
	
	/*
	 * Case in which player 1 has DEFEND and player 2 has RUN.
	 * 1 player defends and the other runs. player2 has a chance at not being able to run
	 */
	public void DefendRun(Cards p1Card, Cards p2Card, ImageView p1Image, Text p1Value, ImageView p2Image, Text p2Value, TextArea outcome, BigDecimal p1Health, BigDecimal p2Health, Text p1HText, Text p2HText, double maxHealth) throws FileNotFoundException {
//	public void DefendRun(Cards testCard1, Cards testCard2, TextArea player1Card, TextArea player2Card, TextArea outcome) {
		System.out.println("[**] Player1 DEFENDs and Player2 RUNs");
		if( p1Card.value > p2Card.value) {
//			System.out.println("[**] Player1 defends for " + testCard1.value + "HP!");
//			System.out.println("[**] Player2 tries to run!");
//			System.out.println("[**] Player1 > Player2 | " + testCard1.value + " > " + testCard2.value);
//			System.out.println("[**] Player1 wins round");
			System.out.println("[**] P1 Starting HP: " + p1Health.multiply(y));
			System.out.println("[**] P2 Starting HP: " + p2Health.multiply(y));
			
			System.out.println("[**] P1 Ending HP: " + p1Health.multiply(y));
			System.out.println("[**] P2 Ending HP: " + p2Health.multiply(y));
			
	    	String picturePath = "pictures\\defend.png";
	    	Image image = new Image(new FileInputStream(picturePath));
	    	p1Image.setImage(image);
	    	picturePath = "pictures\\run.png";
	    	image = new Image(new FileInputStream(picturePath));
	    	p2Image.setImage(image);
	    	p1Value.setText(""+ p1Card.value);
	    	p2Value.setText(""+ p2Card.value);
	    	p1Value.setFill(Color.web("#fc3741"));
	    	p2Value.setFill(Color.web("#d4d1d1"));
	    	
//			player1Card.setText(testCard1.cardType + "\n\n" + testCard1.value);
//			player2Card.setText(testCard2.cardType + "\n\n" + testCard2.value);
//	    	p1HText.setText("Player 1 - " + (p1Health.multiply(y).setScale(0, RoundingMode.DOWN)) + "/" + (int)(maxHealth*100));
//	    	p2HText.setText("Player 2 - " + (p2Health.multiply(y).setScale(0, RoundingMode.DOWN)) + "/" + (int)(maxHealth*100));
			outcome.setText(
					"Player1 defends for " + p1Card.value + "hp! \r\n" +
					"Player2 tries to run but fails to escape!\n	" + 
					"Player1 wins the round!"
			);
		}
		else if( p1Card.value < p2Card.value) {
//			System.out.println("[**] Player1 defends for " + testCard1.value + "HP!");
//			System.out.println("[**] Player2 tries to run!");
//			System.out.println("[**] Player1 < Player2 | " + testCard1.value + " < " + testCard2.value);
//			System.out.println("[**] Player2 wins round");
			System.out.println("[**] P1 Starting HP: " + p1Health.multiply(y));
			System.out.println("[**] P2 Starting HP: " + p2Health.multiply(y));
			
			System.out.println("[**] P1 Ending HP: " + p1Health.multiply(y));
			System.out.println("[**] P2 Ending HP: " + p2Health.multiply(y));
			
	    	String picturePath = "pictures\\defend.png";
	    	Image image = new Image(new FileInputStream(picturePath));
	    	p1Image.setImage(image);
	    	picturePath = "pictures\\run.png";
	    	image = new Image(new FileInputStream(picturePath));
	    	p2Image.setImage(image);
	    	p1Value.setText(""+ p1Card.value);
	    	p2Value.setText(""+ p2Card.value);
	    	p1Value.setFill(Color.web("#fc3741"));
	    	p2Value.setFill(Color.web("#d4d1d1"));
	    	
//			player1Card.setText(testCard1.cardType + "\n\n" + testCard1.value);
//			player2Card.setText(testCard2.cardType + "\n\n" + testCard2.value);
//	    	p1HText.setText("Player 1 - " + (p1Health.multiply(y).setScale(0, RoundingMode.DOWN)) + "/" + (int)(maxHealth*100));
//	    	p2HText.setText("Player 2 - " + (p2Health.multiply(y).setScale(0, RoundingMode.DOWN)) + "/" + (int)(maxHealth*100));
			outcome.setText(
					"Player1 defends for " + p1Card.value + "hp! \r\n" +
					"Player2 escapes! \r\n" + 
					"Player2 wins the round!"
			);
		}
		else if( p1Card.value == p2Card.value) {
//			System.out.println("[**] Player1 hits for " + testCard1.value + "HP!");
//			System.out.println("[**] Player2 tries to run!");
//			System.out.println("[**] Player1 = Player2 | " + testCard1.value + " = " + testCard2.value);
//			System.out.println("[**] TIE");
			System.out.println("[**] P1 Starting HP: " + p1Health.multiply(y));
			System.out.println("[**] P2 Starting HP: " + p2Health.multiply(y));
			
			System.out.println("[**] P1 Ending HP: " + p1Health.multiply(y));
			System.out.println("[**] P2 Ending HP: " + p2Health.multiply(y));
			
	    	String picturePath = "pictures\\defend.png";
	    	Image image = new Image(new FileInputStream(picturePath));
	    	p1Image.setImage(image);
	    	picturePath = "pictures\\run.png";
	    	image = new Image(new FileInputStream(picturePath));
	    	p2Image.setImage(image);
	    	p1Value.setText(""+ p1Card.value);
	    	p2Value.setText(""+ p2Card.value);
	    	p1Value.setFill(Color.web("#fc3741"));
	    	p2Value.setFill(Color.web("#d4d1d1"));
	    	
//			player1Card.setText(testCard1.cardType + "\n\n" + testCard1.value);
//			player2Card.setText(testCard2.cardType + "\n\n" + testCard2.value);
//	    	p1HText.setText("Player 1 - " + (p1Health.multiply(y).setScale(0, RoundingMode.DOWN)) + "/" + (int)(maxHealth*100));
//	    	p2HText.setText("Player 2 - " + (p2Health.multiply(y).setScale(0, RoundingMode.DOWN)) + "/" + (int)(maxHealth*100));
			outcome.setText(
					"Player1 tries to defend for " + p1Card.value + "hp but misses! \r\n" +
					"Player2 tries to run but fails to escape! \r\n" + 
					"tie"
			);	
		}
	}
	
	/*
	 * Case in which player 1 has RUN and player 2 has ATTACK. Player 2 can only deal damage
	 * granted that their card is higher than player 1's. Otherwise, player 1 can dodge the attack
	 * or run away.
	 */
	public BigDecimal RunAttack(Cards p1Card, Cards p2Card, ImageView p1Image, Text p1Value, ImageView p2Image, Text p2Value, TextArea outcome, ProgressBar p1hp, BigDecimal p1Health, BigDecimal p2Health, Text p1HText, Text p2HText, double maxHealth) throws FileNotFoundException {
//		public void RunRun(Cards testCard1, Cards testCard2, TextArea player1Card, TextArea player2Card, TextArea outcome) {
		System.out.println("[**] Player1 RUNs and Player2 ATTACKs");
		if( p1Card.value > p2Card.value) {	
//			System.out.println("[**] Player1 tries to run!");	
//			System.out.println("[**] Player2 hits for " + testCard1.value + "HP!");
//			System.out.println("[**] Player1 > Player2 | " + testCard1.value + " > " + testCard2.value);
//			System.out.println("[**] Player1 wins round");
			System.out.println("[**] P1 Starting HP: " + p1Health.multiply(y));
			System.out.println("[**] P2 Starting HP: " + p2Health.multiply(y));
			// p1run > p1attack | i.e. 5 < 3 | p1 avoids dmg from p2 (no dmg)			
				
			System.out.println("[**] P1 Ending HP: " + p1Health.multiply(y));
			System.out.println("[**] P2 Ending HP: " + p2Health.multiply(y));
			
	    	String picturePath = "pictures\\run.png";
	    	Image image = new Image(new FileInputStream(picturePath));
	    	p1Image.setImage(image);
	    	picturePath = "pictures\\attack.png";
	    	image = new Image(new FileInputStream(picturePath));
	    	p2Image.setImage(image);
	    	p1Value.setText(""+ p1Card.value);
	    	p2Value.setText(""+ p2Card.value);
	    	p2Value.setFill(Color.web("#378bfc"));
	    	p1Value.setFill(Color.web("#d4d1d1"));
	    	
//			player1Card.setText(testCard1.cardType + "\n\n" + testCard1.value);
//			player2Card.setText(testCard2.cardType + "\n\n" + testCard2.value);
//	    	p1HText.setText("Player 1 - " + (p1Health.multiply(y).setScale(0, RoundingMode.DOWN)) + "/" + (int)(maxHealth*100));
//	    	p2HText.setText("Player 2 - " + (p2Health.multiply(y).setScale(0, RoundingMode.DOWN)) + "/" + (int)(maxHealth*100));
			outcome.setText(
					"Player1 escapes the oncoming attack! \n" +
					"Player2 hits for " + p2Card.value + " hp but misses!\n" + 
					"Player1 gets away safely!"
			);
		}
		else if( p1Card.value < p2Card.value) {	
//			System.out.println("[**] Player1 tries to run!");	
//			System.out.println("[**] Player2 hits for " + testCard1.value + "HP!");
//			System.out.println("[**] Player1 < Player2 | " + testCard1.value + " < " + testCard2.value);
//			System.out.println("[**] Player2 wins round");
			System.out.println("[**] P1 Starting HP: " + p1Health.multiply(y));
			System.out.println("[**] P2 Starting HP: " + p2Health.multiply(y));
			// p1run < p1attack | i.e. 3 < 5 | p1 takes dmg from p2 
	    	p1Health = decreaseHpBar(p1Health, p1hp, p2Card.value);	// hit by p2 | decrease p1 hp
			
	    	System.out.println("[**] P1 Ending HP: " + p1Health.multiply(y));
			System.out.println("[**] P2 Ending HP: " + p2Health.multiply(y));
			
	    	String picturePath = "pictures\\run.png";
	    	Image image = new Image(new FileInputStream(picturePath));
	    	p1Image.setImage(image);
	    	picturePath = "pictures\\attack.png";
	    	image = new Image(new FileInputStream(picturePath));
	    	p2Image.setImage(image);
	    	p1Value.setText(""+ p1Card.value);
	    	p2Value.setText(""+ p2Card.value);
	    	p2Value.setFill(Color.web("#378bfc"));
	    	p1Value.setFill(Color.web("#d4d1d1"));
	    	
//			player1Card.setText(testCard1.cardType + "\n\n" + testCard1.value);
//			player2Card.setText(testCard2.cardType + "\n\n" + testCard2.value);
//	    	p1HText.setText("Player 1 - " + (p1Health.multiply(y).setScale(0, RoundingMode.DOWN)) + "/" + (int)(maxHealth*100));
//	    	p2HText.setText("Player 2 - " + (p2Health.multiply(y).setScale(0, RoundingMode.DOWN)) + "/" + (int)(maxHealth*100));
			outcome.setText(
					"Player1 can't escape the oncoming attack! \n" + 
					"Player2 hits for " + p2Card.value + " hp!\n" +
					"Player2 wins the round!"
			);
		}
		else if( p1Card.value == p2Card.value) {	
//			System.out.println("[**] Player1 tries to run!");	
//			System.out.println("[**] Player2 hits for " + testCard1.value + "HP!");
//			System.out.println("[**] Player1 == Player2 | " + testCard1.value + " == " + testCard2.value);
//			System.out.println("[**] TIE");
			System.out.println("[**] P1 Starting HP: " + p1Health.multiply(y));
			System.out.println("[**] P2 Starting HP: " + p2Health.multiply(y));
			// p1run == p1attack | i.e. 5 == 5 | p1 takes no damage from p2
			
			System.out.println("[**] P1 Ending HP: " + p1Health.multiply(y));
			System.out.println("[**] P2 Ending HP: " + p2Health.multiply(y));
			
	    	String picturePath = "pictures\\run.png";
	    	Image image = new Image(new FileInputStream(picturePath));
	    	p1Image.setImage(image);
	    	picturePath = "pictures\\attack.png";
	    	image = new Image(new FileInputStream(picturePath));
	    	p2Image.setImage(image);
	    	p1Value.setText(""+ p1Card.value);
	    	p2Value.setText(""+ p2Card.value);
	    	p2Value.setFill(Color.web("#378bfc"));
	    	p1Value.setFill(Color.web("#d4d1d1"));
	    	
//			player1Card.setText(testCard1.cardType + "\n\n" + testCard1.value);
//			player2Card.setText(testCard2.cardType + "\n\n" + testCard2.value);
//	    	p1HText.setText("Player 1 - " + (p1Health.multiply(y).setScale(0, RoundingMode.DOWN)) + "/" + (int)(maxHealth*100));
//	    	p2HText.setText("Player 2 - " + (p2Health.multiply(y).setScale(0, RoundingMode.DOWN)) + "/" + (int)(maxHealth*100));
			outcome.setText(
					"Player1 dodges the oncoming attack!\n" + 
					"Player2 hits for " + p2Card.value + " hp but misses!\n" +
					"Player1 dodges Player2's attack!"
			);
		}
		
		return p1Health;
	}
	
	/*
	 * Case in which player 1 has RUN and player 2 has DEFEND. 
	 * Player 1 can run or miss their chance to esacep while player 2 can only defend
	 */
	public void RunDefend(Cards p1Card, Cards p2Card, ImageView p1Image, Text p1Value, ImageView p2Image, Text p2Value, TextArea outcome, BigDecimal p1Health, BigDecimal p2Health, Text p1HText, Text p2HText, double maxHealth) throws FileNotFoundException {
//		public void RunRun(Cards testCard1, Cards testCard2, TextArea player1Card, TextArea player2Card, TextArea outcome) {
//			System.out.println("[**] Player1 RUNs and Player2 RUNs");
//			System.out.println("[**] Player1 tries to run!");
//			System.out.println("[**] Player2 defends for " + testCard2.value + "HP!");
			System.out.println("[**] P1 Starting HP: " + p1Health.multiply(y));
			System.out.println("[**] P2 Starting HP: " + p2Health.multiply(y));
			// p1run > p2defend | i.e. 5 > 3 | p1 takes no dmg from p2 
			
			System.out.println("[**] P1 Ending HP: " + p1Health.multiply(y));
			System.out.println("[**] P2 Ending HP: " + p2Health.multiply(y));
			
			
	    	String picturePath = "pictures\\run.png";
	    	Image image = new Image(new FileInputStream(picturePath));
	    	p1Image.setImage(image);
	    	picturePath = "pictures\\defend.png";
	    	image = new Image(new FileInputStream(picturePath));
	    	p2Image.setImage(image);
	    	p1Value.setText(""+ p1Card.value);
	    	p2Value.setText(""+ p2Card.value);
	    	p2Value.setFill(Color.web("#fc3741"));
	    	p1Value.setFill(Color.web("#d4d1d1"));
	    	
	    	
//			player1Card.setText(testCard1.cardType + "\n\n" + testCard1.value);
//			player2Card.setText(testCard2.cardType + "\n\n" + testCard2.value);
//	    	p1HText.setText("Player 1 - " + (p1Health.multiply(y).setScale(0, RoundingMode.DOWN)) + "/" + (int)(int)(maxHealth*100));
//	    	p2HText.setText("Player 2 - " + (p2Health.multiply(y).setScale(0, RoundingMode.DOWN)) + "/" + (int)(int)(maxHealth*100));
	    	outcome.setText(
					"Player1 tries to run!\n" +
					"Player2 defends for " + p2Card.value + "hp! \r\n" + 
					"No damage taken!"
			);
	}
	
	/*
	 * Case in which player 1 has RUN and player 2 has RUN. 
	 * Both players escape if both players run.
	 */
	public void RunRun(Cards p1Card, Cards p2Card, ImageView p1Image, Text p1Value, ImageView p2Image, Text p2Value, TextArea outcome, BigDecimal p1Health, BigDecimal p2Health, Text p1HText, Text p2HText, double maxHealth) throws FileNotFoundException {
//	public void RunRun(Cards testCard1, Cards testCard2, TextArea player1Card, TextArea player2Card, TextArea outcome) {
//		System.out.println("[**] Player1 RUNs and Player2 RUNs");
//		System.out.println("[**] Player1 tries to run!");
//		System.out.println("[**] Player2 tries to run!");
//		System.out.println("[**] Both players run! No damage taken!");
		System.out.println("[**] P1 Starting HP: " + p1Health.multiply(y));
		System.out.println("[**] P2 Starting HP: " + p2Health.multiply(y));
		// p1run ><== p2run | i.e. 5 ><== 4|5 | p1 takes no dmg from p2 
		
		System.out.println("[**] P1 Ending HP: " + p1Health.multiply(y));
		System.out.println("[**] P2 Ending HP: " + p2Health.multiply(y));
		
    	String picturePath = "pictures\\run.png";
    	Image image = new Image(new FileInputStream(picturePath));
    	p1Image.setImage(image);
    	picturePath = "pictures\\run.png";
    	image = new Image(new FileInputStream(picturePath));
    	p2Image.setImage(image);
    	p1Value.setText(""+ p1Card.value);
    	p2Value.setText(""+ p2Card.value);
    	p1Value.setFill(Color.web("#d4d1d1"));
    	p2Value.setFill(Color.web("#d4d1d1"));
    	
    	
//		player1Card.setText(testCard1.cardType + "\n\n" + testCard1.value);
//		player2Card.setText(testCard2.cardType + "\n\n" + testCard2.value);
//    	p1HText.setText("Player 1 - " + (p1Health.multiply(y).setScale(0, RoundingMode.DOWN)) + "/" + (int)(maxHealth*100));
//    	p2HText.setText("Player 2 - " + (p2Health.multiply(y).setScale(0, RoundingMode.DOWN)) + "/" + (int)(maxHealth*100));
		outcome.setText(
				"Player1 tries to run! \n" +
				"Player2 tries to run! \n" + 
				"Both players run! No damage taken!"
		);
	}
	
	public BigDecimal decreaseHpBar(BigDecimal playerHealth, ProgressBar playerHP, int damage) {
		if(playerHealth.doubleValue() == 0) {
			return playerHealth;
		}
		if(playerHealth.doubleValue() > 0) {
			playerHealth = new BigDecimal(String.format("%,2f", playerHealth.doubleValue() - (damage/100.0))); // 100 - 7 = 93
//			System.out.println(playerHealth.doubleValue());
			playerHP.setProgress(playerHealth.doubleValue());
//			myLabel.setText( Integer.toString( (int)Math.round(progress.doubleValue() * 100)) + "%");
		}
//		System.out.println(playerHealth.doubleValue());
		return playerHealth;
	}

	/*
	 * hpCheck does a check on whether the player's health is less than or equal to 0.
	 * If there is a player(s) that are less than or equal to 0, return an int.
	 */
	 public int hpCheck(BigDecimal p1Health, BigDecimal p2Health, int pLose){
		 if(((p1Health.doubleValue()*100) <= 0) && ((p2Health.doubleValue()*100) <= 0)) {
			 // in (-) numbers, if p1Health is smaller than p2Health | i.e. -0.20 < -0.15 | p1 loses
			 if((p1Health.doubleValue()*100) < (p2Health.doubleValue()*100)) {
				 System.out.println("[**] Player 1 has FALLEN. Player 2 WINS! GAME OVER!");
				 pLose = 1;
			 }
			// in (-) numbers, if p2Health is smaller than p1Health | i.e. -0.15 > -0.20 | p2 loses
			 else if((p2Health.doubleValue()*100) < (p1Health.doubleValue()*100)) {
				 System.out.println("[**] Player 2 has FALLEN. Player 1 WINS! GAME OVER!");
				 pLose = 2;
			 }
			 else if((p1Health.doubleValue()*100) == (p2Health.doubleValue()*100)) {
				 System.out.println("[**] BOTH Players have FALLEN. No winner! GAME OVER!");
				 pLose = 3;
			 }
		 }
		 else if((p1Health.doubleValue()*100) <= 0 && (p2Health.doubleValue()*100) > 0){
			 System.out.println("[**] Player 1 has FALLEN. Player 2 WINS! GAME OVER!");
			 pLose = 1;
		 }
		 else if((p2Health.doubleValue()*100) <= 0 && (p1Health.doubleValue()*100) > 0){
			 System.out.println("[**] Player 2 has FALLEN. Player 1 WINS! GAME OVER!");
			 pLose = 2;
		 }
		 
		 return pLose;
	}
	 
}
