package controllers;

import models.Classroom;
import models.Database;
import models.Student;
import models.Teacher;

import java.io.PrintStream;
import java.util.HashMap;

import static java.lang.Integer.parseInt;

public class ClassroomController {

    public static String  create(HashMap<String, String> params, PrintStream ps) {
        if (Database.classrooms.get(params.get("classNumber")) != null) {
            return "Classroom with this number already exists";
        }
        String classNumber = params.get("classNumber");
        if (classNumber != null) {
            Classroom classroom = new Classroom(parseInt(classNumber));
            Database.classrooms.put("" + classroom.getClassNumber(), classroom);
            return"Classroom created successfully";
        } else {
            return "Classroom created ERROR";
        }

    }

    public static String  update(HashMap<String, String> params, PrintStream ps) {
        String classNumber = params.get("classNumber");

        String newclassNumber = params.get("newClassNumber");

        if (classNumber != null) {
            Classroom c = Database.classrooms.get(classNumber);


            if (c != null) {
                Classroom newC = c;
                newC.setClassNumber(parseInt(newclassNumber));
                Database.classrooms.remove(classNumber);
                Database.classrooms.put(newclassNumber, newC);
                return "Classroom updated successfully";
            } else {
                return "Classroom not found to updated";
            }
        } else {
            return"Classroom updated ERROR";
        }
    }

    public static String  delete(HashMap<String, String> params, PrintStream ps) {
        Classroom c = Database.classrooms.get(params.get("classNumber"));
        if (c != null) {
            if (c.getStudents().size() == 0) {
                return"Classroom cannot be removed";
            } else {
                Database.classrooms.remove("" + c.getClassNumber());
                return "Classroom removed";
            }
        } else {
            return "Classroom not found";
        }
    }

    public static String  getOne(HashMap<String, String> params, PrintStream ps) {
        Classroom c = Database.classrooms.get(params.get("classNumber"));
        if (c != null) {
            return c.toString();
        } else {
            return "Classroom not found";
        }
    }

    public static String  addStudent(HashMap<String, String> params, PrintStream ps) {
        Classroom c = Database.classrooms.get(params.get("classNumber"));
        if (c != null) {
            Student student = Database.students.get(params.get("cpf"));
            if (student != null) {
                c.addStudent(student.getCpf());
                return "Student added successfully";
            } else {
                return "Failed to add the student";
            }

        } else {
            return"Classroom not found";
        }

    }

    public static String  addTeacher(HashMap<String, String> params, PrintStream ps) {
        Classroom c = Database.classrooms.get(params.get("classNumber"));
        if (c != null) {
            Teacher teacher = Database.teachers.get(params.get("cpf"));
            if (teacher != null) {
                c.setTeacher(teacher);
                return "Teacher added successfully";
            } else {
                return "Failed to add the teacher";
            }
        } else {
            return "Classroom not found";
        }

    }

    public static String  removeStudent(HashMap<String, String> params, PrintStream ps) {
        Classroom c = Database.classrooms.get(params.get("classNumber"));
        if (c != null) {
            Student student = c.getStudents().get(params.get("cpf"));
            if (student != null) {
                c.getStudents().remove(student.getCpf());
                return"Student removed successfully";
            } else {
                return"Student not found";
            }
        } else {
            return"Classroom not found";
        } 
    }

    public static String  removeTeacher(HashMap<String, String> params, PrintStream ps) {
        Classroom c = Database.classrooms.get(params.get("classNumber"));
        if (c != null) {
            if(c.getTeacher() !=null){
                c.setTeacher(null);
                return "Teacher removed successfully";
            }else{
                return "Classroom has no attr teacher";
            }
        } else {
            return "Classroom not found";
        }
    }

    public static String  getAll(HashMap<String, String> params, PrintStream ps) {
        String str = "";
        for (String classNumber : Database.classrooms.keySet()) {
            Classroom c = Database.classrooms.get(classNumber);
            str += c.toString();
        }
        return str;
    }
}
