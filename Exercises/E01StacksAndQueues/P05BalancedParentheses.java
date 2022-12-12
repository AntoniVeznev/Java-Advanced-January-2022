package Exercises.E01StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P05BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        ArrayDeque<Character> queue = new ArrayDeque<>();
        boolean weDontHaveMatch = false;
        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            if (symbol == '(' || symbol == '{' || symbol == '[') {
                stack.push(symbol);
            } else if (symbol == ')' || symbol == '}' || symbol == ']') {
                queue.offer(symbol);
            } else {
                weDontHaveMatch = true;
                break;
            }
        }
        int stackSize = stack.size();
        int realSize = 0;
        if (!stack.isEmpty() && !queue.isEmpty() && stack.size() == queue.size()) {
            realSize = stackSize;
        } else {
            weDontHaveMatch = true;
        }
        for (int i = 0; i < realSize; i++) {
            char firstItemStack = stack.pop();
            char firstItemQueue = queue.remove();
            switch (firstItemStack) {
                case '(':
                    if (firstItemQueue == ')') {
                        continue;
                    } else {
                        weDontHaveMatch = true;
                    }
                    break;
                case '{':
                    if (firstItemQueue == '}') {
                        continue;
                    } else {
                        weDontHaveMatch = true;
                    }
                    break;
                case '[':
                    if (firstItemQueue == ']') {
                        continue;
                    } else {
                        weDontHaveMatch = true;
                    }
                    break;
            }
        }
        if (weDontHaveMatch) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }
}
