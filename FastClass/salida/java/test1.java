public class test1 extends Padre implements Interfaz, Interfaz2 { 
	String property;
	int read;
	Libro read_write;
	Cuaderno write_constructor;

	public test1(String property, Cuaderno write_constructor) {
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

	public class sub_clase1 extends Padre implements Interfaz, Interfaz2 { 
		String read_write;

		public sub_clase1() {
		}
		public String getRead_write(){
			return this.read_write;
		}
		public void setRead_write(String read_write){
			this.read_write = read_write;
		}
		//Codigo fuente original
		```
        some
        source
        code
        ```
        class sub_sub_clase_1(String r read_only) : Interfaz Interfaz2 {
            ```
            some2
            source2
            code2
            ```
            class sub_sub_sub_clase1(String w write_only) Padre : Interfaz {

            }
        }
    }
    
    class sub_clase2(String rwc read_write) Padre : {
        ```
        some2
        source2
        code2
        ```
	}
}
