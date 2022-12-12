package Labs.L03SetsAndMapsAdvanced;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P04CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        double[] numbers = Arrays.stream(input.split("\\s+"))
                .mapToDouble(Double::parseDouble).toArray();
        Map<Double, Integer> numbersCountMap = new LinkedHashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            double currentNumber = numbers[i];
            if (!numbersCountMap.containsKey(currentNumber)) {
                numbersCountMap.put(currentNumber, 1);
            } else {
                int currentCount = numbersCountMap.get(currentNumber);
                numbersCountMap.put(currentNumber, currentCount + 1);
            }
        }
        for (Double element : numbersCountMap.keySet()) {
            System.out.printf("%.1f -> %d%n", element, numbersCountMap.get(element));
        }
    }
}
