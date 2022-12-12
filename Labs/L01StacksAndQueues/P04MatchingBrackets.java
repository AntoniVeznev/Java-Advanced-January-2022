package Labs.L01StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P04MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        ArrayDeque<String> stack = new ArrayDeque<>();
        for (int i = 0; i < expression.length(); i++) {
            char symbol = expression.charAt(i);
            if (symbol == '(') {
                stack.push(i + "");
            } else if (symbol == ')') {
                int startIndex = Integer.parseInt(stack.pop());
                String content = expression.substring(startIndex, i + 1);
                System.out.println(content);
            }
        }
    }
}
