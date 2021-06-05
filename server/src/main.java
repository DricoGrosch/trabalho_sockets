
import models.Student;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Wish port would you like to star the server ?");
        int port = scan.nextInt();
        ServerSocket ss = new ServerSocket(port);
        Socket s = ss.accept();
        System.out.println("Connection established");
        PrintStream ps
                = new PrintStream(s.getOutputStream());
        BufferedReader br
                = new BufferedReader(
                new InputStreamReader(
                        s.getInputStream()));

        ps.println("Connection established");
        while (true) {
            String str;
            while ((str = br.readLine()) != null) {
                Student student = Student.createFromQueryString(str);
                ps.println("Student saved successfully");
            }

            br.close();
            ss.close();
            s.close();
            System.exit(0);

        }
    }
}
