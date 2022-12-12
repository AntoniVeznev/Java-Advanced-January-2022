package Exams.JavaAdvancedRetakeExam18August2021;

import java.util.*;
import java.util.stream.Collectors;

public class P01Pastryshop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> queueLiquids = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));
        ArrayDeque<Integer> stackIngredients = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(stackIngredients::push);
        Map<String, Integer> dataMap = new LinkedHashMap<>();
        dataMap.put("Biscuit", 0);
        dataMap.put("Cake", 0);
        dataMap.put("Pie", 0);
        dataMap.put("Pastry", 0);
        int length = queueLiquids.size();
        for (int i = 0; i < length; i++) {
            if (queueLiquids.isEmpty() || stackIngredients.isEmpty()) {
                break;
            }
            int sumAllObjects = queueLiquids.peek() + stackIngredients.peek();
            if (sumAllObjects == 25) {
                String food = "Biscuit";
                if (!dataMap.containsKey(food)) {
                    dataMap.put(food, 1);
                } else {
                    int currentShit = dataMap.get(food);
                    dataMap.put(food, currentShit + 1);
                }
                queueLiquids.poll();
                stackIngredients.pop();
            } else if (sumAllObjects == 50) {
                String food = "Cake";
                if (!dataMap.containsKey(food)) {
                    dataMap.put(food, 1);
                } else {
                    int currentShit = dataMap.get(food);
                    dataMap.put(food, currentShit + 1);
                }
                queueLiquids.poll();
                stackIngredients.pop();
            } else if (sumAllObjects == 75) {
                String food = "Pastry";
                if (!dataMap.containsKey(food)) {
                    dataMap.put(food, 1);
                } else {
                    int currentShit = dataMap.get(food);
                    dataMap.put(food, currentShit + 1);
                }
                queueLiquids.poll();
                stackIngredients.pop();
            } else if (sumAllObjects == 100) {
                String food = "Pie";
                if (!dataMap.containsKey(food)) {
                    dataMap.put(food, 1);
                } else {
                    int currentShit = dataMap.get(food);
                    dataMap.put(food, currentShit + 1);
                }
                queueLiquids.poll();
                stackIngredients.pop();
            } else {
                queueLiquids.poll();
                int current = stackIngredients.pop() + 3;
                stackIngredients.push(current);
            }
        }
        if (checkIfAllHaveMoreThen0(dataMap) == 4) {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else if (checkIfAllHaveMoreThen0(dataMap) != 4) {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }
        if (queueLiquids.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            System.out.println("Liquids left: " + String.join(", ", queueLiquids.toString()
                    .replaceAll("[\\[\\]]", "")));

        }
        if (stackIngredients.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            System.out.println("Ingredients left: " + String.join(", ", stackIngredients.toString()
                    .replaceAll("[\\[\\]]", "")));

        }
        for (Map.Entry<String, Integer> element : dataMap.entrySet()) {
            System.out.printf("%s: %d%n", element.getKey(), element.getValue());
        }
    }

    private static int checkIfAllHaveMoreThen0(Map<String, Integer> dataMap) {
        int counter = 0;
        for (Map.Entry<String, Integer> element : dataMap.entrySet()) {
            if (element.getValue() != 0) {
                counter++;
            }
        }
        return counter;
    }
}