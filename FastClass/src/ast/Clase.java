package ast;

import behavior.CompCont;
import java.util.ArrayList;
import java.util.List;

public class Clase implements Nodo {
    
    String nombre;
    List<Parametro> parametros;
    String padre;
    List<String> interfaces;
    String fuente;
    List<Clase> subclases;
    Boolean interna;
    
    String listaParametros;
    String paramsConstructor;
    String initConstructor;
    String gettersSetters;
    
    public Clase(String nombre, List<Parametro> parametros, String padre, List<String> interfaces, String fuente, List<Clase> subclases, Boolean interna) {
        this.nombre = nombre;
        this.parametros = parametros;
        this.padre = padre;
        this.interfaces = interfaces;
        this.fuente = fuente;
        this.subclases = subclases;
        this.interna = interna;
    }
    
    @Override
    public CompCont compileCsharp(CompCont ctx) {
        
        this.indentar(ctx);
        ctx.code.append("public class " + nombre);
        
        if (padre != null || interfaces != null) {
            ctx.code.append(" : ");
        }
        
        if (interfaces != null && interfaces.size() > 0) {
            List<String> padres = new ArrayList(interfaces);
            if (padre != null) {
                padres.add(0, padre);
            }
            ctx.code.append(String.join(", ", padres));
        } else if (padre != null) {
            ctx.code.append(padre);
        }
        
        ctx.code.append(" { \n\n");
        
        listaParametros = "";
        paramsConstructor = "";
        initConstructor = ") {\n";
        gettersSetters = "\t}\n\n";
        
        if (parametros != null) {
            for (Parametro p : parametros) {
                p.registrarClase(this);
                p.compileCsharp(ctx);
            }
        }
        if (paramsConstructor.length() > 0) {
            paramsConstructor = paramsConstructor.substring(0, paramsConstructor.length() - 2);
        }
        ctx.code.append(listaParametros + "\n\t");
        this.indentar(ctx);
        ctx.code.append("public " + nombre + "(" + paramsConstructor + initConstructor);
        this.indentar(ctx);
        ctx.code.append(gettersSetters);
        
        if (fuente != null && fuente.length() > 0) {
            this.indentar(ctx);
            ctx.code.append("\t//Codigo fuente original\n");
            ctx.code.append(fuente);
        }
        
        if (subclases != null) {
            for (Clase sub : subclases) {
                sub.compileCsharp(ctx);
            }
        }
        
        ctx.code.append("\n");
        this.indentar(ctx);
        ctx.code.append("}\n\n");
        
        return ctx;
    }
    
    @Override
    public CompCont compileJava(CompCont ctx) {
        
        this.indentar(ctx);
        ctx.code.append("public class " + nombre);
        
        if (padre != null) {
            ctx.code.append(" extends " + padre);
        }
        
        if (interfaces != null && interfaces.size() > 0) {
            ctx.code.append(" implements " + String.join(", ", interfaces));
        }
        
        ctx.code.append(" { \n\n");
        
        listaParametros = "";
        paramsConstructor = "";
        initConstructor = ") {\n";
        gettersSetters = "\t}\n\n";
        
        if (parametros != null) {
            for (Parametro p : parametros) {
                p.registrarClase(this);
                p.compileJava(ctx);
            }
        }
        if (paramsConstructor.length() > 0) {
            paramsConstructor = paramsConstructor.substring(0, paramsConstructor.length() - 2);
        }
        ctx.code.append(listaParametros + "\n\t");
        this.indentar(ctx);
        ctx.code.append("public " + nombre + "(" + paramsConstructor + initConstructor);
        this.indentar(ctx);
        ctx.code.append(gettersSetters);
        
        if (fuente != null && fuente.length() > 0) {
            this.indentar(ctx);
            ctx.code.append("\t//Codigo fuente original\n");
            ctx.code.append(fuente);
        }
        
        if (subclases != null) {
            for (Clase sub : subclases) {
                sub.compileJava(ctx);
            }
        }
        
        ctx.code.append("\n");
        this.indentar(ctx);
        ctx.code.append("}\n\n");
        
        return ctx;
    }
    
    @Override
    public CompCont compilePhp(CompCont ctx) {
        
        if (this.interna != null && !this.interna) {
            ctx.code.append("<?php \n\n");
        }
        
        this.indentar(ctx);
        ctx.code.append("class " + nombre);
        
        if (padre != null) {
            ctx.code.append(" extends " + padre);
        }
        
        if (interfaces != null && interfaces.size() > 0) {
            ctx.code.append(" implements " + String.join(", ", interfaces));
        }
        
        ctx.code.append(" { \n\n");
        
        listaParametros = "";
        paramsConstructor = "";
        initConstructor = ") {\n";
        gettersSetters = "\t}\n\n";
        
        if (parametros != null) {
            for (Parametro p : parametros) {
                p.registrarClase(this);
                p.compilePhp(ctx);
            }
        }
        if (paramsConstructor.length() > 0) {
            paramsConstructor = paramsConstructor.substring(0, paramsConstructor.length() - 2);
        }
        
        ctx.code.append(listaParametros + "\n\t");
        this.indentar(ctx);
        ctx.code.append("public __construct(" + paramsConstructor + initConstructor);
        this.indentar(ctx);
        ctx.code.append(gettersSetters);
        
        if (fuente != null && fuente.length() > 0) {
            this.indentar(ctx);
            ctx.code.append("\t//Codigo fuente original\n");
            ctx.code.append(fuente);
        }
        
        if (subclases != null) {
            for (Clase sub : subclases) {
                sub.compilePhp(ctx);
            }
        }
        
        ctx.code.append("\n");
        this.indentar(ctx);
        ctx.code.append("}\n\n");
        
        return ctx;
    }
    
    public void indentar(CompCont ctx) {
        if (this.interna != null && this.interna) {
            ctx.code.append("\t");
        }
    }
}
