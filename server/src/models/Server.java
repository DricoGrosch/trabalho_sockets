package models;

import controllers.ClassroomController;
import controllers.StudentController;
import controllers.TeacherController;

import javax.script.ScriptException;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class Server {
    final String CREATE = "create";
    final String UPDATE = "update";
    final String DELETE = "delete";
    final String GETONE = "getone";
    final String ADDSTUDENT = "addstudent";
    final String REMOVESTUDENT = "removestudent";
    final String ADDTEACHER = "addteacher";
    final String REMOVETEACHER = "removeteacher";
    PrintStream ps;
    DataInputStream stream;

    public Server(int port) throws IOException, ScriptException {
        ServerSocket ss = new ServerSocket(port);
        System.out.println("Waiting connections");
        Socket s = ss.accept();
        System.out.println("Connection established");

        this.ps = new PrintStream(s.getOutputStream());

        this.stream = new DataInputStream(s.getInputStream());

        this.ps.println("Connection established");
        while (true) {
            this.handleMessage(this.stream.readUTF());
//            br.close();
//            ss.close();
//            s.close();
//            System.exit(0);

        }
    }

    public void handleMessage(String message) throws ScriptException {
        String[] query = message.split(";");
        HashMap<String, String> params = new HashMap<>();
        for (String param : query) {
            params.put(param.split("=")[0], param.split("=")[1]);
        }
        switch (params.get("model")) {
            case "student": {
                switch (params.get("operation")) {
                    case CREATE: {
                        StudentController.create(params, this.ps);
                        break;
                    }
                    case UPDATE: {
                        StudentController.update(params, this.ps);
                        break;

                    }
                    case DELETE: {
                        StudentController.delete(params, this.ps);
                        break;

                    }
                    case GETONE: {
                        StudentController.getOne(params, this.ps);
                        break;

                    }
                    default: {
                        StudentController.getAll(params, this.ps);
                        break;
                    }
                }
                break;
            }
            case "teacher": {
                switch (params.get("operation")) {
                    case CREATE: {
                        TeacherController.create(params, this.ps);
                        break;
                    }
                    case UPDATE: {
                        TeacherController.update(params, this.ps);
                        break;

                    }
                    case DELETE: {
                        TeacherController.delete(params, this.ps);
                        break;

                    }
                    case GETONE: {
                        TeacherController.getOne(params, this.ps);
                        break;


                    }
                    default: {
                        TeacherController.getAll(params, this.ps);
                        break;
                    }
                }
                break;
            }
            case "classroom": {
                switch (params.get("operation")) {
                    case CREATE: {
                        ClassroomController.create(params, this.ps);
                        break;
                    }
                    case UPDATE: {
                        ClassroomController.update(params, this.ps);
                        break;

                    }
                    case DELETE: {
                        ClassroomController.delete(params, this.ps);
                        break;

                    }
                    case GETONE: {
                        ClassroomController.getOne(params, this.ps);
                        break;

                    }
                    case ADDSTUDENT: {
                        ClassroomController.addStudent(params, this.ps);
                        break;
                    }
                    case REMOVESTUDENT: {
                        ClassroomController.removeStudent(params, this.ps);
                        break;
                    }
                    case ADDTEACHER: {
                        ClassroomController.addTeacher(params, this.ps);
                        break;
                    }
                    case REMOVETEACHER: {
                        ClassroomController.removeTeacher(params, this.ps);
                        break;
                    }
                    default: {
                        ClassroomController.getAll(params, this.ps);
                        break;
                    }
                }
                break;
            }
        }
    }
}
