import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Problem1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Computer> computers = new ArrayList<>();
        int N = scan.nextInt(), T = scan.nextInt();

        for (int i = 0; i < N; i++) {
            computers.add(new Computer(scan.nextInt(), scan.nextInt()));
        }
        computers.removeIf(c -> c.price > T);
        computers.sort(Comparator.comparingInt(c -> -c.coolness));
        System.out.println(computers.size() == 0 ? -1 : computers.get(0).coolness);
    }

    private static class Computer {

        private int price;
        private int coolness;

        public Computer(int price, int coolness) {
            this.price = price;
            this.coolness = coolness;
        }

        @Override
        public String toString() {
            return "Computer{" +
                    "price=" + price +
                    ", coolness=" + coolness +
                    '}';
        }
    }
}
