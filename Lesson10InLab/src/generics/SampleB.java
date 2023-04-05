package generics;

public class SampleB<T, U> extends SampleA<T> {



    private U j;

    public SampleB(T i, U j) {
        super(i);
        this.j = j;
    }

    public U getJ() {
        return j;
    }

}
