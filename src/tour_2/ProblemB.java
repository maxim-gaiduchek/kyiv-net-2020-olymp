package tour_2;

import java.util.Scanner;

public class ProblemB {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int a = scan.nextInt(), b = scan.nextInt(), c = scan.nextInt();

        System.out.println(Math.min(Math.abs(a - b), Math.abs(a - c)) * 2);
    }
}
