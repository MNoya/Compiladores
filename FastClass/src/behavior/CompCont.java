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
    public static String compile(Programa prog) {
        
        String output = "";
        
        if(prog.output.csharp){
            CompCont ctx = new CompCont(prog);
            prog.compileCsharp(ctx);
            output += ctx.code.toString()+"\n\n";
        }
        
        if(prog.output.java){
            CompCont ctx = new CompCont(prog);
            prog.compileJava(ctx);
            output += ctx.code.toString()+"\n\n";
        }
        
        if(prog.output.php){
            CompCont ctx = new CompCont(prog);
            prog.compilePhp(ctx);
            output += ctx.code.toString()+"\n\n";
        }
        
        return output;
    }
}
