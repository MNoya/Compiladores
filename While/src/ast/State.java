package ast;

import java.util.HashMap;

public class State {

    HashMap<String, Pair> map;

    public State() {
        map = new HashMap<String, Pair>();
    }

    public State(HashMap<String, Pair> map) {
        this.map = map;
    }

    public Pair get(String id) {
        return map.get(id);
    }

    public void set(String id, Tipo tipo, Object value) {
        this.map.put(id, new Pair(tipo, value));
    }

    @Override
    public String toString() {
        String s = "";
        for (String key : map.keySet()) {
            Object valor = map.get(key);
            s += key + "=" + valor.toString() + " | ";
        }
        return s;
    }

    @Override
    public boolean equals(Object obj) {
        State state = (State) obj;
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

    public class Pair{
    	
    	public Tipo tipo;
    	public Object valor;
    	
		public Pair(Tipo tipo, Object valor) {
			this.tipo = tipo;
			this.valor = valor;
		}

		@Override
		public boolean equals(Object obj) {
			Pair pair = (Pair) obj;
			return this.tipo == pair.tipo && this.valor.equals(pair.valor);
		}
    }
}
