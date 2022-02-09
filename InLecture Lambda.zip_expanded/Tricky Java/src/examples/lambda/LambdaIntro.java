package examples.lambda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class LambdaIntro{
	
	@FunctionalInterface
	interface Print{
		void print( String message);
	}

	public static void printMethod(String message){
		System.out.println(message);
	}

	public void printMethodInstance(String message){
		System.out.println(message);
	}

	public static <T> void printList(List<T> list, Consumer< T> print){
		for (T t : list) {
			print.accept( t);
		}
	}
	
	static class ConcreteConsumer implements Consumer< String>{
		@Override
		public void accept( String t){
			System.out.println(t);
		}
	}

	public static void main( String[] args){
		LambdaIntro into = new LambdaIntro();
//[A,B,C,D]
		
		
		List<String> list = Arrays.asList( "A","B","C","D","E");
//		list.forEach( e->System.out.println(e));
		
		
		List<String> newList = list.stream().map( s->s.charAt( 0))
		.mapToInt( c->(int)c)
		.filter( i->i%2==0)
		.mapToObj( i->String.valueOf( (char)i))
		.collect( Collectors.toList());
		
		newList.forEach( e->System.out.println(e));
		
//		printList( list, into::printMethodInstance);
//		printList( list, e->System.out.println(e));
//		printList( list, new ConcreteConsumer());
//		printList( list, new Consumer< String>(){
//			public void accept(String t) {
//				System.out.println(t);
//			};
//		});
////		list.forEach( e->System.out.println(e));
////		list.forEach( System.out::print);
//		
////		Print p = (String m)->System.out.println(m);
////		Print p = (m)->System.out.println(m);
//		Print p = m->System.out.println(m);
//		p.print( "Custom Lambda");
//		
//		Print pRefrence = LambdaIntro::printMethod;
//		pRefrence.print( "method refrence");
//		
//		ActionListener action = new ActionListener(){
//			
//			@Override
//			public void actionPerformed( ActionEvent e){
//				System.out.println("hello inside actionPerformed anyonymous class");
//			}
//		};
//		
//		action.actionPerformed( null);
//		
//		ActionListener actionLambda = ( ActionEvent e)->{
//			System.out.println("hello inside lmbda");
//		};
//		
//		actionLambda.actionPerformed( null);
	}
}
