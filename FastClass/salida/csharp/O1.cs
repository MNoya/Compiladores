public class O1 : Padre, Interfaz, Interfaz2 { 
	String p;
	int read;
	Libro read_write;
	Cuaderno read_constructor;

	public O1(String p, int read, Libro read_write, Cuaderno read_constructor) {
		this.p = p;
		this.read = read;
		this.read_write = read_write;
		this.read_constructor = read_constructor;
	}
	public String getP(){
		return this.p;
	}
	public void setP(String p){
		this.p = p;
	}
	public void setRead(int read){
		this.read = read;
	}
	public void setRead_write(Libro read_write){
		this.read_write = read_write;
	}
	public Cuaderno getRead_constructor(){
		return this.read_constructor;
	}

	public class O2 : Padre, Interfaz, Interfaz2 { 
		String read_write;

		public O2(String read_write) {
			this.read_write = read_write;
		}
		public void setRead_write(String read_write){
			this.read_write = read_write;
		}

		public class O3 : Padre, Interfaz, Interfaz2 { 
			String read_only;

			public O3(String read_only) {
				this.read_only = read_only;
			}
			public void setRead_only(String read_only){
				this.read_only = read_only;
			}

			public class O4 : Padre, Interfaz, Interfaz2 { 
				String write_only;

				public O4(String write_only) {
					this.write_only = write_only;
				}
				public String getWrite_only(){
					return this.write_only;
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
}
