package Exams.JavaAdvancedRetakeExam27August2018;

import java.util.*;
import java.util.stream.Collectors;

public class P01Agency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstLine = scanner.nextLine().split("\\s+");

        ArrayDeque<String> id = new ArrayDeque<>();
        for (String s : firstLine) {
            id.push(s);
        }

        ArrayDeque<String> name = Arrays.stream(scanner.nextLine()
                .split("\\s+")).collect(Collectors.toCollection(ArrayDeque::new));

        String input = scanner.nextLine();
        while (!input.equals("stop")) {
            String[] command = input.split("\\s+");
            if (command[0].equals("add-ID")) {
                id.push(command[1]);
            } else if (command[0].equals("add-agent")) {
                String nameA = (command[1]);
                name.offer(nameA);
            } else if (command[0].equals("remove-ID")) {
                System.out.printf("%s has been removed.%n", id.poll());
            } else if (command[0].equals("remove-agent")) {

                System.out.printf("%s has left the queue.%n", name.pollLast());
            } else if (command[0].equals("sort-ID")) {
                List<String> sorted = new ArrayList<>();
                while (!id.isEmpty()) {
                    String num = id.pop();
                    sorted.add(num);
                }
                Collections.sort(sorted);
                for (String i : sorted) {
                    id.push(i);
                }
            }
            input = scanner.nextLine();
        }

        while (!id.isEmpty() && !name.isEmpty()) {
            System.out.printf("%s takes ID number: %s%n", name.poll(), id.pop());
        }
        if (!id.isEmpty() && name.isEmpty())
            System.out.println("No more agents left.");
        while (!id.isEmpty()) {
            System.out.printf("ID number: %s", id.pop());
        }
        if (id.isEmpty() && !name.isEmpty()) {
            while (!name.isEmpty()) {
                System.out.printf("%s does not have an ID.", name.poll());
            }

        }
    }
}
