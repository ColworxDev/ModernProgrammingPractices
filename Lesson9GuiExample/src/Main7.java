import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Stream;

public class Main7 {

    public static void main(String[] args) {
        List<String> friends = Arrays.asList("Bob", "Benny", "Tom");
        List<String> fruits = Arrays.asList("Banana", "Kiwi", "Apple");

        BiFunction<List<String>, String, Stream<String>> streamStringStartsWith = (list, string) -> list.stream();
    }
}
