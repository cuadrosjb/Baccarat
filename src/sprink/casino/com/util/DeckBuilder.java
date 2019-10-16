package sprink.casino.com.util;

import java.util.ArrayList;
import java.util.List;

import sprink.casino.com.Card;
import sprink.casino.com.Deck;
import sprink.casino.com.Symbol;
import sprink.casino.com.Value;

public class DeckBuilder {

	public static Deck build() {
		List<Card> deck = new ArrayList<Card>();

		for (Symbol symbol : Symbol.values()) {
			for (Value value : Value.values()) {
				Card card = new Card(value, symbol, value.getValue());
				deck.add(card);
			}
		}
		
		return  new Deck(deck);
	}

}
