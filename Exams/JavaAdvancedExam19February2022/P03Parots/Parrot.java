package Exams.JavaAdvancedExam19February2022.P03Parots;

public class Parrot {

    private String name;
    private String species;
    private boolean available = true;

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public Parrot(String name, String species) {
        this.name = name;
        this.species = species;

    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void isAvailable(boolean available) {
        this.available = true;
    }

    @Override
    public String toString() {
        return String.format("Parrot (%s): %s", species, name);
    }
}
