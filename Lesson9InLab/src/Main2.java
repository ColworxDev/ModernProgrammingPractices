import java.nio.file.LinkPermission;
import java.util.Arrays;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class Main2 {

    public static void main(String[] args) {
        IntStream intStream = Arrays.stream(new int[] {1, 2, 3, 4});
        //System.out.println(intStream.count());

        //returns 10
        //System.out.println(intStream.sum());

        //intStream.forEach((value) -> System.out.println(value));
        intStream.forEach(System.out::println);
//        intStream.forEach(new IntConsumer() {
//            @Override
//            public void accept(int value) {
//                System.out.println(value);
//            }
//        });


    }
}
