package mod5quizCirrus;

import java.text.NumberFormat;

//import javax.swing.ImageIcon;
//import javax.swing.JOptionPane;

public class PlayerNotDone {
	private String name;
	private Hand hand;
	private double amtMoney;

	public PlayerNotDone() {

	}

	public PlayerNotDone(String n, Hand h, double m) {
		name = n;
		hand = h;
		amtMoney = m;

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

}
