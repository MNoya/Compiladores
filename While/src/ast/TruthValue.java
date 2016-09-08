package ast;

import java.util.*;

import ast.CheckState.Tipo;

/** Representación de valores de verdad (cierto o falso).
*/
public class TruthValue extends Exp {
	public final Boolean value;

	public TruthValue(Boolean value) {
		this.value = value;
	}

	@Override public String unparse() {
		return value ? "true" : "false";
	}

	@Override public String toString() {
		return "TruthValue("+ value +")";
	}

	@Override public int hashCode() {
		int result = 1;
		result = result * 31 + (this.value == null ? 0 : this.value.hashCode());
		return result;
	}

	@Override public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		TruthValue other = (TruthValue)obj;
		return (this.value == null ? other.value == null : this.value.equals(other.value));
	}

	public static TruthValue generate(Random random, int min, int max) {
		Boolean value; 
		value = random.nextBoolean();
		return new TruthValue(value);
	}
	
	public Object evaluate(State state) throws Exception
	{
		return value;
	}

	@Override
	public Tipo check(CheckState s) throws Exception {
		
		return Tipo.TRUTHVALUE;
	}
}
