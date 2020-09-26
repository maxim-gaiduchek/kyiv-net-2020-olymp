import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProblemB {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Coordinates start = new Coordinates(scan.nextInt(), scan.nextInt());
        Coordinates finish = new Coordinates(scan.nextInt(), scan.nextInt());
        Coordinates cur = new Coordinates(start), aim = start;
        int t = 0, stepsOnSF = 1;
        List<Coordinates> steps = new ArrayList<>();

        while (stepsOnSF < 2) {
            int quarter = getQuarter(aim, cur);

            if (!steps.contains(new Coordinates(cur.x + 1, cur.y))) {
                cur.x += 1;
            } else if (!steps.contains(new Coordinates(cur.x, cur.y + 1))) {
                cur.y += 1;
            }

            steps.add(new Coordinates(cur));
            t++;
            if (cur.equals(start) && cur.equals(finish)) {
                stepsOnSF++;
                if (aim.equals(start)) aim = finish;
                else aim = start;
            }
            outputMap(start, finish, cur, steps);
        }

        steps.add(start);
        output(t, steps);
    }

    private static int getQuarter(Coordinates center, Coordinates point) {
        int deltaX = point.x - center.x, deltaY = point.y - center.y;

        if (deltaX >= 0 && deltaY >= 0) return 1;
        else if (deltaX < 0 && deltaY >= 0) return 2;
        else if (deltaX < 0) return 3;
        else return 4;
    }

    private static void outputMap(Coordinates start, Coordinates finish, Coordinates cur, List<Coordinates> steps) {
        System.out.println();
        for (int y = start.y; y <= finish.y; y++) {
            for (int x = start.x; x <= finish.x; x++) {
                Coordinates temp = new Coordinates(x, y);

                if (temp.equals(cur)) {
                    System.out.print("K");
                } else if (temp.equals(start)) {
                    System.out.print("S");
                } else if (temp.equals(finish)) {
                    System.out.print("F");
                } else if (steps.contains(temp)) {
                    System.out.print(1);
                } else {
                    System.out.print(0);
                }
                System.out.print("\t");
            }
            System.out.println();
        }
        System.out.println("//--------------------------");
    }


    private static void output(int t, List<Coordinates> steps) {
        System.out.println(t);
        steps.forEach(c -> System.out.println("\n" + c.x + " " + c.y));
    }

    private static class Coordinates {

        private int x, y;

        private Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }

        private Coordinates(Coordinates other) {
            this.x = other.x;
            this.y = other.y;
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
