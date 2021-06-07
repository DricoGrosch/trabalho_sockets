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
            System.out.println("connected");

            // to send data to the server
            this.stream = new DataOutputStream(
                    this.socket.getOutputStream());

            BufferedReader br
                    = new BufferedReader(
                    new InputStreamReader(
                            this.socket.getInputStream()));

            String response;
            while (!(response = br.readLine()).equals("exit")) {
                System.out.println(response);
                System.out.println("1- To handle students \n" +
                        "2 - To handle Teachers\n" +
                        "3 - To handle Classrooms \n" +
                        "4 - To exit");
                int modelToHandle = s.nextInt();
                System.out.println("Please, enter the operation \n" +
                        "1- CREATE \n" +
                        "2 - UPDATE\n" +
                        "3 - DELETE \n" +
                        "4 - GET ONE \n" +
                        "5 - LIST ALL");
                int operation = s.nextInt();
                switch (modelToHandle) {
                    case 1: {
                        String strParams = "";
                        String strOperation = "getall";
                        switch (operation) {
                            case 1: {
                                System.out.println("cpf");
                                String cpf = s.next();
                                System.out.println("name");
                                String name = s.next();
                                System.out.println("address");
                                String address = s.next();
                                System.out.println("registration Number");
                                String registrationNumber = s.next();
                                strParams = "cpf=" + cpf + ";name=" + name + ";address=" + address + ";registrationNumber=" + registrationNumber;
                                strOperation = "create";
                                break;
                            }
                            case 2: {
                                System.out.println("cpf");
                                String cpf = s.next();
                                System.out.println("name");
                                String name = s.next();
                                System.out.println("address");
                                String address = s.next();
                                System.out.println("registration Number");
                                String registrationNumber = s.next();
                                strParams = "cpf=" + cpf + ";name=" + name + ";address=" + address + ";registrationNumber=" + registrationNumber;
                                strOperation = "update";
                                break;
                            }
                            case 3: {
                                System.out.println("cpf");
                                String cpf = s.next();
                                strOperation = "delete";
                                strParams = "cpf=" + cpf;
                                break;
                            }
                            case 4: {
                                System.out.println("cpf");
                                String cpf = s.next();
                                strOperation = "getone";
                                strParams = "cpf=" + cpf;
                                break;
                            }
                            default: {
                                strOperation = "getall";
                            }
                        }
                        String message = "model=student;operation=" + strOperation + ";" + strParams;
                        this.stream.writeUTF(message);
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

