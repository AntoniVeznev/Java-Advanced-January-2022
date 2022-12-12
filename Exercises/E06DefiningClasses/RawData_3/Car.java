package Exercises.E06DefiningClasses.RawData_3;

public class Car {
    private String model;
    private int engineSpeed;
    private int enginePower;
    private int cargoWeight;
    private String cargoType;
    private double tire1pressure;
    private int tire1age;
    private double tire2pressure;
    private int tire2age;
    private double tire3pressure;
    private int tire3age;
    private double tire4pressure;
    private int tire4age;

    public String getModel() {
        return model;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public String getCargoType() {
        return cargoType;
    }

    public double getTire1pressure() {
        return tire1pressure;
    }

    public double getTire2pressure() {
        return tire2pressure;
    }

    public double getTire3pressure() {
        return tire3pressure;
    }

    public double getTire4pressure() {
        return tire4pressure;
    }

    public Car(String model, int engineSpeed, int enginePower, int cargoWeight, String cargoType, double tire1pressure, int tire1age, double tire2pressure, int tire2age, double tire3pressure, int tire3age, double tire4pressure, int tire4age) {
        this.model = model;
        this.engineSpeed = engineSpeed;
        this.enginePower = enginePower;
        this.cargoWeight = cargoWeight;
        this.cargoType = cargoType;
        this.tire1pressure = tire1pressure;
        this.tire1age = tire1age;
        this.tire2pressure = tire2pressure;
        this.tire2age = tire2age;
        this.tire3pressure = tire3pressure;
        this.tire3age = tire3age;
        this.tire4pressure = tire4pressure;
        this.tire4age = tire4age;
    }
}
