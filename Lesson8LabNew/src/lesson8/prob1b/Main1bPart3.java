package lesson8.prob1b;

import java.util.function.Supplier;

public class Main1bPart3 {
    public static void main(String[] args) {
        Main1bPart3 obj = new Main1bPart3();
        Supplier<Double> supplier = obj.new MySupplier();
        System.out.println(supplier.get());
    }

    class MySupplier implements Supplier<Double> {
        @Override
        public Double get() {
            return Math.random();
        }
    }
}
