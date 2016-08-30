package tests;

import ast.Stmt;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import parser.Parser;

public class Tests {

    public static HashMap<Stmt, String> getTests() {

        final HashMap<Stmt, String> tests = new HashMap();

        for (String[] array : Tests.testStrings()) {
            try {
                Stmt stmt = (Stmt) (Parser.parse(array[0]).value);
                tests.put(stmt, array[1]);
            } catch (Exception ex) {
                Logger.getLogger(Tests.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return tests;
    }

    private static String[][] testStrings() {
        return new String[][]{
            {"prueba1", "resultado1"},
            {"prueba2", "resultado2"},
            {"prueba3", "resultado3"},};
    }
}
