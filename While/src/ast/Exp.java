package ast;

import java.util.Random;
import ast.CheckState;
import ast.CheckState.Tipo;

/** Categoría sintáctica de las expresiones aritméticas de While, las 
	construcciones del lenguaje que evalúan a un número.
*/
public abstract class Exp {

	abstract public String unparse();

	@Override public abstract String toString();

	@Override public abstract int hashCode();

	@Override public abstract boolean equals(Object obj);

	public static Exp generate(Random random, int min, int max) {
		final int TERMINAL_COUNT = 3;
		final int NONTERMINAL_COUNT = 8;		
		
		int i = min > 0 ? random.nextInt(NONTERMINAL_COUNT) + TERMINAL_COUNT
			: random.nextInt(max > 0 ? NONTERMINAL_COUNT + TERMINAL_COUNT: TERMINAL_COUNT);
		switch (i) {
		//Terminals
			case 0: return Numeral.generate(random, min-1, max-1);
			case 1: return Variable.generate(random, min-1, max-1);
			case 2: return TruthValue.generate(random, min-1, max-1);
			case 12:return Literal.generate(random, min-1, max-1);
		//Non terminals
			case 3: return Multiplication.generate(random, min-1, max-1);
			case 4: return Division.generate(random, min-1, max-1);
			case 5: return Addition.generate(random, min-1, max-1);
			case 6: return Subtraction.generate(random, min-1, max-1);
			case 7: return CompareEqual.generate(random, min-1, max-1);
			case 8: return CompareLessOrEqual.generate(random, min-1, max-1);
			case 9: return Negation.generate(random, min-1, max-1);
			case 10: return Conjunction.generate(random, min-1, max-1);
			case 11: return AssignmentExp.generate(random, min-1, max-1);
			default: throw new Error("Unexpected error at Exp.generate()!");
		}
	}

	public abstract Object evaluate(State state) throws Exception;
	
	public abstract Tipo check(CheckState s) throws Exception;
}
