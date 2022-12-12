package Exercises.E03SetsAndMapsAdvanced;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P05Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        Map<String, String> phoneBookMap = new HashMap<>();
        while (!text.equals("search")) {
            String people = text.split("-")[0];
            String phoneNumbers = text.split("-")[1];
            if (!phoneBookMap.containsKey(people)) {
                phoneBookMap.put(people, phoneNumbers);
            } else {
                phoneBookMap.put(people, phoneNumbers);
            }
            text = scanner.nextLine();
        }
        String input = scanner.nextLine();
        while (!input.equals("stop")) {
            if (phoneBookMap.containsKey(input)) {
                String numberWeLf = phoneBookMap.get(input);
                System.out.printf("%s -> %s%n", input, numberWeLf);
            } else {
                System.out.printf("Contact %s does not exist.%n", input);
            }
            input = scanner.nextLine();
        }
    }
}
