package Exams.JavaAdvancedRetakeExam18August2021.P03Cafe;

public class Employee {

    private String name;
    private int age;
    private String country;

    public int getAge() {
        return age;
    }

    public Employee(String name, int age, String country) {
        this.name = name;
        this.age = age;
        this.country = country;
    }

    @Override
    public String toString() {
        return String.format("Employee: %s, %d from %s", name, age, country);
    }

    public String getName() {
        return name;
    }
}
