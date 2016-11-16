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
