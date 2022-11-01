package mod5quizCirrus;

import java.util.ArrayList;
import java.util.Scanner;
import java.text.NumberFormat;

public class PlayCards {

	public static void main(String[] args) {
		int NUM_GAMES = 17;
		Scanner scan = new Scanner(System.in);

		printStart(); // calls printStart method - Eduardo

		DeckOfCards doc = new DeckOfCards();

		// This part is only temporary for now. We might need a for loop when we extend
		// it to mulitple players. - Eduardo
		System.out.println("What is the name of player # 1");
		String playerOne = scan.nextLine();

		System.out.println("How much do they want to bet per hit?");
		double betOne = scan.nextDouble();

		scan.nextLine();

		System.out.println("What is the name of player # 2");
		String playerTwo = scan.nextLine();

		System.out.println("How much do they want to bet per hit?");
		double betTwo = scan.nextDouble();

		/*
		 * Shuffles deck and distributes deck to two players Constructor passes
		 * information to PlayerNotDone Prints information about each player - Eduardo
		 */

		doc.shuffle();
		Hand handOne = getHand(doc);
		Hand handTwo = getHand(doc);
		Hand handComp = getHand(doc);

		System.out.println();
		
		Player p1 = new Player(playerOne, handOne, betOne);
		System.out.println(p1.displayPlayer());

		Player p2 = new Player(playerTwo, handTwo, betTwo);
		System.out.println(p2.displayPlayer());

		Player comp = new Player("computer", handComp, 100);
		System.out.println(comp.displayPlayer());

		// We will need to have an array of players as the amount can be unlimited but
		// this is just temporary - Ben
		ArrayList<Player> playerList = new ArrayList<Player>();
		playerList.add(p1);
		playerList.add(p2);
		playerList.add(comp);

		System.out.println("***Lets start the game***");

		// Bare bones logic for multiple games and players - Ben
		for (int i = 0; i < NUM_GAMES; i++) {
			System.out.println();
			for (Player player : playerList) {
				player.playNextCard(i);
			}
			determineWinnerOfRound(playerList, i);
		}

	}

	// Finds the winner of the round based on the player with the most valuable
	// card. Adds their bet to their total balance
	// Will need game tie logic added - Ben 11/1
	
	// changed ArrayList's name from players to gamers for more legible code - Eduardo 11/1
	public static void determineWinnerOfRound(ArrayList<Player> gamers, int cardIndex) {
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		Scanner scan = new Scanner(System.in);

		int highestCard = 0;
		Player winner = null;

		for (Player player : gamers) {
			//Card playerCard = player.getHand().getCards().get(cardIndex);
			Card playerCard = player.getNextCard(cardIndex); // Calls the getNextCard method in Player to get current card - Eduardo 11/1
			if (playerCard.getPoints() > highestCard) {
				winner = player;
				highestCard = playerCard.getPoints();
			}
		}

		// Renamed the wording of this statement - Eduardo 11/1
		System.out.println("\nThe winner of the round is " + winner.getName() + ". The winner added "
				+ nf.format(winner.getAmtMoney()) + " to their balance\n");
		System.out.println("** Current Balances **");
		for (Player player : gamers) {
			if (player.getName().equals(winner.getName())) {
				player.setBalance(player.getBalance() + player.getAmtMoney());
			}
			System.out.println(player.getName() + " has " + nf.format(player.getBalance())); // Fixed formating - Eduardo 11/1																		
		}
		
		System.out.print("\nHit enter to start next game."); // Add pause between each game - Eduardo 11/1
		scan.nextLine();
		

	}

	// I've set 17 cards for the two players in the game. This will need to be
	// changed at the end of project - Eduardo
	public static Hand getHand(DeckOfCards d) {
		// Scanner scan = new Scanner(System.in);
		// System.out.println("How many cards in a hand?");
		// int numCards = scan.nextInt();

		int numCards = 17;
		Hand hand = new Hand();
		ArrayList<Card> cards = new ArrayList<Card>();
		for (int i = 0; i < numCards; i++) {
			cards.add(d.drawCard());
		}
		hand.setCards(cards);
		return hand;

	}

	// This calculates the total number of points. -Cara
	public static int points(Card c) {
		int value = c.getValue();
		String face = c.getFace();
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
	
	// Created overallWinner method which determines the overall winner. Work in progress - Eduardo
	public static void overallWinner(Player winner) {
		System.out.println("The overall winner is " + winner.getName() + ". Their balance was " + winner.getBalance());
	}

	/*
	 * prints the beginning of the sample output change it if needed to fit with
	 * program - Eduardo
	 */
	public static void printStart() {
		System.out.println("We are going to play Wolff's War! There will be two players and the computer\r\n"
				+ "Each will get 17 cards\r\n" + "So we will play 17 rounds\r\n"
				+ "Scoring:  Hearts = 4 pts, Diamonds = 3 pts,  Clubs = 2 pts,  Spades = 1 pt\r\n"
				+ "Add the points for the suit to the face value for the total points for that person\r\n"
				+ "Highest points win!\r\n" + "For ties, no one wins!!\r\n" + "");
	}

}
