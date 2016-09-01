package ast;

public class Print extends Stmt{
	public final Exp expression;

    public Print(Exp exp) {
        this.expression = exp;
    }

	@Override
	public String unparse() {
		return expression.toString();
	}

	@Override
	public String toString() {
		return "print("+expression.toString()+")";
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
	public State evaluate(State state) throws Exception {
		System.out.println(expression.evaluate(state).toString());
		return state;
	}
}
