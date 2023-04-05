import java.util.Arrays;
import java.util.Optional;

public class Main3 {

    public static void main(String[] args) {

        Optional optional = Optional.empty();
        System.out.println(optional);

        Optional optional1 = Optional.of(10);
        System.out.println(optional1);

        System.out.println(optional.isEmpty());
        System.out.println(optional.isPresent());

        Optional<Integer> optionalInteger = Arrays.asList(1, 2, 3, 4)
        //Optional<Integer> optionalInteger = Arrays.asList()
                .stream() //Stream<Integer>
                .findAny();

//        System.out.println(optionalInteger.isPresent());
//        if(optionalInteger.isPresent()) {
//            System.out.println(optionalInteger.get());
//        }
        //System.out.println(optionalInteger.orElse(0));

        //what is diff b/w orElse and orElseGet
        // orElse return value is ignore but function is executed
        // orElseGet function will be called only if no value exists
//        System.out.println(optionalInteger.orElse(myFun()));
        System.out.println(optionalInteger.orElseGet(() -> myFun()));
    }

    static int myFun() {
        System.out.println("i m called");
        return 0;
    }
}
