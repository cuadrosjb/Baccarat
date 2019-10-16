package sprink.casino.com.util;

import java.util.ArrayList;
import java.util.List;

import sprink.casino.com.Deck;
import sprink.casino.com.Shoe;

public class ShoeBuilder {
	
	private final static int STD_SHOE_SIZE = 8; 

	public Shoe build() {
		List<Deck> shoe = new ArrayList<Deck>();
		for (int index = 0 ; index < STD_SHOE_SIZE; index++) {
			shoe.add(DeckBuilder.build());
		}
		return new Shoe(shoe);
	}
	
}
