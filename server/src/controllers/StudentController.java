package controllers;

import models.Database;
import models.Student;

import java.io.PrintStream;
import java.util.HashMap;

public class StudentController {
    Student student;
    public static void create(HashMap<String, String> params, PrintStream ps) {
        Student s = new Student(params.get("name"), params.get("cpf"), params.get("address"), params.get("registrationNumber"));
        Database.students.put(s.getCpf(), s);
        ps.println("Student created successfully");
    }


    public static void update(HashMap<String, String> params, PrintStream ps) {
        Student s = Database.students.get(params.get("cpf"));
        if (s != null) {
            s.setAddress(params.get("address"));
            s.setName(params.get("name"));
            s.setRegistrationNumber(params.get("registrationNumber"));
            ps.println("Student updated successfully");
        } else {
            ps.println("Student not found");
        }
    }

    public static void delete(HashMap<String, String> params, PrintStream ps) {
        Student s = Database.students.get(params.get("cpf"));
        if (s != null) {
            Database.students.remove(s.getCpf());
            ps.println("Student removed successfully");
        } else {
            ps.println("Student not found");
        }
    }

    public static void getOne(HashMap<String, String> params, PrintStream ps) {
        Student s = Database.students.get(params.get("cpf"));
        if (s != null) {
            ps.println(s.toString());
        } else {
            ps.println("Student not found");
        }
    }

    public static void getAll(HashMap<String, String> params, PrintStream ps) {
        String str = "";
        for (String cpf : Database.students.keySet()) {
            str += Database.students.get(cpf).toString();
        }
        ps.println(str);
    }


}
