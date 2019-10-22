package sprink.casino.com.game;

import java.util.ArrayList;
import java.util.List;

import sprink.casino.com.Card;

public abstract class SpotImp implements Spot{
	
	protected List<Card> hand;
	
	private final static int HAND_TRUE_VALUE = 10;
	
	
	public SpotImp() {
		hand = new ArrayList<Card>();
	}
	
	public SpotImp(List<Card> hand) {
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
	public int value() {
		int value = 0;
		for (Card card : hand) {
			value += card.getTrueValue();
		} 
		
		value = value % HAND_TRUE_VALUE;
		
		return value;
	}
	
	
	@Override
	public boolean isNatural() {
		if(hand.size() == 2) {
			if (((hand.get(0).getTrueValue() + hand.get(1).getTrueValue()) % HAND_TRUE_VALUE)> 7) {
				return true;
			}
		}
		return false;
	}
	

	@Override
	public void add(Card card) {
		hand.add(card);
	}
	
	
	public Card getThirdCard() {
		return hand.get(2);
	}
	
}
