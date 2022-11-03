package mod5quizCirrus;

import java.util.ArrayList;
import java.util.Scanner;
import java.text.NumberFormat;

public class PlayCards {

	public static void main(String[] args) {

		printStart(); // calls printStart method - Eduardo

		DeckOfCards doc = new DeckOfCards();
		doc.shuffle();

		ArrayList<Player> playerList = populatePlayerList(doc);

		for (Player player : playerList) {
			System.out.println(player.displayPlayer());
		}

		System.out.println("***Lets start the game***");

		// Updated all of this - Ben 11/2
		Scanner scan = new Scanner(System.in);
		int numGames = 51 / playerList.size();
		System.out.println("There are " + (playerList.size() - 1) + " players plus 1 computer, so we will be playing "
				+ numGames + " rounds.");
		for (int i = 0; i < numGames; i++) {
			System.out.println();
			for (Player player : playerList) {
				player.playNextCard(i);
			}
			determineWinnerOfRound2(playerList, i);
			//Migrated enter prompt to main so we can stop prompting for Enter
			//once final round is completed. -Cara
			if (i<numGames-1) {
				System.out.print("\nHit enter to start next round.");
				scan.nextLine();}
		}
		// Need a finished final winner method - Ben 11/2
		// Should be good to go. - Cara 11/2
		determineGameWinner(playerList);

	}

	// Updated way to handle round winner. Takes into account all players and
	// handles ties. Tied games will not get any reward - Ben 11/2
	public static void determineWinnerOfRound2(ArrayList<Player> gamersList, int cardIndex) {
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
			// changed gamersList to winners so it only grabs the player that are declared
			// winners - Eduardo 11/2
			for (Player player : winners) {
				player.setBalance(player.getBalance() + (player.getAmtMoney() / 2));
				namesListBuilder += player.getName() + " ";
			}
			System.out.println(namesListBuilder + " tied this round! Tied winners will get half of their bet!!");
		} else {
			// Fix: Balance was being over written and not added to - Ben 11/2
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

	/*Obsolete method, only preserving for reference purposes.  If no longer required, feel free to delete.
	 * -Cara
	 * Finds the winner of the round based on the player with the most valuable
	// card. Adds their bet to their total balance

	// changed ArrayList's name from players to gamers for more legible code -
	// Eduardo 11/1
	// Added tie conditions. I've yet to come across three-way tie, but there's code
	// for that now.
	public static void determineWinnerOfRound(ArrayList<Player> gamers, int cardIndex) {
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		Scanner scan = new Scanner(System.in);

		int highestCard = 0;
		Player winner = null;
		Player winner2 = null;
		Player winner3 = null;
		int winner2Pts = 0;

		for (Player player : gamers) {
			// Card playerCard = player.getHand().getCards().get(cardIndex);
			Card playerCard = player.getNextCard(cardIndex); // Calls the getNextCard method in Player to get current
																// card - Eduardo 11/1
			if (playerCard.getPoints() > highestCard) {
				winner = player;
				highestCard = playerCard.getPoints();
			} else if (playerCard.getPoints() == highestCard && highestCard > 0) {
				if (winner2 == null) {
					winner2 = player;
					winner2Pts = playerCard.getPoints();
				} else
					winner3 = player;
			}
		}

		if (winner2 == null || winner2Pts < highestCard) {
			System.out.println("\nThe winner of the round is " + winner.getName() + ". The winner added "
					+ nf.format(winner.getAmtMoney()) + " to their balance\n");
			System.out.println("** Current Balances **");
			for (Player player : gamers) {
				if (player.getName().equals(winner.getName())) {
					player.setBalance(player.getBalance() + player.getAmtMoney());
				}
				System.out.println(player.getName() + " has " + nf.format(player.getBalance())); // Fixed formating -
																									// Eduardo 11/1
			}
			System.out.print("\nHit enter to start next round.");
			scan.nextLine();
		} else {
			if (winner3 == null) {
				System.out.println(
						"\nThere was a tie this round between " + winner.getName() + " and " + winner2.getName() + ".");
				System.out.println(winner.getName() + " added " + nf.format((winner.getAmtMoney() / 2))
						+ " to their balance, and " + winner2.getName() + " added "
						+ (nf.format(winner2.getAmtMoney() / 2)) + "to theirs.");
				System.out.println("** Current Balances **");
				for (Player player : gamers) {
					if (player.getName().equals(winner.getName()) || player.getName().equals(winner2.getName())) {
						player.setBalance(player.getBalance() + (player.getAmtMoney() * .5));
					}
					System.out.println(player.getName() + " has " + nf.format(player.getBalance()));
				}
				System.out.print("\nHit enter to start next round."); 
				scan.nextLine();
			} else {
				System.out.println("It was a three-way tie!  No money added.");
				System.out.println("** Current Balances **");
				for (Player player : gamers) {
					System.out.println(player.getName() + " has " + nf.format(player.getBalance()));
				}
			}
		}

	}*/

	// Populates the player list in the main driver
	// Needs invalid user input logic - Ben 11/2
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

		// As sometimes the deck count (51) cannot be evenly divisible by the
		// playerCount, an integer type will make sure that
		// there will be an equal amount of cards for each player (Integer rounds down).
		// Every player must have the same amount of cards or some players will be at a
		// severe disadvantage and not be able to play
		int numCards = 51 / playerCount;

		Hand hand = new Hand();
		ArrayList<Card> cards = new ArrayList<Card>();
		for (int i = 0; i < numCards; i++) {
			cards.add(d.drawCard());
		}
		hand.setCards(cards);
		return hand;

	}

	/*
	 * prints the beginning of the sample output change it if needed to fit with
	 * program - Eduardo
	 */
	// Changed output - Eduardo 11/2
	// Updated to reflect tied player rewards - Ben 11/2
	public static void printStart() {
		System.out.println("****************** Wolff's War! **************************** "
				+ "\nScoring:  Hearts = 4 pts, Diamonds = 3 pts,  Clubs = 2 pts,  Spades = 1 pt\r\n"
				+ "Add the points for the suit to the face value for the total points for that person\r\n"
				+ "Highest points win!\r\n" + "For ties, tied winners will get half of their bet!!\r\n" + "");
	}

}
