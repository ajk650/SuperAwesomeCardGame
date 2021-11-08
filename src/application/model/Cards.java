package application.model;

import java.util.ArrayList;
import java.util.Random;

public class Cards {
	private ArrayList<String> arrayType = new ArrayList<String>();
	private ArrayList<Cards> cardDeck = new ArrayList<Cards>();
	public String cardType;
	public int value;
	Cards next;
	
	public Cards(ArrayList<String> arrayType, int value) {
		super();
		this.arrayType = arrayType;
		this.value = value;
		next = null;
	}
	
	public Cards(String cardType, int value) {
		super();
		this.cardType = cardType;
		this.value = value;
		next = null;
	}
	
	public ArrayList<Cards> getCardDeck() {
		return cardDeck;
	}

	public void setCardDeck(ArrayList<Cards> cardDeck) {
		this.cardDeck = cardDeck;
	}

	public Cards() {
		super();
		next = null;
	}

	public int getValue() {
		return value;
	}
	
	public ArrayList<String> getArrayType() {
		return arrayType;
	}
	
	public void setArrayType(ArrayList<String> arrayType) {
		this.arrayType = arrayType;
	}
	
	public String getCardType() {
		return cardType;
	}
	
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	
	/*
	Function: createCard
	-------------------
	This function uses random numbers and the card struct object in order to create a new card and assign it
	particular types and values based on the random number. The percentage determines which type and values the card recieves. Each card is dynamically allocated.
	Returns: Card*
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
	    	//newCard->value = ( rand() % 5 ) + 1; // Get a random number ( 1-5 )
	    	/* -- Test Print 40% - ATTACK Card -- */
	    	System.out.println( "[**] 40% - ATTACK | Type: " + newCard.cardType + " = ATTACK | Value: " + newCard.value + "\n");
	    }
		// -- If randNum is { 4, 5, 6, 7, 8 } = 50%, cardType becomes DEFENSE (1), card value = 3-8 inclusive -- 
	    else if ( randNum == 4 || randNum == 5 || randNum == 6 || randNum == 7 || randNum == 8 )
	    {
	    	cardValue = rand.nextInt(5) + 3;
	    	newCard = new Cards(arrayType.get(1), cardValue);
	    	//newCard->type = 1;
	    	//newCard->value = ( rand() % 6 ) + 3; // Get a random number ( 3-8 )
	    	/* -- Test Print 50% - DEFENSE Card -- */
	    	//System.out.println( "[*] 50%% - DEFENSE | Type: %d = DEFENSE | Value: %d\n", newCard->type, newCard->value );
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
