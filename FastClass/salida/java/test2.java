public class test2 extends Padre implements Interfaz, Interfaz2 { 
	String property;
	int read;
	Libro read_write;
	Cuaderno read_constructor;

	public test2(Cuaderno read_constructor) {
		this.read_constructor = read_constructor;
	}
	public int getRead(){
		return this.read;
	}
	public Libro getRead_write(){
		return this.read_write;
	}
	public void setRead_write(Libro read_write){
		this.read_write = read_write;
	}
	public void setRead_constructor(Cuaderno read_constructor){
		this.read_constructor = read_constructor;
	}

}
