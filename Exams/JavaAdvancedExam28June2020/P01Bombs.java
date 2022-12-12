package Exams.JavaAdvancedExam28June2020;

import java.util.*;
import java.util.stream.Collectors;

public class P01Bombs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> queue = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(stack::push);
        Map<String, Integer> dataMap = new TreeMap<>();
        dataMap.put("Datura Bombs", 0);
        dataMap.put("Cherry Bombs", 0);
        dataMap.put("Smoke Decoy Bombs", 0);
        boolean isSucseeded = false;
        while (true) {
            if (queue.isEmpty()) {
                break;
            }
            if (stack.isEmpty()) {
                break;
            }
            int sum = queue.peek() + stack.peek();
            if (sum == 40) {
                int currentCount = dataMap.get("Datura Bombs");
                dataMap.put("Datura Bombs", currentCount + 1);
                stack.pop();
                queue.poll();
            } else if (sum == 60) {
                int currentCount = dataMap.get("Cherry Bombs");
                dataMap.put("Cherry Bombs", currentCount + 1);
                stack.pop();
                queue.poll();
            } else if (sum == 120) {
                int currentCount = dataMap.get("Smoke Decoy Bombs");
                dataMap.put("Smoke Decoy Bombs", currentCount + 1);
                stack.pop();
                queue.poll();
            } else {
                int current = stack.pop();
                stack.push(current - 5);
            }
            if (dataMap.get("Datura Bombs") >= 3 && dataMap.get("Cherry Bombs") >= 3 && dataMap.get("Smoke Decoy Bombs") >= 3) {
                isSucseeded = true;
                break;
            }
        }
        if (isSucseeded) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }
        if (!queue.isEmpty()) {
            System.out.print("Bomb Effects: ");
            System.out.println(String.join(", ", queue.toString()
                    .replaceAll("[\\[\\]]", "")));
        } else {
            System.out.println("Bomb Effects: empty");
        }
        if (!stack.isEmpty()) {
            System.out.print("Bomb Casings: ");
            System.out.println(String.join(", ", stack.toString()
                    .replaceAll("[\\[\\]]", "")));
        } else {
            System.out.println("Bomb Casings: empty");
        }
        for (var element : dataMap.entrySet()) {
            String bomb = element.getKey();
            int count = element.getValue();
            System.out.printf("%s: %d%n", bomb, count);
        }
    }
}