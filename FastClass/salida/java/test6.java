public class test6 extends Padre { 
	String property;
	int read;
	Libro read_write;
	Cuaderno write_constructor;

	public test6(String property, Cuaderno write_constructor) {
		this.property = property;
		this.write_constructor = write_constructor;
	}
	public String getProperty(){
		return this.property;
	}
	public void setProperty(String property){
		this.property = property;
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
	public void setWrite_constructor(Cuaderno write_constructor){
		this.write_constructor = write_constructor;
	}

}
