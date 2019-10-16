package sprink.casino.com.game;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import sprink.casino.com.Card;
import sprink.casino.com.GameStatus;

public class Rules {

	public GameStatus play(Spot player, Spot banker, Stack<Card> shoe) {
		//check for natural eight or nine
		
		if (naturalWin(player, banker)) {
			return deviceNaturalWinner(player, banker);
		} 
		
		if(playerNeedsToDrawThirdCard(player)) {
			player.getHand().add(shoe.pop());
		}
			
		if(bankerNeedsToDrawThirdCard((Player) player, banker)) {
			banker.getHand().add(shoe.pop());
		}
		
		
		return deviceWinner(player, banker);
		
	}
	
	public GameStatus deviceWinner(Spot player, Spot banker) {
		return deviceNaturalWinner(player, banker);
	}
	
	public boolean naturalWin(Spot player, Spot banker)  {
		if (player.isNatural() || banker.isNatural()) {
			return true;
		}
		return false;
	}
	
	
	public GameStatus deviceNaturalWinner(Spot player, Spot banker) {
		if (player.handValue() > banker.handValue()) {
			return GameStatus.PLAYER;
		} else if (player.handValue() < banker.handValue()) {
			return GameStatus.BANKER;
		}
		
		return GameStatus.TIE;
	}
	
	
	public boolean playerNeedsToDrawThirdCard(Spot player) {
		if (player.handValue() < 6) {
			return true;
		}
		
		return false;
	}
	
	public boolean bankerNeedsToDrawThirdCard(Player player, Spot banker) {

		if (banker.handValue() < 3) {
			return true;
		}

		if (player.getThridCard() != null) {

			int thridCardValue = player.getThridCard().getNumbericalValue();
			return needsToDraw(thridCardValue, banker);
		}

		return false;
	}
	
	public Map<Integer, Integer[]> bankerRules () {
		Map<Integer, Integer[]> rules = new HashMap<Integer, Integer[]>();
		rules.put(0, new Integer[]{0,1,2,3,4,5,6,7,8,9});
		rules.put(1, new Integer[]{0,1,2,3,4,5,6,7,8,9});
		rules.put(2, new Integer[]{0,1,2,3,4,5,6,7,8,9});
		rules.put(3, new Integer[]{0,1,2,3,4,5,6,7,9});
		rules.put(4, new Integer[]{2,3,4,5,6,7});
		rules.put(5, new Integer[]{4,5,6,7});
		rules.put(6, new Integer[]{6,7});
		rules.put(7, new Integer[]{});
		rules.put(8, new Integer[]{});
		rules.put(9, new Integer[]{});
		
		return rules;
	}
	
	public boolean needsToDraw(Integer third, Spot banker) {
		Integer[] possibleCards = bankerRules().get(banker.handValue());
		
		for (Integer card : possibleCards) {
			if (third == card) {
				return true;
			}
		}
		
		return false;
	}
	
	
	
}
