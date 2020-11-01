package tour_3;

import java.math.BigInteger;
import java.util.*;

public class ProblemB {

    public static void main(String[] args) {
        BigInteger integer = new BigInteger(new Scanner(System.in).next());

        if (integer.isProbablePrime(1)) {
            System.out.print(integer);
            System.exit(1);
        }

        List<BigInteger> toAdd = new ArrayList<>();

        while (integer.compareTo(BigInteger.ZERO) > 0) {
            BigInteger biggestPrime = prevProbablePrime(integer);

            while (integer.subtract(biggestPrime).equals(BigInteger.ONE)) {
                biggestPrime = prevProbablePrime(biggestPrime);
            }

            while (integer.compareTo(biggestPrime) >= 0) {
                integer = integer.subtract(biggestPrime);
                toAdd.add(biggestPrime);
            }
            if (integer.isProbablePrime(1)) {
                toAdd.add(integer);
                break;
            }
        }

        Collections.sort(toAdd);
        System.out.print(toAdd.get(0));
        toAdd.remove(0);
        toAdd.forEach(i -> System.out.print("+" + i));
    }

    private static BigInteger prevProbablePrime(BigInteger integer) {
        BigInteger biggestPrime = new BigInteger(integer.subtract(BigInteger.ONE).toString());

        for (; biggestPrime.compareTo(BigInteger.ONE) > 0; biggestPrime = biggestPrime.subtract(BigInteger.ONE)) {
            if (biggestPrime.isProbablePrime(1)) break;
        }

        return biggestPrime;
    }
}
