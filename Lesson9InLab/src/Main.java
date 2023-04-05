import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        Stream<Integer> integerStream = Stream.of(1, 2, 3);
        System.out.println(integerStream.count());

        Stream<String> stringStream = Stream.of("Monday", "Tuesday", "Wednesday");
        System.out.println(stringStream.count());
        //😃stream has already been operated upon or closed
        //System.out.println(stringStream.count());

        Stream<String> stream = Arrays.asList("one", "two").stream();

        Stream<int[]> stream1 = Stream.of(new int[] { 1, 2, 3});

        System.out.println(stream1.count());

        System.out.println("Hello world!");
    }
}