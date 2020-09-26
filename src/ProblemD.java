import java.util.Scanner;

public class ProblemD {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int t = scan.nextInt();
        int a = scan.nextInt();
        int k = scan.nextInt(), b = scan.nextInt();
        int c = scan.nextInt();

        for (int time = 1; time <= t; time++) {
            int aTime = time * a;

            if ((t - aTime) % k == 0) {
                int bTime = (t - aTime) / k * b;
            }
        }
    }
}
