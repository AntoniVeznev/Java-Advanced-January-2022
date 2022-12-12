package Exams.JavaAdvancedRetakeExam17Dec2019;

import java.util.*;
import java.util.stream.Collectors;

public class P01SantasPresentFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(stack::push);
        ArrayDeque<Integer> queue = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));
        Map<String, Integer> dataMap = new TreeMap<>();
        boolean conditionIsValid = false;
        dataMap.put("Doll", 0);
        dataMap.put("Wooden train", 0);
        dataMap.put("Teddy bear", 0);
        dataMap.put("Bicycle", 0);
        while (true) {
            if (stack.isEmpty()) {
                break;
            }
            if (queue.isEmpty()) {
                break;
            }
            int firstStack = stack.peek();
            int secondQueue = queue.peek();
            int multiplication = firstStack * secondQueue;
            if (multiplication == 150) {
                int currentCount = dataMap.get("Doll");
                dataMap.put("Doll", currentCount + 1);
                stack.pop();
                queue.poll();
            } else if (multiplication == 250) {
                int currentCount = dataMap.get("Wooden train");
                dataMap.put("Wooden train", currentCount + 1);
                stack.pop();
                queue.poll();
            } else if (multiplication == 300) {
                int currentCount = dataMap.get("Teddy bear");
                dataMap.put("Teddy bear", currentCount + 1);
                stack.pop();
                queue.poll();
            } else if (multiplication == 400) {
                int currentCount = dataMap.get("Bicycle");
                dataMap.put("Bicycle", currentCount + 1);
                stack.pop();
                queue.poll();
            } else {
                if (multiplication < 0) {
                    int sum = firstStack + secondQueue;
                    stack.pop();
                    queue.poll();
                    stack.push(sum);
                } else if (multiplication > 0) {
                    queue.poll();
                    int current = firstStack + 15;
                    stack.pop();
                    stack.push(current);
                } else {
                    if (firstStack == 0) {
                        stack.pop();
                    } else if (secondQueue == 0) {
                        queue.poll();
                    } else if (firstStack == 0 && secondQueue == 0) {
                        stack.pop();
                        queue.poll();
                    }
                }
            }
        }
        if (dataMap.get("Doll") >= 1 && dataMap.get("Wooden train") >= 1) {
            conditionIsValid = true;
        }
        if (dataMap.get("Teddy bear") >= 1 && dataMap.get("Bicycle") >= 1) {
            conditionIsValid = true;
        }
        if (conditionIsValid) {
            System.out.println("The presents are crafted! Merry Christmas!");
        } else if (!conditionIsValid) {
            System.out.println("No presents this Christmas!");
        }
        if (!stack.isEmpty()) {
            System.out.print("Materials left: ");
            System.out.println(String.join(", ", stack.toString()
                    .replaceAll("[\\[\\]]", "")));
        }
        if (!queue.isEmpty()) {
            System.out.print("Magic left: ");
            System.out.println(String.join(", ", queue.toString()
                    .replaceAll("[\\[\\]]", "")));
        }
        for (Map.Entry<String, Integer> element : dataMap.entrySet()) {
            if (element.getValue() >= 1) {
                System.out.printf("%s: %d%n", element.getKey(), element.getValue());
            }
        }
    }
}