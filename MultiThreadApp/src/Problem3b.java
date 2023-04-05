import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class Problem3b {


        public static void main(String[] args) {
            List<Employee> list = Arrays.asList(
                    new Employee(101, "Joe", 50000),
                    new Employee(102, "Jim", 60000)
            );
            Map<String, Employee> map = empListToMap2(list);
            System.out.println("======" + map);
            System.out.println(map.get("Joe"));
        }

        private static Map<String, Employee> empListToMap2(List<Employee> list) {
            return (Map<String, Employee>) createMap(list, e -> e.getName());
        }

        private static <T, A> Map<A, T> createMap(List<T> list, Function<? super T, A> f) {
            HashMap<A, T> h = new HashMap<>();
            for (T s : list) {
                h.put(f.apply(s), s);
            }
            return h;
        }

        public Map<Object, Employee> empListToMap(List<Employee> emps) {
            return createMap(emps, (Person p) -> p.getName());
        }

        public Map<Number, CheckingAccount> checkingAcctListToMap(List<CheckingAccount> list) {
            return createMap(list, (Account a) -> a.getAcctId());
        }
    }
    class CheckingAccount extends Account{
        CheckingAccount(String n){
            super(n);

        }
    }
    class Account{
        String accountId;
        Account(String n){
            accountId = n;
        }
        public int getAcctId(){
            return Integer.parseInt(accountId);
            // accountId;
        }
    }