package ast;

public class Declaration extends Stmt {

	Tipo tipo;
	String id;
	Exp exp;

	public Declaration(Tipo tipo, String id) {
		this.tipo = tipo;
		this.id = id;
	}

	public Declaration(Tipo tipo, String id, Exp exp) {
		this.tipo = tipo;
		this.id = id;
		this.exp = exp;
	}

	@Override
	public String unparse() {
		if (exp == null) {
			return tipo + " " + id;
		}
		return tipo + " " + id + " = " + exp.unparse();
	}

	@Override
	public String toString() {
		return "Declaration(" + tipo + ", " + id + ", " + exp + ")";
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Declaration other = (Declaration) obj;
		return this.tipo == other.tipo && this.id.equals(other.id)
				&& (this.exp == null ? other.exp == null : this.exp.equals(other.exp));
	}

	@Override
	public State evaluate(State state) throws Exception {
		if (exp != null) {
			Object value = exp.evaluate(state);
			if ((value instanceof String && tipo == Tipo.LITERAL) || (value instanceof Integer && tipo == Tipo.INTEGER)
					|| (value instanceof Double && tipo == Tipo.NUMERAL)
					|| (value instanceof Boolean && tipo == Tipo.TRUTHVALUE)) {
				state.set(id, tipo, value);
			} else {
				throw new Exception(
						"Type mismatch: esperado " + tipo + " recibido " + value.getClass().getSimpleName());
			}
		} else {
			state.set(id, tipo, null);
		}
		return state;
	}

	@Override
	public CheckState check(CheckState cState) throws Exception {
		if (cState.map.containsKey(id)) {
			throw new Exception("Variable " + id + " ya declarada");
		}

		if(exp == null){
			cState.set(id, tipo, false);
			return cState;
		} 
		
		Object value = exp.check(cState);
		if ((value instanceof String && tipo == Tipo.LITERAL) || (value instanceof Integer && tipo == Tipo.INTEGER)
				|| (value instanceof Double && tipo == Tipo.NUMERAL)
				|| (value instanceof Boolean && tipo == Tipo.TRUTHVALUE)) {
			cState.set(id,tipo,true);
		} else {
			throw new Exception("Type mismatch: esperado " + tipo + " recibido " + value.getClass().getSimpleName());
		}
		
		return cState;
	}

}
