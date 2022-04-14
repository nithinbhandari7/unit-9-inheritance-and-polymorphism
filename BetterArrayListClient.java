public class BetterArrayListClient {
	public static void main(String[] args) {
		BetterArrayList<String> list = new BetterArrayList<String>();
		list.add("AB");
		list.add("CD");
		list.add("EF");
		list.add("GH");
		list.add("IJ");
		list.add("KL");
		list.add("MN");
		list.add("OP");
		list.add("QR");
		
		System.out.println(list.getMedian());
		System.out.println(list.getRandomElement());
	}
}
