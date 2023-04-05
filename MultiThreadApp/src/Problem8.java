import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Problem8 {

    public static void main(String[] args) {
        System.out.println(primes(50));
    }

    static List<Integer> primes (int n) {
        return Stream.iterate( 2, i -> i + 1)
                .filter(i -> isPrime(i))
                .limit (n).collect(Collectors.toList());
    }

    static Boolean isPrime(int candidate) {
        int candidateRoot = (int) Math.sqrt((double) candidate);
        return IntStream.rangeClosed(2, candidateRoot) //IntStream
            .noneMatch(
                    i -> candidate % i == 0
            );
    }

}
