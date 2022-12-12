package Exams.JavaAdvancedExam19February2022.P03Parots;

import java.util.ArrayList;
import java.util.List;

public class Cage {

    private String name;
    private int capacity;
    private List<Parrot> data;

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();

    }


    public void add(Parrot parrot) {
        if (capacity > data.size()) {
            data.add(parrot);
        }
    }


    public boolean remove(String name) {
        for (Parrot parrot : data) {
            if (parrot.getName().equals(name)) {
                data.remove(parrot);
                return true;
            }
        }
        return false;
    }


    public Parrot sellParrot(String name) {
        Parrot item = null;
        for (Parrot parrot : data) {
            if (parrot.getName().equals(name)) {
                parrot.setAvailable(false);
                item = parrot;

            }
        }
        return item;

    }


    public List<Parrot> sellParrotBySpecies(String species) {
        List<Parrot> returnAllParrots = new ArrayList<>();
        for (Parrot parrot : data) {
            if (parrot.getSpecies().equals(species)) {
                returnAllParrots.add(parrot);
                data.remove(parrot);
            }

        }
        return returnAllParrots;
    }


    public int count() {
        return data.size();
    }

    public String report() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Parrots available at %s:", getName())).append(System.lineSeparator());
        for (Parrot parrot : data) {
            builder.append(parrot).append(System.lineSeparator());

        }
        return builder.toString();
    }
}
