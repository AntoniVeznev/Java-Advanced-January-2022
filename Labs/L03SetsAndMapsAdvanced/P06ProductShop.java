package Labs.L03SetsAndMapsAdvanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P06ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, Map<String, Double>> dataMap = new TreeMap<>();
        while (!input.equals("Revision")) {
            String[] inputArr = input.split(", ");
            String shop = inputArr[0];
            String product = inputArr[1];
            double price = Double.parseDouble(inputArr[2]);
            if (!dataMap.containsKey(shop)) {
                dataMap.put(shop, new LinkedHashMap<>());
                dataMap.get(shop).put(product, price);
            } else {
                dataMap.get(shop).put(product, price);
            }
            input = scanner.nextLine();
        }
        for (Map.Entry<String, Map<String, Double>> element : dataMap.entrySet()) {
            System.out.printf("%s->%n", element.getKey());
            for (Map.Entry<String, Double> nextMapElements : element.getValue().entrySet()) {
                System.out.printf("Product: %s, Price: %.1f%n", nextMapElements.getKey(), nextMapElements.getValue());
            }
        }
    }
}
