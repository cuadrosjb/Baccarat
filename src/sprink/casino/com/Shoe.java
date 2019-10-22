package sprink.casino.com;

import java.util.List;
import java.util.Stack;

public class Shoe {

	private List<Deck> decks;
	private Stack<Card> cards;
	
	private boolean firstHand = true;
	private boolean cutCard = false;
	
	public final static int CUT_CARD_PLACEMENT_DIFF = 7;
	public final static int CUT_CARD_PLACEMENT_MANDATED_BY_HOUSE = 52;
	
	public Shoe() {
		cards = new Stack<Card>();
	}
	
	public Shoe(List<Deck> decks) {
		this();
		this.decks = decks;
	}

	public List<Deck> getDecks() {
		return decks;
	}

	public void setDecks(List<Deck> decks) {
		this.decks = decks;
	}
	
	public boolean isTheFirstHand () {
		return firstHand;
	}
	
	public Stack<Card> getCards () {
		return cards;
	}
	
	public boolean isCutCardOut() {
		return cutCard;
	}
	
	public Card draw() {
		
		if (cards.peek() instanceof Cut) {
			cards.pop();
			cutCard = true;
//			System.out.println("Cut card removed");
		}
		
		return cards.pop();
	}
	
	public void insertCutCardAt(int index) {
		Card card = new Cut();
		cards.add(index, card);
	}
	
	
	
}
