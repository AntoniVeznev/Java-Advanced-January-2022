package Exercises.E05FunctionalProgramming;

import java.util.Scanner;
import java.util.function.Consumer;

public class P01ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String [] names = input.split("\\s+");

        Consumer<String[]> printNames = array -> {
            for (String name : array) {
                System.out.println(name);
            }
        };
        printNames.accept(names);
    }
}
