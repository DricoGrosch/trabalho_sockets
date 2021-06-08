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
        ps.println("Connection established");
        while (true) {
            String message = this.stream.readUTF();

            String response = this.handleMessage(message);
            this.ps.println(response);
//            br.close();
//            ss.close();
//            s.close();
//            System.exit(0);

        }
    }

    public String handleMessage(String message) throws ScriptException {
        System.out.println(message);
        String[] query = message.split(";");
        HashMap<String, String> params = new HashMap<>();
        for (String param : query) {
            params.put(param.split("=")[0], param.split("=")[1]);
        }
        switch (params.get("model")) {
            case "student": {
                switch (params.get("operation")) {
                    case CREATE: {
                        return StudentController.create(params, this.ps);
                    }
                    case UPDATE: {
                        return StudentController.update(params, this.ps);

                    }
                    case DELETE: {
                        return StudentController.delete(params, this.ps);

                    }
                    case GETONE: {
                        return StudentController.getOne(params, this.ps);

                    }
                    default: {
                        return StudentController.getAll(params, this.ps);
                    }
                }

            }
            case "teacher": {
                switch (params.get("operation")) {
                    case CREATE: {
                        return TeacherController.create(params, this.ps);

                    }
                    case UPDATE: {
                        return TeacherController.update(params, this.ps);


                    }
                    case DELETE: {
                        return TeacherController.delete(params, this.ps);


                    }
                    case GETONE: {
                        return TeacherController.getOne(params, this.ps);


                    }
                    default: {
                        return TeacherController.getAll(params, this.ps);

                    }
                }

            }
            case "classroom": {
                switch (params.get("operation")) {
                    case CREATE: {
                        return ClassroomController.create(params, this.ps);

                    }
                    case UPDATE: {
                        return ClassroomController.update(params, this.ps);


                    }
                    case DELETE: {
                        return ClassroomController.delete(params, this.ps);


                    }
                    case GETONE: {
                        return ClassroomController.getOne(params, this.ps);


                    }
                    case ADDSTUDENT: {
                        return ClassroomController.addStudent(params, this.ps);

                    }
                    case REMOVESTUDENT: {
                        return ClassroomController.removeStudent(params, this.ps);

                    }
                    case ADDTEACHER: {
                        return ClassroomController.addTeacher(params, this.ps);

                    }
                    case REMOVETEACHER: {
                        return ClassroomController.removeTeacher(params, this.ps);

                    }
                    default: {
                        return ClassroomController.getAll(params, this.ps);

                    }
                }

            }
        }
        return "";
    }
}
