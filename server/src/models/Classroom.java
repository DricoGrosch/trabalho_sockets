package models;

import java.util.ArrayList;
import java.util.HashMap;

public class Classroom {
    private HashMap<String, Student> students = new HashMap<>();
    private int classNumber;

    public Classroom(int classNumber) {
        this.classNumber = classNumber;
    }

    public Classroom() {
    }


    public Student getStudent(String cpf) {
        for (String k : this.students.keySet()) {
            if (cpf.equals(k)) {
                return this.students.get(k);
            }
        }
        return null;
    }

    public Student addStudent(String cpf){

        Student s = Database.students.get(cpf);
        if (s != null) {
            students.put(cpf,s);
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
        String msg = "";

        for (String k : students.keySet()) {

            msg += students.get(k).toString();

        }
        return "Classroom{" +
                "Class Number=" + classNumber +"| "+msg+
                '}';
    }
}
