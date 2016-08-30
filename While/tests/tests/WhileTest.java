package tests;

import ast.State;
import ast.Stmt;
import java.util.HashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author juansorondo
 */
public class WhileTest {

//    public WhileTest() {
//    }
    
    @Test
    public void test() throws Exception {

        State state = new State();
        HashMap<Stmt, String> tests = Tests.getTests();
        for (Stmt stmt : tests.keySet()) {
            Assert.assertEquals(stmt.evaluate(state),tests.get(stmt));
        }
    }
}
