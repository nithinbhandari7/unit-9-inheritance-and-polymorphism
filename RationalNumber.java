public class RationalNumber implements Comparable<RationalNumber>{
	private int num;
	private int den;
	
	public RationalNumber(int num, int den) {
		if (den == 0) {
			throw new IllegalArgumentException();
		} if (den < 0) {
			num *= -1;
			den *= -1;
		}
		
		this.num = num;
		this.den = den;
		
		this.reduce();
	}
	
	public int getNumerator() {
		return num;
	}
	
	public int getDenominator() {
		return den;
	}
	
	public double toDecimal() {
		return (double)num/den;
	}
	
	public String toString() {
		if(num == 0 || den == 1) {
			return num + "";
		} 
		return num + "/" + den;
	}
	
	//precondition - num1 and num2 are non-negative
	private static int gcf(int num1, int num2) {
		if(num1 == 0 || num2 == 0) {
			return 1;
		}
		while (num1 != num2) {
			if(num1 > num2) {
				num1 -= num2;
			} else {
				num2 -= num1;
			}
		}
		
		return num1;
	}
	
	private void reduce() {
		int factor = gcf(Math.abs(num), Math.abs(den));
		num /= factor;
		den /= factor;
	}
	
	public boolean equals(Object o) {
		RationalNumber other = (RationalNumber)o;
		return this.num == other.num && this.den == other.den;
	}
	
	public RationalNumber getReciprocal() {
		return new RationalNumber(this.den, this.num);
	}
	
	public RationalNumber add(RationalNumber op) {
		int common = this.den * op.den;
		int newNumerator = this.num*op.den + op.num*this.den;
		return new RationalNumber(newNumerator, common);
		
	}
	
	public RationalNumber subtract(RationalNumber op) {
		int common = this.den * op.den;
		int newNumerator = this.num*op.den - op.num*this.den;
		return new RationalNumber(newNumerator, common);
	}
	
	public RationalNumber multiply(RationalNumber op) {
		return new RationalNumber(this.num*op.num, this.den*op.den);
	}
	
	public RationalNumber divide(RationalNumber op) {
		return this.multiply(op.getReciprocal());
	}
	
	public int compareTo(RationalNumber op) {
		double thisDec = this.toDecimal();
		double opDec = op.toDecimal();
		
		if(thisDec > opDec) {
			return 1;
		} else if (opDec > thisDec) {
			return -1;
		} else {
			return 0;
		}
	}
}