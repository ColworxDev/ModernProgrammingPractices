import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.Stream;

public class Main2 {

    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("Apple", "Orange", "Mango");
        
        Stream<String> stream = fruits.stream();

//        String s[] = stream.toArray(new IntFunction<String[]>() {
//            @Override
//            public String[] apply(int value) {
//                return new String[value];
//            }
//        });
//
//        String s2[] = stream.toArray(value -> new String[value]);

        //Converted a list to String Array
        String s3[] = stream.toArray(String[]::new);

        System.out.println(Arrays.toString(s3));



    }
}
