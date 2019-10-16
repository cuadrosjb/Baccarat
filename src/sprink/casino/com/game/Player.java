package sprink.casino.com.game;

import java.util.ArrayList;
import java.util.List;

import sprink.casino.com.Card;

public class Player  implements Spot{

	private List<Card> hand;

	
	public Player() {
		hand = new ArrayList<Card>();
	}
	
	public Player(List<Card> hand) {
		super();
		this.hand = hand;
	}

	public List<Card> getHand() {
		return hand;
	}

	public void setHand(List<Card> hand) {
		this.hand = hand;
	}

	@Override
	public boolean isNatural() {
		if(hand.size() == 2) {
			int sum = hand.get(0).getNumbericalValue() + hand.get(1).getNumbericalValue();
			if (sum == 8  || sum ==9) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int handValue() {
		int value = 0;
		for (Card card : hand) {
			value += card.getNumbericalValue();
		} 
		
		value = value % 10;
		
		return value;
	}
	
	
	public Card getThridCard() {
		if (hand.size() ==3) {
			return hand.get(2);
		}
		return null;
	}
}
