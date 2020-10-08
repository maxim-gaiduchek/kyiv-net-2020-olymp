package tour_1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ProblemA {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Computer> computers = new ArrayList<>();
        int n = scan.nextInt(), t = scan.nextInt();

        for (int i = 0; i < n; i++) computers.add(new Computer(scan.nextInt(), scan.nextInt()));

        computers.removeIf(c -> c.price > t);
        computers.sort(Comparator.comparingInt(c -> -c.coolness));
        System.out.println(computers.size() == 0 ? -1 : computers.get(0).coolness);
    }

    private static class Computer {

        private final int price;
        private final int coolness;

        private Computer(int price, int coolness) {
            this.price = price;
            this.coolness = coolness;
        }
    }
}
