public class Fish extends Animal{
	public static enum WaterType{freshWater, saltWater}
	private WaterType myWater;
	
	public Fish(String n, WaterType w) {
		super(n);
		myWater = w;
	}
	
	public void move() {
		System.out.println("I swim");
	}
	
	public void characteristics() {
		super.characteristics();
		System.out.println("I have gills");
	}
	
	public void getWater() {
		System.out.println("I like to splash around in " + myWater);
	}
}
