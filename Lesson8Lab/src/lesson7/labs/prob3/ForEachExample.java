package lesson7.labs.prob3;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;


public class ForEachExample {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		List<String> list = Arrays.asList("Hello there", "Goodbye", "Back soon", 
				"Away", "On Vacation", "Everywhere you want to be");
		
		//print each element of the list in upper case format
		
		 Supplier<Double> sp = () -> Math.random();
		 System.out.println(sp.get());
		 
		 Supplier<Double> rp = new MyRandom();
//		 rp.get()
//		 list.
		 
		 System.out.println(rp.get());
		
	}
	
	static class MyRandom implements Supplier<Double> {

		@Override
		public Double get() {
			// TODO Auto-generated method stub
			return Math.random();
		}
		
	}
	
	
	
	public static String toUpper(String s) {
		return s.toUpperCase();
	}
	
	//implement a Consumer
	
	
}