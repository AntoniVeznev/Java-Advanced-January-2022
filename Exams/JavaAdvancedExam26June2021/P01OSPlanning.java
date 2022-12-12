package Exams.JavaAdvancedExam26June2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01OSPlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(stack::push);
        ArrayDeque<Integer> queue = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));
        int task = Integer.parseInt(scanner.nextLine());
        boolean isKilled = false;
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            int firstTask = stack.peek();
            int firstThread = queue.peek();
            if (firstTask == task) {
                isKilled = true;
                break;
            }
            if (firstThread >= firstTask) {
                stack.pop();
                queue.poll();
            } else if (firstThread < firstTask) {
                queue.poll();
            }
        }
        if (isKilled) {
            System.out.printf("Thread with value %d killed task %d%n", queue.peek(), stack.peek());
        }
        for (Integer integer : queue) {
            System.out.print(integer + " ");
        }
    }
}