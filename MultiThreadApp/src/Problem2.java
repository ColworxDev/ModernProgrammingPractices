import java.util.*;
import java.util.stream.Collectors;

public class Problem2 {
    public static void main(String[] args) {


        Set<String> hSet1 = new HashSet<String>(Arrays.asList("A", "B"));
        Set<String> hSet2 = new HashSet<String>(Arrays.asList("D"));
        Set<String> hSet3 = new HashSet<String>(Arrays.asList("1", "3", "5"));
        List<Set<String>> sets = Arrays.asList(hSet1, hSet2, hSet3);
        Set<String> output = union(sets);
        System.out.println(output);

    }


    //Example: The union method should transform the list [{“A”, “B”}, {“D”}, {“1”, “3”, “5”}] to the set
    // {“A”, “B”, “D”, “1”, “3”, “5”}.
    public static Set<String> union(List<Set<String>> sets) {

        return sets
                .stream().map((x) -> new LinkedHashSet(x))
                .reduce((a,b) -> {
                    a.addAll(b);
                    return a;
                }).get();
    }
}
