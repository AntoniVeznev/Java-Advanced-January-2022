package Exams.JavaAdvancedRetakeExam14April2021.P03University;

import java.util.ArrayList;
import java.util.List;

public class University {
    public int capacity;
    public List<Student> students;

    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getStudentCount() {
        return students.size();
    }

    public String registerStudent(Student student) {
        if (capacity > students.size() && !students.contains(student)) {
            students.add(student);
            return String.format("Added student %s %s", student.getFirstName(), student.getLastName());
        }
        if (students.contains(student)) {
            return "Student is already in the university";
        }
        return "No seats in the university";
    }

    public String dismissStudent(Student student) {
        if (students.contains(student)) {
            students.remove(student);
            return String.format("Removed student %s %s", student.getFirstName(), student.getLastName());
        }
        return "Student not found";
    }

    public Student getStudent(String firstName, String lastName) {
        Student item = null;
        for (Student student : students) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                item = student;
            }
        }
        return item;
    }

    public String getStatistics() {
        StringBuilder builder = new StringBuilder();
        for (Student student : students) {
            builder.append(String.format("==Student: First Name = %s, Last Name = %s, Best Subject = %s", student.getFirstName(), student.getLastName(), student.getBestSubject())).append(System.lineSeparator());
        }
        return builder.toString();
    }
}

