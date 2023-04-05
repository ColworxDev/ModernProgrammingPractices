import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Main6 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("one", "two", "three", "two");
        System.out.println(
                list.stream().collect(Collectors.toList())
        );

        System.out.println(
                list.stream().collect(Collectors.toSet())
        );

        System.out.println(
                list.stream().collect(Collectors.joining("-"))
        );

        TreeSet<String> treeSet = list.stream().collect(Collectors.toCollection(TreeSet::new));
        System.out.println(treeSet);


    }
}
