package ast;

import java.util.Random;

/** Representación de las negaciones de expresiones booleanas.
*/
public class Negation extends Exp {
	public final Exp condition;

	public Negation(Exp condition) {
		this.condition = condition;
	}

	@Override public String unparse() {
		return "(!"+ condition.unparse() +")";
	}

	@Override public String toString() {
		return "Negation("+ condition +")";
	}

	@Override public int hashCode() {
		int result = 1;
		result = result * 31 + (this.condition == null ? 0 : this.condition.hashCode());
		return result;
	}

	@Override public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		Negation other = (Negation)obj;
		return (this.condition == null ? other.condition == null : this.condition.equals(other.condition));
	}

	public static Negation generate(Random random, int min, int max) {
		Exp condition; 
		condition = Exp.generate(random, min-1, max-1);
		return new Negation(condition);
	}
	
	public Object evaluate(State state) throws Exception
	{
		Object cond = condition.evaluate(state);
		
		if (cond instanceof Boolean){
			return !(Boolean) cond;
		}
		else
		{
			throw new Exception("Tipo no booleano "+cond.getClass().getName());
		}
	}

	@Override
	public Tipo check(CheckState s) throws Exception {
		Tipo leftTipo = condition.check(s);
		
		
		if (leftTipo == Tipo.TRUTHVALUE){
			return Tipo.TRUTHVALUE;
		} else {
			throw new Exception("Type mismatch: " + leftTipo);
		}
	}
}
