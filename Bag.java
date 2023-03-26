
import java.util.Arrays;
import java.util.NoSuchElementException;


public class Bag<T>
{
	private final int CAPACITY = 1000;   // default capacity of bag
	private int capacity;  //a specific number in the array
	private T[] data;  // array of any type in an object array
	private int count; //Counts the number of items 

	
	public Bag() {
// create array of T elements
		setCapacity(CAPACITY);
		data = (T[])new Object[capacity];
		count = 0;
	}

	public void setCapacity(int newCapacity)
	{
		capacity = newCapacity;
	}

	public int getSize()
	{
		return count;
	}
	private void resize()
	{
		capacity *= 1.5; 
		data = Arrays.copyOf(data, capacity);
	}
	public void insert(T element) 
	{
		// if current number of elements is at capacity
		if (count >= capacity) 
		{
			resize();		// expand size of bag 
		} 
		// add item at end of the array
		else 
		{
			data[count] = element;
			count++;
		}
	}



	public T delete()
	{
		T target = null;
		// can't remove an element if empty
		if(isEmpty())
		{
			throw new IllegalStateException("Bag - delete()");
		}
		//otherwise, remove last element in the bag
		target = data[count - 1];
		data[count - 1] = null;
		count--;

		return target; 
	}
	
	public T delete(T element)
	{
		T target = null;
		Boolean done = false;  // still looking for  element 
		int i = 0; 	// loop variable
		
		// iterate through array looking for element
		while(i < count && !done)
		{
			if (data[i] == element) 
			{
				// get return value
				target = data[i];
				//move last element into space left by this element
				data[i] = data[count-1];
				// set old last position to null
				data[count - 1] = null;
				// update count
				count--;
				// done, so set to true 
				done = true;
			}
			i++;
		}
		// if not done, didn't find element 
		if(!done)
		{
			throw new NoSuchElementException("Bag - remove(element)");
		}
		return target;
	}

	
      int numberOfOccurrences(T[] a, T b){ 
        // setting the parameters for passing in an array and for passing an integer to use to search for
        int count = 0; boolean test = false;
        // creating and initializing a boolean value to use for returning a test
        for(  T e1 : a ) { 
            // create an int called 'e1'(which is a temporary storage holder for iterating over values) and use the  single colon operator as a shortcut for iterating. 
            if(e1 == b) {
                // if the compared value that is passed in from the user compares to the element in the array that we re iterating over using the single colon operator
                test = true; count++; }
                } // Print the result 
                System.out.println("Is " + b + " is present in the bag: " ); 
                System.out.printf("The number of occurrences \n" ); return count ;
                // we have to return the value from here 
                } 
       
   


	public boolean isEmpty()
	{
		// empty if count equals 0, not otherwise 
		return (count == 0);
	}

	public T get(int index)
	{
		T target = null;
		// if try to access index that contains an element
		if(index < 0 || index >= count)
		{
			throw new IndexOutOfBoundsException("Bag - get(index)");
		}
		target = data[index];
		return target;
	}


    public String toString() {


        System.out.println("The bag has " + count + " elements:");
		// if not empty
		if (!isEmpty()) 
		{
			
			for (int i = 1; i < count; i++) 
			{
				System.out.print(data[i] +  ", "  );
             
                

                
			}
      
      
    }
    String hello = ""; 
    return hello;
    }
  
    public static void main(String[] args) {
	Bag bag = new Bag();
    boolean p = false;
    bag.insert(1);
    bag.insert("Hell0");
    bag.insert("Hell0");
    bag.insert(false);
    bag.insert(1.011);
    bag.insert(p); 
    System.out.println(bag.toString() + "\n"+ bag.getSize() );
    System.out.println(bag.numberOfOccurrences(bag.data,"Hell0"));
	bag.delete("Hell0"); 
    System.out.println("\n" + bag.getSize()); 
   


}

}
