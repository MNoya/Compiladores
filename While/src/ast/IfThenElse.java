package ast;

import java.util.*;

import ast.CheckState.Tipo;

/**
 * Representación de las sentencias condicionales.
 */
public class IfThenElse extends Stmt {

    public final Exp condition;
    public final Stmt thenBody;
    public final Stmt elseBody;

    public IfThenElse(Exp condition, Stmt thenBody, Stmt elseBody) {
        this.condition = condition;
        this.thenBody = thenBody;
        this.elseBody = elseBody;
    }

    @Override
    public String unparse() {
        return "if " + condition.unparse() + " then { " + thenBody.unparse() + " } else { " + elseBody.unparse() + " }";
    }

    @Override
    public String toString() {
        return "IfThenElse(" + condition + ", " + thenBody + ", " + elseBody + ")";
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = result * 31 + (this.condition == null ? 0 : this.condition.hashCode());
        result = result * 31 + (this.thenBody == null ? 0 : this.thenBody.hashCode());
        result = result * 31 + (this.elseBody == null ? 0 : this.elseBody.hashCode());
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
        IfThenElse other = (IfThenElse) obj;
        return (this.condition == null ? other.condition == null : this.condition.equals(other.condition))
                && (this.thenBody == null ? other.thenBody == null : this.thenBody.equals(other.thenBody))
                && (this.elseBody == null ? other.elseBody == null : this.elseBody.equals(other.elseBody));
    }

    public static IfThenElse generate(Random random, int min, int max) {
        Exp condition;
        Stmt thenBody;
        Stmt elseBody;
        condition = Exp.generate(random, min - 1, max - 1);
        thenBody = Stmt.generate(random, min - 1, max - 1);
        elseBody = Stmt.generate(random, min - 1, max - 1);
        return new IfThenElse(condition, thenBody, elseBody);
    }
    
    @Override
    public State evaluate(State state) throws Exception{
        Object value = condition.evaluate(state);
        if (value instanceof Boolean){
            if ((Boolean)value){
            	if (thenBody != null)
            		return thenBody.evaluate(state);
            	else
            		return null;
            } else {
            	if (elseBody != null)
            		return elseBody.evaluate(state);
            	else
            		return null;
            }
        }
        else
        {
        	throw new Exception("Condicion de IfThenElse no evalua a un valor booleano");
        }
    }
    
    @Override
    public CheckState check(CheckState cState) throws Exception{
        Tipo tipo = condition.check(cState);
        if (tipo != Tipo.TRUTHVALUE) {
        	throw new Exception("Error de Tipos: Condicion de IfThenElse no booleana");
        }

    	CheckState body = cState;
    	CheckState thenBodyState = thenBody.check(cState.clone());
    	if (elseBody != null) {
        	body = elseBody.check(cState);
    	}
    	
    	for (String id : body.map.keySet()) {
    		if (thenBodyState.map.containsKey(id)) {
    			if (body.map.get(id).tipo == thenBodyState.map.get(id).tipo) {
    				thenBodyState.set(id, tipo, true);
    			} else
    				thenBodyState.map.remove(id);
	            }	
            }
    	return thenBodyState;
    	}
}
