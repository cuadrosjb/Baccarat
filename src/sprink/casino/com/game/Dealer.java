package sprink.casino.com.game;

import java.util.Collections;
import java.util.Random;

import sprink.casino.com.Card;
import sprink.casino.com.Deck;
import sprink.casino.com.GameStatus;
import sprink.casino.com.Shoe;

public class Dealer {

	private Shoe shoe;

	private Player player;
	private Banker banker;

	private int bankerCounter = 0;
	private int playerCounter = 0;
	private int tieCounter = 0;

	public Dealer() {
		player = new Player();
		banker = new Banker();
	}

	public Dealer(Shoe shoe) {
		this();
		this.shoe = shoe;
	}

	public void openTable() {
		wash();
		shuffleShoe();
		placeCutCard();
		performBurn();
	}

	public void wash() {
		for (Deck deck : shoe.getDecks()) {
			shoe.getCards().addAll(deck.getCards());
		}
	}

	public void shuffleShoe() {
		Collections.shuffle(shoe.getCards());
	}

	public void dealfirstTwoCard() {
		for (int index = 0; index < 2; index++) {
			player.add(shoe.draw());
			banker.add(shoe.draw());
		}
	}

	public void game() throws Exception {
		while (!shoe.isCutCardOut()) {

			dealfirstTwoCard();

			GameStatus status = winner();

			recordResult(status);

			pickUpCards();
		}

		System.out.println(
				"the bank won:" + bankerCounter + ", the player won: " + playerCounter + ", TIE: " + tieCounter);

	}

	private void recordResult(GameStatus status) {
		if (status == GameStatus.BANKER) {
			bankerCounter++;
		} else if (status == GameStatus.PLAYER) {
			playerCounter++;
		} else {
			tieCounter++;
		}
	}

	private GameStatus winner() {

		if (Rules.naturalWin(player, banker)) {
			return Rules.decideNaturalWinner(player, banker);
		}

		if (Rules.playerNeedsToDrawThirdCard(player)) {
			player.add(shoe.draw());
		}

		if (Rules.bankerNeedsToDrawThirdCard(player, banker)) {
			banker.add(shoe.draw());
		}
		return Rules.decideWinner(player, banker);

	}

	public void pickUpCards() {
		player = new Player();
		banker = new Banker();
	}

	public void performBurn() {
		Card burns = shoe.draw();
//		System.out.println(burns.getTrueValue() + " card(s) to be burned.");

		for (int index = 0; index < burns.getTrueValue(); index++) {
			shoe.draw();
//			System.out.println("Burning card: " + card.toString());
		}
	}

	public void deal() throws Exception {
		game();
	}

	private void placeCutCard() {
		Random random = new Random();
		int index = random.nextInt(Shoe.CUT_CARD_PLACEMENT_DIFF);
		if (random.nextBoolean()) {
			index *= -1;
		}
		index = index + Shoe.CUT_CARD_PLACEMENT_MANDATED_BY_HOUSE;
		shoe.insertCutCardAt(index);
	}

}
