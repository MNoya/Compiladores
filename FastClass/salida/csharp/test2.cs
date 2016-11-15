public class test2 : Padre, Interfaz, Interfaz2 { 
	String property;
	int read;
	Libro read_write;
	Cuaderno read_constructor;

	public test2(String property, Cuaderno read_constructor) {
		this.property = property;
		this.read_constructor = read_constructor;
	}
	public Cuaderno read_constructor { set; }

}
