public class Client 
{
	public static void main(String[] args)
	{
		Superclass sup = new Superclass(1, 2, 3);
		Subclass sub = new Subclass(1, 2, 3, 4);
		
		
		//sup.pri = 42;	//legal?  why/why not: illegal because its private data
		//sup.pro = 42;	//legal?  why/why not: legal because same package
		//sup.pub = 42;	//legal?  why/why not: legal because it is public data anything can access it
		//sup.subData = 42;	//legal?  why/why not: illegal it is private data
		
		//sub.pri = 42;	//legal?  why/why not: illegal private data
		//sub.pro = 42;	//legal?  why/why not: legal because same package 
		//sub.pub = 42;	//legal?  why/why not: legal it gets super class data
		//sub.subData = 42;	//legal?  why/why not: illegal private data
		 
		/*
		sup.setPri(4);	//legal?  why/why not: legal
		sub.setPri(4);	//legal?  why/why not: legal inherits the function		
		sup.setSubData(42);	//legal?  why/why not: illegal, superclass doesnt get subclass functions
		sub.setSubData(42);	//legal?  why/why not: legal
		 */
		
		System.out.println(sup);	//predict output: Private: 1 Protected: 2 Public: 3
		System.out.println(sub);	//predict output: Private: 1 Protected: 2 Public: 3 Sub Data: 4
		
		
		//Superclass sup2 = new Subclass(5, 6, 7, 8);	//legal?  legal

		//Subclass sub2 = new Superclass(5, 6, 7);	//legal?  illegal subclass has more memory

		//sup2.setPri(2);	//legal?  why/why not: legal function is defined in superclass
		//sup2.setSubData(3);	//legal?  why/why not: illegal in compile time, sup2 is superclass
		//((Subclass)sup2).setSubData(3);	//legal?  why/why not: legal because sup2 is declared as a subclass
		//((Subclass)sup).setSubData(3);	//legal?  why/why not: illegal its defined as a superclass

		//String output = sup2.toString();	subclass to string
		
	}
}



