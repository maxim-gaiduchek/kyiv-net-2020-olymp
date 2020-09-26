import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProblemB {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int xS = scan.nextInt(), yS = scan.nextInt();
        int xF = scan.nextInt(), yF = scan.nextInt();
        int xK = xS, yK = yS;
        List<Coordinates> steps = new ArrayList<>();

        if (xF - xS == 0) {
            for (int y = yS; y <= yF; y++) {
                yK = y;
                steps.add(new Coordinates(xK, yK));
            }

            xK++;
            steps.add(new Coordinates(xK, yK));
            for (int y = yF - 1; y >= yS; y--) {
                yK = y;
                steps.add(new Coordinates(xK, yK));
            }
            xK--;
            steps.add(new Coordinates(xK, yK));

            xK--;
            steps.add(new Coordinates(xK, yK));
            for (int y = yS; y <= yF; y++) {
                yK = y;
                steps.add(new Coordinates(xK, yK));
            }
            xK++;
            steps.add(new Coordinates(xK, yK));

            yK++;
            steps.add(new Coordinates(xK, yK));
            xK++;
            steps.add(new Coordinates(xK, yK));
            xK++;
            steps.add(new Coordinates(xK, yK));
            for (int y = yF; y >= yS - 1; y--) {
                yK = y;
                steps.add(new Coordinates(xK, yK));
            }
            xK--;
            steps.add(new Coordinates(xK, yK));
            xK--;
            steps.add(new Coordinates(xK, yK));
            yK++;
            steps.add(new Coordinates(xK, yK));
        } else if (yF - yS == 0) {
            for (int x = xS; x <= xF; x++) {
                xK = x;
                steps.add(new Coordinates(xK, yK));
            }

            yK++;
            steps.add(new Coordinates(xK, yK));
            for (int x = xF - 1; x >= xS; x--) {
                xK = x;
                steps.add(new Coordinates(xK, yK));
            }
            yK--;
            steps.add(new Coordinates(xK, yK));

            yK--;
            steps.add(new Coordinates(xK, yK));
            for (int x = xS; x <= xF; x++) {
                xK = x;
                steps.add(new Coordinates(xK, yK));
            }
            yK++;
            steps.add(new Coordinates(xK, yK));

            xK++;
            steps.add(new Coordinates(xK, yK));
            yK++;
            steps.add(new Coordinates(xK, yK));
            yK++;
            steps.add(new Coordinates(xK, yK));
            for (int x = xF; x >= xS - 1; x--) {
                xK = x;
                steps.add(new Coordinates(xK, yK));
            }
            yK--;
            steps.add(new Coordinates(xK, yK));
            yK--;
            steps.add(new Coordinates(xK, yK));
            xK++;
            steps.add(new Coordinates(xK, yK));
        } else {
            for (int x = xS; x <= xF; x++) {
                xK = x;
                steps.add(new Coordinates(xK, yK));
            }
            for (int y = yS + 1; y <= yF; y++) {
                yK = y;
                steps.add(new Coordinates(xK, yK));
            }

            for (int x = xF - 1; x >= xS; x--) {
                xK = x;
                steps.add(new Coordinates(xK, yK));
            }
            for (int y = yF - 1; y >= yS; y--) {
                yK = y;
                steps.add(new Coordinates(xK, yK));
            }

            yK--;
            steps.add(new Coordinates(xK, yK));
            for (int x = xS + 1; x <= xF + 1; x++) {
                xK = x;
                steps.add(new Coordinates(xK, yK));
            }
            for (int y = yS; y <= yF; y++) {
                yK = y;
                steps.add(new Coordinates(xK, yK));
            }
            xK--;
            steps.add(new Coordinates(xK, yK));

            yK++;
            steps.add(new Coordinates(xK, yK));
            for (int x = xF - 1; x >= xS - 1; x--) {
                xK = x;
                steps.add(new Coordinates(xK, yK));
            }
            for (int y = yF; y >= yS; y--) {
                yK = y;
                steps.add(new Coordinates(xK, yK));
            }
            xK++;
            steps.add(new Coordinates(xK, yK));
        }

        System.out.println(steps);

        output(steps);
    }
    /*
2 2
7 6

2 2
3 3

2 2
8 2

3 3
3 6
     */

    private static void output(List<Coordinates> steps) {
        System.out.print(steps.size());
        steps.forEach(c -> System.out.print("\n" + c.x + " " + c.y));
    }

    private static class Coordinates {

        private final int x, y;

        private Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + x + "; " + y + ")";
        }

        @Override
        public boolean equals(Object o) {
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
