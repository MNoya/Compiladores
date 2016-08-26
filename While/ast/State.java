package ast;

import java.util.HashMap;

public class State {

    HashMap<String, Object> map;

    public State() {
        map = new HashMap<String, Object>();
    }

    public Object get(String id) {
        return map.get(id);
    }

    public void set(String id, Object value) {
        this.map.put(id, value);
    }

}
