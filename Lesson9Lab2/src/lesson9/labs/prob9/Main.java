package lesson9.labs.prob9;

import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        printSquares(4);
    }


//    public static void printSquares(int num)
//    which creates an IntStream using the iterate method.
//    The method prints to the console the first num squares.
//    For instance, if num = 4, then your method would output 1, 4, 9, 16.
//    Note: You will need to come up with a function to be used in the
//    second argument of iterate. Do not use the map or filter operations on Stream.

    public static void printSquares(int num) {
        //w/o using map or filter
        IntStream.iterate(1, n -> n + 1)
                .limit(num)
                .forEach(s -> System.out.print(s*s + ((s != num) ? ", " : ".")));
    }
}
