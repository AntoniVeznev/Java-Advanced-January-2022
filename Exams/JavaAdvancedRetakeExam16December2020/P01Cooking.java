package Exams.JavaAdvancedRetakeExam16December2020;

import java.util.*;
import java.util.stream.Collectors;

public class P01Cooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> queue = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(stack::push);
        Map<String, Integer> dataMap = new TreeMap<>();
        dataMap.put("Bread", 0);
        dataMap.put("Cake", 0);
        dataMap.put("Pastry", 0);
        dataMap.put("Fruit Pie", 0);
        while (!queue.isEmpty() && !stack.isEmpty()) {
            int sum = stack.peek() + queue.peek();
            String food = "";
            if (sum == 25) {
                food = "Bread";
                if (dataMap.containsKey(food)) {
                    int currentCount = dataMap.get(food);
                    dataMap.put(food, currentCount + 1);
                }
                stack.pop();
                queue.poll();
            } else if (sum == 50) {
                food = "Cake";
                if (dataMap.containsKey(food)) {
                    int currentCount = dataMap.get(food);
                    dataMap.put(food, currentCount + 1);
                }
                stack.pop();
                queue.poll();
            } else if (sum == 75) {
                food = "Pastry";
                if (dataMap.containsKey(food)) {
                    int currentCount = dataMap.get(food);
                    dataMap.put(food, currentCount + 1);
                }
                stack.pop();
                queue.poll();
            } else if (sum == 100) {
                food = "Fruit Pie";
                if (dataMap.containsKey(food)) {
                    int currentCount = dataMap.get(food);
                    dataMap.put(food, currentCount + 1);
                }
                stack.pop();
                queue.poll();
            } else {
                queue.poll();
                int currentItem = stack.pop();
                stack.push(currentItem + 3);
            }
        }
        if (dataMap.get("Bread") > 0 && dataMap.get("Cake") > 0 && dataMap.get("Fruit Pie") > 0 && dataMap.get("Pastry") > 0) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }
        if (!queue.isEmpty()) {
            System.out.println("Liquids left: " + String.join(", ", queue.toString()
                    .replaceAll("[\\[\\]]", "")));
        } else {
            System.out.println("Liquids left: none");
        }
        if (!stack.isEmpty()) {
            System.out.println("Ingredients left: " + String.join(", ", stack.toString()
                    .replaceAll("[\\[\\]]", "")));
        } else {
            System.out.println("Ingredients left: none");
        }
        for (var element : dataMap.entrySet()) {
            System.out.printf("%s: %d%n", element.getKey(), element.getValue());
        }
    }
}