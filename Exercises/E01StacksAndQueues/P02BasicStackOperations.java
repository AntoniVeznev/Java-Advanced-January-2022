package Exercises.E01StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P02BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstInput = scanner.nextLine().split("\\s+");
        String[] secondInput = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int n = Integer.parseInt(firstInput[0]);
        int s = Integer.parseInt(firstInput[1]);
        int x = Integer.parseInt(firstInput[2]);
        int minimum = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int currentAddInStack = Integer.parseInt(secondInput[i]);
            stack.push(currentAddInStack);
        }
        for (int i = 0; i < s; i++) {
            stack.pop();
        }
        if (stack.contains(x)) {
            System.out.println("true");
        } else {
            if (stack.isEmpty()) {
                System.out.println("0");
            } else {
                for (Integer element : stack) {
                    if (element < minimum) {
                        minimum = element;
                    }
                }
                System.out.println(minimum);
            }
        }
    }
}
