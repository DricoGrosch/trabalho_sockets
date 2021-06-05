package models;

import java.util.ArrayList;

public class Classroom {
    ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student s) {
        this.students.add(s);
    }


}
