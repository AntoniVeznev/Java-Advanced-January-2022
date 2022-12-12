package Exams.JavaAdvancedExam23October2021;

import java.util.*;
import java.util.stream.Collectors;

public class P01AutumnCocktails {
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
        int length = stack.size();
        for (int i = 0; i < length; i++) {
            if (queue.isEmpty() || stack.isEmpty()) {
                break;
            }
            if (queue.peek() == 0) {
                queue.poll();
                i--;
                continue;
            }
            int totalFreshLevel = queue.peek() * stack.peek();
            if (totalFreshLevel == 150) {
                String cocktailName = "Pear Sour";
                if (!dataMap.containsKey(cocktailName)) {
                    dataMap.put(cocktailName, 1);
                } else {
                    int currentCocktails = dataMap.get(cocktailName);
                    dataMap.put(cocktailName, currentCocktails + 1);
                }
                queue.poll();
                stack.pop();
            } else if (totalFreshLevel == 250) {
                String cocktailName = "The Harvest";
                if (!dataMap.containsKey(cocktailName)) {
                    dataMap.put(cocktailName, 1);
                } else {
                    int currentCocktails = dataMap.get(cocktailName);
                    dataMap.put(cocktailName, currentCocktails + 1);
                }
                queue.poll();
                stack.pop();
            } else if (totalFreshLevel == 300) {
                String cocktailName = "Apple Hinny";
                if (!dataMap.containsKey(cocktailName)) {
                    dataMap.put(cocktailName, 1);
                } else {
                    int currentCocktails = dataMap.get(cocktailName);
                    dataMap.put(cocktailName, currentCocktails + 1);
                }
                queue.poll();
                stack.pop();
            } else if (totalFreshLevel == 400) {
                String cocktailName = "High Fashion";
                if (!dataMap.containsKey(cocktailName)) {
                    dataMap.put(cocktailName, 1);
                } else {
                    int currentCocktails = dataMap.get(cocktailName);
                    dataMap.put(cocktailName, currentCocktails + 1);
                }
                queue.poll();
                stack.pop();
            } else {
                stack.pop();
                int currentQueElement = queue.peek();
                int finalElement = currentQueElement + 5;
                queue.poll();
                queue.offer(finalElement);
            }
        }
        if (dataMap.size() == 4) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }
        int sum = 0;
        for (Integer integer : queue) {
            sum += integer;
        }
        if (!queue.isEmpty()) {
            System.out.printf("Ingredients left: %d%n", sum);
        }
        for (Map.Entry<String, Integer> element : dataMap.entrySet()) {
            System.out.printf(" # %s --> %d%n", element.getKey(), element.getValue());
        }
    }
}