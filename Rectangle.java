public class Rectangle extends Shape{
	private double length;
	private double width;
	
	public Rectangle(double l, double w) {
		super(4);
		if(l <= 0 || w <= 0)
			throw new IllegalArgumentException();
		length = l;
		width = w;
	}
	
	public double getArea() {
		return length * width;
	}
	
	public double getPerimeter() {
		return 2 * length + 2 * width;
	}
	
	public double getLength() {
		return length;
	}
	
	public double getWidth() {
		return width;
	}
	
	public void setWidth(double w) {
		if(w <= 0)
			throw new IllegalArgumentException();
		width = w;
	}
	
	public void setLength(double l) {
		if(l <= 0) 
			throw new IllegalArgumentException();
		length = l;
	}
	
	public double getDiagonalLength() {
		return Math.hypot(length, width);
	}
}
