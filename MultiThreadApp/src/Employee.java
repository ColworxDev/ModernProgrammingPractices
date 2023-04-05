public class Employee extends Person{
    int id;
    String name;
    int salary;

    public Employee(int i, String n, int s){
        super(n);
        id = i;
        name = n;
        salary = s;
    }
   
    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        final int prime = 31;
        long result = prime +name.hashCode()+id+salary;

        return (int)result;
    }
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSalary() {
        return this.salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", salary='" + getSalary() + "'" +
            "}";
    }

}
