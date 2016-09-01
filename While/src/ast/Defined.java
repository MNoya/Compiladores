package ast;

public class Defined extends Exp{
	public final String id;

    public Defined(String id) {
        this.id = id;
    }

	@Override
	public String unparse() {
		return id.toString();
	}

	@Override
	public String toString() {
		return "defined("+id.toString()+")";
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
		return (state.get(id) != null);
	}
}
