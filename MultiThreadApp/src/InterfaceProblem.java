import java.util.Arrays;
import java.util.stream.Collectors;

public class InterfaceProblem {

    public static void main(String[] args) {
        AB ab = new AB();

        Arrays.asList(1).stream().collect(Collectors.toSet())
        ab.myFun();

    }
    interface A {
        void myFun();
    }

    interface B {
        void myFun();
    }

    static class AB implements A, B {

        @Override
        public void myFun() {
            System.out.println("no error");
        }
    }
}
