package prob1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        probA();
        probB();
    }

    private static void probA() {
//        List<Integer> ints = new ArrayList<>();
//        ints.add(1);
//        ints.add(2);
//        //compiler error below because type mismatch for above must have same types
//        List<Number> nums = ints;
//        nums.add(3.14);
    }

    private static void probB() {
//        List<Integer> ints = new ArrayList<>();
//        ints.add(1);
//        ints.add(2);
//        List<? extends Number> nums = ints;
//        //compiler error below
//        nums.add(3.14);
    }
}
