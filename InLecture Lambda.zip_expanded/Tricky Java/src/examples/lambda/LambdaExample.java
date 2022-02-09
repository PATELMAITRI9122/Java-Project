package examples.lambda;

import java.util.ArrayList;
import java.util.List;

public class LambdaExample{

	/**
	 * take a message and print on the console.
	 * this method has the same signature as Printer interface.
	 * @param message - a string message.
	 */
	public static void printOnConsole( String message){
		System.out.println( message);
	}
	
	/**
	 * take a generic message object and print on the console.
	 * this method has the same signature as Printer interface.
	 * @param <E> - this generic type will be determined by compiler when the function is called.
	 * @param message - a string message.
	 */
	public static <E> void printOnConsole( E message){
		System.out.println( message);
	}

	/**
	 * take a generic message and use the converter provided to convert it to string before printing.
	 * @param <E> - this generic type will be determined by compiler when the function is called.
	 * @param message - a generic message object to be printed
	 * @param converter - a functional interface that is used to convert the object to string
	 */
	public static <E> void printOnConsole( E message, Converter<E,String> converter){
		System.out.println( converter.convert( message));
	}
	
	public static void main( String[] args){
		
		Person p = new Person( "Shawn", "E", 1900, 1, 1);
		//print the person object using the toString
		printOnConsole( p.toString());
		//print the person object using the static method in Person
		printOnConsole( Person.convertToString( p));
		
		//long way of using the Converter interface
		printOnConsole( p, new Converter<Person,String>(){
			public String convert( Person p){
				return p.toString();
			}
			
		});
		//using lambda to create the converter
		printOnConsole( p, person->person.toString());
		//using Method Reference so need to create or use lambda. method must have the same signature as interface method
		printOnConsole( p, Person::convertToString);
		
		List<Person> persons = new ArrayList<>(5);
		persons.add( new Person( "Shawn", "E", 1900, 1, 1));
		persons.add( new Person( "Sean", "F", 1922, 2, 2));
		persons.add( new Person( "Shaun", "G", 1933, 3, 3));
		
		//long version
		for (Person person : persons) {
			printOnConsole( person, new Converter<Person,String>(){
				public String convert( Person p){
					return p.toString();
				}
				
			});
		}
		
		//in this case method reference is used
		//because Printer is generic it has the same signature
		//as both of printOnConsole methods which take one argument
		persons.forEach( LambdaExample::printOnConsole);
		
		//this is like last one but with the converter
		persons.forEach( person->printOnConsole( person, Person::convertToString));
	}
}

class Person{
	
	private String fn, ln;
	private int year, month, day;
	
	public Person( String fn, String ln, int year, int month, int day){
		this.fn = fn;
		this.ln = ln;
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	/**
	 * this method is pointless it simply used as a point of example;
	 * this method very importantly has the same method signature as the only method in Converter interface.
	 * @param p - Person object to be converted to string
	 * @return string representation of Person object
	 */
	public static String convertToString( Person p){
		return p.toString();
	}
	
	@Override
	public String toString(){
		return String.format( "Person:[Name: %s, %s, DoB: %d/%d/%d]", ln, fn, year, month, day);
	}
}

//functional interface must only have one method.
//if there is a need for methods with body, default keyword can be used.
@FunctionalInterface
interface Printer<T>{
	void print( T t);
}

@FunctionalInterface
interface Converter<T,R>{
	R convert( T t);
}
