package tour_2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ProblemD {

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        Scanner scan = new Scanner(new FileInputStream("t.txt"));
        //Scanner scan = new Scanner(System.in);

        int n = scan.nextInt(), m = scan.nextInt();
        List<Task> tasks = new ArrayList<>();
        long money = 0;

        for (int i = 0; i < m; i++) {
            if (scan.hasNext()) tasks.add(new Task(scan.nextInt()));
        }
        for (int i = 0; i < m; i++) {
            if (scan.hasNext()) tasks.get(i).money = scan.nextInt();
        }
        System.out.println(n + " " + m);
        System.out.println(tasks.size());

        tasks.removeIf(t -> t.days >= n);

        for (int day = n - 1; day >= 1; day--) {
            final int curDay = day;
            Task task = tasks.stream()
                    .filter(t -> curDay + t.days <= n)
                    .max(Comparator.comparingDouble(Task::value))
                    .orElse(null);

            //System.out.println(day + " -> " + task);
            if (task != null) {
                money += task.money;
                tasks.remove(task);
            }
            if (tasks.isEmpty()) break;
        }

        System.out.println(money);
        System.out.println("Run time: " + ((float) (System.currentTimeMillis() - start) / 1000) + "s");
    }

    private static class Task {

        private final int days;
        private int money;

        private Task(int days) {
            this.days = days;
        }

        private double value() {
            return (double) money / days;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Task)) return false;

            Task task = (Task) o;

            if (days != task.days) return false;
            return money == task.money;
        }

        @Override
        public int hashCode() {
            int result = days;
            result = 31 * result + money;
            return result;
        }

        @Override
        public String toString() {
            return "Work{" +
                    "a=" + days +
                    ", b=" + money +
                    '}';
        }
    }
}
