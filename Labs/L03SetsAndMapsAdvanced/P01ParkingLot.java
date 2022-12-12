package Labs.L03SetsAndMapsAdvanced;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P01ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Set<String> numbersOfCars = new LinkedHashSet<>();
        while (!input.equals("END")) {
            String[] inputArr = input.split(", ");
            String direction = inputArr[0];
            String carNumber = inputArr[1];
            switch (direction) {
                case "IN":
                    numbersOfCars.add(carNumber);
                    break;
                case "OUT":
                    numbersOfCars.remove(carNumber);
                    break;
            }
            input = scanner.nextLine();
        }
        if (numbersOfCars.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        }
        for (String item : numbersOfCars) {
            System.out.println(item);
        }
    }
}
