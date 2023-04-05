package generics;

public class GenericClass<A> {

	private A i; // parameter type variable

	public GenericClass(A i) {
		super();
		this.i = i;
	}

	public A getI() {
		return i;
	}

	public void setI(A i) {
		this.i = i;
	}
	
	// cannot create generic static method -> cause error
	/*
	public static void test(A v) {
		
	}
	*/
	
	// extended type parameter4
	// A can be number or any sub class of Number
	public <X extends Number> void fun(X a) { // Number is super class to all number classes (Integer, Double...)

		System.out.println(a.intValue());
	}


	public static  <X extends Number> void fun2(X a) { // Number is super class to all number classes (Integer, Double...)

		System.out.println(a.intValue());
	}
	
	@Override
	public String toString() {
		return "GenericClass [i=" + i + "]";
	}

}
