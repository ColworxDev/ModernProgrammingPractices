import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main6 {

    public static void main(String[] args) {
        Arrays.asList(10, 5, 22, 30)
                .stream()
                .sorted()
                .forEach(System.out::println);

//        Arrays.asList("Tom", "Jerry", "Kim", "Ali")
//                .stream()
//                .sorted()
//                .forEach(System.out::println);

        Arrays.asList("Tom", "Jerry", "Kim", "Ali")
                .stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);

        List<Employee> employees = Arrays.asList(
//                new Employee("Tim", 5000),
//                new Employee("Joe", 5000),
//                new Employee("Joe", 6000),
//                new Employee("Donald", 6000),
//                new Employee("Mickey", 6000)
        );




//        employees.stream().sorted(Comparator.comparing( e-> e.getName()))
//                .forEach(System.out::println);

//        employees.stream().sorted(Comparator.comparing( (Employee e)-> e.getName()).thenComparing( (Employee e) -> e.getSalary()))
//                .forEach(System.out::println);

//        employees.stream().sorted(Comparator.comparing( (Employee e)-> e.getName()).thenComparing( (Employee e) -> e.getSalary(), Comparator.reverseOrder()))
//                .forEach(System.out::println);

//        employees.stream().sorted(Comparator.comparing(Employee::getName).thenComparing(Employee::getSalary, Comparator.reverseOrder()))
//                .forEach(System.out::println);

        //find the total salary
//        int totalSalary = employees.stream().mapToInt(Employee::getSalary)
//                .sum();
//        System.out.println("totalSalary=" + totalSalary);

//        int minSalary = employees.stream().mapToInt(Employee::getSalary)
//                .min().getAsInt();
//        System.out.println("minSalary=" + minSalary);
//
//        Double averageSalary = employees.stream().mapToInt(Employee::getSalary)
//                .average().getAsDouble();
//
//        System.out.println("averageSalary=" + averageSalary);

        int minSalary = employees.stream().mapToInt(Employee::getSalary)
                .min().orElse(0);
        System.out.println("minSalary=" + minSalary);

        Double averageSalary = employees.stream().mapToInt(Employee::getSalary)
                .average().orElse(0.0);

        System.out.println("averageSalary=" + averageSalary);

    }
}

class Employee {


    private String name;
    private int salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }


    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
