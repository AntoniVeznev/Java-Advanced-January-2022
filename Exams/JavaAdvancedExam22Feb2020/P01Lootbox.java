package Exams.JavaAdvancedExam22Feb2020;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P01Lootbox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        String[] lineArr = scanner.nextLine().split("\\s+");
        for (int i = 0; i < lineArr.length; i++) {
            queue.offer(Integer.valueOf(lineArr[i]));
        }
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        String[] lineARRRR = scanner.nextLine().split("\\s+");
        for (int i = 0; i < lineARRRR.length; i++) {
            stack.push(Integer.valueOf(lineARRRR[i]));
        }
        int collection = 0;
        while (true) {
            if (queue.isEmpty()) {
                break;
            }
            if (stack.isEmpty()) {
                break;
            }
            int sum = queue.peek() + stack.peek();
            if (sum % 2 == 0) {
                collection += sum;
                stack.pop();
                queue.poll();
            } else {
                int currentItem = stack.pop();
                queue.offer(currentItem);
            }
        }
        if (queue.isEmpty()) {
            System.out.println("First lootbox is empty");
        }
        if (stack.isEmpty()) {
            System.out.println("Second lootbox is empty");
        }
        if (collection >= 100) {
            System.out.printf("Your loot was epic! Value: %d", collection);
        } else {
            System.out.printf("Your loot was poor... Value: %d", collection);
        }
    }
}