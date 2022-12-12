package Exercises.E06DefiningClasses.CarSalesman_4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfEngines = Integer.parseInt(scanner.nextLine());
        List<Engine> engines = new ArrayList<>();
        for (int i = 0; i < numberOfEngines; i++) {

            String[] engineInfo = scanner.nextLine().split("\\s+");
            String model = engineInfo[0];
            int power = Integer.parseInt(engineInfo[1]);
            Engine engine;
            if (engineInfo.length == 3) {
                Character thirdLine = engineInfo[2].charAt(0);
                if (Character.isDigit(thirdLine)) {
                    int displacement = Integer.parseInt(engineInfo[2]);
                    engine = new Engine(model, power, displacement);
                    engines.add(engine);
                } else if (Character.isLetter(thirdLine)) {
                    String efficiency = engineInfo[2];
                    engine = new Engine(model, power, efficiency);
                    engines.add(engine);
                }

            } else if (engineInfo.length == 4) {
                int displacement = Integer.parseInt(engineInfo[2]);
                String efficiency = engineInfo[3];
                engine = new Engine(model, power, displacement, efficiency);
                engines.add(engine);
            } else {
                engine = new Engine(model, power);
                engines.add(engine);
            }

        }
        int numberOfCars = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new LinkedList<>();
        for (int i = 0; i < numberOfCars; i++) {
            Car car;
            String[] carInfo = scanner.nextLine().split("\\s+");
            String model = carInfo[0];
            String engine = carInfo[1];

            if (carInfo.length == 3) {
                Character thirdLine = carInfo[2].charAt(0);

                if (Character.isDigit(thirdLine)) {
                    int weight = Integer.parseInt(carInfo[2]);
                    car = new Car(model, engine, weight);
                    cars.add(car);
                } else if (Character.isLetter(thirdLine)) {
                    String color = carInfo[2];
                    car = new Car(model, engine, color);
                    cars.add(car);
                }

            } else if (carInfo.length == 4) {
                int weight = Integer.parseInt(carInfo[2]);
                String color = carInfo[3];
                car = new Car(model, engine, weight, color);
                cars.add(car);
            } else {
                car = new Car(model, engine);
                cars.add(car);
            }

        }

        for (Car car : cars) {
            System.out.println(car.getModel() + ":");
            System.out.println(car.getEngine() + ":");
            engines.forEach(engine -> {
                if (engine.getModel().equals(car.getEngine())) {
                    System.out.println(engine.toString());
                }
            });
            if (car.getWeight() == 0) {
                System.out.println("Weight: n/a");
            } else {
                System.out.println("Weight: " + car.getWeight());
            }
            System.out.println("Color: " + car.getColor());
        }
    }

}
