import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main4 {

    public static void main(String[] args) {
        //Optional.ofNullable()

        User user = null;
        Optional<User> optional = Optional.ofNullable(user);

        List<String> list = Arrays.asList("one", null, "two", "three");
        //NullPointerException: Cannot invoke "String.toUpperCase()" because "data" is null
//        list.stream()
//                .map(data -> data.toUpperCase())
//                .filter(data -> data.startsWith("t"))
//                .collect(Collectors.toList())
//                .forEach(System.out::println);
        list.stream()
                .map(data -> Optional.ofNullable(data).orElse("empty").toUpperCase())
                .filter(data -> data.startsWith("T"))
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }


}

class User {

}
