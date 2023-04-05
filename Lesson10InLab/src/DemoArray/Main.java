package DemoArray;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    static <T extends Number> T[] func(T t) {
        T arrayT[] = null; //do not instantiate as new T[5]


        //arrayT = Array.newInstance(Integer.class, 5);

        arrayT = (T[]) Array.newInstance(t.getClass(), t.intValue());

        return arrayT;

    }

    public static void main(String[] args) {
        Integer intArray[] = func(5);
        System.out.println(intArray.length);
        Float floatArray[] = func(2.3f);
        System.out.println(floatArray.length);

    }
}
