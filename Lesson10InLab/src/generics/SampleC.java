package generics;

//non generic extends generic class
public class SampleC extends SampleA<Integer>{
    private Integer x;

    public SampleC(Integer i) {
        super(i);
    }
}
