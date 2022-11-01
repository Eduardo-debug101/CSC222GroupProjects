package mod5quizCirrus;


public class Card {
	private String face; // face of card
	private String suit; // suit of card
	private int value; // 1 to 13 for value

	// constructor
	public Card() {
		
	}
	public Card(int num,String cardFace, String cardSuit) {

		face = cardFace; // initialize face of card
		suit = cardSuit; // initialize suit of card
		value = num;
	}

	// return String representation of Card
	public String toString() {
		// Slightly updated to be more eligible. Removed getPoints as that can be handled in playNextCard() in Player class. -Ben 11/1
		return value + ":" + face + " of " + suit;
	}
	
	//This calculates the total number of points, work in progress.  -Cara
	public static int oldGetPoints(int v, String s) {
		int value = v;
		String face = s;
		int faceBonus = 0;
		if (face.equalsIgnoreCase("hearts"))
			faceBonus = 4;
		else if (face.equalsIgnoreCase("diamonds"))
			faceBonus = 3;
		else if (face.equalsIgnoreCase("clubs"))
			faceBonus = 2;
		else
			faceBonus = 1;
		return value + faceBonus;
	}
	
	// Different way of getting card points see if you like it better :) -Ben 11/1
	// Changed name from newGetPoints to getPoints - Eduardo 11/1
	public  int getPoints() {
		switch (suit) {
		case "Hearts":
			return value + 4;
		case "Diamonds":
			return value + 3;
		case "Clubs":
			return value + 2;
		default:
			return value + 1;
		}
	}

	public String getFace() {
		return face;
	}

	public void setFace(String face) {
		this.face = face;
	}

	public String getSuit() {
		return suit;
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

} // end class Card

