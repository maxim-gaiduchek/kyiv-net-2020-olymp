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

        int palindromes = (int) counters.values().stream().filter(value -> value % 2 == 1).count();

        if (palindromes <= 1) {
            System.out.println(chars.length);
        } else {
            int pairs = chars.length - palindromes;

            System.out.println(pairs / (palindromes * 2) * 2 + 1);
        }
    }
}
