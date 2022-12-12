package Exams.JavaAdvancedRetakeExam16December2020.P03Openning;

import java.util.ArrayList;
import java.util.List;

public class Bakery {

    private String name;
    private int capacity;
    private List<Employee> employees;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void add(Employee employee) {
        if (employees.size() < capacity) {
            employees.add(employee);
        }
    }

    public boolean remove(String name) {
        Employee item = null;
        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                item = employee;
                employees.remove(item);
                return true;
            }
        }
        return false;
    }

    public Employee getOldestEmployee() {
        Employee item = null;
        for (Employee employee : employees) {
            if (item == null || employee.getAge() > item.getAge()) {
                item = employee;
            }
        }
        return item;

    }

    public Employee getEmployee(String name) {
        Employee item = null;
        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                item = employee;
                return item;
            }
        }
        return null;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public int getCount() {
        return employees.size();
    }

    public String report() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Employees working at Bakery %s:", name)).append(System.lineSeparator());
        for (Employee employee : employees) {
            builder.append(employee).append(System.lineSeparator());
        }
        return builder.toString();
    }
}
