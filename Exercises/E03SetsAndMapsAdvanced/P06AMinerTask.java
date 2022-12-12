package Exercises.E03SetsAndMapsAdvanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P06AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> allInfoMap = new LinkedHashMap<>();
        String resource = scanner.nextLine();
        while (!resource.equals("stop")) {
            int quantity = Integer.parseInt(scanner.nextLine());
            if (allInfoMap.containsKey(resource)) {
                int currentQuantity = allInfoMap.get(resource);
                allInfoMap.put(resource, currentQuantity + quantity);
            } else {
                allInfoMap.put(resource, quantity);
            }
            resource = scanner.nextLine();
        }
        for (Map.Entry<String, Integer> element : allInfoMap.entrySet()) {
            System.out.printf("%s -> %d%n", element.getKey(), element.getValue());
        }
    }
}
