public class Triangle extends Shape{
	private double[] sideLengths;
	private double longestSide;
	private double[] shortSides;
	private double semiPerimeter;
	
	public static enum TriangleType{equilateral, isosceles, scalene}
	public Triangle(double[] sLengths) {
		super(3);
		checkValidity(sLengths);
		sideLengths = new double[3];
		for(int i = 0; i < sideLengths.length; i++)
			sideLengths[i] = sLengths[i];
		semiPerimeter = this.getPerimeter()/2;
	}
	
	private void checkValidity(double[] lengths) {
		if(lengths.length != 3) {
			throw new IllegalArgumentException();
		}
		for(double l : lengths)
			if(l <= 0)
				throw new IllegalArgumentException();
		int maxIndex = 0;
		for(int i = 0; i < lengths.length; i++)
			if(lengths[i] > lengths[maxIndex]) 
				maxIndex = i;
		longestSide = lengths[maxIndex];
		double shortSum = 0;
		shortSides = new double[2];
		int shortIndex = 0;
		for(int i = 0; i < lengths.length; i++)
			if(i != maxIndex) {
				shortSum += lengths[i];
				shortSides[shortIndex] = lengths[i];
				shortIndex++;
			}
		if(longestSide >= shortSum) {
			throw new IllegalArgumentException();
		}
	}
	
	public double getPerimeter() {
		double p = 0;
		for(double l : sideLengths)
			p += l;
		return p;
	}
	
	public double getArea() {
		return Math.sqrt(semiPerimeter * (semiPerimeter - sideLengths[0]) * (semiPerimeter - sideLengths[1]) * (semiPerimeter - sideLengths[2]));
	}
	
	public double[] getSideLengths() {
		return sideLengths;
	}
	
	public double getBase() {
		return longestSide;
	}
	
	public double getHeight() {
		return this.getArea() * 2 / longestSide;
	}
	
	public void setSideLengths(double[] sLengths) {
		checkValidity(sLengths);
		for(int i = 0; i < sLengths.length; i++) 
			sideLengths[i] = sLengths[i];
		semiPerimeter = this.getPerimeter() / 2;
	}
	
	public boolean isRight() {
		return longestSide * longestSide == shortSides[0] * shortSides[0] + shortSides[1] * shortSides[1];
	}
	
	public  Circle getInscribedCircle() {
		return new Circle(this.getArea() / semiPerimeter);
	}
	
	public TriangleType getTriangleType() {
		double side1 = this.longestSide;
		int sidesEqual = 1;
		for(double s : shortSides)
			if(s == side1) 
				sidesEqual++;
		if(sidesEqual == 1 && shortSides[0] == shortSides[1])
			sidesEqual++;
		
		if(sidesEqual == 1)
			return Triangle.TriangleType.scalene;
		if(sidesEqual == 2)
			return Triangle.TriangleType.isosceles;
		return Triangle.TriangleType.equilateral;
	}
}
