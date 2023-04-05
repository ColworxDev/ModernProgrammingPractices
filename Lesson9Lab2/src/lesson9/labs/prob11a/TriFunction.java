package lesson9.labs.prob11a;

import java.awt.*;
import java.util.List;

@FunctionalInterface
public interface TriFunction<S,T,U,R> {
	R apply(S s, T t, U u);
}

class Sample<X extends TriFunction<String, String, String, String>> {
	public X a;


	public Sample(X a) {
		this.a = a;

		a.apply("", "", "");
	}
}

class Sample2<Y extends Sample, Z extends List> {
	private Y a;
	private Z abc;


	public Sample2(Y a) {
		this.a = a;
		this.abc.add("");
		a.a.apply("", "" , "");
	}
}