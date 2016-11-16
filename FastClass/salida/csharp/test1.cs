public class test1 : Padre, Interfaz, Interfaz2 { 
	String property;
	int read;
	Libro read_write;
	Cuaderno write_constructor;

	public test1(String property, Cuaderno write_constructor) {
		this.property = property;
		this.write_constructor = write_constructor;
	}
	public Cuaderno write_constructor { set; }

	public class sub_clase1 : Padre, Interfaz, Interfaz2 { 
		String read_write;

		public sub_clase1() {
		}
		public String read_write { get; set; }
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
