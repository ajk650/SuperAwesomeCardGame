/* Group 8
 * ------------------------------------------
 * Cards:
 * This class handles the card creation that will be dealt to each player's hand. 
 * Each card holds a value and a card type that will be met with certain conditions based
 * on each player's hand.
 */

// imported packages
package application.model;

// imported libraries
import java.util.ArrayList;
import java.util.Random;

public class Cards {
	private ArrayList<String> arrayType = new ArrayList<String>();
	private ArrayList<Cards> cardDeck = new ArrayList<Cards>();
	public String cardType;
	public int value;
//	Cards next;
	
	// constructor
	public Cards(ArrayList<String> arrayType, int value) {
		super();
		this.arrayType = arrayType;
		this.value = value * 10;
//		next = null;
	}
	
	// constructor
	public Cards(String cardType, int value) {
		super();
		this.cardType = cardType;
		this.value = value * 10;
//		next = null;
	}

	// constructor
	public Cards() {
		super();
//		next = null;
	}
	
	// return arraylist of cards
	public ArrayList<Cards> getCardDeck() {
		return cardDeck;
	}

	// set arraylist of cards
	public void setCardDeck(ArrayList<Cards> cardDeck) {
		this.cardDeck = cardDeck;
	}

	// return value
	public int getValue() {
		return value;
	}
	
	// set value
	public void setValue(int value) {
		this.value = value;
	}
	
	// return arraylist of strings
	public ArrayList<String> getArrayType() {
		return arrayType;
	}
	
	// set arraytype
	public void setArrayType(ArrayList<String> arrayType) {
		this.arrayType = arrayType;
	}
	
	// return cardType
	public String getCardType() {
		return cardType;
	}
	
	// set cardType
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	
	/*
	 * This method creates a card that holds a random integer for the card's value and
	 * a card type.
	 */
	public Cards createCard()
	{
		Random rand = new Random();
		int randNum = rand.nextInt(10);
		int cardValue;
		Cards newCard = null;
	
		arrayType.add("ATTACK");
		arrayType.add("DEFEND");
		arrayType.add("RUN");
		
		/* -- randNum Test Print -- */
		System.out.println( "[**] randNum: " + randNum );

		
		
		// -- If randNum is { 0, 1, 2, 3 } = 40%, card type becomes ATTACK (0), card value = 1-5 inclusive --
	    if ( randNum == 0 || randNum == 1 || randNum == 2 || randNum == 3 )
	    {
	    	cardValue = rand.nextInt(5) + 1;
	    	newCard = new Cards(arrayType.get(0), cardValue);
	    	// Get a random number ( 1-5 )
	    	/* -- Test Print 40% - ATTACK Card -- */
	    	System.out.println( "[**] 40% - ATTACK | Type: " + newCard.cardType + " = ATTACK | Value: " + newCard.value + "\n");
	    }
		// -- If randNum is { 4, 5, 6, 7, 8 } = 50%, cardType becomes DEFENSE (1), card value = 3-8 inclusive -- 
	    else if ( randNum == 4 || randNum == 5 || randNum == 6 || randNum == 7 || randNum == 8 )
	    {
	    	cardValue = rand.nextInt(5) + 3;
	    	newCard = new Cards(arrayType.get(1), cardValue);
	    	// Get a random number ( 4-8 )
	    	/* -- Test Print 50% - DEFENSE Card -- */
	    	System.out.println( "[**] 50% - DEFEND | Type: " + newCard.cardType + " = DEFEND | Value: " + newCard.value + "\n");
	    }
		// -- If randNum is { 9 } = 10%, cardType becomes RUN (2), card value = 1-8 inclusive --
	    else if ( randNum == 9 )
	    {
	    	cardValue = rand.nextInt(8) + 1;
	    	newCard = new Cards(arrayType.get(2), cardValue);
	    	//newCard->type = 2;
	    	//newCard->value = ( rand() % 8 ) + 1; // Get a random number ( 1-8 )
	    	/* -- Test Print 10% - RUN Card -- */
	    	//printf( "[*] 10%% - RUN | Type: %d = RUN | Value: %d\n", newCard->type, newCard->value );
	    	System.out.println( "[**] 10% - RUN | Type: " + newCard.cardType + " = RUN | Value: " + newCard.value + "\n");
	    	
	    }
		
		//newCard->next = NULL;
		
		return newCard;
	}
	
}
