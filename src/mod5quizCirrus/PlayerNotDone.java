package mod5quizCirrus;

import java.text.NumberFormat;

//import javax.swing.ImageIcon;
//import javax.swing.JOptionPane;

public class PlayerNotDone {
	private String name;
	private Hand hand;
	private double amtMoney;
	// Added the players balance so that their total balance can be kept track of. - Ben 11/1
	private double balance = 0;

	public PlayerNotDone() {

	}

	public PlayerNotDone(String n, Hand h, double b) {
		name = n;
		hand = h;
		amtMoney = b;

	}

	public String displayPlayer() {
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		// Changed wording to match sample output - Eduardo
		return name + " is betting " + nf.format(amtMoney) + ".  Their hand is: " + hand.displayHand();
	}
	
	public String toString() {
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		// We need to get info to card class somehow. - Eduardo
		//hand.getCards().get(0);
		return name + " bet " + nf.format(amtMoney) + " and the card was " + hand.getCards().get(0);
	}
	
	// Plays the next card in the hand
	public void playNextCard(int cardIndex) {
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		Card currentCard = getHand().getCards().get(cardIndex);

		System.out.println(name + " bet " + nf.format(amtMoney) + " and the card was " + currentCard.toString());
		System.out.println("Card worth: " + currentCard.newGetPoints() + "pts");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}

	public double getAmtMoney() {
		return amtMoney;
	}

	public void setAmtMoney(double amtMoney) {
		this.amtMoney = amtMoney;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

}
