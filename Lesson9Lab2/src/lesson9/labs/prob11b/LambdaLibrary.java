package lesson9.labs.prob11b;

import java.util.List;
import java.util.stream.Collectors;

public class LambdaLibrary {
    public static final TriFunction<List<Employee>, Integer, String, List<String>> filterExpression =
            (list, salary, nameRegex) -> {

//            return list.stream().
//                    filter(av -> av.getSalary() > salary)
//                    .filter(va -> va.lastName.matches(nameRegex))
//                    .map(emp -> emp.fullName()).sorted()
//                    .collect(Collectors.toList());

                return list.stream().
                        filter(av -> av.getSalary() > salary)
                        .filter(va -> va.lastName.matches(nameRegex))
                        .map(Employee::fullName).sorted()
                        .collect(Collectors.toList());
    };
}
