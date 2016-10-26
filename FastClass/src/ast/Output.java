package ast;

public class Output {
    
    public Boolean java;
    public Boolean csharp;
    public Boolean php;

    public Output() {
        java = false;
        csharp = false;
        php = false;
    }

    public void setJava() {
        this.java = true;
    }

    public void setCsharp() {
        this.csharp = true;
    }

    public void setPhp() {
        this.php = true;
    }    
}
