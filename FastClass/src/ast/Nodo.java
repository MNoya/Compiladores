package ast;

import behavior.CompCont;

public interface Nodo {
    
    public CompCont compileCsharp(CompCont ctx);
    public CompCont compileJava(CompCont ctx);
    public CompCont compilePhp(CompCont ctx);
    
}
