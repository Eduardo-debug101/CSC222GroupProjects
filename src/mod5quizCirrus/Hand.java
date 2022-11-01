package mod5quizCirrus;
import java.util.ArrayList;

public class Hand {
	private ArrayList<Card> cards;

	public Hand() {

	}

	public Hand(ArrayList<Card> c) {
		cards = c;
	}

	public String displayHand() {
		String s = "";
		for (int i=0;i<cards.size();i++)
			s = s + cards.get(i).toString() + " ";
		s = s + "\n";
		return s;
	}
	

	public ArrayList<Card> getCards() {
		return cards;
	}

	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}
}
