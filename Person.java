public class Person extends Animal{
	public Person (String n) {
		super(n);
	}
	
	public void move() {
		System.out.println("I walk on two legs");
	}
	
	public void characteristics() {
		super.characteristics();
		System.out.println("I am self-aware and have opposite thumbs");
	}
}
