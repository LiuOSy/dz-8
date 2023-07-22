package org.example;

public class Student {

    private static int counter = 0;
    private final int id;
    private String firstName;
    private String lastName;

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = ++counter;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getId() { return id; }

    @Override
    public String toString() {
        return String.format("Student %s %s. ID: %d.", this.firstName, this.lastName, this.id);
    }

}
