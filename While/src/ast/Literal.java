package ast;

import java.util.Random;

import ast.CheckState.Tipo;

public class Literal extends Exp{
	public final String literal;

	public Literal(String literal) {
		this.literal = literal;
	}

	@Override public String unparse() {
		return literal.toString();
	}

	@Override public String toString() {
		return "Literal("+ literal +")";
	}

	@Override public int hashCode() {
		int result = 1;
		result = result * 31 + (this.literal == null ? 0 : this.literal.hashCode());
		return result;
	}

	@Override public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		Literal other = (Literal)obj;
		return (this.literal == null ? other.literal == null : this.literal.equals(other.literal));
	}

	public static Literal generate(Random random, int min, int max) {
		String literal; 
		literal = Math.round(random.nextDouble()* 1000) / 100.0 +"";
		return new Literal(literal);
	}
	
	public Object evaluate(State state) throws Exception
	{
		return literal;
	}

	@Override
	public Tipo check(CheckState s) throws Exception {
		return Tipo.LITERAL;
	}
}
