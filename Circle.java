public class Circle extends Shape{
	private double radius;
	
	public Circle(double r) {
		super(1);
		if(r <= 0) 
			throw new IllegalArgumentException();
		radius = r;
	}
	
	public double getArea() {
		return Math.PI * radius * radius;
	}
	
	public double getPerimeter() {
		return 2 * Math.PI * radius;
	}
	
	public double getCircumference() {
		return this.getPerimeter();
	}
	
	public String toString() {
		return this.getType() + " with area " + this.getArea() + ", circumference " + this.getPerimeter();
	}
	
	public double getRadius() {
		return radius;
	}
	
	public void setRadius(double r) {
		if(r <= 0) 
			throw new IllegalArgumentException();
		radius = r;
	}
	
	public double getDiameter() {
		return 2 * radius;
	}
	
	public double getArcLength(double theta) {
		return radius * theta;
	}
	
	public double getArcAngle(double arcLength) {
		return arcLength/radius;
	}
	
	public double getArcAngleDegrees(double arcLength) {
		return arcLength/radius * 180 / Math.PI;
	}
}
