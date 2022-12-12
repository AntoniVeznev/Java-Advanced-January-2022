package Exercises.E01StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P04BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstInput = scanner.nextLine().split("\\s+");
        String[] secondInput = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int n = Integer.parseInt(firstInput[0]);
        int s = Integer.parseInt(firstInput[1]);
        int x = Integer.parseInt(firstInput[2]);
        for (int i = 0; i < n; i++) {
            queue.offer(Integer.parseInt(secondInput[i]));
        }
        for (int i = 0; i < s; i++) {
            queue.poll();
        }
        if (queue.contains(x)) {
            System.out.println("true");
        } else {
            if (queue.isEmpty()) {
                System.out.println("0");
            } else {
                System.out.println(Collections.min(queue));
            }
        }
    }
}
