public class RationalClient 
{
	public static void main(String[] args) 
	{
		RationalNumber r = new RationalNumber(-7, 2);
		MixedNumber m = new MixedNumber(1, 3, 4);
		MixedNumber m2 = new MixedNumber(new RationalNumber(6, 8));
		RationalNumber rat = new MixedNumber(1, 1, 2);
		
		System.out.println(r); //output? 
		System.out.println(m);  //output?
		System.out.println(m2); //output?
		System.out.println(rat);  //output?
		
		//System.out.println(r.add(m)); //legal? why/why not?  if legal, which function called? legal rational's add
		//System.out.println(m.add(r)); //legal? why/why not?  if legal, which function called? legal mixed number's add
		//System.out.println(m.add(m2)); //legal? why/why not?  if legal, which function called? legal mixed number's add
		//System.out.println(rat.add(m)); //legal? why/why not?  if legal, which function called? legal mixed number's add
		
		//System.out.println(rat.getNumerator()); //legal? why/why not?  if legal, which function called? legal mixed number's getNumerator
		//System.out.println(rat.getWhole()); //legal? why/why not?  if legal, which function called? illegal
		
		
	}
}