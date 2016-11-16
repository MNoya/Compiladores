public class TODO { 

	public TODO() {
	}

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

			public class sub_sub_clase_1 implements Interfaz, Interfaz2 { 
				String read_only;

				public sub_sub_clase_1() {
				}
				public String getRead_only(){
					return this.read_only;
				}

				public class sub_sub_sub_clase1 extends Padre implements Interfaz { 
					String write_only;

					public sub_sub_sub_clase1() {
					}
					public void setWrite_only(String write_only){
						this.write_only = write_only;
					}

				}
			}
		}
		public class sub_clase2 extends Padre { 
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
	public class test2 extends Padre implements Interfaz, Interfaz2 { 
					String property;
	int read;
	Libro read_write;
	Cuaderno read_constructor;

		public test2(String property, Cuaderno read_constructor) {
			this.property = property;
			this.read_constructor = read_constructor;
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
		public void setRead_constructor(Cuaderno read_constructor){
			this.read_constructor = read_constructor;
		}

	}
	public class test3 { 

		public test3() {
		}

	}
	public class test4 { 
					String property;
	int read;
	int write;
	int const;

		public test4(String property, int const) {
			this.property = property;
			this.const = const;
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
		public void setWrite(int write){
			this.write = write;
		}

	}
	public class test5 { 
					int readwrite;
	int writeconst;
	int readcont;
	int leescrcom;

		public test5(int writeconst, int readcont, int leescrcom) {
			this.writeconst = writeconst;
			this.readcont = readcont;
			this.leescrcom = leescrcom;
		}
		public int getReadwrite(){
			return this.readwrite;
		}
		public void setReadwrite(int readwrite){
			this.readwrite = readwrite;
		}
		public void setWriteconst(int writeconst){
			this.writeconst = writeconst;
		}
		public int getReadcont(){
			return this.readcont;
		}
		public int getLeescrcom(){
			return this.leescrcom;
		}
		public void setLeescrcom(int leescrcom){
			this.leescrcom = leescrcom;
		}

	}
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
	public class test7 extends Dad implements Interfaz { 
		String p;

		public test7(String p) {
			this.p = p;
		}
		public String getP(){
			return this.p;
		}
		public void setP(String p){
			this.p = p;
		}

	}
}
