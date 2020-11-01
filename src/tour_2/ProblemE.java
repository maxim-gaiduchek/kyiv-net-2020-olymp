package tour_2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class ProblemE {

    public static void main(String[] args) {
        //long start = System.currentTimeMillis();
        Scanner scan = new Scanner(System.in);
        //Scanner scan = new Scanner("30 5 5");
        int size = scan.nextInt(), rising = scan.nextInt(), reducing = scan.nextInt();

        if (rising + reducing - 1 > size) {
            System.out.print(-1);
        } else if (rising == 1) {
            if (size == reducing) {
                for (int i = size; i >= 1; i--) System.out.print(i + " ");
            } else {
                System.out.print(-1);
            }
        } else if (reducing == 1) {
            if (size == rising) {
                for (int i = 1; i <= size; i++) System.out.print(i + " ");
            } else {
                System.out.print(-1);
            }
        } else {
            int zigzagLength = size - rising - reducing + 2;
            int risingArrInZig = zigzagLength / 2 + 1;
            int reducingArrInZig = zigzagLength - risingArrInZig + 2;
            System.out.println(zigzagLength + " " + risingArrInZig + " " + reducingArrInZig);

            if (risingArrInZig > rising || reducingArrInZig > reducing) {
                System.out.print(-1);
            } else {
                List<Integer> arr = new ArrayList<>();
                List<Integer> numbers = new ArrayList<>();

                for (int i = 1; i <= size; i++) numbers.add(i);

                for (int i = size - rising + 1; i <= size; i++) {
                    arr.add(i);
                    numbers.remove(Integer.valueOf(i));
                }
                for (int i = reducing - 1; i >= 1; i--) {
                    arr.add(i);
                    numbers.remove(Integer.valueOf(i));
                }

                boolean isMax = true;
                Integer num;
                while (!numbers.isEmpty()) {
                    if (isMax) {
                        num = numbers.stream().max(Integer::compare).orElse(-1);
                        isMax = false;
                    } else {
                        num = numbers.stream().min(Integer::compare).orElse(-1);
                        isMax = true;
                    }
                    arr.add(num);
                    numbers.remove(num);
                }

                if (arr.size() == new HashSet<>(arr).size()) {
                    arr.forEach(i -> System.out.print(i + " "));
                } else {
                    System.out.print(-1);
                }
            }
        }
        //System.out.println("Run time: " + ((float) (System.currentTimeMillis() - start) / 1000) + "s");
    }
}
