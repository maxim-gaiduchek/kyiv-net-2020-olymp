package tour_2;

import java.util.Scanner;

public class ProblemA {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        long l = scan.nextLong(), r = scan.nextLong();
        long size = 0;

        for (long i = l; i <= r; i *= 2, size++) {}

        System.out.println(size);
    }
}
