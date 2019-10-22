package sprink.casino.com.game;

import java.util.List;

import sprink.casino.com.Card;

public interface Spot {
	
	public List<Card> getHand();
	
	public boolean isNatural();
	
	public int value();
	
	public void add(Card card);

	public Card getThirdCard();
	

}
