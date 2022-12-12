package Exercises.E03SetsAndMapsAdvanced;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P03PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        Set<String> allData = new TreeSet<>();
        for (int i = 0; i < number; i++) {
            String[] strArr = scanner.nextLine().split("\\s+");
            for (int j = 0; j < strArr.length; j++) {
                String currentChemical = strArr[j];
                allData.add(currentChemical);
            }
        }
        for (String element : allData) {
            System.out.print(element + " ");
        }
    }
}
