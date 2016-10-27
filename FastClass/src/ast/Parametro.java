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
        //Agregar a lista de parametros
        clase.listaParametros += "    " + tipo + " " + nombre + ";\n";

        if (c) {
            //Agregar en paramsConstructor
            clase.paramsConstructor += tipo + " " + nombre + ",";
            //Agregar en initConstructor
            clase.initConstructor += "        this." + nombre + " = " + nombre + ";\n";
        }

        //Agregar getters y setters
        String camel = (nombre.charAt(0) + "").toUpperCase() + nombre.substring(1);
        if (r) {
            clase.gettersSetters += "public " + tipo + " get" + camel + "(){\n return this." + nombre + ";\n}\n\n";
        }
        if (w) {
            clase.gettersSetters += "public void set" + camel + "(" + tipo + " " + nombre + "){\n this." + nombre + " = " + nombre + ";\n}\n\n";
        }
        return ctx;
    }

    @Override
    public CompCont compilePhp(CompCont ctx) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
