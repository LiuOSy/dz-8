package org.example;

import java.util.HashSet;
import java.util.Set;

public class Task {

    private String description;

    private Set<Student> studentsCompletedTask = new HashSet<>();

    public Task(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Student> getStudentsCompletedTask() {
        return studentsCompletedTask;
    }

    public void markAsCompletedByStudent(Student student) {
        studentsCompletedTask.add(student);
    }

    @Override
    public String toString() {
        String completionInfo;
        if (studentsCompletedTask.isEmpty()) {
            completionInfo = "No one completed the task!";
        }
        else {
            String studentCompleted = "";
            for (Student student : studentsCompletedTask) {
                studentCompleted += student.toString() + "\n";
            }
            completionInfo = String.format("It is completed by students: \n%s", studentCompleted);
        }
            return String.format("The task is \"%s\". %s" , description, completionInfo);
    }

}
