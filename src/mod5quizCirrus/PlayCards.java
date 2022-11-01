package mod5quizCirrus;

import java.util.ArrayList;
import java.util.Scanner;

public class PlayCards {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		printStart(); // calls printStart method - Eduardo
		
		DeckOfCards doc = new DeckOfCards();
		
		// This part is only temporary for now. We might need a for loop when we extend it to mulitple players. - Eduardo
		System.out.println("What is the name of player # 1");
		String playerOne = scan.nextLine();
		
		System.out.println("How much do they want to bet per hit?");
		double betOne = scan.nextDouble();
		
		scan.nextLine();
		
		System.out.println("What is the name of player # 2");
		String playerTwo = scan.nextLine();
		
		System.out.println("How much do they want to bet per hit?");
		double betTwo = scan.nextDouble();
		
		//System.out.println("Cards in order:");
		//System.out.println(doc.toString());
		
		/* Shuffles deck and distributes deck to two players
		Constructor passes information to PlayerNotDone 
		Prints information about each player - Eduardo */
		
		doc.shuffle();
		Hand handOne = getHand(doc);
		Hand handTwo = getHand(doc);
		Hand handComp = getHand(doc);
		PlayerNotDone p1 = new PlayerNotDone(playerOne, handOne, betOne);
		System.out.println(p1.displayPlayer()); 
		PlayerNotDone p2 = new PlayerNotDone(playerTwo, handTwo, betTwo);
		System.out.println(p2.displayPlayer());
		PlayerNotDone comp = new PlayerNotDone("computer", handComp, 100);
		System.out.println(comp.displayPlayer());
		
		System.out.println("***Lets start the game***");
		//for(int i=0; i<17; i++) {
		System.out.println(p1.toString());
		System.out.println("Value: " + points(handOne.getCards().get(0)));
		System.out.println(p2.toString());
		System.out.println("Value: " + points(handTwo.getCards().get(0)));
		System.out.println(comp.toString());
		System.out.println("Value: " + points(handComp.getCards().get(0)));
		
		//System.out.println("\nShuffled cards:");
		//System.out.println(doc.toString());
		
		//System.out.println("\n\n");
		

		//System.out.println("Here is your first hand");
		//System.out.println(getHand(doc).displayHand());
		
		//System.out.println("Here is your second hand");
		//System.out.println(getHand(doc).displayHand());
		
	}
	// I've set 17 cards for the two players in the game. This will need to be changed at the end of project - Eduardo
	public static Hand getHand(DeckOfCards d) {
		//Scanner scan = new Scanner(System.in);
		//System.out.println("How many cards in a hand?");
		//int numCards = scan.nextInt();
		
		int numCards = 17; 
		Hand hand = new Hand();
		ArrayList<Card> cards = new ArrayList<Card>();
		for (int i=0;i<numCards;i++) {
			cards.add(d.drawCard());			
		}
		hand.setCards(cards);
		return hand;
				
	}
	
	//This calculates the total number of points, work in progress.  -Cara
	public static int points(Card c) {
		int value = c.getValue();
		String face = c.getSuit();
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
	
	
	/* prints the beginning of the sample output 
	 change it if needed to fit with program - Eduardo */
	public static void printStart() {
		System.out.println("We are going to play Wolff's War! There will be two players and the computer\r\n"
				+ "Each will get 17 cards\r\n"
				+ "So we will play 17 rounds\r\n"
				+ "Scoring:  Hearts = 4 pts, Diamonds = 3 pts,  Clubs = 2 pts,  Spades = 1 pt\r\n"
				+ "Add the points for the suit to the face value for the total points for that person\r\n"
				+ "Highest points win!\r\n"
				+ "For ties, no one wins!!\r\n"
				+ "");
	}

}
