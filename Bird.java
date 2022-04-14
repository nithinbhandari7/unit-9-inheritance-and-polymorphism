public class Bird extends Animal{
	public Bird(String n) {
		super(n);
	}
	
	public void move() {
		System.out.println("I fly");
	}
	
	public void characteristics() {
		super.characteristics();
		System.out.println("I have feathers");
	}
}
