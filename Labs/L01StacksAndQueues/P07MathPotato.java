package Labs.L01StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P07MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] names = scanner.nextLine().split(" ");
        int countingUp = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> queue = new ArrayDeque<>();
        for (int i = 0; i < names.length; i++) {
            queue.offer(names[i]);
        }
        int cycle = 0;
        while (queue.size() != 1) {
            cycle++;
            for (int i = 1; i < countingUp; i++) {
                String currentKid = queue.poll();
                queue.offer(currentKid);
            }
            int bigCounter = 0;
            for (int i = 2; i <= cycle; ++i) {
                if (cycle % i == 0) {
                    bigCounter++;
                }
            }
            if (bigCounter > 1 || cycle == 1) {
                String removeThatOne = queue.poll();
                System.out.printf("Removed %s%n", removeThatOne);
            } else {
                System.out.printf("Prime %s%n", queue.peek());
            }
        }
        String lastOne = queue.peek();
        System.out.printf("Last is %s%n", lastOne);
    }
}
