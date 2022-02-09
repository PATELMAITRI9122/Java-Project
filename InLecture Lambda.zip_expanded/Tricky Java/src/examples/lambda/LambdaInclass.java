package examples.lambda;

import java.util.ArrayList;
import java.util.List;

public class LambdaInclass {
	
	List<String> list;
	
	// This block call anonymous Block Which is 
	//Being called every time file run 
	// Not supposed to run instead use constructor
	{
		list = new ArrayList<>();
	}
	
	// This block as well known as anonymous Block which will 
	//run everytime file run
	// and it cannot be refrenced by object 
	
	{
		list.add("Hello");
		list.forEach( str -> System.out.println(str));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
