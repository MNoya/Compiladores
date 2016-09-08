package ast;

import ast.CheckState.Tipo;

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

	@Override
	public Tipo check(CheckState s) throws Exception {
		Tipo tipoExp = expression.check(s);
		
		if(tipoExp == Tipo.LITERAL){
			return Tipo.LITERAL;
		} else{
			throw new Exception("Se le pasa algo a length() que no es un LITERAL.");
		}
	}
}
