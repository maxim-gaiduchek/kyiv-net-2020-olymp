package tour_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProblemE {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(), m = scan.nextInt(), k = scan.nextInt();

        if (m + k - 1 > n) {
            System.out.print(-1);
        } else if (m == 1) {
            if (n == k) {
                for (int i = n; i >= 1; i--) System.out.print(i + " ");
            } else {
                System.out.print(-1);
            }
        } else if (k == 1) {
            if (n == m) {
                for (int i = 1; i <= n; i++) System.out.print(i + " ");
            } else {
                System.out.print(-1);
            }
        } else {
            List<Integer> numbers = new ArrayList<>();

            for (int i = 1; i <= n; i++) numbers.add(i);

            for (int i = n - m + 1; i <= n; i++) {
                System.out.print(i + " ");
                numbers.remove(Integer.valueOf(i));
            }
            for (int i = k - 1; i >= 1; i--) {
                System.out.print(i + " ");
                numbers.remove(Integer.valueOf(i));
            }

            boolean isMax = true;
            Integer num;
            while (!numbers.isEmpty()) {
                if (isMax) {
                    num = numbers.stream().max(Integer::compare).orElse(-1);
                    isMax = false;
                } else {
                    num = numbers.stream().min(Integer::compare).orElse(-1);
                    isMax = true;
                }
                System.out.print(num + " ");
                numbers.remove(num);
            }
        }
    }
}
