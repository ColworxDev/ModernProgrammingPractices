import java.util.ArrayList;
import java.util.stream.Stream;

public class Problem1 {
    //IMPLEMENT - you must use the reduce operation on Streams
    public static <T> ArrayList<T> combine(Stream<ArrayList<T>> stream) {


        return stream.reduce((a, b) -> {
                    a.addAll(b);
                    return a;
                }

                ).get();
    }

    //expected
    //linkedhashset for ordered output
    //"A" , "B", "C", "D"

    public static void testCombine() {
        ArrayList<ArrayList<String>> mainList = new ArrayList<>();
        ArrayList<String> list1 = new ArrayList<String>() {
            {
                add("hello");add("there");
            }
        };
        ArrayList<String> list2 = new ArrayList<String>() {
            {
                add("goodbye");add("there");
            }
        };
        mainList.add(list1);
        mainList.add(list2);
        System.out.println(combine(mainList.stream()));
    }
    public static void main(String[] args) {
        testCombine();
    }
}
