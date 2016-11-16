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
