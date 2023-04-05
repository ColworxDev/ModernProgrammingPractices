package generics;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
        List<? super B> list1;
        List<? extends B> list2;
        List<?> list3;
        A objA = new A();
        B objB = new B();
        C objC = new C();
        D objD = new D();
        
        //objB = (B)objA;
        objA = objB;
        
        List<A> listA = new ArrayList<>();
        List<B> listB = new ArrayList<>();
        List<C> listC = new ArrayList<>();
        List<D> listD = new ArrayList<>();

        


        list1 = listA;
        list1 = listB;
        list1 = listC;
        list1 = listD;

        list1.add(objA);
        list1.add(objB);
        list1.add(objC);
        list1.add(objD);

        list2.add(objB);
        list2.add(objA);
        list2.add(objC);
        list2.add(objD);


        list3.add(objB);
        list3.add(objA);
        list3.add(objC);
        list3.add(objD);


    }

    static public class A {

    }

    static public class B extends A {

    }

    static public class C extends B {

    }

    static public class D extends C {

    }

}
