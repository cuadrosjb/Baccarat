package sprink.casino.com;

import java.util.List;

public class Shoe {

	private List<Deck> decks;
	
	public Shoe(List<Deck> decks) {
		super();
		this.decks = decks;
	}

	public List<Deck> getDecks() {
		return decks;
	}

	public void setDecks(List<Deck> decks) {
		this.decks = decks;
	}
	
	
	
}
