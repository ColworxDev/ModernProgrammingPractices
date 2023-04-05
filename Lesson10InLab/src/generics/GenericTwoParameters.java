package generics;

public class GenericTwoParameters<T, E> {

	private T i;
	private E j;

	public GenericTwoParameters(T i, E j) {
		super();
		this.i = i;
		this.j = j;
	}

	public T getI() {
		return i;
	}

	public void setI(T i) {
		this.i = i;
	}

	public E getJ() {
		return j;
	}

	public void setJ(E j) {
		this.j = j;
	}

	@Override
	public String toString() {
		return "GenericTwoParameters [i=" + i + ", j=" + j + "]";
	}

}
