package ast;

public class Output {
    
    boolean java;
    boolean csharp;
    boolean php;

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
