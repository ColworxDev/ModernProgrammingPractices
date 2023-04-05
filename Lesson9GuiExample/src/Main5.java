import java.util.Optional;
import java.util.stream.Stream;

public class Main5 {

    public static void main(String[] args) {
        Stream strings = Stream.of("A", "good", "day", "to", "write", "some", "Java");
        //System.out.println(strings.reduce("",  (x, y) -> x + "" + y));

        System.out.println(strings.reduce(  (x, y) -> x + "" + y));


    }
}
