package controllers;

import models.Database;
import models.Student;

import java.io.PrintStream;
import java.util.HashMap;

public class StudentController {
    Student student;

    public static String create(HashMap<String, String> params, PrintStream ps) {
        if (Database.students.get(params.get("cpf")) != null) {
            return "Student with this CPF already exists";
        }
        Student s = new Student(params.get("name"), params.get("cpf"), params.get("address"), params.get("registrationNumber"));
        Database.students.put(s.getCpf(), s);
        return "Student created successfully";
    }


    public static String update(HashMap<String, String> params, PrintStream ps) {
        Student s = Database.students.get(params.get("cpf"));
        if (s != null) {
            s.setAddress(params.get("address"));
            s.setName(params.get("name"));
            s.setRegistrationNumber(params.get("registrationNumber"));
            return "Student updated successfully";
        } else {
            return "Student not found";
        }
    }

    public static String delete(HashMap<String, String> params, PrintStream ps) {
        Student s = Database.students.get(params.get("cpf"));
        if (s != null) {
            Database.students.remove(s.getCpf());
            return "Student removed successfully";
        } else {
            return "Student not found";
        }
    }

    public static String getOne(HashMap<String, String> params, PrintStream ps) {
        Student s = Database.students.get(params.get("cpf"));
        if (s != null) {
            return s.toString();
        } else {
            return "Student not found";
        }
    }

    public static String getAll(HashMap<String, String> params, PrintStream ps) {
        String str = "";
        for (String cpf : Database.students.keySet()) {
            str += Database.students.get(cpf).toString();
        }
        return str;
    }


}
