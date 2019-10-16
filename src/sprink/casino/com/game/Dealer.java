package sprink.casino.com.game;

import java.util.Collections;
import java.util.Stack;

import sprink.casino.com.Card;
import sprink.casino.com.Deck;
import sprink.casino.com.GameStatus;
import sprink.casino.com.Shoe;
import sprink.casino.com.util.ShoeBuilder;

public class Dealer {
	
	private Shoe shoe;
	private Stack<Card> cards;
	private boolean newGame = true;
	
	private Player player;
	private Banker banker;
	
	private int bankerCounter = 0;
	private int playerCounter = 0;
	private int tieCounter = 0;
	
	
	public Dealer() {
		cards = new Stack<Card>();
		player = new Player();
		banker = new Banker();
	}
	
	public Dealer(Shoe shoe) {
		this();
		this.shoe = shoe;
	}

	public void washShoe() {
		for (Deck deck : shoe.getDecks()) {
			cards.addAll(deck.getCards());
		}
		shuffle();
	}
	
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	public void initializeGame() {
		
		if (newGame) {
			washShoe();
			performBurn();
		}
		
		while (cards.size() > 52) {
			for (int index =0 ; index < 2 ; index++) {
				player.getHand().add(pullCard());
				banker.getHand().add(pullCard());
			}
			
			Rules rules = new Rules();
			
			GameStatus gs = rules.play(player, banker, cards);
			
			if (gs == GameStatus.BANKER) {
				bankerCounter++;
			} else if (gs == GameStatus.PLAYER) {
				playerCounter++;
			} else {
				tieCounter++;
			}
			
//			System.out.println(gs.toString() + " WINS!");
			
			clearHands();
		}
		
		System.out.println("the bank won:" + bankerCounter + ", the player won: " + playerCounter + ", TIE: " + tieCounter);
		
	}
	
	public void clearHands() {
		player = new Player();
		banker = new Banker();
	}
	
	public void performBurn() {
		System.out.println("How many cards to burn: ");
		Card card = pullCard();
		System.out.println(card.toString());
		
		for (int index = 0; index < card.getNumbericalValue(); index ++) {
			Card burningCard = pullCard();
			System.out.println("Burning card: " + burningCard.toString());
		}
		newGame = false;
	}
	
	private Card pullCard () {
		return cards.pop();
	}
	
	public static void main(String[] args) {
		Shoe shoe = new ShoeBuilder().build();
		Dealer dealer = new Dealer(shoe);
		
		dealer.initializeGame();
		
		
	}

}
