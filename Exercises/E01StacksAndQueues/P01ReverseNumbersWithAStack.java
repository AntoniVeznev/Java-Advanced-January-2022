package Exercises.E01StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P01ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        ArrayDeque<String> stack = new ArrayDeque<>();
        for (String element : input) {
            stack.push(element);
        }
        for (String element : stack) {
            System.out.print(element + " ");
        }
    }
}
