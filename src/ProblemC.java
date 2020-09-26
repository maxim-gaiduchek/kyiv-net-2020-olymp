import java.util.*;

public class ProblemC {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        List<Integer> apples = new ArrayList<>();
        Map<Integer, String> characters = new HashMap<>();
        int step = 1;

        for (int i = 0; i < n; i++) apples.add(scan.nextInt());
        characters.put(0, "Alice");
        characters.put(1, "Bob");

        final int[] min = new int[1];
        while (apples.size() > 0) {
            if (step == 0) step = 1;
            else step = 0;
            min[0] = apples.stream().mapToInt(Integer::intValue).min().getAsInt();

            apples.removeIf(a -> {
                if (a == min[0]) {
                    min[0]++;
                    return true;
                } else {
                    return false;
                }
            });
            System.out.println(apples);
        }

        System.out.println(characters.get(step));
    }
}
