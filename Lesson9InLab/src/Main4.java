import java.util.function.IntFunction;
import java.util.stream.Stream;

public class Main4 {

    public static void main(String[] args) {
         //"Welcome".chars().forEach((val) -> System.out.println(val));

        Stream<Character> characterStream = "Welcome".chars().mapToObj( val -> (char) val );
        Stream<Character> characterStream1 = " to MPP".chars().mapToObj( val -> (char) val );
                //.forEach((val) -> System.out.println(val));

        //"to MPP".chars().mapToObj( val -> (char) val );
                //.forEach((val) -> System.out.println(val));

        Stream.concat(characterStream, characterStream1).forEach(System.out::println);



    }
}
