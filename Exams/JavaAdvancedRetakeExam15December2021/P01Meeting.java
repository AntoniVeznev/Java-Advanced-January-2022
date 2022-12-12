package Exams.JavaAdvancedRetakeExam15December2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P01Meeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] malesArr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] femalesArr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        int counter = 0;
        int size = 0;
        for (int i = 0; i < malesArr.length; i++) {
            stack.push(malesArr[i]);
        }
        for (int i = 0; i < femalesArr.length; i++) {
            queue.offer(femalesArr[i]);
        }
        if (malesArr.length > femalesArr.length) {
            size = malesArr.length;
        } else {
            size = femalesArr.length;
        }
        for (int i = 0; i < size; i++) {
            if (stack.isEmpty() || queue.isEmpty()) {
                break;
            }
            int firstMan = stack.peek();
            int firstWoman = queue.peek();
            if (firstMan % 25 == 0) {
                stack.pop();
                stack.pop();
                if (stack.isEmpty() || queue.isEmpty()) {
                    break;
                }
                continue;
            }
            if (firstWoman % 25 == 0) {
                queue.poll();
                queue.poll();
                if (stack.isEmpty() || queue.isEmpty()) {
                    break;
                }
                continue;
            }
            if (stack.peek() == 0 || stack.peek() < 0) {
                stack.pop();
                continue;
            }
            if (queue.peek() == 0 || queue.peek() < 0) {
                queue.poll();
                continue;
            }
            if (firstMan == firstWoman) {
                counter++;
                stack.pop();
                queue.poll();
            } else {
                queue.poll();
                int current = stack.pop() - 2;
                stack.push(current);
            }
        }
        System.out.printf("Matches: %d\n", counter);
        System.out.print("Males left: ");
        if (!stack.isEmpty()) {
            System.out.println(String.join(", ", stack.toString()
                    .replaceAll("[\\[\\]]", "")));
        } else {
            System.out.println("none");
        }
        System.out.print("Females left: ");
        if (!queue.isEmpty()) {
            System.out.print(String.join(", ", queue.toString()
                    .replaceAll("[\\[\\]]", "")));
        } else {
            System.out.print("none");
        }

    }
}