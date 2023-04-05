package prob3;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ForEachExample {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		List<String> list = Arrays.asList("Hello there", "Goodbye", "Back soon", "Away", "On Vacation",
				"Everywhere you want to be");

		// print each element of the list in upper case format
		list.forEach(new MyConsumer()); // (s -> System.out.println(s.toUpperCase())

	}

	public static String toUpper(String s) {
		return s.toUpperCase();
	}

	// implement a Consumer

	static class MyConsumer implements Consumer<String> {
		public void accept(String s) {
			System.out.println(s.toUpperCase());
		}
	}

}