package lesson8.prob1b;

import java.util.function.Supplier;

public class Main1bPart1 {
    public static void main(String[] args) {
        Supplier<Double> rand = () -> Math.random();
        System.out.println(rand.get());
    }
}
