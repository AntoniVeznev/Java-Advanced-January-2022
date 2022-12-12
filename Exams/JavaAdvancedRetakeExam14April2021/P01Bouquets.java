package Exams.JavaAdvancedRetakeExam14April2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01Bouquets {
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
        int totalForLater = 0;
        while (!stack.isEmpty() || !queue.isEmpty()) {
            if (stack.isEmpty() || queue.isEmpty()) {
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
                int current = stack.peek();
                stack.pop();
                stack.push(current - 2);
            } else if (sum < 15) {
                totalForLater += sum;
                stack.pop();
                queue.poll();
            }
        }
        if (totalForLater > 0) {
            int result = totalForLater / 15;
            counter += result;
        }
        if (counter >= 5) {
            System.out.printf("You made it! You go to the competition with %d bouquets!", counter);
        } else {
            int diff = Math.abs(5 - counter);
            System.out.printf("You failed... You need more %d bouquets.", diff);
        }
    }
}