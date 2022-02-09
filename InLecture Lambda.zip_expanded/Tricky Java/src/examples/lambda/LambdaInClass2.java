package examples.lambda;

import java.util.function.Consumer;

public class LambdaInClass2 {

	@FunctionalInterface // Which means it can only have one abstract method
	interface Printer {
		void print();
	}
	
	@FunctionalInterface
	interface Printer2{
		void print(String message);
	}

	static class HPPrinter implements Printer {

		@Override
		public void print() {
			// TODO Auto-generated method stub
			System.out.println("HP Printer");

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// If we do not have static before insider class
		// we need the first access of LambdaInClass 2 object and then HPPrinter class
		// Printer p = new LambdaInClass2().new HPPrinter();

		// but if we have static we do not need to specify main class refrence

		// Casting A->B->C
		// here for casting A = B, B = C and A = C which is Casting Up is correct
		// But casting down is not correct
		// for example B = A in this case we need casting; B = (B)A Casting down
		Printer p = new HPPrinter();
		p.print();

		// This Block called anonymous instance
		Printer p1 = new Printer() {

			@Override
			public void print() {
				// TODO Auto-generated method stub
				System.out.println("P1 Printer");

			}
		};
		p1.print();

		
		//Lambda method is the static method in the byte code implemntation
		//Lambda method can be called as many as times but can not be instantiated in the same way more than one time
		
		// Lambda Example remove the things that we already know
		Printer p2 =  () -> { System.out.println("P2 Printer");};
		p2.print();
		
		//Lambda another function remove curly brackets because single line to execute
		Printer p3 =  () ->  System.out.println("P3 Printer");
		p3.print();
		
		Printer2 p4 =  (String message) ->  System.out.println(message);
		p4.print("Hello CST8288 1");
		
		Printer2 p5 =  ( message) ->  System.out.println(message);
		p5.print("Hello CST8288 2");
		
		// no need for () when only one argument
		Printer2 p6 =  message ->  System.out.println(message);
		p6.print("Hello CST8288 3");
		
		// a method refrence
		Printer2 p7 =   System.out::println;
		p7.print("Hello CST8288 4");
		
		// Built In lambda Functionality
		Consumer<String> p8 = System.out::println;
		p8.accept("Hello CST8288 5");
	}

}
