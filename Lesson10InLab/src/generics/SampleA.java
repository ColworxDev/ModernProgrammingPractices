package generics;

public class SampleA <T> {


    T i;

    public SampleA(T i) {
        this.i = i;
    }


    public T getI() {
        return i;
    }

    public void setI(T i) {
        this.i = i;
    }

}

