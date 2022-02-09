package Genericss;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayListObject {

	private Object[] values;
	private int count;

	public ArrayListObject() {
		this(10);
	}

	public ArrayListObject(int size) {
		values = new Object[size];
		count = 0;
	}
	
	public void add(Object obj) {
		if(count+1>=values.length)
			throw new IndexOutOfBoundsException("max size has reached");
		values[count++] = obj;
	}
	
	public Object get(int i) {
		if(i<0 || i>count)
			throw new IndexOutOfBoundsException("max size has reached");
		return values[i];
	
	}
	
	public int size() {
		return count;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return Arrays.toString(values);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayListObject list = new ArrayListObject();
		list.add("C");
		list.add("S");
		list.add("T");
		list.add(8);
		list.add(2);
		list.add(8);
		list.add(8);
		//System.out.println(list);
		
		for (int i = 0; i<list.size(); i++) {
			System.out.print(list.get(i));
			
		}
		
		//Problem here is how we get to know what type of data is and how to perform here
		Object obj = list.get(0);
		if (obj instanceof String) {
			// do something here
			//everytime we can not write code if data is double or any other type do something
			//this is not the solutions
			
		}

	}

}
