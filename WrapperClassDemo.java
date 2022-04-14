public class WrapperClassDemo 
{
	public static void main(String[] args)
	{
		Integer intObj = new Integer(6);	//boxing/wrapping
		int j = intObj.intValue();			//unboxing/unwrapping
		
		System.out.println("Integer value: " + intObj);
		//calls toString() 
		
		Object object = new Integer(6);		//this type of declaration is legal because an Integer IS-A Object
		//there are implications of this definition
		//object is considered to be during compile time, and Object variable
	
	
		Integer intObj2 = new Integer(6);	
		int k = intObj2.intValue();
		
		/*
		if(intObj.equals(intObj2))						//legal, compares the value
			System.out.println("intObj equals intObj2");
		
		if(intObj.intValue() == intObj2.intValue())		//legal, comparing two ints
			System.out.println("intObj == intObj2");
		
		if(k.equals(j))									//illegal, cant call function on primitive type
			System.out.println("k equals j");
			
		if(intObj.equals(j))							//legal, auto box
			System.out.println("intObj equals j");
		
		if(intObj.intValue().compareTo(intObj2.intValue()) < 0)		//legal, both are ints
			System.out.println("intObj compared To intObj2 is < 0");
		
		if(intObj.compareTo(intObj2.intValue()) == 0)		//illegal, one is Integer one is int
			System.out.println("intObj compared To intObj2 is == 0");
		
		if(intObj.compareTo(object) < 0)		//legal, object class counts as an Integer
			System.out.println("intObj compared to (Integer)object is < 0");
		
		if(intObj.equals(object))		//legal, object class counts as an Integer
			System.out.println("intobj is equal to object");
		
		if(intObj.compareTo((Integer)object) < 0)		//illegal, object is already Integer			
			System.out.println("intObj compared to (Integer)object is < 0");
		
		if(object.equals(intObj))	//legal, both are Integer class
			System.out.println("something");
		
		if(object.compareTo(intObj) < 0)			//legal, both are Integer class
			System.out.println("object compared to intObj is < 0");
		
		if(((Integer)object).compareTo(intObj) == 0)			//ill
			System.out.println("object compared to intObj is < 0");
		*/
	}
}