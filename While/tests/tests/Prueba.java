package tests;

import ast.Sequence;
import ast.State;
import ast.Stmt;

import java.util.ArrayList;
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
//            	String[] testsString = test.test.split("\\n");
//            	ArrayList<Stmt> stmts = new ArrayList();
//            	
//            	for(String t:testsString){
//                 Stmt stmt = (Stmt) (Parser.parse(t).value);
                 Stmt stmt = (Stmt) (Parser.parse(test.test).value);
//                 stmts.add(stmt);
//            	}
//            	
//            	Stmt[] stmtArray = new Stmt[0];
//            	stmts.toArray(stmtArray);
//            	
//                tests.put(new Sequence(stmtArray), new State(test.state));
                tests.put(stmt, new State(test.state));
                
            } catch (Exception ex) {
            	System.out.println("FALLO AL COMPILAR: "+test.test);
                Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return tests;
    }

    private static Prueba[] testStrings() {

        return new Prueba[]{
            
            //Addition
            new Prueba("x=1+2;", new Object[][]{
                new Object[]{"x", 3.0},
            }), 
            
            //Assignment
            new Prueba("x=true;", new Object[][]{
                new Object[]{"x", true},
            }), 
            
            //AssignmentExp
            new Prueba("y=1+(x=2);", new Object[][]{
                new Object[]{"x", 2.0},
                new Object[]{"y", 3.0},
            }), 
            
            //CompareEqual
            new Prueba("x=(1==1);", new Object[][]{
                new Object[]{"x", true}
            }), 
            
            //CompareLessOrEqual
            new Prueba("x=(3<=0);", new Object[][]{
                new Object[]{"x", false},
            }), 
            
            //Conjunction
            new Prueba("x=(true && true);", new Object[][]{
                new Object[]{"x", true}
            }), 
            
            //Division
            new Prueba("x=(10/5);", new Object[][]{
                new Object[]{"x", 2.0}
            }), 
            
            //IfThenElse
            new Prueba("if (1==0) then x=1; else x=2;", new Object[][]{
                new Object[]{"x", 2.0}
            }), 
            
            //Literal
            new Prueba("x=\"probando\";", new Object[][]{
                new Object[]{"x", "probando"}
            }), 
            
            //Multiplicacion
            new Prueba("x=(10*5);", new Object[][]{
                new Object[]{"x", 50.0}
            }), 
            
            //Negation
            new Prueba("x=!true;", new Object[][]{
                new Object[]{"x", false}
            }), 
            
            //Numeral
            new Prueba("x=50;", new Object[][]{
                new Object[]{"x", 50.0}
            }), 
            
            //Sequence
            new Prueba("x=50;", new Object[][]{
                new Object[]{"x", 50.0}
            }), 
            
            //Subtraction
            new Prueba("x=(50-40);", new Object[][]{
                new Object[]{"x", 10.0}
            }),
            
            //TruthValue
            new Prueba("x=false;", new Object[][]{
                new Object[]{"x", false}
            }),
            
            //Length
            new Prueba("x=length(\"prueba\");", new Object[][]{
                new Object[]{"x", 6.0}
            }),
            
            //Defined
            new Prueba("x=defined(pepe);", new Object[][]{
                new Object[]{"x", false}
            })
          
        };
    }
}
