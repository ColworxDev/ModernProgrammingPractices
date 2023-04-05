package labs.prob4;

import java.math.BigInteger;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PrimeStream {

    private static final Supplier<Stream<BigInteger>> primes = () -> Stream
            .iterate(new BigInteger("2"),
                    n -> n.nextProbablePrime());


    public static void main(String[] args) {
        PrimeStream ps = new PrimeStream(); //PrimeStream is enclosing class
        
        ps.printFirstNPrimes(10);
        System.out.println("====");
        ps.printFirstNPrimes(5);

    }

    private void printFirstNPrimes(int limit) {
//        Supplier<Stream<BigInteger>> primes = () -> Stream
//                        n -> n.nextProbablePrime());
//                .iterate(new BigInteger("2"),


        System.out.println(primes.get().limit(limit)
                .collect(Collectors.toList()));
    }
}
