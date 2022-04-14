import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ShapeClient {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner fileScan = new Scanner(new File("dimensions.txt"));
		
		ArrayList<Shape> shapes = new ArrayList<Shape>();
		while(fileScan.hasNextLine()) {
			String shapeType = fileScan.next();
			if(shapeType.equals("circle")) {
				shapes.add(new Circle(fileScan.nextDouble()));
			} else if(shapeType.equals("rectangle")) {
				shapes.add(new Rectangle(fileScan.nextDouble(), fileScan.nextDouble()));
			} else if(shapeType.equals("square")) {
				shapes.add(new Square(fileScan.nextDouble()));
			} else if(shapeType.equals("triangle")) {
				double[] s = {fileScan.nextDouble(), fileScan.nextDouble(), fileScan.nextDouble()};
 				shapes.add(new Triangle(s));
			}
		}
		
		for(Shape s : shapes)
			System.out.println(s);
		System.out.println();
		Collections.sort(shapes);
		for(Shape s : shapes) {
			System.out.println();
			if(s instanceof Circle) {
				System.out.println(((Circle)s).getArcAngle(1.2));
			}
		}
	}
}
