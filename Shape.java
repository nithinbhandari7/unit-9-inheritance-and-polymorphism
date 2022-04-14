public abstract class Shape implements Comparable<Shape>{
	private int numSides;
	
	public Shape(int n) {
		if(n <= 0 || n==2) 
			throw new IllegalArgumentException();
		numSides = n;
	}
	
	public abstract double getArea();
	public abstract double getPerimeter();
	
	public String getType() {
		return this.getClass().getSimpleName();
	}
	
	public int compareTo(Shape s) {
		return Double.compare(this.getArea(), s.getArea());
	}
	
	public boolean equals(Object o) {
		Shape s = (Shape)o;
		return this.getType().equals(s.getType()) && this.getArea() == s.getArea() && this.getPerimeter() == s.getPerimeter();
	}
	
	public String toString() {
		return this.getType() + " with area " + this.getArea() + ", perimeter " + this.getPerimeter();
	}
	
	public int getNumSides() {
		return numSides;
	}
}
