public class MixedNumber extends RationalNumber{
	public MixedNumber(int w, int n, int d) {
		super(w * d + n, d);
		if(d <= 0 || n < 0 && w > 0 || n > 0 && w < 0)
			throw new IllegalArgumentException();
	}
	
	public MixedNumber(RationalNumber r) {
		super(r.getNumerator(), r.getDenominator());
	}
	
	public int getNumerator() {
		return this.getNumerator() % this.getDenominator();
	}
	
	public int getWholeNumber() {
		return this.getNumerator() / this.getDenominator();
	}
	
	public String toString() {
		if(this.getWholeNumber() == 0)
			return super.toString();
		if(this.getNumerator() == 0)
			return this.getWholeNumber() + "";
		if(this.getWholeNumber() > 0) 
			return this.getWholeNumber() + " " + this.getNumerator() + "/" + this.getDenominator();
		else
			return this.getWholeNumber() + " " + Math.abs(this.getNumerator()) + "/" + this.getDenominator();
	}
	
	public MixedNumber add(RationalNumber op) {
		return new MixedNumber(super.add(op));
	}
	
	public MixedNumber subtract(RationalNumber op) {
		return new MixedNumber(super.subtract(op));
	}
	
	public MixedNumber multiply(RationalNumber op) {
		return new MixedNumber(super.add(op));
	}
	
	public MixedNumber divide(RationalNumber op) {
		return new MixedNumber(super.divide(op));
	}
	
	
}
