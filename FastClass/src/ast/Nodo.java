package ast;

import behavior.CompCont;

public interface Nodo {
    
    public void compileCsharp(CompCont ctx);
    public void compileJava(CompCont ctx);
    public void compilePhp(CompCont ctx);
    
}
