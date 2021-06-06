
import models.Consumer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        System.out.println("Please insert the consumer host");
        String host = s.next();
        System.out.println("Wish port would you like to star the server ?");
        int port = s.nextInt();
        new Consumer(host, port,s);
    }
}