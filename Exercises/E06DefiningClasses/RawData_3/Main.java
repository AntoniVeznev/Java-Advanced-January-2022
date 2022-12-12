package Exercises.E06DefiningClasses.RawData_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Car> cars = new ArrayList<>();
        int count = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();

        while (!(input.equals("flamable") || input.equals("fragile"))) {
            String model = input.split(" ")[0];
            int engineSpeed = Integer.parseInt(input.split(" ")[1]);
            int enginePower = Integer.parseInt(input.split(" ")[2]);
            int cargoWeight = Integer.parseInt(input.split(" ")[3]);
            String cargoType = input.split(" ")[4];
            double tire1pressure = Double.parseDouble(input.split(" ")[5]);
            int tire1age = Integer.parseInt(input.split(" ")[6]);
            double tire2pressure = Double.parseDouble(input.split(" ")[7]);
            int tire2age = Integer.parseInt(input.split(" ")[8]);
            double tire3pressure = Double.parseDouble(input.split(" ")[9]);
            int tire3age = Integer.parseInt(input.split(" ")[10]);
            double tire4pressure = Double.parseDouble(input.split(" ")[11]);
            int tire4age = Integer.parseInt(input.split(" ")[12]);
            Car car = new Car(model, engineSpeed, enginePower, cargoWeight, cargoType, tire1pressure, tire1age, tire2pressure, tire2age, tire3pressure, tire3age, tire4pressure, tire4age);
            cars.add(car);
            input = scanner.nextLine();
        }

        if (input.equals("fragile")) {
            for (Car car : cars) {
                if (car.getCargoType().equals("fragile") && (car.getTire1pressure() < 1.0 || car.getTire2pressure() < 1.0 || car.getTire3pressure() < 1.0 || car.getTire4pressure() < 1)) {
                    System.out.println(car.getModel());

                }
            }
        } else if (input.equals("flamable")) {
            for (Car car : cars) {

                if (car.getCargoType().equals("flamable") && car.getEnginePower() > 250) {
                    System.out.println(car.getModel());

                }
            }
        }
    }
}
