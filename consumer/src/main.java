
import models.Consumer;

import java.io.IOException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        System.out.println("Please insert the consumer host");
        String host = s.next();
        System.out.println("Wish port would you like to star the server ?");
        int port = s.nextInt();
        Consumer consumer = new Consumer(host, port);
        System.out.println("1- To handle students \n" +
                "2 - To handle Teachers\n" +
                "3 - To handle Classrooms \n" +
                "4 - To exit");
        int operation = s.nextInt();
        while (operation != 4) {
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
                    consumer.sendMessage("operation=CREATE;cpf=" + cpf + ";name=" + name + ";address=" + address + ";");
                }
                case 2: {

                }
                case 3: {

                }
                default: {
                }
            }
        }
    }
}