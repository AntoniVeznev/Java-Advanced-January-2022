package Labs.L01StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P06HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] names = scanner.nextLine().split(" ");
        int countingUp = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> queue = new ArrayDeque<>();
        for (int i = 0; i < names.length; i++) {
            queue.offer(names[i]);
        }
        while (queue.size() != 1) {
            for (int i = 1; i < countingUp; i++) {
                String currentKid = queue.poll();
                queue.offer(currentKid);
            }
            String removeThatOne = queue.poll();
            System.out.printf("Removed %s%n", removeThatOne);
        }
        String lastOne = queue.peek();
        System.out.printf("Last is %s%n", lastOne);
    }
}
