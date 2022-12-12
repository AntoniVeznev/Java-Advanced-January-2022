package Labs.L01StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P05PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String commandsOrFiles = scanner.nextLine();
        ArrayDeque<String> queue = new ArrayDeque<>();
        while (!commandsOrFiles.equals("print")) {
            if (!commandsOrFiles.equals("cancel")) {
                queue.offer(commandsOrFiles);
            } else {
                if (!queue.isEmpty()) {
                    System.out.printf("Canceled %s%n", queue.poll());
                } else {
                    System.out.println("Printer is on standby");
                }
            }
            commandsOrFiles = scanner.nextLine();
        }
        for (String element : queue) {
            System.out.println(element);
        }
    }
}
