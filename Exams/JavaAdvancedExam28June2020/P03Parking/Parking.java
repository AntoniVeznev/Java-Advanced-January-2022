package Exams.JavaAdvancedExam28June2020.P03Parking;

import java.util.ArrayList;
import java.util.List;

public class Parking {
    private List<Car> data;
    private String type;
    private int capacity;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (capacity > data.size()) {
            data.add(car);
        }
    }

    public boolean remove(String manufacturer, String model) {
        for (Car car : data) {
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                data.remove(car);
                return true;
            }
        }
        return false;
    }

    public Car getLatestCar() {
        Car latest = null;
        for (Car car : data) {
            if (latest == null || car.getYear() > latest.getYear()) {
                latest = car;
            }
        }
        return latest;
    }

    public Car getCar(String manufacturer, String model) {
        Car getCar = null;
        for (Car car : data) {
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                getCar = car;
            }
        }
        return getCar;
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("The cars are parked in %s:", type)).append(System.lineSeparator());
        for (Car car : data) {
            builder.append(car.toString()).append(System.lineSeparator());
        }
        return builder.toString();
    }
}
