package sprink.casino.com;

public enum Value {

	ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, JOKER, CUT;

	public int getValue() {

		if (this == Value.ONE) {
			return 1;
		} else if (this == Value.TWO) {
			return 2;
		} else if (this == Value.THREE) {
			return 3;
		} else if (this == Value.FOUR) {
			return 4;
		} else if (this == Value.FIVE) {
			return 5;
		} else if (this == Value.SIX) {
			return 6;
		} else if (this == Value.SEVEN) {
			return 7;
		} else if (this == Value.EIGHT) {
			return 8;
		} else if (this == Value.NINE) {
			return 9;
		} else if (this == Value.TEN || this == Value.JACK || this == Value.QUEEN || this == Value.KING) {
			return 0;
		} else {
			return -1; 
		}

	}

}
