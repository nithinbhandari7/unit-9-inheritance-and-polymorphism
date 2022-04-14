public class Subclass extends Superclass{
	private int subData;
	
	public Subclass() {
		super(); //this class the Superclass's default constructor
		subData = 0;
		//the call to the Superclass constructor must be the first line in this constructor
		//IF we dont call the Superclass constructor the JRE will automatically call the default
		//constructor in the Superclass IF it exists
	}
	
	public Subclass(int a, int b, int c, int d) {
		super(a, b, c);
		subData = d;
	}
	
	public void setSubData(int d) {
		subData = d;
	}
	
	public String toString() {
		return super.toString() + "\n Sub Data: " + subData;
		//super.toString calls the toString function in the superclass
	}
}
