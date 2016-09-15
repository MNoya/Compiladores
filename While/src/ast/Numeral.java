package ast;

import java.util.Random;

/** Representación de floats y enteros **/
public class Numeral extends Exp {
	public final Object number;

	public Numeral(Double number) {
		this.number = number;
	}
	
	public Numeral(Integer number) {
		this.number = number;
	}

	@Override public String unparse() {
		return number.toString();
	}

	@Override public String toString() {
		return "Numeral("+ number +")";
	}

	@Override public int hashCode() {
		int result = 1;
		result = result * 31 + (this.number == null ? 0 : this.number.hashCode());
		return result;
	}

	@Override public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		Numeral other = (Numeral)obj;
		return (this.number == null ? other.number == null : this.number.equals(other.number));
	}

	public static Numeral generate(Random random, int min, int max) {
		Double number; 
		number = Math.round(random.nextDouble() * 1000) / 100.0;
		return new Numeral(number);
	}
	
	public Object evaluate(State state) throws Exception {
        return number;
	}

	@Override
	public Tipo check(CheckState s) throws Exception {
		if (number instanceof Integer){
			return Tipo.INTEGER;
		} else {
			return Tipo.NUMERAL;
		}
	}
}
