package org.example;

import java.util.*;

public class StudentsGroup {

    private Student groupLeader;
    private Set<Student> students = new HashSet<>();

    private List<Task> tasks = new ArrayList<>();

    public StudentsGroup(Student groupLeader){
        this.groupLeader = groupLeader;
        this.students.add(groupLeader);
    }

    public StudentsGroup(Student groupLeader, Collection<Student> students){
        this(groupLeader);
        this.students.addAll(students);
    }

    public Student getGroupLeader() {
        return groupLeader;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void addStudent(Student student){
        this.students.add(student);
    }

    public void removeStudent(Student student){
        this.students.remove(student);
    }

    public void removeStudent(int id) throws Exception {
        if (groupLeader.getId() == id)
            throw new Exception("Group Leader cannot be removed!");
        for (Student student : students) {
            if (student.getId() == id) {
                this.students.remove(student);
                return;
            }
        }
    }

    public void changeGroupLeader(Student newGroupLeader) throws Exception {
        if (!students.contains(newGroupLeader))
            throw new Exception("Group Leader should be the member of the group!");
        this.groupLeader = newGroupLeader;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void markTaskAsCompletedByStudent(Task task, Student student) throws Exception {
        if (!students.contains(student))
            throw new Exception("Student should be the member of the group!");
        if (!tasks.contains(task))
            throw new Exception("This task is not assigned to the group!");
        tasks.get(tasks.indexOf(task)).markAsCompletedByStudent(student);
    }

    @Override
    public String toString() {
        String studentCollection = "";
        for (Student student : students) {
            if (student != groupLeader) {
                studentCollection += student.toString() + "\n";
            }
        }
        String taskCollection = "";
        for (Task task : tasks) {
            taskCollection += task.toString() + "\n";
        }
        return String.format("Group's Leader is %s \nStudents are: \n%sTasks are: \n%s",
                groupLeader, studentCollection, taskCollection);
    }

}
