package tour_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ProblemD {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        List<Task> tasks = new ArrayList<>();
        int money = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) tasks.add(new Task(Integer.parseInt(st.nextToken())));
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) tasks.get(i).money = Integer.parseInt(st.nextToken());

        tasks.removeIf(t -> t.days >= n);

        for (int day = n - 1; day >= 1; day--) {
            final int curDay = day;
            Task task = tasks.stream()
                    .filter(t -> curDay + t.days <= n)
                    .max(Comparator.comparingDouble(Task::value))
                    .orElse(null);

            if (task != null) {
                tasks.remove(task);
                money += task.money;
            }
            if (tasks.isEmpty()) break;
        }

        System.out.println(money);
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
