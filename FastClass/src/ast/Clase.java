package ast;

import behavior.CompCont;
import java.util.List;

public class Clase implements Nodo {

    String nombre;
    List<Parametro> parametros;
    String padre;
    List<String> interfaces;
    String fuente;
    List<Clase> subclases;

    String listaParametros;
    String paramsConstructor;
    String initConstructor;
    String gettersSetters;

    public Clase(String nombre, List<Parametro> parametros, String padre, List<String> interfaces, String fuente, List<Clase> subclases) {
        this.nombre = nombre;
        this.parametros = parametros;
        this.padre = padre;
        this.interfaces = interfaces;
        this.fuente = fuente;
        this.subclases = subclases;
    }

    @Override
    public CompCont compileCsharp(CompCont ctx) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CompCont compileJava(CompCont ctx) {

        ctx.code.append("public class " + nombre);

        if (padre != null) {
            ctx.code.append(" extends " + padre);
        }

        if (interfaces != null && interfaces.size() > 0) {
            ctx.code.append(" implements " + String.join(", ", interfaces));
        }

        ctx.code.append(" { \n\n");

        listaParametros = "";
        paramsConstructor = "\n\npublic " + nombre + "(";
        initConstructor = ") {\n";
        gettersSetters = "}\n\n";

        if (parametros != null) {
            for (Parametro p : parametros) {
                p.registrarClase(this);
                p.compileJava(ctx);
            }
        }
        paramsConstructor = paramsConstructor.substring(0, paramsConstructor.length() - 1);
        ctx.code.append(listaParametros + paramsConstructor + initConstructor + gettersSetters + "}");

        if (subclases != null) {
            for (Clase sub : subclases) {
                sub.compileJava(ctx);
            }
        }

        return ctx;
    }

    @Override
    public CompCont compilePhp(CompCont ctx) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
