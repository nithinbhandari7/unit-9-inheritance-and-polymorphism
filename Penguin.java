public class Penguin extends Bird{
	public Penguin(String n) {
		super(n);
	}
	
	public void move() {
		System.out.println("I waddle");
	}
	
	public void characteristics() {
		super.characteristics();
		System.out.println("My body is fusiform and streamlined");
	}
}
