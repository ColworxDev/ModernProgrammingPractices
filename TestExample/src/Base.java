
public class Base extends Extension {

	public static void main(String[] args) {
		Extension b = new Base();
		b.print();
	}
	
	public void print() {
		System.out.print("from extension");
	}

}
