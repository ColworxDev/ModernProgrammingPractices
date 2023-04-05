package generics;

public class Main {

	public static void main(String [] args) {
		// before adding <Generic tag>
		GenericClass gc = new GenericClass(10);
		System.out.println(gc);
		GenericClass gc2 = new GenericClass(2.3);
		/*-------------------------------------------*/
		GenericClass<Integer> gci = new GenericClass<>(10);
		GenericClass<Float> gcf = new GenericClass<>(10f);
		/*-------------------------------------------*/
		GenericTwoParameters<Integer, String> gtp = new GenericTwoParameters<>(10, "mark");
		System.out.println(fun(gtp, gcf, 159));


	}
	
	public static <T,E> String fun(T t, E e, double d) {
		String res = "Hey !!";
		res += ("\n T = " + t.toString());
		res += ("\n E = " + e.toString());
		res += ("\n double = " + d);
		return res;
	}
}
