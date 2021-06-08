package models;

import java.util.ArrayList;
import java.util.HashMap;

public class Classroom {
    private final HashMap<String, Student> students = new HashMap<>();
    private Teacher teacher;
    private int classNumber;

    public Classroom(int classNumber) {
        this.classNumber = classNumber;
    }

    public Classroom() {
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public HashMap<String, Student> getStudents() {
        return students;
    }

    public Student getStudent(String cpf) {
        for (String k : this.students.keySet()) {
            if (cpf.equals(k)) {
                return this.students.get(k);
            }
        }
        return null;
    }

    public Student addStudent(String cpf) {

        Student s = Database.students.get(cpf);
        if (s != null) {
            students.put(cpf, s);
            return s;
        }
        return null;

    }

    public int getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(int classNumber) {
        this.classNumber = classNumber;
    }

    @Override
    public String toString() {
        String strStudents = this.students.toString();
        String strTeacher = "";
        if (this.teacher != null) {
            strTeacher = this.teacher.toString() + " | ";
        }
        return "Class Number=" + classNumber + " | " + strTeacher + " | " + "Students:" + strStudents;
    }
}
