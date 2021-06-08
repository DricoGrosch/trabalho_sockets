package controllers;

import models.Database;
import models.Teacher;

import java.io.PrintStream;
import java.util.HashMap;

public class TeacherController {
    Teacher teacher;
    public static String create(HashMap<String, String> params, PrintStream ps) {
        if (Database.teachers.get(params.get("cpf")) != null) {
            return "Teacher with this CPF already exists";
        }
        Teacher s = new Teacher(params.get("name"), params.get("cpf"), params.get("address"), params.get("discipline"));
        Database.teachers.put(s.getCpf(), s);
        return "Teacher created successfully";
    }


    public static String update(HashMap<String, String> params, PrintStream ps) {
        Teacher s = Database.teachers.get(params.get("cpf"));
        if (s != null) {
            s.setAddress(params.get("address"));
            s.setName(params.get("name"));
            s.setDiscipline(params.get("discipline"));
            return "Teacher updated successfully";
        } else {
            return "Teacher not found";
        }
    }

    public static String delete(HashMap<String, String> params, PrintStream ps) {
        Teacher s = Database.teachers.get(params.get("cpf"));
        if (s != null) {
            Database.teachers.remove(s.getCpf());
            return "Teacher removed successfully";
        } else {
            return "Teacher not found";
        }
    }

    public static String getOne(HashMap<String, String> params, PrintStream ps) {
        Teacher s = Database.teachers.get(params.get("cpf"));
        if (s != null) {
            return s.toString();
        } else {
            return "Teacher not found";
        }
    }

    public static String getAll(HashMap<String, String> params, PrintStream ps) {
        String str = "";
        for (String cpf : Database.teachers.keySet()) {
            str += Database.teachers.get(cpf).toString();
        }
        return str;
    }


}
