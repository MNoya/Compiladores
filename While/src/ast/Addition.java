package ast;

import java.util.Random;

/**
 * Representación de sumas.
 */
public class Addition extends Exp {
	public final Exp left;
	public final Exp right;

	public Addition(Exp left, Exp right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public String unparse() {
		return "(" + left.unparse() + " + " + right.unparse() + ")";
	}

	@Override
	public String toString() {
		return "Addition(" + left + ", " + right + ")";
	}

	@Override
	public int hashCode() {
		int result = 1;
		result = result * 31 + (this.left == null ? 0 : this.left.hashCode());
		result = result * 31 + (this.right == null ? 0 : this.right.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Addition other = (Addition) obj;
		return (this.left == null ? other.left == null : this.left.equals(other.left))
				&& (this.right == null ? other.right == null : this.right.equals(other.right));
	}

	public static Addition generate(Random random, int min, int max) {
		Exp left;
		Exp right;
		left = Exp.generate(random, min - 1, max - 1);
		right = Exp.generate(random, min - 1, max - 1);
		return new Addition(left, right);
	}

	public Object evaluate(State state) throws Exception {
		Object leftValue = left.evaluate(state);
		Object rightValue = right.evaluate(state);

		if ((leftValue instanceof Double || leftValue instanceof Integer) && (rightValue instanceof Double || rightValue instanceof Integer)) {
			if (leftValue instanceof Integer && rightValue instanceof Integer){
				return (Integer) left.evaluate(state) + (Integer) right.evaluate(state);
			} else {
				return (Double) left.evaluate(state) + (Double) right.evaluate(state);
			}
		} else if (leftValue instanceof String || rightValue instanceof String) {
			return left.evaluate(state).toString() + right.evaluate(state).toString();
		} else {
			throw new Exception("Tipos incompatibles: " + leftValue.getClass().getName() + " "
					+ rightValue.getClass().getName() + "\n");
		}
	}

	@Override
	public Tipo check(CheckState s) throws Exception {
		Tipo leftTipo = left.check(s);
		Tipo rightTipo = right.check(s);

		if ((leftTipo == Tipo.NUMERAL || leftTipo == Tipo.INTEGER) && (rightTipo == Tipo.NUMERAL || rightTipo == Tipo.INTEGER)) {
			if (leftTipo == rightTipo){
				return leftTipo;
			} else {
				return Tipo.NUMERAL;
			}
		} else {
			throw new Exception("Type mismatch: " + leftTipo + " vs. " + rightTipo);
		}
	}
}
