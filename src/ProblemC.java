import java.util.*;

public class ProblemC {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        List<Integer> apples = new ArrayList<>();
        Map<Integer, Integer> counters = new HashMap<>();

        for (int i = 0; i < n; i++) {
            apples.add(scan.nextInt());
        }

        for (int apple : apples) {
            if (counters.containsKey(apple)) {
                counters.replace(apple, counters.get(apple) + 1);
            } else {
                counters.put(apple, 1);
            }
        }

        System.out.println(counters.values().stream().anyMatch(i -> i % 2 == 1) ? "Alice" : "Bob");
    }
}
