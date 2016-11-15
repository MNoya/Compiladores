public class test1 : Padre, Interfaz, Interfaz2 { 
	String property;
	int read;
	Libro read_write;
	Cuaderno write_constructor;

	public test1(Cuaderno write_constructor) {
		this.write_constructor = write_constructor;
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

	public class sub_clase1 : Padre, Interfaz, Interfaz2 { 
		String read_write;

		public sub_clase1() {
		}
		public String getRead_write(){
			return this.read_write;
		}
		public void setRead_write(String read_write){
			this.read_write = read_write;
		}

		public class sub_sub_clase_1 : Interfaz, Interfaz2 { 
			String read_only;

			public sub_sub_clase_1() {
			}
			public String getRead_only(){
				return this.read_only;
			}

			public class sub_sub_sub_clase1 : Padre, Interfaz { 
				String write_only;

				public sub_sub_sub_clase1() {
				}
				public void setWrite_only(String write_only){
					this.write_only = write_only;
				}
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
		public String getRead_write(){
			return this.read_write;
		}
		public void setRead_write(String read_write){
			this.read_write = read_write;
		}

	}
}
