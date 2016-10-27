package behavior;

import ast.Programa;
import java.util.*;

public class CompCont {

    public final List<String> variables = new ArrayList();
    public final StringBuilder code = new StringBuilder();

    public CompCont(Programa prog) {
        this(new HashSet<String>());
    }

    public CompCont(Collection<String> variables) {
        this.variables.addAll(variables);
    }
    
    /**
     * Este método se utiliza para generar el código y obtener como un String
     * @param prog Programa a compilar
     * @return Código generado
     */
//    public static String compile(Programa prog) {
//        
//        
//    }
}
