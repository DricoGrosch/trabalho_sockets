package models;

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
    final String GETALL = "getall";
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

    //todo criar um controller porque isso aqui ta muito grande
    public void handleMessage(String message) throws ScriptException {
        String[] query = message.split(";");
        HashMap<String, String> params = new HashMap<>();
        for (String param : query) {
            params.put(param.split("=")[0], param.split("=")[1]);
        }
        switch (params.get("model")) {
            case "student": {
//                todo replicar pras outras classes (sala tem que ter uma opção pra add aluno e professor)
//                todo só passar o cpf de cada um e adicionar no objeto de turma (hashmap.put(cpf, objeto))
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
                System.out.println("classroom");
                break;
            }
        }
    }
}
