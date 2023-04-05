import java.util.List;

public class Problem7 {

    public static void main(String[] args) {

    }

    public double calculateAverage2(List<Employee> employeeList) {
        return employeeList.stream()
                .mapToInt(a -> a.getSalary())
                .sum() / employeeList.size();
    }

    public double calculateAverage(List<Employee> employeeList) {
        int sum = 0;
        int count = 0;
        for (int i = 0; i < employeeList.size(); i++) {
            Employee employee = employeeList.get(i);
            sum += employee.getSalary();
            count++;
        }
        return (double) sum / count;
    }

    static class Employee {
        int salary;
        int id;
        String name;

        public Employee(int id, String name, int salary) {
            this.salary = salary;
            this.id = id;
            this.name = name;
        }

        public int getSalary() {
            return salary;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "salary=" + salary +
                    ", id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

}
