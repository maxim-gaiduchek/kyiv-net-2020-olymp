import java.util.Scanner;

public class ProblemE {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String n = scan.next();
        String d = scan.next();

        System.out.println(n.contains(d) ? "Yes" : "No");
    }
}
