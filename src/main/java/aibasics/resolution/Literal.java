package aibasics.resolution;

public class Literal {
	public final String symbol;
	public final boolean negative;
	
	public Literal(String symbol, boolean negative)
	{
		this.symbol = symbol;
		this.negative = negative;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Literal)
		{
			Literal other = (Literal) obj;
			return other.symbol.equals(symbol) && other.negative == negative;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return symbol.hashCode() + Boolean.valueOf(negative).hashCode();
	}
	
	@Override
	public String toString() {
		return (negative?"not ":"") + symbol;
	}
}
