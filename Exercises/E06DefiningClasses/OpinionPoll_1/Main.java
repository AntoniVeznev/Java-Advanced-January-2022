package Exercises.E06DefiningClasses.OpinionPoll_1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Person> dataList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] inputArr = scanner.nextLine().split("\\s+");
            String name = inputArr[0];
            int age = Integer.parseInt(inputArr[1]);
            if (age > 30) {
                Person person = new Person();
                person.setName(name);
                person.setAge(age);
                dataList.add(person);
            }
        }
        dataList.sort(Comparator.comparing(Person::getName));
        dataList.forEach(person -> System.out.println(person.toString()));
    }
}
