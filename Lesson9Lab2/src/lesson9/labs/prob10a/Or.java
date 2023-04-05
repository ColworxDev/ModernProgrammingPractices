package lesson9.labs.prob10a;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Or {

	public static void main(String[] args) {
		List<Simple> list = Arrays.asList(new Simple(false),
				new Simple(false), new Simple(true));
		Or obj = new Or();
		//Part a
		System.out.println(obj.someSimpleIsTrue(list));


		//Part b
		Stream<String> stringStream = Stream.of("Bill", "Thomas", "Mary");
		//expected output -> Bill, Thomas, Mary
		System.out.println(stringStream.reduce((a, b) -> a + ", " + b).get());

		//Part c
		IntSummaryStatistics myIntStream = IntStream.iterate(1, n -> n + 1).limit(50).summaryStatistics();
		//IntSummaryStatistics myIntStream = Stream.of(1, 2, 3, 4, 5, 6, 7,)
		//		.collect(Collectors.summarizingInt(Integer::intValue));
		System.out.println("myIntStream max: " +  myIntStream.getMax() + " min: " + myIntStream.getMin());



	}
	
	public boolean someSimpleIsTrue(List<Simple> list) {
		return list.stream().reduce((a, b) -> a.flag || b.flag ? b : a).get().flag;
//		boolean accum = false;
//		for(Simple s: list) {
//			accum = accum || s.flag;
//		}
//		return accum;
	}

}
