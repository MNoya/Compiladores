package ast;

public enum Tipo {
	LITERAL, INTEGER, NUMERAL, TRUTHVALUE;
	
	@Override
	public String toString() {
		switch (this) {
		case LITERAL:
			return "str";
		case INTEGER:
			return "int";
		case NUMERAL:
			return "num";
		case TRUTHVALUE:
			return "bool";
		default:
			return "void";
		}
	}
}