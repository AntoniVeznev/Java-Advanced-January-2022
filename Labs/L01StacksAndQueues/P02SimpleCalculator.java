package Labs.L01StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P02SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] allSigns = scanner.nextLine().split(" ");
        ArrayDeque<String> stack = new ArrayDeque<>();
        Collections.addAll(stack, allSigns);
        while (stack.size() > 1) {
            int result = 0;
            int firstNumber = Integer.parseInt(stack.pop());
            String operator = stack.pop();
            int secondNumber = Integer.parseInt(stack.pop());
            if (operator.equals("+")) {
                result = firstNumber + secondNumber;
                stack.push(String.valueOf(result));
            } else {
                result = firstNumber - secondNumber;
                stack.push(String.valueOf(result));
            }
        }
        System.out.println(stack.peek());
    }
}
