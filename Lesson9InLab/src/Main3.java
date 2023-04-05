import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main3 {

    public static void main(String[] args) {
        Stream.generate(new Supplier<Double>() {

            @Override
            public Double get() {
                return Math.random();
            }
        })
                .limit(5)
                .forEach(System.out::println);

        Stream.generate(() -> Math.random())
                .limit(5)
                .forEach(System.out::println);


        //UnaryOperator --> Function operation

//        List<Integer> list = Stream.iterate(10, new UnaryOperator<Integer>() {
//            @Override
//            public Integer apply(Integer integer) {
//                return integer + integer;
//            }
//        }).limit(4)
//                .collect(Collectors.toList());
        //To collect in list part
        //.collect(Collectors.toList());

        //Change to lamda
        List<Integer> list2 = Stream.iterate(10, val -> val+val).limit(4)
                .collect(Collectors.toList());
        System.out.println(list2);


        //for iterate stream limit is optional
        Stream.iterate(5,  //seed value
                new Predicate<Integer>() { // predicate
            @Override
            public boolean test(Integer integer) {
                return false;
            }
        }, new UnaryOperator<Integer>() { //unary operator
            @Override
            public Integer apply(Integer integer) {
                return null;
            }
        });
    }
}
