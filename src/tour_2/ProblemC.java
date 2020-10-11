package tour_2;

import java.util.*;

public class ProblemC {

    public static void main(String[] args) {
        char[] chars = new Scanner(System.in).next().toCharArray();
        Map<Character, Integer> counters = new HashMap<>();

        for (char ch : chars) {
            if (counters.containsKey(ch)) {
                counters.replace(ch, counters.get(ch) + 1);
            } else {
                counters.put(ch, 1);
            }
        }

        int odds = (int) counters.entrySet().stream().filter(entry -> entry.getValue() % 2 == 1).count();

        if (odds <= 1) {
            System.out.println(chars.length);
            System.exit(2);
        }

        int pairs = counters.values().stream().mapToInt(Integer::intValue).sum() - odds;

        System.out.println();
        System.out.println((int) Math.floor((double) pairs / odds) - pairs % odds + 1);
    }
}
