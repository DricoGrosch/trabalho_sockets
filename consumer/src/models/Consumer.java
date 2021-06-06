package models;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Consumer {
    private String host;
    private int port;
    private Socket socket;
    DataOutputStream stream;

    public Socket getSocket() {
        return socket;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Consumer(String host, int port, Scanner s) {
        this.host = host;
        this.port = port;
        try {
            this.socket = new Socket(host, port);
            this.stream = new DataOutputStream(this.socket.getOutputStream());
            System.out.println("connected");
            BufferedReader br
                    = new BufferedReader(
                    new InputStreamReader(
                            this.getSocket().getInputStream()));
            String response;
            while (!(response = br.readLine()).equals("exit")) {
                System.out.println(response);
                System.out.println("1- To handle students \n" +
                        "2 - To handle Teachers\n" +
                        "3 - To handle Classrooms \n" +
                        "4 - To exit");
                int operation = s.nextInt();
                System.out.println("Please, enter the operation \n" +
                        "1- CREATE \n" +
                        "2 - UPDATE\n" +
                        "3 - DELETE \n" +
                        "4 - GET ONE \n" +
                        "5 - LIST ALL");
                int crudOperation = s.nextInt();
                switch (operation) {
                    case 1: {
//                    todo switch with crud operation
                        System.out.println("cpf");
                        String cpf = s.next();
                        System.out.println("name");
                        String name = s.next();
                        System.out.println("address");
                        String address = s.next();
                        System.out.println("registration Number");
                        String registrationNumber = s.next();
                        this.stream.writeBytes("model=student;operation=create;cpf=" + cpf + ";name=" + name + ";address=" + address + ";registrationNumber=" + registrationNumber);
                        break;
                    }
                    case 2: {
                        System.out.println("cpf");
                        String cpf = s.next();
                        break;

                    }
                    case 3: {
                        System.out.println("cpf");
                        String cpf = s.next();
                        break;

                    }
                    default: {
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

