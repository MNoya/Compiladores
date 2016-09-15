package ast;

import java.util.Random;

import ast.State.Pair;

/**
 * Representación de las asignaciones de valores a variables.
 */
public class Assignment extends Stmt {

	public final String id;
	public final Exp expression;

	public Assignment(String id, Exp expression) {
		this.id = id;
		this.expression = expression;
	}

	@Override
	public String unparse() {
		return id + " = " + expression.unparse() + "; ";
	}

	@Override
	public String toString() {
		return "Assignment(" + id + ", " + expression + ")";
	}

	@Override
	public int hashCode() {
		int result = 1;
		result = result * 31 + (this.id == null ? 0 : this.id.hashCode());
		result = result * 31 + (this.expression == null ? 0 : this.expression.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Assignment other = (Assignment) obj;
		return (this.id == null ? other.id == null : this.id.equals(other.id))
				&& (this.expression == null ? other.expression == null : this.expression.equals(other.expression));
	}

	public static Assignment generate(Random random, int min, int max) {
		String id;
		Exp expression;
		id = "" + "abcdefghijklmnopqrstuvwxyz".charAt(random.nextInt(26));
		expression = Exp.generate(random, min - 1, max - 1);
		return new Assignment(id, expression);
	}

	@Override
	public State evaluate(State state) throws Exception {

		Object value = expression.evaluate(state);
		if (!state.map.containsKey(id)) {
			throw new Exception("Variable " + id + " no declarada.");
		}
		
		Pair par = state.map.get(id);
		Tipo tipo = par.tipo;
		
		if ((value instanceof String && tipo == Tipo.LITERAL) || (value instanceof Integer && tipo == Tipo.INTEGER)
				|| (value instanceof Double && tipo == Tipo.NUMERAL)
				|| (value instanceof Boolean && tipo == Tipo.TRUTHVALUE)) {
			par.valor = value;
		} else {
			throw new Exception("Type mismatch: esperado " + tipo + " recibido " + value.getClass().getSimpleName());
		}
		
		return state;
	}

	@Override
	public CheckState check(CheckState cState) throws Exception {
		
		if (!cState.map.containsKey(id)) {
			throw new Exception("Variable " + id + " no declarada");
		}

		ast.CheckState.Pair par = cState.map.get(id);
		Tipo tipo = par.tipo;
		
		Object value = expression.check(cState);
		if ((value instanceof String && tipo == Tipo.LITERAL) || (value instanceof Integer && tipo == Tipo.INTEGER)
				|| (value instanceof Double && tipo == Tipo.NUMERAL)
				|| (value instanceof Boolean && tipo == Tipo.TRUTHVALUE)) {
			par.inicializado = true;
		} else {
			throw new Exception("Type mismatch: esperado " + tipo + " recibido " + value.getClass().getSimpleName());
		}
		
		return cState;
	}

}
