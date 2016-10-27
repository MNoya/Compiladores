package ast;

import behavior.CompCont;
import java.util.List;

public class Programa {

    public Output output;
    public List<Clase> clases;

    public Programa(Output output, List<Clase> clases) {
        this.output = output;
        this.clases = clases;
    }

    public String compile() {
        String salida = "";

        if (output.csharp) {
            CompCont ctx = new CompCont(this);
            for (Clase clase : clases) {
                clase.compileCsharp(ctx);
            }
            salida += ctx.code.toString() + "\n\n";
        }

        if (output.java) {
            CompCont ctx = new CompCont(this);
            for (Clase clase : clases) {
                clase.compileJava(ctx);
            }
            salida += ctx.code.toString() + "\n\n";
        }

        if (output.php) {
            CompCont ctx = new CompCont(this);
            for (Clase clase : clases) {
                clase.compilePhp(ctx);
            }
            salida += ctx.code.toString() + "\n\n";
        }

        return salida;
    }
}
