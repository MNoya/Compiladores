package ast;

import java.util.List;

public class Programa {
    public Output output;
    public List<Clase> clases;

    public Programa(Output output, List<Clase> clases) {
        this.output = output;
        this.clases = clases;
    }
}
