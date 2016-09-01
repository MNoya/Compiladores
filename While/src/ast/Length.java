package ast;

public class Length extends Exp{
	public final Exp expression;

    public Length(Exp exp) {
        this.expression = exp;
    }

	@Override
	public String unparse() {
		return expression.toString();
	}

	@Override
	public String toString() {
		return "length("+expression.toString()+")";
	}

	@Override
	public int hashCode() {
		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		return false;
	}

	@Override
	public Object evaluate(State state) throws Exception {
		return (double) expression.evaluate(state).toString().length();
	}
}
