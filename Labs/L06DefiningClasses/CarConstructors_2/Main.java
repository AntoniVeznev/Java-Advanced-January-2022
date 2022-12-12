package Labs.L06DefiningClasses.CarConstructors_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        List<Car> dataList = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            String input = scanner.nextLine();
            String[] inputArr = input.split("\\s+");
            if (inputArr.length == 1) {
                Car car = new Car(inputArr[0]);
                dataList.add(car);
            } else {
                Car car = new Car(inputArr[0], inputArr[1], Integer.parseInt(inputArr[2]));
                dataList.add(car);
            }
        }
        dataList.forEach(element -> System.out.println(element.toString()));
    }
}
