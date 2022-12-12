package Exercises.E03SetsAndMapsAdvanced;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P04CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        Map<String, Integer> dataMap = new TreeMap<>();
        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);
            if (!dataMap.containsKey(symbol + "")) {
                dataMap.put(symbol + "", 1);
            } else {
                int currentValue = dataMap.get(symbol + "");
                dataMap.put(symbol + "", currentValue + 1);
            }
        }
        for (Map.Entry<String, Integer> element : dataMap.entrySet()) {
            System.out.printf("%s: %d time/s%n", element.getKey(), element.getValue());
        }
    }
}
