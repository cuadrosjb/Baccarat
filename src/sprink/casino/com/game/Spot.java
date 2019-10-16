package sprink.casino.com.game;

import java.util.List;

import sprink.casino.com.Card;
import sprink.casino.com.GameStatus;

public interface Spot {
	
	public List<Card> getHand();
	
	public boolean isNatural();
	
	public int handValue();
	

}
