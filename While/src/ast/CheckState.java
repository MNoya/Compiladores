package ast;

import java.util.HashMap;

public class CheckState {

	HashMap<String, Pair> map;	

	public CheckState() {
		map = new HashMap<String, Pair>();
	}

	public CheckState(HashMap<String, Pair> map) {
		this.map = map;
	}

	public Pair get(String id) {
		return map.get(id);
	}

	public void set(String id, Tipo clase, boolean inicializado) {
		this.map.put(id, new Pair(clase, inicializado));
	}
 
	@Override
	public String toString() {
		String s = "";
		for (String key : map.keySet()) {
			Pair par = map.get(key);
			s += key + "(" + par.tipo.toString() + " init:" + par.inicializado + " | ";
		}
		return s;
	}

	@Override
	public boolean equals(Object obj) {
		CheckState state = (CheckState) obj;
		HashMap<String, Pair> map2 = state.map;

		if (map.keySet().size() != map2.keySet().size()) {
			return false;
		}

		for (String id : map.keySet()) {
			if (!map2.containsKey(id) || !map.get(id).equals(map2.get(id))) {
				return false;
			}
		}
		return true;
	}

	public class Pair {

		public Tipo tipo;
		public boolean inicializado;

		public Pair(Tipo tipo, boolean inicializado) {
			this.tipo = tipo;
			this.inicializado = inicializado;
		}

		@Override
		public boolean equals(Object obj) {
			Pair pair = (Pair) obj;
			return this.tipo == pair.tipo && this.inicializado == pair.inicializado;
		}
	}

	public enum Tipo {
		LITERAL, NUMERAL, TRUTHVALUE;
	}
}
