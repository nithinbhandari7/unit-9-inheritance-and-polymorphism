public class Superclass {
	private int pri;
	protected int pro;
	public int pub;
	
	//if you dont define any constructors in a class, the JRE automatically provides the default constructor
	
	public Superclass() {
		pri = 0;
		pro = 0;
		pub = 0;
	}
	
	public Superclass(int a, int b, int c) {
		pri = a;
		pro = b;
		pub = c;
	}
	
	public void setPri(int a) {
		pri = a;
	}
	
	public String toString() {
		return "Private: " + pri + "\nProtected: " + pro + "\nPublic: " + pub;
	}
}
