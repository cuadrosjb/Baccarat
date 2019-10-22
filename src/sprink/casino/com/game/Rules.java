package sprink.casino.com.game;

import java.util.HashMap;
import java.util.Map;

import sprink.casino.com.GameStatus;

public class Rules {

	public static GameStatus decideWinner(Spot player, Spot banker) {
		if (player.value() > banker.value()) {
//			System.out.println("PLAYER Wins with:" + player.value() + ", BANKER losses with:" + banker.value());
			return GameStatus.PLAYER;
		} else if (banker.value() > player.value()) {
//			System.out.println("BANKER Wins with:" + banker.value() + ", PLAYER losses with:" + player.value());
			return GameStatus.BANKER;
		}

		return GameStatus.TIE;
	}

	public static boolean naturalWin(Spot player, Spot banker) {
		if (player.isNatural() || banker.isNatural()) {
			return true;
		}
		return false;
	}

	public static GameStatus decideNaturalWinner(Spot player, Spot banker) {
		if (player.value() > banker.value()) {
//			System.out.println("PLAYER Wins with Natural:" + player.value() + ", BANKER losses with:" + banker.value());
			return GameStatus.PLAYER;
		} else if (banker.value() > player.value()) {
//			System.out.println("BANKER Wins with Natural:" + banker.value() + ", PLAYER losses with:" + player.value());
			return GameStatus.BANKER;
		}

		return GameStatus.TIE;
	}

	public static boolean playerNeedsToDrawThirdCard(Spot player) {
		if (player.value() < 6) {
			return true;
		}

		return false;
	}

	public static boolean bankerNeedsToDrawThirdCard(Spot player, Spot banker) {

		if (banker.value() < 3) {
			return true;
		}

		if (player.getHand().size() == 3) {

			int thridCardValue = player.getThirdCard().getTrueValue();
			return needsToDraw(thridCardValue, banker);
		}

		return false;
	}

	public static Map<Integer, Integer[]> bankerRules() {
		Map<Integer, Integer[]> rules = new HashMap<Integer, Integer[]>();
		rules.put(0, new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 });
		rules.put(1, new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 });
		rules.put(2, new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 });
		rules.put(3, new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7, 9 });
		rules.put(4, new Integer[] { 2, 3, 4, 5, 6, 7 });
		rules.put(5, new Integer[] { 4, 5, 6, 7 });
		rules.put(6, new Integer[] { 6, 7 });
		rules.put(7, new Integer[] {});
		rules.put(8, new Integer[] {});
		rules.put(9, new Integer[] {});

		return rules;
	}

	public static boolean needsToDraw(Integer third, Spot banker) {
		Integer[] possibleCards = bankerRules().get(banker.value());

		for (Integer card : possibleCards) {
			if (third == card) {
				return true;
			}
		}

		return false;
	}

}
