import java.util.Scanner;

public class ProblemD {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int t = scan.nextInt();
        int a = scan.nextInt();
        int k = scan.nextInt(), b = scan.nextInt();
        int c = scan.nextInt();

        int min = c;

        for (int time = 1; time <= t; time++) {
            int money = (int) Math.ceil((float) (t - time) / k) * b + time * a;

            if (min > money) {
                min = money;
            }
        }

        System.out.println(min);
    }
}
