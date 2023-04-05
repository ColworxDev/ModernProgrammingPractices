package lesson9.labs.prob7;

import java.math.BigInteger;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		List<Integer> intList = Arrays.asList(4, 5, -2, 0, -3, -1, -5, -4);
		//expected output: [0, -1, -2, -3, -4, 4, -5, 5]
		ordering1(intList);
		List<String> stringList = Arrays.asList("cba", "efg", "doe", "fie", "set");
		//expected output: [cba, fie, doe, efg, set]
		ordering2(stringList);
		
	}
	
	//Orders the integers according to this pattern:
	// 0, -1, 1, -2, 2, -3, 3, . . .
	//Using this ordering, this method sorts the list as part of 
	//a stream pipeline, and prints to the console
	public static void ordering1(List<Integer> list) {

		List<Integer> nos = list.stream().sorted(
						(o1, o2) -> {
							if (Math.abs(o1) == Math.abs(o2)) {
								return o1 - o2;
							} else {
								return Math.abs(o1) - Math.abs(o2);
							}
						}
		).collect(Collectors.toList());

//		List<Integer> nos = list.stream().sorted(Comparator.comparing(new Function<Integer, Integer>() {
//													  @Override
//													  public Integer apply(Integer integer) {
//														  return integer;
//													  }
//												  }, new Comparator<Integer>() {
//													  @Override
//													  public int compare(Integer o1, Integer o2) {
//														  return Math.abs(o1) - Math.abs(o2);
//													  }
//												  }
//		)
//
//	).collect(Collectors.toList());

		System.out.println(nos);
		
	}
	
	//Orders words by first reversing each and comparing 
	//in the usual way.  So 
	//    cba precedes bed
	//since
	//    cba.reverse() precedes bed.reverse()
	//in the usual ordering
	//Using this ordering, this method sorts the list as part of 
	//a stream pipeline, and prints to the console
	public static void ordering2(List<String> words) {


		List<String> list = words.stream().map( s -> (new StringBuffer(s).reverse().toString()) )
				.sorted()
				//.map(s -> (new StringBuffer(s).reverse().toString()) )
		.collect(Collectors.toList());

		System.out.println(list);

				
	}

}
