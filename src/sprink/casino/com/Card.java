package sprink.casino.com;

/**
 * @author Jeffrey B Cuadros
 *
 */
public class Card {

	private Value value;
	private Symbol symbol;
	private int numbericalValue;

	public Card(Value value, Symbol symbol, int numbericalValue) {
		super();
		this.value = value;
		this.symbol = symbol;
		this.numbericalValue = numbericalValue;
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
	public int getNumbericalValue() {
		return numbericalValue;
	}
	public void setNumbericalValue(int numbericalValue) {
		this.numbericalValue = numbericalValue;
	}

	@Override
	public String toString() {
		return "Card [value=" + value + ", symbol=" + symbol + ", numbericalValue=" + numbericalValue + "]";
	}
	
	
}
