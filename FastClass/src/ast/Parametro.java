package ast;

import behavior.CompCont;

public class Parametro implements Nodo {

    String tipo;
    boolean r;
    boolean w;
    boolean c;
    String nombre;

    private Clase clase;

    public Parametro(String tipo, String rwc, String nombre) {
        this.tipo = tipo;
        this.nombre = nombre;
        
        if (rwc.indexOf("r") != -1) {
        	this.r = true;
        }
        if (rwc.indexOf("w") != -1) {
        	this.w = true;
        }
        if (rwc.indexOf("c") != -1) {
        	this.c = true;
        }
    }

    public void setR() {
        this.r = true;
    }

    public void setW() {
        this.w = true;
    }

    public void setC() {
        this.c = true;
    }

    public void registrarClase(Clase clase) {
        this.clase = clase;
    }

    @Override
    public CompCont compileCsharp(CompCont ctx) {
        return this.compileJava(ctx);
    }

    @Override
    public CompCont compileJava(CompCont ctx) {
        clase.indentar(ctx);
        clase.listaParametros += "\t" + tipo + " " + nombre + ";\n";
        String indent = clase.getIndent();
        
        if (c) {
            clase.paramsConstructor += tipo + " " + nombre + ", ";
            clase.initConstructor += indent + "\t\tthis." + nombre + " = " + nombre + ";\n";
        }

        String camel = (nombre.charAt(0) + "").toUpperCase() + nombre.substring(1);
        
        clase.gettersSetters += (r) ? indent + "\tpublic " + tipo + " get" + camel + "(){\n" + indent +  "\t\treturn this." + nombre + ";\n" + indent + "\t}\n" : "";
        clase.gettersSetters += (w) ? indent + "\tpublic void set" + camel + "(" + tipo + " " + nombre + "){\n" + indent +  "\t\tthis." + nombre + " = " + nombre + ";\n" + indent +  "\t}\n" : "";

        return ctx;
    }

    @Override
    public CompCont compilePhp(CompCont ctx) {
        clase.indentar(ctx);
        clase.listaParametros += "\tpublic $" + nombre + ";\n";
        String indent = clase.getIndent();
        
        if (c) {
            clase.paramsConstructor += "$" + nombre + ", ";
            clase.initConstructor += indent + "\t\t$this->" + nombre + " = $" + nombre + ";\n";
        }

        String camel = (nombre.charAt(0) + "").toUpperCase() + nombre.substring(1);
        
        clase.gettersSetters += (r) ? indent + "\tpublic function get" + camel + "(){\n" + indent + "\t\treturn $this->" + nombre + ";\n" + indent + "\t}\n" : "";
        clase.gettersSetters += (w) ? indent + "\tpublic function set" + camel + "($" + nombre + "){\n" + indent + "\t\t$this->" + nombre + " = $" + nombre + ";\n" + indent + "\t}\n" : "";

        return ctx;
    }
}
