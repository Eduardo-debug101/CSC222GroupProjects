package mod5quizCirrus;

import java.util.ArrayList;
import java.util.Scanner;
import java.text.NumberFormat;

public class PlayCards {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		printStart(); // calls printStart method - Eduardo

		DeckOfCards doc = new DeckOfCards();
		doc.shuffle();

		ArrayList<Player> playerList = populatePlayerList(doc);

		// Displays each player's starting hand
		for (Player player : playerList) {
			System.out.println(player.displayPlayer());
		}

		System.out.println("***Lets start the game***");

		int numGames = 51 / playerList.size();
		System.out.println("There are " + (playerList.size() - 1) + " players plus 1 computer, so we will be playing "
				+ numGames + " rounds.");
		
		// Iterates through the needed amount of games relative to the amount of cards
		// Iterates through the populated player list to play next card
		// Round winner is then determined and after all games are ran the final winner is found from the highest balance - Ben
		for (int i = 0; i < numGames; i++) {
			System.out.println();
			for (Player player : playerList) {
				player.playNextCard(i);
			}
			determineWinnerOfRound(playerList, i);
			if (i<numGames-1) {
				System.out.print("\nHit enter to start next round.");
				scan.nextLine();}
		}
		determineGameWinner(playerList);

	}

	// Updated way to handle round winner. Takes into account all players and
	// handles ties. Tied games will not get any reward - Ben
	public static void determineWinnerOfRound(ArrayList<Player> gamersList, int cardIndex) {
		ArrayList<Player> winners = new ArrayList<Player>();
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		Scanner scan = new Scanner(System.in);

		// Finds the highest card of this play
		int highestCardPoints = 0;
		for (Player player : gamersList) {
			Card playerCard = player.getNextCard(cardIndex);
			if (playerCard.getPoints() > highestCardPoints) {
				highestCardPoints = playerCard.getPoints();
			}
		}

		// Adds players who have the highest card to a winners list
		for (Player player : gamersList) {
			Card playerCard = player.getNextCard(cardIndex);
			if (playerCard.getPoints() == highestCardPoints) {
				winners.add(player);
			}
		}

		// Handles 1 up to multiple winners. Tied games the winners get half of their
		// bet amount for that play
		if (winners.size() > 1) {
			String namesListBuilder = "";
			for (Player player : winners) {
				player.setBalance(player.getBalance() + (player.getAmtMoney() / 2));
				namesListBuilder += player.getName() + " ";
			}
			System.out.println(namesListBuilder + " tied this round! Tied winners will get half of their bet!!");
		} else {
			winners.get(0).setBalance(winners.get(0).getBalance() + winners.get(0).getAmtMoney());

			System.out.println(winners.get(0).getName() + " won this round!! I'm adding "
					+ nf.format(winners.get(0).getAmtMoney()) + " to their balance.");
		}

		// Lists out player balances
		System.out.println();
		System.out.println("** Current Balances **");
		for (Player player : gamersList) {
			System.out.println(player.getName() + " has " + nf.format(player.getBalance()));
		}
	}


	// Populates the player list in the main driver - Ben
	public static ArrayList<Player> populatePlayerList(DeckOfCards deck) {
		Scanner scan = new Scanner(System.in);

		ArrayList<Player> playerList = new ArrayList<Player>();

		System.out.println("How many players will be playing today?");
		// Total player count must account for the computer so + 1
		int playerCount = scan.nextInt() + 1;
			

		// -1 as we are not counting the computer
		for (int i = 0; i < playerCount - 1; i++) {
			System.out.println("What is the name of player #" + (i + 1) + "?");

			scan.nextLine();
			String name = scan.nextLine();

			System.out.println("How much do they want to bet per hit?");
			double bet = scan.nextDouble();

			Hand hand = getHand(deck, playerCount);
			Player player = new Player(name, hand, bet);

			playerList.add(player);
		}

		Hand handComp = getHand(deck, playerCount);
		Player comp = new Player("computer", handComp, 100);
		playerList.add(comp);

		return playerList;
	}

	// Prints out the winner. -Cara
	public static void determineGameWinner(ArrayList<Player> competitors) {
		ArrayList<Player> gameWinners = new ArrayList<Player>();
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		double maxWinnings = 0;
		for (Player player : competitors) {
			if (player.getBalance() > maxWinnings)
				maxWinnings = player.getBalance();
		}
		for (Player player : competitors) {
			if (player.getBalance() == maxWinnings)
				gameWinners.add(player);
		}
		
		if (gameWinners.size() > 1) {
			String winnersListString = "";
			for (Player player : gameWinners) {
				winnersListString += player.getName() + ", ";
			}
			System.out.println("The overall winners are: " + winnersListString + "who tied with " + nf.format(maxWinnings) 
			+ " in earnings each!");
		} else {
			System.out.println("\n\nThe overall winner is: " + gameWinners.get(0).getName() + " with total earnings of "
					+ nf.format(gameWinners.get(0).getBalance()) + ".");
		}
	}

	public static Hand getHand(DeckOfCards d, int playerCount) {
		int numCards = 51 / playerCount;

		Hand hand = new Hand();
		ArrayList<Card> cards = new ArrayList<Card>();
		for (int i = 0; i < numCards; i++) {
			cards.add(d.drawCard());
		}
		hand.setCards(cards);
		return hand;

	}

	public static void printStart() {
		System.out.println("****************** Wolff's War! **************************** "
				+ "\nScoring:  Hearts = 4 pts, Diamonds = 3 pts,  Clubs = 2 pts,  Spades = 1 pt\r\n"
				+ "Add the points for the suit to the face value for the total points for that person\r\n"
				+ "Highest points win!\r\n" + "For ties, tied winners will get half of their bet!!\r\n" + "");
	}

}
