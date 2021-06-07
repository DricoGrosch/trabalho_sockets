package controllers;

import models.Classroom;
import models.Database;
import models.Student;

import java.io.PrintStream;
import java.util.HashMap;

import static java.lang.Integer.parseInt;

public class ClassroomController {

    public static void create(HashMap<String, String> params, PrintStream ps) {
        String numberClass = params.get("classNumber");
        if (numberClass != null){
            Classroom classroom= new Classroom(parseInt(numberClass));
            Database.classrooms.put(""+classroom.getClassNumber(), classroom);
            ps.println("Classroom created successfully");
        }else{
            ps.println("Classroom created ERROR");
        }

    }

    public static void update(HashMap<String, String> params, PrintStream ps) {
        String numberClass = params.get("classNumber");

        String newNumberClass = params.get("newClassNumber");

        if (numberClass != null){
            Classroom c = Database.classrooms.get(""+numberClass);


            if (c !=null){
                Classroom newC = c;
                newC.setClassNumber(parseInt(newNumberClass));
                Database.classrooms.remove(numberClass);
                Database.classrooms.put(newNumberClass,newC);
                ps.println("Classroom updated successfully");
            }else{
                ps.println("Classroom not found to updated");
            }
        }else{
            ps.println("Classroom updated ERROR");
        }
    }

    public static void addStudent(HashMap<String, String> params, PrintStream ps) {

        Classroom c = Database.classrooms.get(params.get("classNumber"));
        if ( c!=null ){
            Student student = Database.students.get(params.get("cpf"));
            if (student !=null){
                c.addStudent(student.getCpf());
                ps.println("Student added successfully");
            }else{
                ps.println("Failed to add the student");
            }

        }else{
            ps.println("Classroom not found");
        }

    }

    public static void getAll(HashMap<String, String> params, PrintStream ps) {
        String str = "";
        for (String classNumber : Database.classrooms.keySet()) {
            Classroom c = Database.classrooms.get(classNumber);
            str += c.toString();
        }
        ps.println(str);
    }
}
