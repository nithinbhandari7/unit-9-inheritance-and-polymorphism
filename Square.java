public class Square extends Rectangle{
	public Square(double s) {
		super(s, s);
	}
	
	public double getSideLength() {
		return super.getLength();
	}
	
	public void setLength(double l) {
		super.setLength(l);
		super.setWidth(l);
	}
	
	public void setWidth(double w) {
		super.setLength(w);
		super.setWidth(w);
	}
	
	public void setSideLength(double l) {
		this.setWidth(l);
	}
}
