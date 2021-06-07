package models;

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
    HashMap<String, Student> students;

    public Server(int port) throws IOException, ScriptException {
//        todo criar um classe pra guardar o "banco de dados"
        this.students = new HashMap<>();
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
//                todo testar e replicar pras outras classes (sala tem que ter uma opção pra add aluno e professor)
//                todo só passar o cpf de cada um e adicionar no objeto de turma (hashmap.put(cpf, objeto))
                switch (params.get("operation")) {
                    case CREATE: {
                        Student s = new Student(params.get("name"), params.get("cpf"), params.get("address"), params.get("registrationNumber"));
                        this.ps.println("Student created successfully");
                        this.students.put(s.getCpf(), s);
                        break;
                    }
                    case UPDATE: {
                        Student s = this.students.get(params.get("cpf"));
                        if (s != null) {
                            s.setAddress(params.get("address"));
                            s.setName(params.get("name"));
                            s.setRegistrationNumber(params.get("registrationNumber"));
                            this.ps.println("Student updated successfully");
                        } else {
                            this.ps.println("Student not found");
                        }
                        break;

                    }
                    case DELETE: {
                        Student s = this.students.get(params.get("cpf"));
                        if (s != null) {
                            this.students.remove(s.getCpf());
                            this.ps.println("Student removed successfully");
                        } else {
                            this.ps.println("Student not found");
                        }
                        break;

                    }
                    case GETONE: {
                        Student s = this.students.get(params.get("cpf"));
                        if (s != null) {
                            this.ps.println(s.toString());
                        } else {
                            this.ps.println("Student not found");
                        }
                        break;


                    }
                    default: {

                        String str = "";
                        for (String cpf : this.students.keySet()) {
                            str += this.students.get(cpf).toString();
                        }
                        this.ps.println(str);
                        break;
                    }
                }
                break;
            }
            case "teacher": {
                System.out.println("teacher");
                break;
            }
            case "classroom": {
                System.out.println("classroom");
                break;
            }
        }
    }
}
