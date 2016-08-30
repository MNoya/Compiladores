package tests;

import ast.State;
import ast.Stmt;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import parser.Parser;

public class Prueba {

    String test;
    HashMap<String, Object> state;

    public Prueba(String test, Object[][] state) {
        this.test = test;

        this.state = new HashMap();
        for (Object[] obj : state) {
            this.state.put((String) obj[0], obj[1]);
        }
    }

    public static HashMap<Stmt, State> getTests() {

        final HashMap<Stmt, State> tests = new HashMap();

        for (Prueba test : Prueba.testStrings()) {
            try {
                Stmt stmt = (Stmt) (Parser.parse(test.test).value);
                tests.put(stmt, new State(test.state));
            } catch (Exception ex) {
                Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return tests;
    }

    private static Prueba[] testStrings() {

        return new Prueba[]{
            new Prueba("prueba1", new Object[][]{
                new Object[]{"x", 3},
                new Object[]{"y", 1.0},
                new Object[]{"z", false}
            }), 
        };
    }
}
