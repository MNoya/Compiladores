package ast;

import extras.Archivo;
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
            for (Clase clase : clases) {
                CompCont ctx = new CompCont(this);
                clase.compileCsharp(ctx);
                Archivo.guardar("csharp/" + clase.nombre + ".cs", ctx.code.toString());
            }
        }
        if (output.java) {
            for (Clase clase : clases) {
                CompCont ctx = new CompCont(this);
                clase.compileJava(ctx);
                Archivo.guardar("java/" + clase.nombre + ".java", ctx.code.toString());
            }
        }
        if (output.php) {
            for (Clase clase : clases) {
                CompCont ctx = new CompCont(this);
                clase.compilePhp(ctx);
                Archivo.guardar("php/" + clase.nombre + ".php", ctx.code.toString());
            }
        }
        return salida;
    }
}
