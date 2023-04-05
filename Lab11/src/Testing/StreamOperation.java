package Testing;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamOperation {

	public static Function<List<String>, List<String>> function = data -> data.stream() 
			.map(String::toUpperCase)
			.collect(Collectors.toList());
	
	public static void main(String[] args) {
		
	}

}
