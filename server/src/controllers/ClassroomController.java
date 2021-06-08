package controllers;

import models.Classroom;
import models.Database;
import models.Student;
import models.Teacher;

import java.io.PrintStream;
import java.util.HashMap;

import static java.lang.Integer.parseInt;

public class ClassroomController {

    public static void create(HashMap<String, String> params, PrintStream ps) {
        String classNumber = params.get("classNumber");
        if (classNumber != null) {
            Classroom classroom = new Classroom(parseInt(classNumber));
            Database.classrooms.put("" + classroom.getClassNumber(), classroom);
            ps.println("Classroom created successfully");
        } else {
            ps.println("Classroom created ERROR");
        }

    }

    public static void update(HashMap<String, String> params, PrintStream ps) {
        String classNumber = params.get("classNumber");

        String newclassNumber = params.get("newClassNumber");

        if (classNumber != null) {
            Classroom c = Database.classrooms.get(classNumber);


            if (c != null) {
                Classroom newC = c;
                newC.setClassNumber(parseInt(newclassNumber));
                Database.classrooms.remove(classNumber);
                Database.classrooms.put(newclassNumber, newC);
                ps.println("Classroom updated successfully");
            } else {
                ps.println("Classroom not found to updated");
            }
        } else {
            ps.println("Classroom updated ERROR");
        }
    }

    public static void delete(HashMap<String, String> params, PrintStream ps) {
        Classroom c = Database.classrooms.get(params.get("classNumber"));
        if (c != null) {
            if (c.getStudents().size() == 0) {
                ps.println("Classroom cannot be removed");
            } else {
                Database.classrooms.remove("" + c.getClassNumber());
                ps.println("Classroom removed");
            }
        } else {
            ps.println("Classroom not found");
        }
    }

    public static void getOne(HashMap<String, String> params, PrintStream ps) {
        Classroom c = Database.classrooms.get(params.get("classNumber"));
        if (c != null) {
            ps.println(c.toString());
        } else {
            ps.println("Classroom not found");
        }
    }

    public static void addStudent(HashMap<String, String> params, PrintStream ps) {
        Classroom c = Database.classrooms.get(params.get("classNumber"));
        if (c != null) {
            Student student = Database.students.get(params.get("cpf"));
            if (student != null) {
                c.addStudent(student.getCpf());
                ps.println("Student added successfully");
            } else {
                ps.println("Failed to add the student");
            }

        } else {
            ps.println("Classroom not found");
        }

    }

    public static void addTeacher(HashMap<String, String> params, PrintStream ps) {
        Classroom c = Database.classrooms.get(params.get("classNumber"));
        if (c != null) {
            Teacher teacher = Database.teachers.get(params.get("cpf"));
            if (teacher != null) {
                c.setTeacher(teacher);
                ps.println("Teacher added successfully");
            } else {
                ps.println("Failed to add the teacher");
            }
        } else {
            ps.println("Classroom not found");
        }

    }

    public static void removeStudent(HashMap<String, String> params, PrintStream ps) {
        Classroom c = Database.classrooms.get(params.get("classNumber"));
        if (c != null) {
            Student student = c.getStudents().get(params.get("cpf"));
            if (student != null) {
                c.getStudents().remove(student.getCpf());
                ps.println("Student removed successfully");
            } else {
                ps.println("Student not found");
            }
        } else {
            ps.println("Classroom not found");
        }
    }

    public static void removeTeacher(HashMap<String, String> params, PrintStream ps) {
        Classroom c = Database.classrooms.get(params.get("classNumber"));
        if (c != null) {
            c.setTeacher(null);
            ps.println("Teacher removed successfully");
        } else {
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
