package ast;

import behavior.CompCont;

public class Parametro implements Nodo {

    String tipo;
    boolean r;
    boolean w;
    boolean c;
    String nombre;

    private Clase clase;

    public Parametro(String tipo, String nombre) {
        this.tipo = tipo;
        this.nombre = nombre;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CompCont compileJava(CompCont ctx) {
        clase.listaParametros += "\t" + tipo + " " + nombre + ";\n";

        if (c) {
            clase.paramsConstructor += tipo + " " + nombre + ", ";
            clase.initConstructor += "\t\tthis." + nombre + " = " + nombre + ";\n";
        }

        String camel = (nombre.charAt(0) + "").toUpperCase() + nombre.substring(1);
        
        clase.gettersSetters += (r) ? "\tpublic " + tipo + " get" + camel + "(){\n\t\treturn this." + nombre + ";\n\t}\n\n" : "";
        clase.gettersSetters += (w) ? "\tpublic void set" + camel + "(" + tipo + " " + nombre + "){\n\t\tthis." + nombre + " = " + nombre + ";\n\t}\n\n" : "";

        return ctx;
    }

    @Override
    public CompCont compilePhp(CompCont ctx) {
        clase.listaParametros += "\tpublic $" + nombre + ";\n";

        if (c) {
            clase.paramsConstructor += "$" + nombre + ", ";
            clase.initConstructor += "\t\t$this->" + nombre + " = $" + nombre + ";\n";
        }

        String camel = (nombre.charAt(0) + "").toUpperCase() + nombre.substring(1);
        
        clase.gettersSetters += (r) ? "\tpublic function get" + camel + "(){\n\t\treturn $this->" + nombre + ";\n\t}\n\n" : "";
        clase.gettersSetters += (w) ? "\tpublic function set" + camel + "($" + nombre + "){\n\t\t$this->" + nombre + " = $" + nombre + ";\n\t}\n\n" : "";

        return ctx;
    }
}
