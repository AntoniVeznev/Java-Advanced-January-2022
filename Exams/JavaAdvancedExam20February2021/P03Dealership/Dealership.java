package Exams.JavaAdvancedExam20February2021.P03Dealership;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    public List<Car> data;
    public String name;
    public int capacity;

    public Dealership(String name, int capacity) {
        this.data = new ArrayList<>();
        this.name = name;
        this.capacity = capacity;
    }

    public void add(Car car) {
        if (data.size() < capacity) {
            data.add(car);
        }
    }

    public boolean buy(String manufacturer, String model) {
        for (Car car : data) {
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                data.remove(car);
                return true;
            }
        }
        return false;
    }


    public Car getLatestCar() {
        Car result = null;
        for (Car car : data) {
            if (result == null || result.getYear() < car.getYear()) {
                result = car;
            }
        }
        return result;

    }

    public int getCount() {
        return data.size();
    }


    public Car getCar(String manufacturer, String model) {
        for (Car car : data) {
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                return car;
            }
        }
        return null;
    }

    public String getStatistics() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format(" The cars are in a car dealership %s:", name)).append("\n");
        for (Car car : data) {
            builder.append(car.toString()).append("\n");
        }
        return builder.toString();
    }

}
