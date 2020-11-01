package tour_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProblemA {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int result = 0;

        int num = scan.nextInt();
        List<Operation> operations = new ArrayList<>();

        for (int i = scan.nextInt(); i > 0; i--) {
            operations.add(new Operation(scan.nextInt(), scan.nextInt()));
        }

        while (num > 0) {
            final int finalNum = num;
            Operation operation = operations.stream()
                    .max((o1, o2) -> Float.compare(o1.valuable(finalNum), o2.valuable(finalNum))).get();

            num -= operation.reducing;
            result += operation.money;
        }

        System.out.println(result);
    }

    private static class Operation {

        private final int reducing, money;

        private Operation(int reducing, int money) {
            this.reducing = reducing;
            this.money = money;
        }

        private float valuable(int num) {
            return (Math.min(reducing, num)) / (float) money;
        }

        @Override
        public String toString() {
            return "Operation{" +
                    "reducing=" + reducing +
                    ", money=" + money +
                    '}';
        }
    }
}
