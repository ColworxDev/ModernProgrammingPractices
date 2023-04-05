package prob5;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static Object secondSmallest(List<?> list) {
        return secondSmallestHelper(list);
    }

    public static <T> Object secondSmallestHelper(List<T> list) {
        return list.stream().sorted().skip(list.size() > 1 ? 1 : 0).findFirst().get();
    }

    public static void main(String[] args) {
        List<Integer> ints = Arrays.asList(5, 3, 2, 5, 2, 1, 0, 2, 4, 2, 4);
        System.out.println(secondSmallest(ints));
    }
}
