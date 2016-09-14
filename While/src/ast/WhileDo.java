package ast;

import java.util.Random;

/** Representación de las iteraciones while-do.
*/
public class WhileDo extends Stmt {
	public final Exp condition;
	public final Stmt body;

	public WhileDo(Exp condition, Stmt body) {
		this.condition = condition;
		this.body = body;
	}

	@Override public String unparse() {
		return "while "+ condition.unparse() +" do { "+ body.unparse() +" }";
	}

	@Override public String toString() {
		return "WhileDo("+ condition +", "+ body +")";
	}

	@Override public int hashCode() {
		int result = 1;
		result = result * 31 + (this.condition == null ? 0 : this.condition.hashCode());
		result = result * 31 + (this.body == null ? 0 : this.body.hashCode());
		return result;
	}

	@Override public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		WhileDo other = (WhileDo)obj;
		return (this.condition == null ? other.condition == null : this.condition.equals(other.condition))
			&& (this.body == null ? other.body == null : this.body.equals(other.body));
	}

	public static WhileDo generate(Random random, int min, int max) {
		Exp condition; Stmt body; 
		condition = Exp.generate(random, min-1, max-1);
		body = Stmt.generate(random, min-1, max-1);
		return new WhileDo(condition, body);
	}

	@Override
	public State evaluate(State state) throws Exception {
		Object cond = condition.evaluate(state);
		if (!(cond instanceof Boolean))
			throw new Exception("Tipos no booleano: "+cond.getClass().getName());
		else
		{
	        while ((Boolean)condition.evaluate(state)){
	        	state = body.evaluate(state);
	        }
	        return state;
		}
	}

	@Override
	public CheckState check(CheckState cState) throws Exception {
	    Tipo tipo = condition.check(cState);
        if (tipo != Tipo.TRUTHVALUE) {
        	throw new Exception("Error de Tipos: Condicion de WhileDo no booleana");
        }
        
        CheckState estado = cState;
    	CheckState whileBody = body.check(cState.clone());
    	
    	for (String id : estado.map.keySet()) {
    		if (whileBody.map.containsKey(id)) {
    			if (estado.map.get(id).tipo == whileBody.map.get(id).tipo) {
    				whileBody.map.get(id).tipo = estado.map.get(id).tipo;
    			} else {
    				whileBody.map.remove(id);
	            }	
            }
    	}
		return whileBody;
        
	}
}
