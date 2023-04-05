package generics;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Problem2 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3,4);

        System.out.println(max(list));
    }

//    public static Integer max(List<Integer> list) {
//        Integer max = list.get(0);
//        for(Integer i : list) {
//            if(i.compareTo(max) > 0) {
//                max = i;
//            }
//        }
//        return max;
//    }

    public static <T extends Comparable<T>> T max(List<T> list) {
        T max = list.get(0);
        for(T i : list) {
            if(i.compareTo(max) > 0) {
                max = i;
            }
        }
        return max;
    }
}
