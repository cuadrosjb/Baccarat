package sprink.casino.com;

public class Cut extends Card{


	public Cut() {
		this(Value.CUT, Symbol.UNKNOWN, Value.CUT.getValue());
	}
	
	public Cut(Value value, Symbol symbol, int trueValue) {
		super(value, symbol, trueValue);
	}

}
