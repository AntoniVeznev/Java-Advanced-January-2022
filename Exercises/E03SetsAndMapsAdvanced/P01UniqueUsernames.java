package Exercises.E03SetsAndMapsAdvanced;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P01UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Set<String> wordsSet = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            String word = scanner.nextLine();
            wordsSet.add(word);
        }
        for ( String element: wordsSet) {
            System.out.println(element);
        }
    }
}
