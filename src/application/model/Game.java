package application.model;

import javafx.scene.control.TextArea;

public class Game {
	
	public void AttackAttack(Cards testCard1, Cards testCard2, TextArea player1Card, TextArea player2Card, TextArea outcome) {
		if( testCard1.value > testCard2.value) {
			System.out.println("[**] Player1 hits for " + testCard1.value + "HP!");
			System.out.println("[**] Player2 hits for " + testCard2.value + "HP!");
			System.out.println("[**] Player1 > Player2 | " + testCard1.value + " > " + testCard2.value);
			System.out.println("[**] Player1 wins round");
			player1Card.setText(testCard1.cardType + "\n\n" + testCard1.value);
			player2Card.setText(testCard2.cardType + "\n\n" + testCard2.value);
			outcome.setText(
					"Player1 hits for " + testCard1.value + "HP! \r\n" +
					"Player2 hits for " + testCard2.value + "HP! \r\n" + 
					"Player1 wins the round!"
			);
		}
		else if( testCard1.value < testCard2.value) {
			System.out.println("[**] Player1 hits for " + testCard1.value + "HP!");
			System.out.println("[**] Player2 hits for " + testCard2.value + "HP!");
			System.out.println("[**] Player1 < Player2 | " + testCard1.value + " < " + testCard2.value);
			System.out.println("[**] Player2 wins round");
			player1Card.setText(testCard1.cardType + "\n\n" + testCard1.value);
			player2Card.setText(testCard2.cardType + "\n\n" + testCard2.value);
			outcome.setText(
					"Player1 hits for " + testCard1.value + "HP! \r\n" +
					"Player2 hits for " + testCard2.value + "HP! \r\n" + 
					"Player2 wins the round!"
			);
		}
		else if( testCard1.value == testCard2.value){
			System.out.println("[**] Player1 hits for " + testCard1.value + "HP!");
			System.out.println("[**] Player2 hits for " + testCard2.value + "HP!");
			System.out.println("[**] testCard1 = testCard2 | " + testCard1.value + " = " + testCard2.value);
			System.out.println("[**] TIE");
			player1Card.setText(testCard1.cardType + "\n\n" + testCard1.value);
			player2Card.setText(testCard2.cardType + "\n\n" + testCard2.value);
			outcome.setText(
					"Player1 hits for " + testCard1.value + "HP! \r\n" +
					"Player2 hits for " + testCard2.value + "HP! \r\n" + 
					"TIE"
			);
		}
	}
	public void AttackDefend(Cards testCard1, Cards testCard2, TextArea player1Card, TextArea player2Card, TextArea outcome) {
		int dmgDiff1 = testCard1.value - testCard2.value;
		int dmgDiff2 = testCard2.value - testCard1.value;
		System.out.println("[**] Player1 ATTACKs and Player2 DEFENDs");
		if( testCard1.value > testCard2.value) {
			System.out.println("[**] Player1 hits for " + testCard1.value + "HP!");
			System.out.println("[**] Player2 defends for " + testCard2.value + "HP!");
			System.out.println("[**] Player1 > Player2 | " + testCard1.value + " > " + testCard2.value);
			System.out.println("[**] Player1 - Player2 | " + testCard1.value + " - " + testCard2.value + " = " + dmgDiff1 + "HP");
			System.out.println("[**] Player2 takes only " + dmgDiff1 + " damage");
			System.out.println("[**] Player1 wins round");
			player1Card.setText(testCard1.cardType + "\n\n" + testCard1.value);
			player2Card.setText(testCard2.cardType + "\n\n" + testCard2.value);
			outcome.setText(
					"Player1 hits for " + testCard1.value + "HP! \r\n" +
					"Player2 defends for " + testCard2.value + "HP! \r\n" + 
					"Player1 wins the round!"
			);
		}
		else if( testCard1.value < testCard2.value) {
			System.out.println("[**] Player1 hits for " + testCard1.value + "HP!");
			System.out.println("[**] Player2 defends for " + testCard2.value + "HP!");
			System.out.println("[**] Player1 < Player2 | " + testCard1.value + " < " + testCard2.value);
			System.out.println("[**] Player2 - Player1 | " + testCard2.value + " - " + testCard1.value + " = " + dmgDiff2 + "HP");
			System.out.println("[**] Player2 takes only " + dmgDiff2 + " damage");
			System.out.println("[**] Player2 wins round");
			player1Card.setText(testCard1.cardType + "\n\n" + testCard1.value);
			player2Card.setText(testCard2.cardType + "\n\n" + testCard2.value);
			outcome.setText(
					"Player1 hits for " + testCard1.value + "HP! \r\n" +
					"Player2 defends for " + testCard2.value + "HP! \r\n" + 
					"Player2 wins the round!"
			);
		}
		else if( testCard1.value == testCard2.value) {
			System.out.println("[**] Player1 hits for " + testCard1.value + "HP!");
			System.out.println("[**] Player2 defends for " + testCard2.value + "HP!");
			System.out.println("[**] Player1 = Player2 | " + testCard1.value + " = " + testCard2.value);
			System.out.println("[**] TIE");
			player1Card.setText(testCard1.cardType + "\n\n" + testCard1.value);
			player2Card.setText(testCard2.cardType + "\n\n" + testCard2.value);
			outcome.setText(
					"Player1 hits for " + testCard1.value + "HP! \r\n" +
					"Player2 defends for " + testCard2.value + "HP! \r\n" + 
					"TIE"
			);	
		}
	}
	public void AttackRun(Cards testCard1, Cards testCard2, TextArea player1Card, TextArea player2Card, TextArea outcome) {
		System.out.println("[**] Player1 ATTACKs and Player2 RUNs");
		if( testCard1.value > testCard2.value) {
			System.out.println("[**] Player1 hits for " + testCard1.value + "HP!");
			System.out.println("[**] Player2 tries to run!");
			System.out.println("[**] Player1 > Player2 | " + testCard1.value + " > " + testCard2.value);
			System.out.println("[**] Player1 wins round");
			player1Card.setText(testCard1.cardType + "\n\n" + testCard1.value);
			player2Card.setText(testCard2.cardType + "\n\n" + testCard2.value);
			outcome.setText(
					"Player1 hits for " + testCard1.value + "HP! \r\n" +
					"Player2 tries to run!" + 
					"Player1 wins the round!"
			);
		}
		else if( testCard1.value < testCard2.value) {
			System.out.println("[**] Player1 hits for " + testCard1.value + "HP!");
			System.out.println("[**] Player2 tries to run!");
			System.out.println("[**] Player1 < Player2 | " + testCard1.value + " < " + testCard2.value);
			System.out.println("[**] Player2 wins round");
			player1Card.setText(testCard1.cardType + "\n\n" + testCard1.value);
			player2Card.setText(testCard2.cardType + "\n\n" + testCard2.value);
			outcome.setText(
					"Player1 tries to hit for " + testCard1.value + "HP! \r\n" +
					"Player2 escapes the attack oncoming attack! \r\n" + 
					"Player2 wins the round!"
			);
		}
		else if( testCard1.value == testCard2.value) {
			System.out.println("[**] Player1 hits for " + testCard1.value + "HP!");
			System.out.println("[**] Player2 tries to run!");
			System.out.println("[**] Player1 = Player2 | " + testCard1.value + " = " + testCard2.value);
			System.out.println("[**] TIE");
			player1Card.setText(testCard1.cardType + "\n\n" + testCard1.value);
			player2Card.setText(testCard2.cardType + "\n\n" + testCard2.value);
			outcome.setText(
					"Player1 tries to hit for " + testCard1.value + "HP but misses! \r\n" +
					"Player2 tries to run but fails to escape! \r\n" + 
					"TIE"
			);	
		}
	}
	public void DefendAttack(Cards testCard1, Cards testCard2, TextArea player1Card, TextArea player2Card, TextArea outcome) {
		int dmgDiff1 = testCard1.value - testCard2.value;
		int dmgDiff2 = testCard2.value - testCard1.value;
		System.out.println("[**] Player1 DEFENDs and Player2 ATTACKs");
		if( testCard1.value > testCard2.value) {
			System.out.println("[**] Player1 defends for " + testCard1.value + "HP!");
			System.out.println("[**] Player2 attacks for " + testCard2.value + "HP!");
			System.out.println("[**] Player1 > Player2 | " + testCard1.value + " > " + testCard2.value);
			System.out.println("[**] Player1 - Player2 | " + testCard1.value + " - " + testCard2.value + " = " + dmgDiff1 + "HP");
			System.out.println("[**] Player1 takes only " + dmgDiff1 + " damage");
			System.out.println("[**] Player1 wins round");
			player1Card.setText(testCard1.cardType + "\n\n" + testCard1.value);
			player2Card.setText(testCard2.cardType + "\n\n" + testCard2.value);
			outcome.setText(
					"Player1 defends for " + testCard1.value + "HP! \r\n" +
					"Player2 hits for " + testCard2.value + "HP! \r\n" + 
					"Player1 wins the round!"
			);
		}
		else if( testCard1.value < testCard2.value) {
			System.out.println("[**] Player1 defends for " + testCard1.value + "HP!");
			System.out.println("[**] Player2 attacks for " + testCard2.value + "HP!");
			System.out.println("[**] Player1 < Player2 | " + testCard1.value + " < " + testCard2.value);
			System.out.println("[**] Player2 - Player1 | " + testCard2.value + " - " + testCard1.value + " = " + dmgDiff2 + "HP");
			System.out.println("[**] Player2 takes only " + dmgDiff2 + " damage");
			System.out.println("[**] Player2 wins round");
			player1Card.setText(testCard1.cardType + "\n\n" + testCard1.value);
			player2Card.setText(testCard2.cardType + "\n\n" + testCard2.value);
			outcome.setText(
					"Player1 defends for " + testCard1.value + "HP! \r\n" +
					"Player2 hits for " + testCard2.value + "HP! \r\n" + 
					"Player2 wins the round!"
			);
		}
		else if( testCard1.value == testCard2.value){
			System.out.println("[**] Player1 defends for " + testCard1.value + "HP!");
			System.out.println("[**] Player2 defends for " + testCard2.value + "HP!");
			System.out.println("[**] Player1 = Player2 | " + testCard1.value + " = " + testCard2.value);
			System.out.println("[**] TIE");
			player1Card.setText(testCard1.cardType + "\n\n" + testCard1.value);
			player2Card.setText(testCard2.cardType + "\n\n" + testCard2.value);
			outcome.setText(
					"Player1 defends for " + testCard1.value + "HP! \r\n" +
					"Player2 hits for " + testCard2.value + "HP! \r\n" + 
					"TIE"
			);	
		}
	}
	public void DefendDefend(Cards testCard1, Cards testCard2, TextArea player1Card, TextArea player2Card, TextArea outcome) {
		System.out.println("[**] Player1 defends for " + testCard1.value + "HP!");
		System.out.println("[**] Player2 defends for " + testCard2.value + "HP!");
		System.out.println("[**] Both players defend! No damage taken!");
		player1Card.setText(testCard1.cardType + "\n\n" + testCard1.value);
		player2Card.setText(testCard2.cardType + "\n\n" + testCard2.value);
		outcome.setText(
				"Player1 defends for " + testCard1.value + "HP! \r\n" +
				"Player2 defends for " + testCard2.value + "HP! \r\n" + 
				"Both players defend! No damage taken!"
		);
	}
	public void DefendRun(Cards testCard1, Cards testCard2, TextArea player1Card, TextArea player2Card, TextArea outcome) {
		System.out.println("[**] Player1 DEFENDs and Player2 RUNs");
		if( testCard1.value > testCard2.value) {
			System.out.println("[**] Player1 defends for " + testCard1.value + "HP!");
			System.out.println("[**] Player2 tries to run!");
			System.out.println("[**] Player1 > Player2 | " + testCard1.value + " > " + testCard2.value);
			System.out.println("[**] Player1 wins round");
			player1Card.setText(testCard1.cardType + "\n\n" + testCard1.value);
			player2Card.setText(testCard2.cardType + "\n\n" + testCard2.value);
			outcome.setText(
					"Player1 defends for " + testCard1.value + "HP! \r\n" +
					"Player2 tries to run but fails to escape!" + 
					"Player1 wins the round!"
			);
		}
		else if( testCard1.value < testCard2.value) {
			System.out.println("[**] Player1 defends for " + testCard1.value + "HP!");
			System.out.println("[**] Player2 tries to run!");
			System.out.println("[**] Player1 < Player2 | " + testCard1.value + " < " + testCard2.value);
			System.out.println("[**] Player2 wins round");
			player1Card.setText(testCard1.cardType + "\n\n" + testCard1.value);
			player2Card.setText(testCard2.cardType + "\n\n" + testCard2.value);
			outcome.setText(
					"Player1 defends for " + testCard1.value + "HP! \r\n" +
					"Player2 escapes the oncoming attack! \r\n" + 
					"Player2 wins the round!"
			);
		}
		else if( testCard1.value == testCard2.value) {
			System.out.println("[**] Player1 hits for " + testCard1.value + "HP!");
			System.out.println("[**] Player2 tries to run!");
			System.out.println("[**] Player1 = Player2 | " + testCard1.value + " = " + testCard2.value);
			System.out.println("[**] TIE");
			player1Card.setText(testCard1.cardType + "\n\n" + testCard1.value);
			player2Card.setText(testCard2.cardType + "\n\n" + testCard2.value);
			outcome.setText(
					"Player1 tries to defend for " + testCard1.value + "HP but misses! \r\n" +
					"Player2 tries to run but fails to escape! \r\n" + 
					"TIE"
			);	
		}
	}
	
	public void RunRun(Cards testCard1, Cards testCard2, TextArea player1Card, TextArea player2Card, TextArea outcome) {
		System.out.println("[**] Player1 RUNs and Player2 RUNs");
		System.out.println("[**] Player1 tries to run!");
		System.out.println("[**] Player2 tries to run!");
		System.out.println("[**] Both players run! No damage taken!");
		player1Card.setText(testCard1.cardType + "\n\n" + testCard1.value);
		player2Card.setText(testCard2.cardType + "\n\n" + testCard2.value);
		outcome.setText(
				"Player1 tries to run! \n" +
				"Player2 tries to run! \n" + 
				"Both players run! No damage taken!"
		);
	}
}
