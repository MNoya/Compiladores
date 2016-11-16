public class TODO { 

	public TODO() {
	}	}

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
	public class test3 { 

		public test3() {
		}	}

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
		public int const;
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
		public int leescrcom { get; set; }

	}
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
	public class test7 : Dad, Interfaz { 
		String p;

		public test7(String p) {
			this.p = p;
		}
		public String p { get; set; }

	}
}
