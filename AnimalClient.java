public class AnimalClient {
	public static void main(String[] args) {
		Animal[] animals = new Animal[5];
		animals[0] = new Person("Snoop Dog");
		animals[1] = new Fish("Dory", Fish.WaterType.saltWater);
		animals[2] = new Shark("Bruce", Fish.WaterType.saltWater);
		animals[3] = new Bird("Blue");
		animals[4] = new Penguin("Skipper");
		
		for(Animal a : animals) {
			System.out.println(a);
			a.characteristics();
			a.move();
			if(a instanceof Fish) {
				((Fish)a).getWater();
			}
			System.out.println();
		}
	}
}