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

        
        
        HashMap<Stmt,State> tests = Prueba.getTests();
        for (Stmt stmt : tests.keySet()) {
        	
            State state = new State();
            
        	State evaluado = stmt.evaluate(state);
        	State esperado = tests.get(stmt);
        	
        	System.out.println("Codigo: "+stmt.unparse());
			System.out.println("Evaluado: "+ evaluado);
			System.out.println("Esperado: "+ esperado);
            Assert.assertEquals(evaluado, esperado);
        }
    }
}
