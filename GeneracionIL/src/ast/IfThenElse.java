package ast;

import java.util.*;
import behaviour.*;
import java.io.*;

/** Representación de las sentencias condicionales.
*/
public class IfThenElse extends Stmt {
	public final BExp condition;
	public final Stmt thenBody;
	public final Stmt elseBody;

	public IfThenElse(BExp condition, Stmt thenBody, Stmt elseBody) {
		this.condition = condition;
		this.thenBody = thenBody;
		this.elseBody = elseBody;
	}

	@Override public String unparse() {
		return "if "+ condition.unparse() +" then { "+ thenBody.unparse() +" } else { "+ elseBody.unparse() +" }";
	}

	@Override public State evaluate(State state) {
		return condition.evaluate(state) ? thenBody.evaluate(state) : elseBody.evaluate(state);
	}

	@Override public Set<String> freeVariables(Set<String> vars) {
		vars = condition.freeVariables(vars); vars = thenBody.freeVariables(vars); return elseBody.freeVariables(vars);
	}

	@Override public int maxStackIL() {
		return Math.max(condition.maxStackIL(), Math.max(thenBody.maxStackIL(), elseBody.maxStackIL()));
	}

	@Override public CompilationContextIL compileIL(CompilationContextIL ctx) {
        
        String jump_s1 = ctx.newLabel();
        String jump_s2 = ctx.newLabel();
        
        condition.compileIL(ctx);
        ctx.codeIL.append("brfalse.s " + jump_s2 + " \n");
        thenBody.compileIL(ctx);
        ctx.codeIL.append("br.s " + jump_s1 + " \n");
        ctx.codeIL.append(jump_s2 + ": ");
        elseBody.compileIL(ctx);
        ctx.codeIL.append(jump_s1 + ": nop \n");
        
        return ctx;
	}

	@Override public String toString() {
		return "IfThenElse("+ condition +", "+ thenBody +", "+ elseBody +")";
	}

	@Override public int hashCode() {
		int result = 1;
		result = result * 31 + (this.condition == null ? 0 : this.condition.hashCode());
		result = result * 31 + (this.thenBody == null ? 0 : this.thenBody.hashCode());
		result = result * 31 + (this.elseBody == null ? 0 : this.elseBody.hashCode());
		return result;
	}

	@Override public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		IfThenElse other = (IfThenElse)obj;
		return (this.condition == null ? other.condition == null : this.condition.equals(other.condition))
			&& (this.thenBody == null ? other.thenBody == null : this.thenBody.equals(other.thenBody))
			&& (this.elseBody == null ? other.elseBody == null : this.elseBody.equals(other.elseBody));
	}

	public static IfThenElse generate(Random random, int min, int max) {
		BExp condition; Stmt thenBody; Stmt elseBody; 
		condition = BExp.generate(random, min-1, max-1);
		thenBody = Stmt.generate(random, min-1, max-1);
		elseBody = Stmt.generate(random, min-1, max-1);
		return new IfThenElse(condition, thenBody, elseBody);
	}

	@Override
	public Stmt optimize(State state) {
		BExp condition2 = condition.optimization(state);
		Stmt thenBody2 = thenBody.optimize(state);
		Stmt elseBody2 = elseBody.optimize(state);
		if (condition2 instanceof TruthValue){
			if (((TruthValue)condition2).value){
				return thenBody2;
			}
			else{
				return elseBody2;
			} 
		}
		return new IfThenElse(condition2, thenBody2, elseBody2);
	}
}
