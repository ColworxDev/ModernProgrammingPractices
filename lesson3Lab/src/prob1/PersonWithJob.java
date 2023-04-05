package prob1;

public class PersonWithJob {
	
	private double salary;
	private Person person;
	
	public double getSalary() {
		return salary;
	}
	PersonWithJob(String n, double s) {
		//super(n);
		salary = s;
		person = new Person(n);
	}
	
	public Person getPerson() {
		return person;
	}
	
	@Override
	public boolean equals(Object aPerson) {
		if (aPerson == null)
			return false;
		if (!(aPerson instanceof Person))
			return false;
		Person p = (Person) aPerson;
		boolean isEqual = this.person.getName().equals(p.getName());
		return isEqual;
	}

	public static void main(String[] args) {
		PersonWithJob p1 = new PersonWithJob("Joe", 30000);
		Person p2 = new Person("Joe");
		//As PersonsWithJobs, p1 should be equal to p2
		System.out.println("p1.equals(p2)? " + p1.equals(p2));
		//i changed like this to make both equal
		System.out.println("p2.equals(p1)? " + p2.equals(p1.getPerson()));
	}
	
	/*
	 1. p1.equals(p2)? false
		-> It's false on checking if p2 is instance of PersonWithJob object. The reason is that PersonWithJob class inherits
		Person class, which also means PersonWithJob is a Person but not in the other way around. Technically speaking,
		Person is not instance of PersonWithJob.
	2. p2.equals(p1)? true
		-> It's true because p1 which is an instance of PersonWithJob object is also Person object (by inheritance),
		not null, and name of p1 equalling p2.
	 * */


}
