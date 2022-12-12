package Exams.JavaAdvancedRetakeExam15December2021.P03WaterAdventure;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {

    private String name;
    private int capacity;
    private int size;
    private List<Fish> fishInPool;

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    public Aquarium(String name, int capacity, int size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        this.fishInPool = new ArrayList<>();
    }

    public int getFishInPool() {
        return fishInPool.size();
    }


    public void add(Fish fish) {
        if (!fishInPool.contains(fish)) {
            if (capacity > fishInPool.size()) {
                fishInPool.add(fish);
            }
        }


    }

    public boolean remove(String name) {
        for (Fish fish : fishInPool) {
            if (fish.getName().equals(name)) {
                fishInPool.remove(fish);
                return true;
            }
        }
        return false;
    }


    public Fish findFish(String name) {
        Fish item = null;
        for (Fish fish : fishInPool) {
            if (fish.getName().equals(name)) {
                item = fish;
                return item;
            }
        }
        return null;
    }

    public String report() {
        StringBuilder build = new StringBuilder();
        build.append(String.format("Aquarium: %s ^ Size: %s", name, size)).append(System.lineSeparator());
        for (Fish fish : fishInPool) {
            build.append(fish).append(System.lineSeparator());
        }
        return build.toString();
    }
}
