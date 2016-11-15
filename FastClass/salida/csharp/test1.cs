public class test1 : Padre, Interfaz, Interfaz2 { 
	String property;
	int read;
	Libro read_write;
	Cuaderno write_constructor;

	public test1(Cuaderno write_constructor) {
		this.write_constructor = write_constructor;
	}
	public Cuaderno write_constructor { set; }

	public class sub_clase1 : Padre, Interfaz, Interfaz2 { 
		String read_write;

		public sub_clase1() {
		}
		public String read_write { get; set; }

		public class sub_sub_clase_1 : Interfaz, Interfaz2 { 
			String read_only;

			public sub_sub_clase_1() {
			}
			public String read_only { get; }

			public class sub_sub_sub_clase1 : Padre, Interfaz { 
				String write_only;

				public sub_sub_sub_clase1() {
				}
				public String write_only { set; }
				//Codigo fuente original
				```
                some
                source
                code
                ```
			}
		}
	}
	public class sub_clase2 : Padre { 
		String read_write;

		public sub_clase2(String read_write) {
			this.read_write = read_write;
		}
		public String read_write { get; set; }

	}
}
