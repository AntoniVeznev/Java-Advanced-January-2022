package Exams.JavaAdvancedRetakeExam19August2020;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01FlowerWreaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(stack::push);
        ArrayDeque<Integer> queue = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));
        int counter = 0;
        int totalPeaces = 0;
        while (true) {
            if (stack.isEmpty()) {
                break;
            }
            if (queue.isEmpty()) {
                break;
            }
            int firstStack = stack.peek();
            int firstQueue = queue.peek();
            int sum = firstStack + firstQueue;
            if (sum == 15) {
                counter++;
                stack.pop();
                queue.poll();
            } else if (sum > 15) {
                int current = stack.pop();
                stack.push(current - 2);
            } else {
                totalPeaces += sum;
                stack.pop();
                queue.poll();
            }
        }
        totalPeaces = totalPeaces / 15;
        counter += totalPeaces;
        if (counter >= 5) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!", counter);
        } else {
            System.out.printf("You didn't make it, you need %d wreaths more!", 5 - counter);
        }
    }
}