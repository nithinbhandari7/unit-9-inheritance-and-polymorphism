import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BetterArrayList<E> extends ArrayList<E> {
	//int array sum
	//remove all instances of an element
	//string array alphabetical order
	//reverse the order
	//int array range
	
	public BetterArrayList() {
		super();
	}
	
	public int[] indexesOf(E element) {
		int[] indexes = new int[getNumberOfOccurrences(element)];
		int currentIndex = 0;
		for(int i = 0; i < this.size(); i++) 
			if(this.get(i).equals(element)) {
				indexes[currentIndex] = i;
				currentIndex += 1;
			}
		return indexes;
	}
	
	public int getNumberOfOccurrences(E element) {
		int count = 0;
		for(int i = 0; i < this.size(); i++) 
			if(this.get(i).equals(element)) 
				count++;
		return count;
	}
	
	public void scramble() {
		for(int i = 0; i < this.size(); i++) 
			this.swap(i, (int)(Math.random() * this.size()));
	}
	
	public E getRandomElement() {
		return this.get((int)(Math.random() * this.size()));
	}
	
	public void setAll(E value) {
		for(int i = 0; i < this.size(); i++)
			this.set(i, value);
	}
	
	public Comparable getMedian() {
		BetterArrayList<Comparable> copy = new BetterArrayList<Comparable>();
		for(E element : this)
			copy.add((Comparable)element);
		Collections.sort(copy);
		return copy.get(copy.size()/2);
	}
	
	public void removeAllInstancesOf(E element) {
		for(int i = 0; i < this.size(); i++) 
			if(this.get(i).equals(element)) {
				this.remove(i);
				i--;
			}
	}
	
	public BetterArrayList<E> getReverse(){
		BetterArrayList<E> reverse = new BetterArrayList<E>();
		for(int i = this.size() - 1; i >= 0; i--)
			reverse.add(this.get(i));
		return reverse;
	}
	
	public void swap(int i, int j) {
		E temp = this.get(i);
		this.set(i, this.get(j));
		this.set(j, temp);
	}
}