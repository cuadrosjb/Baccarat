package sprink.casino.com;

/**
 * @author Jeffrey B Cuadros
 *
 */
public class Card {

	private Value value;
	private Symbol symbol;
	private int trueValue;

	public Card(Value value, Symbol symbol, int trueValue) {
		super();
		this.value = value;
		this.symbol = symbol;
		this.trueValue = trueValue;
	}
	
	public Value getValue() {
		return value;
	}
	public void setValue(Value value) {
		this.value = value;
	}
	public Symbol getSymbol() {
		return symbol;
	}
	public void setSymbol(Symbol symbol) {
		this.symbol = symbol;
	}
	public int getTrueValue() {
		return trueValue;
	}
	public void setTrueValue(int trueValue) {
		this.trueValue = trueValue;
	}

	@Override
	public String toString() {
		return "Card [value=" + value + ", symbol=" + symbol + ", trueValue=" + trueValue + "]";
	}
	
	
}
