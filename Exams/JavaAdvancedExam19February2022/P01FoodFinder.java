package Exams.JavaAdvancedExam19February2022;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P01FoodFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] stringArr1 = scanner.nextLine().split("\\s+");
        String[] stringArr2 = scanner.nextLine().split("\\s+");
        ArrayDeque<String> queue = new ArrayDeque<>();
        ArrayDeque<String> stack = new ArrayDeque<>();
        for (int i = 0; i < stringArr1.length; i++) {
            queue.offer(stringArr1[i]);
        }
        for (int i = 0; i < stringArr2.length; i++) {
            stack.push(stringArr2[i]);
        }
        List<String> builder1 = new ArrayList<>();
        List<String> builder2 = new ArrayList<>();
        List<String> builder3 = new ArrayList<>();
        List<String> builder4 = new ArrayList<>();
        int counter = 0;
        while (!stack.isEmpty()) {
            String firstItem = queue.peek();
            String secondItem = stack.peek();
            queue.poll();
            queue.offer(firstItem);
            stack.pop();
            String word1 = "pear";
            String word2 = "flour";
            String word3 = "pork";
            String word4 = "olive";
            if (word1.contains(firstItem)) {
                if (!builder1.contains(firstItem)) {
                    builder1.add(firstItem);
                }
            }
            if (word2.contains(firstItem)) {
                if (!builder2.contains(firstItem)) {
                    builder2.add(firstItem);
                }
            }
            if (word3.contains(firstItem)) {
                if (!builder3.contains(firstItem)) {
                    builder3.add(firstItem);
                }
            }
            if (word4.contains(firstItem)) {
                if (!builder4.contains(firstItem)) {
                    builder4.add(firstItem);
                }
            }
            if (word1.contains(secondItem)) {
                if (!builder1.contains(secondItem)) {
                    builder1.add(secondItem);
                }
            }
            if (word2.contains(secondItem)) {
                if (!builder2.contains(secondItem)) {
                    builder2.add(secondItem);
                }
            }
            if (word3.contains(secondItem)) {
                if (!builder3.contains(secondItem)) {
                    builder3.add(secondItem);
                }
            }
            if (word4.contains(secondItem)) {
                if (!builder4.contains(secondItem)) {
                    builder4.add(secondItem);
                }
            }
        }
        if (builder1.size() == 4) {
            counter++;
        }
        if (builder2.size() == 5) {
            counter++;
        }
        if (builder3.size() == 4) {
            counter++;
        }
        if (builder4.size() == 5) {
            counter++;
        }
        System.out.printf("Words found: %d%n", counter);
        if (builder1.size() == 4) {
            System.out.println("pear");
        }
        if (builder2.size() == 5) {
            System.out.println("flour");
        }
        if (builder3.size() == 4) {
            System.out.println("pork");
        }
        if (builder4.size() == 5) {
            System.out.println("olive");
        }
    }
}