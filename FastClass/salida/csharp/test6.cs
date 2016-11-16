public class test6 : Padre { 
	String property;
	int read;
	Libro read_write;
	Cuaderno write_constructor;

	public test6(String property, Cuaderno write_constructor) {
		this.property = property;
		this.write_constructor = write_constructor;
	}
	public Cuaderno write_constructor { set; }

}
