import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main5 {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Tom", "Jerry", "Jim", "Tim", "Joe");
//        names.stream()
//                .filter(new Predicate<String>() {
//                    @Override
//                    public boolean test(String s) {
//                        return s.startsWith("J");
//                    }
//                })
//                .forEach(System.out::println);

//        names.stream()
//                .filter(s -> s.startsWith("J"))
//                .map(new Function<String, Object>() {
//
//                    @Override
//                    public Object apply(String s) {
//                        return s.toUpperCase();
//                    }
//                })
//                .forEach(System.out::println);

        names.stream()
                .filter(s -> s.startsWith("J"))
                .map( s -> s.toUpperCase())
                .filter(s -> s.length() > 3)
                .forEach(System.out::println);
    }
}
