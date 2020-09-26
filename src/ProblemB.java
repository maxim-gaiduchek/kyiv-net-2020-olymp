import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProblemB {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Coordinates start = new Coordinates(scan.nextInt(), scan.nextInt());
        Coordinates finish = new Coordinates(scan.nextInt(), scan.nextInt());
        int t = 0;
        List<Coordinates> steps = new ArrayList<>();



        output(t, steps);
    }

    private static void output(int t, List<Coordinates> steps) {
        System.out.println(t);
        steps.forEach(c -> System.out.println("\n" + c.x + " " + c.y));
    }

    private static class Coordinates {

        private final int x, y;

        private Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Coordinates)) return false;

            Coordinates that = (Coordinates) o;

            return this.x == that.x && this.y == that.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }
}
