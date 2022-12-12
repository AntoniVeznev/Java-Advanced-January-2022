package Exams.JavaAdvancedRetakeExam17Dec2019.P03Christmas;

import java.util.ArrayList;
import java.util.List;

public class Bag {
    private List<Present> data;
    private String color;
    private int capacity;

    public String getColor() {
        return color;
    }

    public int getCapacity() {
        return capacity;
    }

    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.data = new ArrayList<>();

    }


    public int count() {
        return data.size();
    }


    public void add(Present present) {
        if (capacity > data.size()) {
            data.add(present);
        }
    }


    public boolean remove(String name) {
        for (Present present : data) {
            if (present.getName().equals(name)) {
                data.remove(present);
                return true;
            }
        }
        return false;
    }


    public Present heaviestPresent() {
        Present item = null;
        for (Present present : data) {
            if (item == null || present.getWeight() > item.getWeight()) {
                item = present;
            }
        }
        return item;

    }


    public Present getPresent(String name) {
        Present item = null;
        for (Present present : data) {
            if (present.getName().equals(name)) {
                item = present;
                return item;
            }
        }
        return null;
    }


    public String report() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%s bag contains:", getColor())).append(System.lineSeparator());
        for (Present present : data) {
            builder.append(present).append(System.lineSeparator());
        }
        return builder.toString();
    }

}
