package sprink.casino.com.game;

import sprink.casino.com.Shoe;
import sprink.casino.com.util.ShoeBuilder;

public class Table {
	
	private Shoe shoe;
	private Dealer dealer;
	private boolean open;
	
	public Table () {
		super();
		shoe = new ShoeBuilder().build();
		dealer = new Dealer(shoe);
	}
	
	public Table(Shoe shoe, Dealer dealer) {
		this.shoe = shoe;
		this.dealer = dealer;
	}

	public void play () throws Exception {
		if (!open) {
			dealer.openTable();
		}
		dealer.deal();
	} 
	
	public static void main(String[] args) throws Exception {
		for (int i = 0; i < 1; i++) {
			Table table = new Table();
			table.play();
		}
	}
}
