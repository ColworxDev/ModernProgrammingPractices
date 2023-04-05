import java.util.*;
import java.util.function.Function;

public class Problem3 { }
//    public static void main(String[] args) {
//
//
//
//        List<Employee> list = Arrays.asList(
//                new Employee(101, "Joe", 50000),
//                new Employee(102, "Jim", 60000));
//        Map<String, Employee> map = emplistToMap(list);
//
//
//        System.out.println(map.get("Joe"));
//        //returns the Employee object having name "Joe"
//        System.out.println(map.get("Jim"));
//        //returns the Employee object having name "Jim"
//
//
//    }
//
//
//
////    static <T> Map<?, T> createMap(List<T> list, Function<T , ?> f) {
////        List<T> t = new ArrayList<>();
////        f.apply(t.get(0));
////        return createMapHelper(list, f);
////    }
//
//    static <T, A> Map<A, T> createMap(List<T> list, Function<? super T, A> f) {
//        HashMap<A, T> h = new HashMap<>();
//        for (T s: list) {
//            h.put(f.apply(s), s);
//        }
//        return h;
//    }
//
//    public Map<Object, Employee> empListToMap(List<Employee> emps) {
//        return  createMap(emps, p -> p.getName());
//    }
//
//    public Map<Number, CheckingAccount> checkingAcctListToMap(List<CheckingAccount> list) {
//        return createMap(list, a -> a.getAccId());
//    }
//
//    static Map<String, Employee> emplistToMap(List<Employee> emps) {
//        return  createMap(emps, e -> e.getName());
//    }
//
//
//}
//
//class Person {
//
//    int salary;
//    String name;
//
//    public Person(int salary, String name) {
//        this.salary = salary;
//        this.name = name;
//    }
//
//
//    public int getSalary() {
//        return salary;
//    }
//
//
//    public String getName() {
//        return name;
//    }
//
//}
//
//class Employee {
//    int salary;
//    int id;
//    String name;
//
//    public Employee(int id, String name, int salary) {
//        this.salary = salary;
//        this.id = id;
//        this.name = name;
//    }
//
//    public int getSalary() {
//        return salary;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    @Override
//    public String toString() {
//        return "Employee{" +
//                "salary=" + salary +
//                ", id=" + id +
//                ", name='" + name + '\'' +
//                '}';
//    }
//}
//
//class Account {
//    String accId;
//
//    public Account(String accId) {
//        this.accId = accId;
//    }
//
//    public String getAccId() {
//        return accId;
//    }
//}
//
//class CheckingAccount extends Account {
//    public CheckingAccount(String accId) {
//        super(accId);
//    }
//}