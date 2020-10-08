package tour_1;

import java.util.*;

public class ProblemC {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<Integer, Integer> counters = new HashMap<>();

        int n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            int apple = scan.nextInt();

            if (counters.containsKey(apple)) {
                counters.replace(apple, counters.get(apple) + 1);
            } else {
                counters.put(apple, 1);
            }
        }

        System.out.println(counters.values().stream().anyMatch(i -> i % 2 == 1) ? "Alice" : "Bob");
    }
}
