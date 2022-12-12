package Exams.JavaAdvancedExam20February2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01Magicbox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> queue = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(stack::push);
        int claimed = 0;
        while (true) {
            if (stack.isEmpty()) {
                break;
            }
            if (queue.isEmpty()) {
                break;
            }
            int first = queue.peek();
            int second = stack.peek();
            int sum = first + second;
            if (sum % 2 == 0) {
                claimed += sum;
                stack.pop();
                queue.poll();
            } else {
                int current = stack.pop();
                queue.offer(current);
            }
        }
        if (queue.isEmpty()) {
            System.out.println("First magic box is empty.");
        }
        if (stack.isEmpty()) {
            System.out.println("Second magic box is empty.");
        }
        if (claimed >= 90) {
            System.out.printf("Wow, your prey was epic! Value: %d", claimed);
        } else {
            System.out.printf("Poor prey... Value: %d", claimed);
        }
    }
}
