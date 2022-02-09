package Genericss;

import java.util.Arrays;

public class ArrayListString {

	private String[] values;
	private int count;

	public ArrayListString() {
		this(10);
	}

	public ArrayListString(int size) {
		values = new String[size];
		count = 0;
	}
	
	public void add(String str) {
		if(count+1>=values.length)
			throw new IndexOutOfBoundsException("max size has reached");
		values[count++] = str;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return Arrays.toString(values);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayListString list = new ArrayListString();
		list.add("C");
		list.add("S");
		list.add("T");
		list.add("8");
		list.add("2");
		list.add("8");
		list.add("8");
		System.out.println(list);

	}

}
