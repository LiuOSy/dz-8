package org.example;

import java.util.ArrayList;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {

        Student student1 = new Student("Mary", "Johns");
        Student student2 = new Student("Tom", "Cat");
        Student student3 = new Student("Jerry", "Mouse");
        Student student4 = new Student("John", "Smith");
        Student student6 = new Student("Anna", "Peters");
        Student student5 = student4;

        Collection<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);

        StudentsGroup group1 = new StudentsGroup(student1, students);
        System.out.println(group1);

        try {
            group1.changeGroupLeader(student6);
            System.out.println("The string will not be printed. Student is not in the group");
            System.out.println(group1);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        try {
            group1.changeGroupLeader(student3);
            System.out.println("After GroupLeader change:");
            System.out.println(group1);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        Task task1 = new Task("test task 1");
        try {
            // Positive case of work with task
            group1.addTask(task1);
            group1.markTaskAsCompletedByStudent(task1, student3);
            System.out.println(group1);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        try {
            // Negative case (task didn't assigned to group)
            Task task2 = new Task("test task 2");
            group1.markTaskAsCompletedByStudent(task2, student3);
            System.out.println(group1); // unreachable
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        try {
            // Negative case (student is not a member of the group
            group1.markTaskAsCompletedByStudent(task1, student6);
            System.out.println(group1); // unreachable
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }
}