package generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem3 {

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1, 2, 3, 4);

        reverse(arr);
    }

    public static void reverse(List<?> list) {
        updateList(list);
        System.out.println(list);
    }


    public static <T> List<T> updateList(List<T> list) {
        List<T> tmp = new ArrayList<T>(list);

        for (int i = 0; i < list.size(); i++) {
            list.set(i, tmp.get(list.size() - i- 1));

        }
        return tmp;
    }

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
