import java.util.Collection;
import java.util.Stack;

public class ReversibleStack<E> extends Stack{
	public ReversibleStack() {
		super();
	}
	
	public void reverse() {
		Stack<E> temp = new Stack<E>();
		while(!this.empty()) {
			temp.push((E)this.pop());
		}
		this.addAll(temp);
	}
	
	public static void main(String[] args)
	{
		ReversibleStack<Integer> numbers = new ReversibleStack<Integer>();
		
		numbers.push(42);
		numbers.push(4);
		numbers.push(64);
		
		System.out.println(numbers);
		
		numbers.reverse();
		System.out.println(numbers);
	}
}
