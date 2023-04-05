import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FilterMain {

	public FilterMain() {
		// TODO Auto-generated constructor stub
	}
	
	


    static class Employee {
    	
    	
		long id;
    	String firstName;
    	String lastName;
    	int age;
    	
    	
    	public Employee(long id, String firstName, String lastName, int age) {
			
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.age = age;
		}
    	
    	
    }
    
    static class Util {
    	
    	public static <T> List<T> filterMapEmployeeGen(List<Employee> list){
            List<T> names = new ArrayList<>();
            List<String> names2 = new ArrayList<>();
            for(Employee e: list){
                if(e.age>20){
                    names2.add(
                        e.firstName
                    );
                }
            }
            names.addAll((Collection<? extends T>) names2);
            return names;
        }
    	
//    	public static <?> List<T> filterMapEmployee(List<Employee> list) {
//    		
//    		List<?> names = new ArrayList<>();
//    		for(Employee e : list) {
//    			if(e.age > 20) {
//    				names = addHelper(list, e.firstName);
//    				//names.add(e.firstName);
//    			}
//    		}
//    		
//    		return names;
//    		
//    	}
//    	
//    	public static <T> List<T> addHelper(List<T> list, T item) {
//    		list.add(item);
//    		return list;
//    		
//    	}
    	
//    	public static List<String> filterMapEmployee(List<Employee> list) {
//    		
//    		List<String> names = new ArrayList<>();
//    		for(Employee e : list) {
//    			if(e.age > 20) {
//    				names.add(e.firstName);
//    			}
//    			
//    		}
//    		
//    		return names;
//    		
//    	}
    }

}
