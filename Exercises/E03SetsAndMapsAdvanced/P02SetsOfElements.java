package Exercises.E03SetsAndMapsAdvanced;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P02SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();
        Set<Integer> finalSet = new LinkedHashSet<>();
        int[] arr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int firstSetLength = arr[0];
        int secondSetLength = arr[1];
        for (int i = 0; i < firstSetLength; i++) {
            int numberForTheFirstSet = Integer.parseInt(scanner.nextLine());
            firstSet.add(numberForTheFirstSet);
        }
        for (int i = 0; i < secondSetLength; i++) {
            int numberForTheSecondSet = Integer.parseInt(scanner.nextLine());
            secondSet.add(numberForTheSecondSet);
        }
        for (int number : firstSet) {
            if (secondSet.contains(number)) {
                finalSet.add(number);
            }
        }
        for (Integer element : finalSet) {
            System.out.print(element + " ");
        }
    }
}
