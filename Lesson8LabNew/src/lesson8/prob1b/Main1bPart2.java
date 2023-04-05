package lesson8.prob1b;

import java.util.function.Supplier;

public class Main1bPart2 {
    public static void main(String[] args) {
        Supplier<Double> supplier = Math::random;
        System.out.println(supplier.get());

    }
}
