package sprink.casino.com.game;

public class Player extends SpotImp  implements Spot{

	
	public boolean hasPlayerTakenAThirdCard() {
		return super.hand.size() == 3 ? true: false;
	}


}
