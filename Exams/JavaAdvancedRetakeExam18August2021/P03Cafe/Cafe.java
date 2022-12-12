package Exams.JavaAdvancedRetakeExam18August2021.P03Cafe;

import java.util.ArrayList;
import java.util.List;

public class Cafe {

    private String name;
    private int capacity;
    private List<Employee> employees;

    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }


    public void addEmployee(Employee employee) {
        if (capacity > employees.size()) {
            employees.add(employee);
        }
    }

    public boolean removeEmployee(String name) {
        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                employees.remove(employee);
                return true;
            }
        }
        return false;
    }

    public Employee getOldestEmployee() {
        int older = 0;
        for (Employee employee : employees) {
            if (employee.getAge() > older) {
                older = employee.getAge();
            }
        }
        for (Employee employee : employees) {
            if (employee.getAge() == older) {
                return employee;
            }
        }
        return null;
    }

    public Employee getEmployee(String name) {
        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                return employee;
            }
        }
        return null;
    }

    public int getCount() {
        return employees.size();
    }


    public String report() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Employees working at Cafe %s:", name)).append(System.lineSeparator());
        for (Employee employee : employees) {
            builder.append(employee).append(System.lineSeparator());
        }
        return builder.toString();
    }
}
