package ast;

import java.util.*;
import behaviour.*;
import java.io.*;

/** Representación de conjunciones booleanas (AND).
*/
public class Conjunction extends BExp {
	public final BExp left;
	public final BExp right;

	public Conjunction(BExp left, BExp right) {
		this.left = left;
		this.right = right;
	}

	@Override public String unparse() {
		return "("+ left.unparse() +" and "+ right.unparse() +")";
	}

	@Override public Boolean evaluate(State state) {
		return left.evaluate(state) && right.evaluate(state);
	}

	@Override public Set<String> freeVariables(Set<String> vars) {
		return right.freeVariables(left.freeVariables(vars));
	}

	@Override public int maxStackIL() {
		return Math.max(left.maxStackIL(), right.maxStackIL() + 1);
	}

	@Override public CompilationContextIL compileIL(CompilationContextIL ctx) {
        left.compileIL(ctx);
        right.compileIL(ctx);
        ctx.codeIL.append("and \n");
        return ctx;
	}

	@Override public String toString() {
		return "Conjunction("+ left +", "+ right +")";
	}

	@Override public int hashCode() {
		int result = 1;
		result = result * 31 + (this.left == null ? 0 : this.left.hashCode());
		result = result * 31 + (this.right == null ? 0 : this.right.hashCode());
		return result;
	}

	@Override public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		Conjunction other = (Conjunction)obj;
		return (this.left == null ? other.left == null : this.left.equals(other.left))
			&& (this.right == null ? other.right == null : this.right.equals(other.right));
	}

	public static Conjunction generate(Random random, int min, int max) {
		BExp left; BExp right; 
		left = BExp.generate(random, min-1, max-1);
		right = BExp.generate(random, min-1, max-1);
		return new Conjunction(left, right);
	}

    @Override
    public BExp optimization(State state) {
        
        BExp left2 = left.optimization(state);
        BExp right2 = right.optimization(state);

        if (left2 instanceof TruthValue) {
            if (!((TruthValue) left2).value){
                return new TruthValue(false);
            }
            return right2;
        } else if (right2 instanceof TruthValue) {
            if (!((TruthValue) right2).value){
                return new TruthValue(false);
            }
            return left2;
        }
        
        return new Conjunction(left2, right2);
    }
    
}
