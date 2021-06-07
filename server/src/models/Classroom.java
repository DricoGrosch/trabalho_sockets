package models;

import java.util.ArrayList;
import java.util.HashMap;

public class Classroom {
    private HashMap<String, Student> students = new HashMap<>();

    public Student getStudent(String cpf) {
        for (String k : this.students.keySet()) {
            if (cpf.equals(k)) {
                return this.students.get(k);
            }
        }
        return null;
    }
}
