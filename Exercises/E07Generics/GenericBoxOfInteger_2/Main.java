package Exercises.E07Generics.GenericBoxOfInteger_2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());


        Box<Integer> numbersBox = new Box<>();
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            numbersBox.add(number);
        }
        System.out.println(numbersBox);

    }
}
