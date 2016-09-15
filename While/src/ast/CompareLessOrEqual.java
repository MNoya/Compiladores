package ast;

import java.util.Random;

/**
 * Representación de las comparaciones por menor o igual.
 */
public class CompareLessOrEqual extends Exp {
	public final Exp left;
	public final Exp right;

	public CompareLessOrEqual(Exp left, Exp right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public String unparse() {
		return "(" + left.unparse() + " <= " + right.unparse() + ")";
	}

	@Override
	public String toString() {
		return "CompareLessOrEqual(" + left + ", " + right + ")";
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
		CompareLessOrEqual other = (CompareLessOrEqual) obj;
		return (this.left == null ? other.left == null : this.left.equals(other.left))
				&& (this.right == null ? other.right == null : this.right.equals(other.right));
	}

	public static CompareLessOrEqual generate(Random random, int min, int max) {
		Exp left;
		Exp right;
		left = Exp.generate(random, min - 1, max - 1);
		right = Exp.generate(random, min - 1, max - 1);
		return new CompareLessOrEqual(left, right);
	}

	public Object evaluate(State state) throws Exception {

		Object leftValue = left.evaluate(state);
		Object rightValue = right.evaluate(state);

		if (leftValue.getClass().equals(rightValue.getClass())) {
			switch (leftValue.getClass().getSimpleName()) {
			case "Boolean":

				if ((Boolean) leftValue) {
					return true;
				} else {
					return (Boolean) rightValue;
				}
			case "Double":
				return ((Double) leftValue) <= ((Double) rightValue);
			case "Integer":
				return ((Double) leftValue) <= ((Double) rightValue);
			case "String":
				return ((String) leftValue).compareTo((String) rightValue);
			default:
				throw new Exception("Tipos no comparables: " + leftValue.getClass().getName() + " "
						+ rightValue.getClass().getName());

			}
		}
		throw new Exception(
				"Tipos incompatibles: " + leftValue.getClass().getName() + " " + rightValue.getClass().getName());

	}

	@Override
	public Tipo check(CheckState s) throws Exception {
		Tipo leftTipo = left.check(s);
		Tipo rightTipo = right.check(s);
		
		if (leftTipo != null && leftTipo == rightTipo){
			return Tipo.TRUTHVALUE;
		} else {
			throw new Exception("Type mismatch: " + leftTipo + " vs. " + rightTipo);
		}
	}

}
