package Labs.L01StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P03DecimalToBinaryConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int startingNumber = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        if (startingNumber == 0) {
            System.out.println("0");
        }
        while (startingNumber != 0) {
            int firstResult = 0;
            int secondResult = 0;
            firstResult = startingNumber % 2;
            secondResult = startingNumber / 2;
            stack.push(firstResult);
            startingNumber = secondResult;
        }
        for (Integer element : stack) {
            System.out.print(element);
        }
    }
}
