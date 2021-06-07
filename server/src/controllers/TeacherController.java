package controllers;

import models.Database;
import models.Teacher;

import java.io.PrintStream;
import java.util.HashMap;

public class TeacherController {
    Teacher teacher;
    public static void create(HashMap<String, String> params, PrintStream ps) {
        Teacher s = new Teacher(params.get("name"), params.get("cpf"), params.get("address"), params.get("discipline"));
        Database.teachers.put(s.getCpf(), s);
        ps.println("Teacher created successfully");
    }


    public static void update(HashMap<String, String> params, PrintStream ps) {
        Teacher s = Database.teachers.get(params.get("cpf"));
        if (s != null) {
            s.setAddress(params.get("address"));
            s.setName(params.get("name"));
            s.setDiscipline(params.get("discipline"));
            ps.println("Teacher updated successfully");
        } else {
            ps.println("Teacher not found");
        }
    }

    public static void delete(HashMap<String, String> params, PrintStream ps) {
        Teacher s = Database.teachers.get(params.get("cpf"));
        if (s != null) {
            Database.teachers.remove(s.getCpf());
            ps.println("Teacher removed successfully");
        } else {
            ps.println("Teacher not found");
        }
    }

    public static void getOne(HashMap<String, String> params, PrintStream ps) {
        Teacher s = Database.teachers.get(params.get("cpf"));
        if (s != null) {
            ps.println(s.toString());
        } else {
            ps.println("Teacher not found");
        }
    }

    public static void getAll(HashMap<String, String> params, PrintStream ps) {
        String str = "";
        for (String cpf : Database.teachers.keySet()) {
            str += Database.teachers.get(cpf).toString();
        }
        ps.println(str);
    }


}
